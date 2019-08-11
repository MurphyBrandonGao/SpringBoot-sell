package com.action.utils;

/**
 * @author Dell
 * @create 2019-08-11 15:43
 */
public class MathUtil {

    private static final double MONEY_RANGE = 0.01;
    /**
     * 比较两个金额是否相等
     * @param d1
     * @param d2
     * @return
     */
    public static boolean equals(Double d1, Double d2) {
        double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        }
        else
            return false;
    }
}
