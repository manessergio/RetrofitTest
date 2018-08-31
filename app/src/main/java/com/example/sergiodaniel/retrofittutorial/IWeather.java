package com.example.sergiodaniel.retrofittutorial;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IWeather {

    @GET("forecast/ed0d57047cf5fd8a804baf1d1ea069b4/{latitude},{longitude}")
    Call<Weather> call(@Path("latitude") double latitude,
                       @Path("longitude") double longitude);
}
