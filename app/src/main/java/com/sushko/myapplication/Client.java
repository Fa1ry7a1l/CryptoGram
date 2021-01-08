package com.sushko.myapplication;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Client {
    @POST(value = "/get/")
    Call<String> predict1(@Query("userto") Long userTo, @Query("userfrom") Long userFrom, @Query("message") String message);

    @GET(value = "/post/")
    Call<ArrayList<Message>> predict2(@Query("userto") Long userTo);

}
