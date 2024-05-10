package com.sqlitedemo.model;

import java.io.Serializable;

public class Item implements Serializable {
    private int id;
    private String title, category, price, date;

    public Item() {
    }

    public Item(int id, String title, String category, String price, String date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public Item(String title, String category, String price, String date) {
        this.title = title;
        this.category = category;
        this.price = price;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}
