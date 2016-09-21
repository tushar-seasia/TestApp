package com.example.bawejatushar.demoapp.api;

import com.example.bawejatushar.demoapp.config.App;
import com.example.bawejatushar.demoapp.config.Logger;
import com.example.bawejatushar.demoapp.dtos.Diseases;
import com.example.bawejatushar.demoapp.dtos.UserInfoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class APIHelper {
    private static APIHelper instance;
    private APIService apiService;
    private App app;
    public static synchronized APIHelper init(App app) {
        if (null == instance) {
            instance = new APIHelper();
            instance.setApplication(app);
            instance.initAPIService();
        }
        return instance;
    }
    private void setApplication(App app) {
        this.app = app;
    }
    private void initAPIService() {
        OkHttpClient okHttpClient = new OkHttpClient();
        //Define Logger Interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(Logger.isIsLogEnabled() ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        okHttpClient.interceptors().add(loggingInterceptor);
        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://lifebeat.16mb.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
        apiService = retrofit.create(APIService.class);
        //http://chestter.16mb.com/android/
    }

    public void userRegister(UserInfoDTO userInfoDTO, final APICallback<Map> callback){
        apiService.userRegister(userInfoDTO).enqueue(new retrofit.Callback<Map>() {
            @Override
            public void onResponse(retrofit.Response<Map> response, Retrofit retrofit) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                callback.onFailure("unable to get data from server");
            }
        });
    }

}