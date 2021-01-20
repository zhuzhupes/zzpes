package com.xiaozhu.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.sf.cglib.beans.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class BeanMapUtils {
    private static final Logger log = LoggerFactory.getLogger(BeanMapUtils.class);

    public BeanMapUtils() {
    }

    /**
     * 将对象装换为map
     * @param bean 源实体对象
     * @return
     */
    public static <T> Map<String, Object> bean2Map(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 将map装换为javabean对象
     * @param map 源map
     * @param clazz 目标类型
     * @return
     */
    public static <T> T map2Bean(Map<String, Object> map,Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (Exception e) {
            log.error("创建实体对象{}失败！", clazz);
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    /**
     * 将List<T>转换为List<Map<String, Object>>
     * @param objList
     * @return
     */
    public static <T> List<Map<String, Object>> lists2Maps(List<T> objList) {
        List<Map<String, Object>> list = Lists.newArrayList();
        if (objList != null && objList.size() > 0) {
            Map<String, Object> map = null;
            for (T bean: objList) {
                map = bean2Map(bean);
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 将List<Map<String,Object>>转换为List<T>
     * @param maps
     * @param clazz
     * @return
     */
    public static <T> List<T> maps2Lists(List<Map<String, Object>> maps,Class<T> clazz) {
        List<T> list = Lists.newArrayList();
        if (maps != null && maps.size() > 0) {
            for (Map<String, Object> map: maps) {
                list.add(map2Bean(map, clazz));
            }
        }
        return list;
    }
}
