package com.sandev.juno.data.api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class NetworkClient {
    private static final String URL_BASE = "https://api.github.com";

    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
