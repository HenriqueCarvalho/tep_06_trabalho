package com.example.henriquecarvalho.tep_06_trabalho;

/**
 * Created by henriquecarvalho on 2016-07-25.
 */
public class Cost {
    private TypeCost type;
    private String date;
    private double price;

    public Cost(TypeCost type, String date, double price) {
        this.type = type;
        this.date = date;
        this.price = price;
    }

    public TypeCost getType() {
        return type;
    }

    public void setType(TypeCost type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
