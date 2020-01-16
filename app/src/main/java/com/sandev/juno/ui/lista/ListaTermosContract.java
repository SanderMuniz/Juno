package com.sandev.juno.ui.lista;

import android.content.Context;

import com.sandev.juno.data.model.Termo;

import java.util.List;

import retrofit.Response;

//todo imports
public interface ListaTermosContract {

    interface view {
        void retornaLista(List<Termo> list);

        void informaUI(String mensagem);
    }

    interface presenter {
        void setView(view view);

        @SuppressWarnings("SameReturnValue")
        Context getContext();

        void buscar(String termo, Context context);
        //implements code
        void retornaDados(Response response);

    }


    interface call {
        void buscar(String termo);
    }
}
