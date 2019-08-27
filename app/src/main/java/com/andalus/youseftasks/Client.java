package com.andalus.youseftasks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Retrofit instance;

    private static Retrofit getClient(){
        if (instance == null){
            instance = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
    static UserClient getService(){
        return getClient().create(UserClient.class);
    }
}
