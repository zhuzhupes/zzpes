package com.sws.myGenerator;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Date;
import java.util.Properties;

/**
 * Comment Generator
 * @ClassName CommentGenerator
 * @Description
 * @author Marvis
 */
public class CommentGenerator extends DefaultCommentGenerator {
    private Properties properties;
    private boolean suppressDate;
    private boolean suppressAllComments;

    public CommentGenerator() {
        this.properties = new Properties();
        this.suppressDate = false;
        this.suppressAllComments = false;
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {

//        compilationUnit.addFileCommentLine("/*** copyright (c) 2019 Marvis  ***/");
    }

    /**
     * XML file Comment
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        if (this.suppressAllComments) {
            return;
        }

    }

    @Override
    public void addRootComment(XmlElement rootElement) {
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        this.suppressDate = StringUtility.isTrue(properties.getProperty("suppressDate"));

        this.suppressAllComments = StringUtility.isTrue(properties.getProperty("suppressAllComments"));
    }

    @Override
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append("@date");
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    @Override
    protected String getDateString() {
        if (this.suppressDate) {
            return null;
        }
        return new Date().toString();
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }

        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().getDomainObjectName());
        innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().toString());
        addJavadocTag(innerClass, false);
        innerClass.addJavaDocLine(" */");
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**");
        innerEnum.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().getAlias());
        innerEnum.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (this.suppressAllComments) {
            return;
        }

//        if(introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().trim().equals(""))

        field.addJavaDocLine("/**");
        field.addJavaDocLine(" * " + introspectedColumn.getRemarks());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }
        field.addJavaDocLine("/**");
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }


    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (this.suppressAllComments) {
            return;
        }
    }


    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
//        if (this.suppressAllComments) {
//            return;
//        }
//        method.addJavaDocLine("/**");
//
//
//        method.addJavaDocLine(" * @return " + introspectedTable.getFullyQualifiedTable().getAlias() + " : " + introspectedColumn.getRemarks());
//        method.addJavaDocLine(" */");
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
//        if (this.suppressAllComments) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        method.addJavaDocLine("/**");
//
//        Parameter parm = (Parameter) method.getParameters().get(0);
//        sb.append(" * @param ");
//        sb.append(parm.getName());
//        sb.append(" : ");
//        sb.append(introspectedColumn.getRemarks());
//        method.addJavaDocLine(sb.toString());
//        method.addJavaDocLine(" */");
    }


    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (this.suppressAllComments) {
            return;
        }

        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().getAlias());
        innerClass.addJavaDocLine(" * " + introspectedTable.getFullyQualifiedTable().toString());
        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" */");
    }
}