package com.xiaozhu.mbg;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

public class ServiceAndControllerGeneratorPlugin extends PluginAdapter  {

    // 项目目录，一般为 src/main/java
    private String targetProject;

    // service包名，如：com.thinkj2ee.cms.service.service
    private String servicePackage;

    // service实现类包名，如：com.thinkj2ee.cms.service.service.impl
    private String serviceImplPackage;
    // Controlle类包名，如：com.thinkj2ee.cms.service.controller
    private String controllerPackage;
    // Controller的类的项目地址
    private String controllerTargetProject;
    // service接口名前缀
    private String servicePreffix;

    // service接口名后缀
    private String serviceSuffix;

    // service接口的父接口
    private String superServiceInterface;

    // service实现类的父类
    private String superServiceImpl;
    // controller类的父类
    private String superController;
    // dao接口基类
    private String superDaoInterface;
    //Service输入位置
    private String serviceProject;

    // Example类的包名
    private String examplePacket;

    private String recordType;

    private String modelName;

    private FullyQualifiedJavaType model;

    private String serviceName;
    private String serviceImplName;
    private String controllerName;

    @Override
    public boolean validate(List<String> warnings) {
        boolean valid = true;
        targetProject = properties.getProperty("targetProject");
        servicePackage = properties.getProperty("servicePackage");
        serviceImplPackage = properties.getProperty("serviceImplPackage");
        servicePreffix = properties.getProperty("servicePreffix");
        servicePreffix = stringHasValue(servicePreffix) ? servicePreffix : "";
        serviceSuffix = properties.getProperty("serviceSuffix");
        serviceSuffix = stringHasValue(serviceSuffix) ? serviceSuffix : "";
        superServiceInterface = properties.getProperty("superServiceInterface");
        superServiceImpl = properties.getProperty("superServiceImpl");
        superDaoInterface = properties.getProperty("superDaoInterface");
        controllerPackage = properties.getProperty("controllerPackage");
        superController = properties.getProperty("superController");
        controllerTargetProject = properties.getProperty("controllerTargetProject");
        serviceProject = properties.getProperty("serviceProject");

        return valid;
    }

    @Override
    public List<GeneratedJavaFile> contextGenerateAdditionalJavaFiles(IntrospectedTable introspectedTable) {
        recordType = introspectedTable.getBaseRecordType();
        modelName = recordType.substring(recordType.lastIndexOf(".") + 1);
        model = new FullyQualifiedJavaType(recordType);
        serviceName = servicePackage + "." + servicePreffix + modelName + serviceSuffix;
        serviceImplName = serviceImplPackage + "." + modelName + serviceSuffix+"Impl";
        examplePacket=recordType.substring(0,recordType.lastIndexOf("."));
        controllerName=controllerPackage.concat(".").concat(modelName).concat("Controller");
        List<GeneratedJavaFile> answer = new ArrayList<>();
        GeneratedJavaFile gjf = generateServiceInterface(introspectedTable);
        GeneratedJavaFile gjf2 = generateServiceImpl(introspectedTable);
        GeneratedJavaFile gjf3 = generateController(introspectedTable);
        answer.add(gjf);
        answer.add(gjf2);
        answer.add(gjf3);
        return answer;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType superInterfaceType = new FullyQualifiedJavaType(
                new StringBuilder("BaseMapper<")
                        .append(introspectedTable.getBaseRecordType())
                        .append(">")
                        .toString()
        );
        FullyQualifiedJavaType baseMapperInstance = FullyQualifiedJavaTypeProxyFactory.getBaseMapperInstance();

        interfaze.addSuperInterface(superInterfaceType);
        interfaze.addImportedType(baseMapperInstance);

        List<Method> changeMethods = interfaze.getMethods().stream()
                .filter(method -> method.getName().endsWith("WithBLOBs")
                        || method.getReturnType().toString().endsWith("WithBLOBs")
                        || Arrays.toString(method.getParameters().toArray()).contains("WithBLOBs"))
                .collect(Collectors.toList());

        interfaze.getMethods().retainAll(changeMethods);

        if (changeMethods.isEmpty()) {
            interfaze.getImportedTypes().removeIf(javaType -> javaType.getFullyQualifiedName().equals("java.util.List")
                    || javaType.getFullyQualifiedName().equals("org.apache.ibatis.annotations.Param"));
        }
        return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
    }

    // 生成service接口
    private GeneratedJavaFile generateServiceInterface(IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType service = new FullyQualifiedJavaType(serviceName);
        Interface serviceInterface = new Interface(service);
        serviceInterface.setVisibility(JavaVisibility.PUBLIC);
        // 添加父接口
        if(stringHasValue(superServiceInterface)) {
            String superServiceInterfaceName = superServiceInterface.substring(superServiceInterface.lastIndexOf(".") + 1);
            serviceInterface.addImportedType(new FullyQualifiedJavaType(superServiceInterface));
            serviceInterface.addImportedType(new FullyQualifiedJavaType(recordType));
            serviceInterface.addSuperInterface(new FullyQualifiedJavaType(superServiceInterfaceName + "<" + modelName + ">"));
        }
        GeneratedJavaFile gjf = new GeneratedJavaFile(serviceInterface, serviceProject, context.getJavaFormatter());
        return gjf;
    }

    // 生成serviceImpl实现类
    private GeneratedJavaFile generateServiceImpl(IntrospectedTable introspectedTable) {
        FullyQualifiedJavaType service = new FullyQualifiedJavaType(serviceName);
        FullyQualifiedJavaType serviceImpl = new FullyQualifiedJavaType(serviceImplName);
        TopLevelClass clazz = new TopLevelClass(serviceImpl);
        //描述类的作用域修饰符
        clazz.setVisibility(JavaVisibility.PUBLIC);
        //描述类 引入的类
        clazz.addImportedType(service);
        //描述类 的实现接口类
        clazz.addSuperInterface(service);
        if(stringHasValue(superServiceImpl)) {
            String superServiceImplName = superServiceImpl.substring(superServiceImpl.lastIndexOf(".") + 1);
            clazz.addImportedType(superServiceImpl);
            clazz.addImportedType(recordType);
            clazz.setSuperClass(superServiceImplName + "<" + modelName + ">");
        }
        clazz.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Service"));
        clazz.addAnnotation("@Service");


        GeneratedJavaFile gjf2 = new GeneratedJavaFile(clazz, serviceProject, context.getJavaFormatter());
        return gjf2;
    }


    // 生成controller类
    private GeneratedJavaFile generateController(IntrospectedTable introspectedTable) {

        FullyQualifiedJavaType controller = new FullyQualifiedJavaType(controllerName);
        TopLevelClass clazz = new TopLevelClass(controller);
        //描述类的作用域修饰符
        clazz.setVisibility(JavaVisibility.PUBLIC);

        //添加@Controller注解，并引入相应的类
        clazz.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Controller"));
        clazz.addAnnotation("@Controller");
        //添加@RequestMapping注解，并引入相应的类
        clazz.addImportedType(new FullyQualifiedJavaType("org.springframework.web.bind.annotation.RequestMapping"));
        clazz.addAnnotation("@RequestMapping(\"/"+firstCharToLowCase(modelName)+"\")");
        //添加@Api注解，并引入相应的类
        clazz.addImportedType(new FullyQualifiedJavaType("io.swagger.annotations.Api"));
        String controllerSimpleName = controllerName.substring(controllerName.lastIndexOf(".") + 1);
        clazz.addAnnotation("@Api(tags = \""+controllerSimpleName+"\", description = \""+controllerSimpleName+"\")");

        //引入controller的父类和model，并添加泛型
        if(stringHasValue(superController)) {
            clazz.addImportedType(superController);
            clazz.addImportedType(recordType);
            FullyQualifiedJavaType superClass = new FullyQualifiedJavaType(superController+"<"+modelName+">");
            clazz.setSuperClass(superClass);
        }
        GeneratedJavaFile gjf2 = new GeneratedJavaFile(clazz, controllerTargetProject, context.getJavaFormatter());
        return gjf2;
    }


    private String firstCharToLowCase(String str) {
        char[] chars = new char[1];
        //String str="ABCDE1234";
        chars[0] = str.charAt(0);
        String temp = new String(chars);
        if(chars[0] >= 'A'  &&  chars[0] <= 'Z') {
            return str.replaceFirst(temp,temp.toLowerCase());
        }
        return str;
    }
}