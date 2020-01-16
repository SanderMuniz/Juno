package com.sandev.juno.data.model;

import java.util.List;

public class Retorno {
    private List<Termo> items;

    public Retorno(int total_count, boolean incomplete_results, List<Termo> items) {
        this.items = items;
    }

    public List<Termo> getItems() {
        return items;
    }
}
