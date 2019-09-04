package com.andalus.youseftasks;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static Retrofit instance;

    private static Retrofit getClient(){
        if (instance == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


            instance = new Retrofit.Builder().baseUrl("http://api.openweathermap.org/data/2.5/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
    static UserClient getService(){
        return getClient().create(UserClient.class);
    }
}
