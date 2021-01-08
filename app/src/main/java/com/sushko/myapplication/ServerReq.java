package com.sushko.myapplication;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerReq {
    private static String PREDICTOR_URI_JSON = "http://10.132.50.88:8080/";
    public static void updateMessages (Long userFor){
        Log.d("server","Зашли в updateMessages");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PREDICTOR_URI_JSON)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Client service = retrofit.create(Client.class);
        Call<ArrayList<Message>> call  = service.predict2(userFor);

        call.enqueue(new Callback<ArrayList<Message>>() {
            @Override
            public void onResponse(Call<ArrayList<Message>> call, Response<ArrayList<Message>> response) {
                try {
                    /*for (Message message: response.body() ) {
                    /////////////////////////////ТУТ НАДО ДОБАВИТЬ ДОБАВЛЕНИЕ СООБЩЕНИЙ

                    }*/

                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("Suc","Сообщение получено");
            }
            @Override
            public void onFailure(Call<ArrayList<Message>> call, Throwable t) {
                Log.e("Err","Ошибка при получении ответа сервера");
            }
        });
    }

}
