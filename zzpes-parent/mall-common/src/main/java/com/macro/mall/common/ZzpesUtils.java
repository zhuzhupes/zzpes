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
}
