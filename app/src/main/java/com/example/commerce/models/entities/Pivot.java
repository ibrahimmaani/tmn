package com.example.commerce.models.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hamdhanywijaya@gmail.com on 02/02/18.
 */

public class Pivot {
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
