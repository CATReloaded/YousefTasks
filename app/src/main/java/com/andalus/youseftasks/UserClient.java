package com.andalus.youseftasks;

import com.andalus.youseftasks.weather.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserClient {

    @GET ("weather")
    Call<WeatherResponse> getWeather(@Query("q") String name, @Query("APPID") String key);
}
