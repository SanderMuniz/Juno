package com.sandev.juno.ui.lista;

import android.content.Context;

import com.sandev.juno.data.model.Termo;

import java.util.List;

import retrofit.Response;

//todo imports
public interface ListaTermosContract {

    interface view {
        void retornaLista(List<Termo> list);
    }

    interface presenter {
        void setView(view view);

        public Context getContext();

        void buscar(String termo, Context context);
        //implements code
        void retornaDados(Response response);

        void setContext(Context context);
    }


    interface call {

    }
}
