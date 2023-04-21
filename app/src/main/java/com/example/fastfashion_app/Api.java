package com.example.fastfashion_app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "http://10.0.2.2/fast-fashion/api/";
    @GET("users")
    Call<List<Results>> getUsers(@Header("Key") String Key);

    @GET("allproducts")
    Call<List<ResultsProducts>> getProducts(@Header("Key") String Key);


    @POST("user/post")

    Call<ResultsPost> postUser(@Header("Name") String name,@Header("Email") String email, @Header("Password") String password);}