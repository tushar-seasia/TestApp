package com.example.bawejatushar.demoapp.utils;

import com.example.bawejatushar.demoapp.config.Logger;
import com.example.bawejatushar.demoapp.dtos.UserInfoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class JsonHelper {
    private static JsonHelper instance;
    private static Gson gson;
    private JsonHelper() {
        super();
    }
    public static synchronized JsonHelper init() {
        if (null == instance) {
            instance = new JsonHelper();
            gson = new GsonBuilder().serializeNulls().create();
        }
        return instance;
    }
    /*====================================================================*/
    public static void putData(JSONObject jsonObject, String key, Object value) {
        try {
            jsonObject.put(key, value);
        } catch (JSONException e) {
            Logger.error("JSON: " + key + "->" + value + "\n" + e.getMessage());
        }
    }
    public static boolean getBoolean(JSONObject jsonObject, String key) {
        boolean value = false;
        try {
            value = jsonObject.getBoolean(key);
        } catch (JSONException e) {
            Logger.error("JSON: " + key + "->" + value + "\n" + e.getMessage());
        }
        return value;
    }
    public static String getString(JSONObject jsonObject, String key) {
        String value = null;
        try {
            value = jsonObject.getString(key);
        } catch (JSONException e) {
            Logger.error("JSON: " + key + "->" + value + "\n" + e.getMessage());
        }
        return value;
    }
    /*====================================================================*/
    public static UserInfoDTO getUserInfo(Map map) {
        UserInfoDTO userInfoDTO = null;
        try {
            userInfoDTO = gson.fromJson(gson.toJson(map), UserInfoDTO.class);
        } catch (Exception e) {
            Logger.error("Unable to parse user info" + "\n" + e.getMessage());
        }
        return userInfoDTO;
    }
}
