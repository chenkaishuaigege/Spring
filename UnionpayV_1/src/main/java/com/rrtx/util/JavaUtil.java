package com.rrtx.util;

public class JavaUtil {

    public static boolean isEmpty(String[] s) {
        if(s == null){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isEmpty(String s) {
        return null == s || "".equals(s.trim());
    }

}
