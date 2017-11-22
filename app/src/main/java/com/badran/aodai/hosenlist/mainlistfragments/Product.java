package com.badran.aodai.hosenlist.mainlistfragments;

import android.widget.EditText;

/**
 * Created by user on 20/11/2017.
 */

class Product {
    private double amount;
    private double price;
    private boolean iscompleted=false;

    public void setName() {
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCompleted(boolean completed) {
        this.iscompleted = completed;
    }

    public void setName(EditText etName) {
    }
}
