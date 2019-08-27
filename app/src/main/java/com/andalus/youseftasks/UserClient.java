package com.andalus.youseftasks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserClient {

    @GET ("weather")
    Call<Weather> getWeather(@Query("q") String name, @Query("APPID") int key);
}
