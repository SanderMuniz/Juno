package com.sandev.juno.ui.detalhe;

import android.content.Context;

//todo imports
public class DetalheTermoPresenter implements DetalheTermoContract.presenter {

    private DetalheTermoCall mCall;
    private DetalheTermoContract.view mView;

    public DetalheTermoPresenter() {
        mCall = new DetalheTermoCall(this);
    }

    @Override
    public void setView(DetalheTermoContract.view view) {
        this.mView = view;
    }

    @Override
    public Context getContext() {
        return null;
    }

    //implements code

}
