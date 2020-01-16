package com.sandev.juno.ui.detalhe;

public class DetalheTermoCall implements DetalheTermoContract.call {

    private DetalheTermoContract.presenter mPresenter;

    public DetalheTermoCall(DetalheTermoContract.presenter presenter) {
        this.mPresenter = presenter;
    }

}