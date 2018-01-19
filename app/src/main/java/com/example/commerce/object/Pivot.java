package com.example.commerce.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arie-Ezio on 19-Jan-18.
 */

public class Pivot {
    @SerializedName("product_id")
    private Integer productId;
    @SerializedName("category_id")
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
