package com.example.commerce.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arie-Ezio on 19-Jan-18.
 */

public class ListProduk {
    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private Data data;
    @SerializedName("count")
    private Integer count;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
