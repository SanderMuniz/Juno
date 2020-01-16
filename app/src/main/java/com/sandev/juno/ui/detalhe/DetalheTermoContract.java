package com.sandev.juno.ui.detalhe;

import android.content.Context;

//todo imports
public interface DetalheTermoContract {

    interface view {

    }

    interface presenter {
        void setView(view view);

        public Context getContext();
        //implements code
    }


    interface call {

    }
}
