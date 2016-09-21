package com.example.bawejatushar.demoapp.api;

import com.example.bawejatushar.demoapp.dtos.Diseases;
import com.example.bawejatushar.demoapp.dtos.UserInfoDTO;

import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;


/**
 * Created by BawejaTushar on 9/20/2016.
 */
public interface APIService {
    @GET("get_data_in_json_format.php")
    public void getData(Callback<List<Diseases>> response);

    @POST("registeruser.php")
    Call<Map> userRegister(@Body UserInfoDTO userInfoDTO);
}
