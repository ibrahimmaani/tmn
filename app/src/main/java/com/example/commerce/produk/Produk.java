package com.example.commerce.produk;

public class Produk {
    private int id;
    private String name;
    private Long price;
    private Long discountprice;
    private String description;
    private Long list;
    private Long rating;
    private Long status;

    public Produk(){}

    public Produk(int id, String name, Long price, Long discountprice, String description,
                  Long list, Long rating, Long status){
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountprice = discountprice;
        this.description = description;
        this.list = list;
        this.rating = rating;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(Long discountprice) {
        this.discountprice = discountprice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getList() {
        return list;
    }

    public void setList(Long list) {
        this.list = list;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
