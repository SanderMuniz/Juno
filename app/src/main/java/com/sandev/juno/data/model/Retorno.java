package com.sandev.juno.data.model;

import java.util.List;

public class Retorno {
    private int total_count;
    private boolean incomplete_results;
    private List<Termo> items;

    public Retorno(int total_count, boolean incomplete_results, List<Termo> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public Retorno() {
    }

    public List<Termo> getItems() {
        return items;
    }
}
