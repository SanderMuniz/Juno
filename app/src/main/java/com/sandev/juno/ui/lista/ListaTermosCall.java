package com.sandev.juno.ui.lista;

import android.util.Log;

import com.sandev.juno.data.api.ApiGit;
import com.sandev.juno.data.api.NetworkClient;
import com.sandev.juno.data.model.Retorno;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ListaTermosCall implements ListaTermosContract.call {

    private ListaTermosContract.presenter mPresenter;

    public ListaTermosCall(ListaTermosContract.presenter presenter) {
        this.mPresenter = presenter;
    }

    public void buscar(String termo) {
        Retrofit retrofit = NetworkClient.getRetrofitClient();
        ApiGit api = retrofit.create(ApiGit.class);
        Call<Retorno> call = api.getTermo(termo);
        call.enqueue(new Callback<Retorno>() {
            @Override
            public void onResponse(Response<Retorno> response, Retrofit retrofit) {
                Log.i("teste", "onResponse: " + response.body());
                mPresenter.retornaDados(response);
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}