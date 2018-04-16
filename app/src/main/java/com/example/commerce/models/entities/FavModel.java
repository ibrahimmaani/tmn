package com.example.commerce.models.entities;

/**
 * Created by Arie-Ezio on 11-Apr-18.
 */

public class FavModel {
    private Integer id;
    private String name;
    private Integer price;
    private String url;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {return price;}

    public void setPrice(Integer price) {this.price = price;}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
