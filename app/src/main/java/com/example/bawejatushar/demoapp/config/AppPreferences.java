package com.example.bawejatushar.demoapp.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.bawejatushar.demoapp.dtos.UserInfoDTO;
import com.google.gson.Gson;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class AppPreferences {
    private static AppPreferences instance;
    private final Context context;
    protected SharedPreferences sharedPreferences;
    public AppPreferences(Context context) {
        super();
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }
    public static AppPreferences init(Context context) {
        if (null == instance) {
            instance = new AppPreferences(context);
        }
        return instance;
    }
    /**
     * *      Private Methods To Set values in Preferences
     */
    private void setInteger(String key, int val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putInt(key, val);
        e.commit();
    }
    private void setString(String key, String val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString(key, val);
        e.commit();
    }
    private void setBoolean(String key, boolean val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putBoolean(key, val);
        e.commit();
    }
    private void setDouble(String key, double val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putString(key, String.valueOf(val));
        e.commit();
    }
    private void setLong(String key, long val) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.putLong(key, val);
        e.commit();
    }
    private void remove(String key) {
        SharedPreferences.Editor e = sharedPreferences.edit();
        e.remove(key);
        e.commit();
    }
    /**
     * *      Public Methods To Get & Set Preferences
     */
    private static final String KEY_USER_INFO = "USER_INFO";
    public UserInfoDTO getUserInfo() {
        UserInfoDTO userInfoDTO = null;
        try {
            String value = sharedPreferences.getString(KEY_USER_INFO, null);
            if (null != value) {
                userInfoDTO = new Gson().fromJson(value, UserInfoDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userInfoDTO;
    }
    public void setUserInfo(UserInfoDTO userInfoDTO) {
        if (null != userInfoDTO) {
            setString(KEY_USER_INFO, new Gson().toJson(userInfoDTO));
            Log.v("tushar good", new Gson().toJson(userInfoDTO));
        } else {
            remove(KEY_USER_INFO);
        }
    }
}
