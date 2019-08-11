package com.action.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Dell
 * @create 2019-08-11 11:39
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
