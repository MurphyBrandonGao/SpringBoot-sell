package com.action.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * cookie工具类
 * @author Dell
 * @create 2019-08-13 1:17
 */
public class CookieUtil {
    /**
     * 设置cookie
     * @param response http响应
     * @param name cookie名
     * @param value cookie值
     * @param maxAge 生存时间
     */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 获取cookie
     * @param request http请求
     * @param name cookie名
     * @return cookie
     */
    public static Cookie get(HttpServletRequest request,
                           String name) {
        Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name))
            return cookieMap.get(name);
        else
            return null;
    }

    /**
     * 将cookie封装成map
     * @param request http请求
     * @return map
     */
    public static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
