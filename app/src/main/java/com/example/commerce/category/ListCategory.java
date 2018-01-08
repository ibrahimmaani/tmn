package com.example.commerce.category;


import java.util.ArrayList;

public class ListCategory {
    private String status;
    private String count;
    private ArrayList<Category> data = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ListCategory(String status) {

        this.status = status;
    }

    public ArrayList<Category> getData() {
        return data;
    }

    public void setData(ArrayList<Category> data) {
        this.data = data;
    }

    public String getCount() {

        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
