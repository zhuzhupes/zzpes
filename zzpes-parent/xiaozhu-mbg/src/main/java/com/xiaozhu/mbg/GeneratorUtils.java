package com.xiaozhu.mbg;

import com.macro.mall.common.ZzpesUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.JDBCConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

@Slf4j
public class GeneratorUtils {


    /**
     * 得到表注释
     * @param table 表
     * @param context 上下文
     * @return
     */
    public static String getTableComment(FullyQualifiedTable table, Context context) {
        String tableComment = "";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            JDBCConnectionFactory jdbc = new JDBCConnectionFactory(context.getJdbcConnectionConfiguration());
            connection = jdbc.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("SHOW CREATE TABLE " + table.getIntrospectedTableName());

            if (rs != null && rs.next()) {
                String createDDL = rs.getString(2);
                int index = createDDL.indexOf("COMMENT='");
                if (index < 0) {
                    tableComment = "";
                } else {
                    tableComment = createDDL.substring(index + 9);
                    tableComment = tableComment.substring(0, tableComment.length() - 1);
                }
            }
        } catch (SQLException e) {
            log.error("获取表Comment失败...");
        } finally {
            ZzpesUtils.closeSource(rs);
            ZzpesUtils.closeSource(statement);
            ZzpesUtils.closeSource(connection);
        }
        return tableComment;
    }

    public static <T extends  JavaElement> void addDocLines(T element, String desc, String tableName) {
        element.addJavaDocLine("/**");
        element.addJavaDocLine(" * @description " + desc);
        element.addJavaDocLine(" * @version 1.0.0");
        element.addJavaDocLine(" * @tableName " + tableName);
        element.addJavaDocLine(" * @author xiaozhu");
        element.addJavaDocLine(" * @date " + ZzpesUtils.getDateTimeStr(new Date()));
        element.addJavaDocLine(" * @copyright 2021 xiaozhu");
        element.addJavaDocLine(" */");
    }
}
