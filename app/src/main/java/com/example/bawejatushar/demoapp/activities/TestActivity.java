package com.example.bawejatushar.demoapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.bawejatushar.demoapp.R;
import com.example.bawejatushar.demoapp.api.APICallback;
import com.example.bawejatushar.demoapp.config.App;
import com.example.bawejatushar.demoapp.dtos.Diseases;
import com.example.bawejatushar.demoapp.utils.ToastUtils;

import java.util.List;
import java.util.Map;

public class TestActivity extends AppCompatActivity {

    List<Diseases> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        list=App.getApiHelper().getData(new APICallback<Map>() {
            @Override
            public void onSuccess(Map map) {

            }

            @Override
            public void onFailure(String errorMessage) {

            }
        });

        Log.v("hello list size", String.valueOf(list.size()));
        ToastUtils.showToast(getApplicationContext(), String.valueOf(list.size()));
    }
}
