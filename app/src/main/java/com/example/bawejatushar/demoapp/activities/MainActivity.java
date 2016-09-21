package com.example.bawejatushar.demoapp.activities;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bawejatushar.demoapp.R;
import com.example.bawejatushar.demoapp.api.APICallback;
import com.example.bawejatushar.demoapp.config.App;
import com.example.bawejatushar.demoapp.dtos.UserInfoDTO;
import com.example.bawejatushar.demoapp.utils.JsonHelper;
import com.example.bawejatushar.demoapp.utils.SnackBarUtils;
import com.example.bawejatushar.demoapp.utils.StringUtils;
import com.example.bawejatushar.demoapp.utils.ToastUtils;

import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.etName)
    EditText etName;
    @Bind(R.id.etMobile)
    EditText etMobile;
    @Bind(R.id.etAddress)
    EditText etAddress;
    @Bind(R.id.etCity)
    EditText etCity;
    @Bind(R.id.etState)
    EditText etState;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        ButterKnife.bind(this);
    }
    @OnClick(R.id.btnSubmit)
    public void onClickSubmit() {
        String name = etName.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String state = etState.getText().toString().trim();
        if (validateFields()) {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.name = name;
            userInfoDTO.address = address;
            userInfoDTO.mobile = mobile;
            userInfoDTO.city = city;
            userInfoDTO.state = state;

            App.getApiHelper().userRegister(userInfoDTO, new APICallback<Map>() {
                @Override
                public void onSuccess(Map map) {
                    if (map != null) {
                        UserInfoDTO userInfoDTO = JsonHelper.getUserInfo(map);
                        App.getAppContext().setUserInfoDTO(userInfoDTO);
                        clearFields();
                        ToastUtils.showToast(getApplicationContext(), "Register Successfully.");
                    }
                }

                @Override
                public void onFailure(String errorMessage) {
                    SnackBarUtils.showSnackBar(activity, errorMessage);
                }
                private void clearFields() {
                    etName.setText("");
                    etAddress.setText("");
                    etMobile.setText("");
                    etCity.setText("");
                    etState.setText("");
                }
            });
        }
    }
    public boolean validateFields() {
        String name = etName.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String address = etAddress.getText().toString().trim();
        String city = etCity.getText().toString().trim();
        String state = etState.getText().toString().trim();
        if (StringUtils.isEmpty(name)) {
            SnackBarUtils.showSnackBar(activity, R.string.error_name_empty);
            return false;
        }
        if (StringUtils.isEmpty(address)) {
            SnackBarUtils.showSnackBar(activity, R.string.error_address_empty);
            return false;
        }
        if (StringUtils.isEmpty(mobile)) {
            SnackBarUtils.showSnackBar(activity, R.string.error_mobile_empty);
            return false;
        }
        if (StringUtils.isEmpty(city)) {
            SnackBarUtils.showSnackBar(activity, R.string.error_city_empty);
            return false;
        }
        if (StringUtils.isEmpty(state)) {
            SnackBarUtils.showSnackBar(activity, R.string.error_state_empty);
            return false;
        }
        if (mobile.length() < 10) {
            SnackBarUtils.showSnackBar(activity, R.string.error_mobile_length);
            return false;
        }
        return true;
    }
}
