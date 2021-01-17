package com.sws.myGenerator.plugin;

import com.sws.myGenerator.common.XiaoZhuUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Date;
import java.util.List;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * mybatis-generator 集成 lombok 的插件
 *
 * @ClassName: LombokPlugin
 * @author xuxx
 * @date 2019-05-12 14:09:43
 * @since JDK 1.8
 *
 */
public class MyLombokPlugin extends PluginAdapter {
    private final String IGNORE_FIELDS = "ignoreFields";
    private final String MY_SUPPER_CLASS = "supperClass";
    private final String GENERATOR_DEFAULT_SERIAL_VERSION_UID = "defaultSerialVersionUID";

    private String supperClass;


    @Override
    public boolean validate(List<String> warnings) {
        boolean valid = true;
        supperClass = properties.getProperty(MY_SUPPER_CLASS);
        if(supperClass == null || "false".equals(supperClass)){
            return true;
        }
        try {
            Class.forName(supperClass);
        } catch (ClassNotFoundException e) {
            warnings.add(getString("ValidationError.18",
                    "MyLombokPlugin",
                    "MY_SUPPER_CLASS"));
//            valid = false;
        }

        return valid;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        // 添加domain的import
        topLevelClass.addImportedType("lombok.Data");
        topLevelClass.addImportedType("javax.persistence.Id");
        topLevelClass.addImportedType("javax.persistence.Table");

        // 添加domain的注解
        topLevelClass.addAnnotation("@Data");
        String tableName = introspectedTable.getFullyQualifiedTable().getIntrospectedTableName();
        topLevelClass.addAnnotation(String.format("@Table(name = \"%s\")", tableName));
        // 设置父类
        if (supperClass != null) {
            topLevelClass.setSuperClass(new FullyQualifiedJavaType(supperClass));
        }

        // 设置 GENERATOR_DEFAULT_SERIAL_VERSION_UID
        String generatorDefaultSerialVersionUID = properties.getProperty(GENERATOR_DEFAULT_SERIAL_VERSION_UID);
        if ("true".equals(generatorDefaultSerialVersionUID)) {
            generatorDefaultSerialVersionUID(topLevelClass);
        }

        // 将需要忽略生成的属性过滤掉
        List<Field> fields = topLevelClass.getFields();
        String primaryKeyStr = "";
        List primaryKeys = introspectedTable.getPrimaryKeyColumns();
        if(primaryKeys != null && primaryKeys.size() == 1){
            IntrospectedColumn primaryKey = (IntrospectedColumn) primaryKeys.get(0);
            primaryKeyStr = primaryKey.getJavaProperty();
        }
        if(!"".equals(primaryKeyStr)){
            // 给主键增加@ID注解
            for (Field field : fields) {
                if(primaryKeyStr.equals(field.getName())){
                    field.addAnnotation("@Id");
                }
            }
        }

        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
                                   IntrospectedTable introspectedTable) {
        // Mapper文件的注释

        interfaze.addJavaDocLine("/**");
        String tableComment = XiaoZhuUtils.getTableComment(introspectedTable.getFullyQualifiedTable(), context);
        if(StringUtility.stringHasValue(tableComment)) {
            interfaze.addJavaDocLine(" * @description " + tableComment+"操作Mapper");
        }
        interfaze.addJavaDocLine(" * @version 1.0.0");
        interfaze.addJavaDocLine(" * @tableName " + "table.toString()");
        interfaze.addJavaDocLine(" * @author xiaozhu");
        interfaze.addJavaDocLine(" * @date " + XiaoZhuUtils.getDateTimeStr(new Date()));
        interfaze.addJavaDocLine(" * @copyright 2021 xiaozhu");
        interfaze.addJavaDocLine(" */");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 不生成getter
        return false;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
                                              IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable, ModelClassType modelClassType) {
        // 不生成setter
        return false;
    }



    private String getIgnoreFields() {
        return properties.getProperty(IGNORE_FIELDS);
    }

    /**
     *
     * @Title: camelToUnderline
     * @Description: 把 java 驼峰的变量变为下划线的
     * @param fieldName
     * @return String
     */
    private static String camelToUnderline(String fieldName) {
        StringBuilder result = new StringBuilder();
        if (fieldName != null && fieldName.length() > 0) {
            // 将第一个字符处理成大写
            result.append(fieldName.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < fieldName.length(); i++) {
                String s = fieldName.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

    /**
     *
     * @Title: generatorDefaultSerialVersionUID
     * @Description: 生成默认的 serialVersionUID
     * @param topLevelClass
     * @return void
     */
    private void generatorDefaultSerialVersionUID(TopLevelClass topLevelClass) {
        Field field = new Field();
        field.setFinal(true);
        field.setInitializationString("1L");
        field.setName("serialVersionUID");
        field.setStatic(true);
        field.setType(new FullyQualifiedJavaType("long"));
        field.setVisibility(JavaVisibility.PRIVATE);
        topLevelClass.getFields().add(0, field);
    }
}