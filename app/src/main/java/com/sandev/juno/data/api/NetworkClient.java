package com.sandev.juno.data.api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class NetworkClient {
    public static final String URL_BASE = "https://api.github.com";

    public static Retrofit retrofit;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            //Defining the Retrofit using Builder
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE) //This is the only mandatory call on Builder object.
                    .addConverterFactory(GsonConverterFactory.create()) // Convertor library used to convert response into POJO
                    .build();
        }
        return retrofit;
    }
}
