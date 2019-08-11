package com.action.utils;

import com.action.enums.CodeEnum;

/**
 * @author Dell
 * @create 2019-08-11 18:18
 */
public class EnumUtil {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode()))
                return each;
        }
        return null;
    }
}
