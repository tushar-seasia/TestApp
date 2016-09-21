package com.example.bawejatushar.demoapp.api;

/**
 * Created by BawejaTushar on 9/20/2016.
 */
public interface APICallback<T> {
    void onSuccess(T t);
    void onFailure(String errorMessage);
}
