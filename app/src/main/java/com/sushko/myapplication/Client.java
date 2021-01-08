package com.sushko.myapplication;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Client {
    @GET(value = "/get/")
    Call<String> predict(@Query("userto") Long userTo, @Query("userfrom") Long userFrom, @Query("message") String message);

    @POST(value = "/post/")
    Call<ArrayList<Message>> predict(@Query("userto") Long userTo);

}
