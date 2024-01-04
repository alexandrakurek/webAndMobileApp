package com.alexandrakurek.androidapi.services;

import android.app.Activity;

import com.alexandrakurek.androidapi.LoginRequest;
import com.alexandrakurek.androidapi.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("login")
    Call<LoginResponse>loginUser(@Body LoginRequest loginRequest);

}
