package com.sandev.juno.ui.lista;

import android.content.Context;
import android.util.Log;

import com.sandev.juno.data.model.Retorno;
import com.sandev.juno.data.model.Termo;

import java.util.List;

import retrofit.Response;

//todo imports
public class ListaTermosPresenter implements ListaTermosContract.presenter {

    private ListaTermosCall mCall;
    private ListaTermosContract.view mView;
    private Context mContext;

    public ListaTermosPresenter() {
        mCall = new ListaTermosCall(this);
    }

    @Override
    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void setView(ListaTermosContract.view view) {
        this.mView = view;
    }

    @Override
    public Context getContext() {
        return null;
    }

    //implements code

    @Override
    public void buscar(String termo, Context context) {
        Log.i("teste", "buscar:  presenter");
        mCall.buscar(termo);
    }

    @Override
    public void retornaDados(Response response) {
        Retorno retorno = (Retorno) response.body();
        List<Termo> list = retorno.getItems();
        mView.retornaLista(list);
    }


}
