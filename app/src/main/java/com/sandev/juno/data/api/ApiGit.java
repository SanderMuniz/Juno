package com.sandev.juno.data.api;

import com.sandev.juno.data.model.Retorno;

import retrofit.Call;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Query;


public interface ApiGit {
    String getTerm = "/search/repositories";

    @GET(getTerm)
    Call<Retorno> getTermo(@Query(value = "q") String q);
}