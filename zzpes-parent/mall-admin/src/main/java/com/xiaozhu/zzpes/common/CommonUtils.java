package com.xiaozhu.zzpes.common;

import com.mysql.cj.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 2020/8/9 xiaozhu Create 1.0 <br>
 * @version 1.0.0
 * @description 描述。
 * @copyright ©2019-2019 cbcc.cn. All Copyright Reserved.
 */
public class CommonUtils {
    public static boolean isNullOrEmpty(String o){
        if(StringUtils.isNullOrEmpty(o)){
            return true;
        }else{
            return false;
        }
    }

    public static Date getCurrentDate(){
        return new Date();
    }

    public static Date getDateFromStr(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            try {
                return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return new Date();
    }

    public static Long getCurrentUserId(){
        return Long.valueOf(15);
    }
}
