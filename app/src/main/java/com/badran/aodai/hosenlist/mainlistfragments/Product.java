package com.badran.aodai.hosenlist.mainlistfragments;

import android.widget.EditText;

/**
 * Created by user on 20/11/2017.
 */

class Product {

    private String name;

    private double price;
    private double amount;

    private boolean isCompeleted;

    private String imgPath;

    private String KeyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isCompeleted() {
        return isCompeleted;
    }

    public void setCompeleted(boolean compeleted) {
        isCompeleted = compeleted;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getKeyId() {
        return KeyId;
    }

    public void setKeyId(String keyId) {
        KeyId = keyId;
    }

    public Product(String name, double price, double amount, boolean isCompeleted, String imgPath, String keyId) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isCompeleted = isCompeleted;
        this.imgPath = imgPath;
        KeyId = keyId;
    }

    public Product(String name, double price, double amount, boolean isCompeleted, String imgPath) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.isCompeleted = isCompeleted;
        this.imgPath = imgPath;
    }

    public Product() {
    }

}









