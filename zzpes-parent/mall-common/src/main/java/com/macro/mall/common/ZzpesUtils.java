package com.macro.mall.common;

import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
public class ZzpesUtils {
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
}
