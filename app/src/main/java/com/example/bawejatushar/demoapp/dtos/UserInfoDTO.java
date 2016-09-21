package com.example.bawejatushar.demoapp.dtos;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public class UserInfoDTO implements Serializable {
    @SerializedName("name")
    public String name;
    @SerializedName("address")
    public String address;
    @SerializedName("mobile")
    public String mobile;
    @SerializedName("city")
    public String city;
    @SerializedName("state")
    public String state;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
