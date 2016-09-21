package com.example.bawejatushar.demoapp.config;

import android.support.multidex.MultiDexApplication;

import com.example.bawejatushar.demoapp.api.APIHelper;
import com.example.bawejatushar.demoapp.dtos.UserInfoDTO;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class App extends MultiDexApplication {
    private static AppPreferences preferences;
    private static APIHelper apiHelper;
    private static App instance;
    private UserInfoDTO userInfoDTO;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        preferences = AppPreferences.init(this);
        apiHelper = APIHelper.init(this);
        //JsonHelper.init();
        //userInfoDTO = preferences.getUserInfo();
    }
    public static App getAppContext() {
        return instance;
    }

    public static synchronized AppPreferences getPreferences() {
        return preferences;
    }

    public static synchronized APIHelper getApiHelper() {
        return apiHelper;
    }

    public UserInfoDTO getUserInfoDTO() {
        return userInfoDTO;
    }
    public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
        this.userInfoDTO = userInfoDTO;
        preferences.setUserInfo(userInfoDTO);
    }
}
