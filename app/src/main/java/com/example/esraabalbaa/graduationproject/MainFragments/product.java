package com.example.esraabalbaa.graduationproject.MainFragments;

/**
 * Created by reham moamed on 10/04/2017.
 */

public class product {
    private String name;
    private int price;
    private int thumbnail;


    public product(String name, int price, int thumbnail) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getThumbnail() {
        return thumbnail;

    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;

    }
}


