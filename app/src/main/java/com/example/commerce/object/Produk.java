package com.example.commerce.object;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Produk {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private Integer price;
    @SerializedName("discount_price")
    private Integer discountPrice;
    @SerializedName("description")
    private String description;
    @SerializedName("status")
    private Integer status;
    @SerializedName("list")
    private Integer list;
    @SerializedName("rating")
    private Integer rating;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("sku")
    private List<Sku> sku = null;
    @SerializedName("category")
    private List<Category> category = null;
    @SerializedName("image_product")
    private List<Object> imageProduct = null;
    @SerializedName("featured")
    private List<Object> featured = null;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getList() {
        return list;
    }

    public void setList(Integer list) {
        this.list = list;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Sku> getSku() {
        return sku;
    }

    public void setSku(List<Sku> sku) {
        this.sku = sku;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<Object> getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(List<Object> imageProduct) {
        this.imageProduct = imageProduct;
    }

    public List<Object> getFeatured() {
        return featured;
    }

    public void setFeatured(List<Object> featured) {
        this.featured = featured;
    }
}
