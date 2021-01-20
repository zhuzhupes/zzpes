package com.xiaozhu.common;

import org.springframework.util.StringUtils;

import java.util.List;

public class Xzutils {
    public Xzutils() {
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
}
