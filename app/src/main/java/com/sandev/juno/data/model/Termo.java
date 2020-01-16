package com.sandev.juno.data.model;

public class Termo {

    private int _id;
    private String id;
    private String name;
    private String nameSearch;
    private String full_name;
    private String description;
    private double score;

    public Termo(int _id, String id, String name, String nameSearch, String full_name, String description, double score) {
        this._id = _id;
        this.id = id;
        this.name = name;
        this.nameSearch = nameSearch;
        this.full_name = full_name;
        this.description = description;
        this.score = score;
    }

    public Termo() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSearch() {
        return nameSearch;
    }

    public void setNameSearch(String nameSearch) {
        this.nameSearch = nameSearch;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
