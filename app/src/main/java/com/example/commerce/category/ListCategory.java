package com.example.commerce.category;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListCategory {
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private List<Category> category = null;
    @SerializedName("count")
    private Integer count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
