package com.sandev.juno.data.model;

import java.util.List;

public class Retorno {
    private List<Termo> items;

    public Retorno(List<Termo> items) {
        this.items = items;
    }

    public List<Termo> getItems() {
        return items;
    }
}
