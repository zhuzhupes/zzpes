package com.sws.myGenerator.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.JDBCConnectionFactory;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
public class XiaoZhuUtils {
    public static String getDateTimeStr(Date date) {
        if(date == null){
            date = new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     *  关闭所有可关闭对象
     * @param s 关闭对象
     * @param <T> 对象类型
     * @return 是否正确关闭
     */
    public static <T extends  AutoCloseable> boolean closeSource(T s){
        if(s != null){
            try{
                s.close();
            } catch (Exception e) {
                log.error("关闭流失败{}", s.getClass().getName());
                return false;
            }
        }
        return true;
    }

    /**
     * 判断对象是否为空
     * @param obj 对象
     * @return boolean，true:空
     *                  false：不为空
     */
    public static boolean isEmpty(Object obj){
        if (obj == null){
            return true;
        }else if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }else if ((obj instanceof String)){
            return StringUtils.isEmpty(obj);
        }
        return false;
    }

    /**
     * 复制属性
     */
    public static void setProperty(Object obj, String key, Object value){
        try {
            BeanUtils.setProperty(obj, key, value);
        } catch (Exception e) {
            log.debug("设置{}属性失败", key);
            e.printStackTrace();
        }
    }


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
            closeSource(rs);
            closeSource(statement);
            closeSource(connection);
        }
        return tableComment;
    }
}
