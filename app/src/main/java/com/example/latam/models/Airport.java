package com.example.latam.models;

public class Airport {
    private int id;
    private String name;
    private int category;
    private int quantity;
    private double price;

    public Airport() {
    }

    public Airport(String name, int category, int quantity, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void retrieve(int value){
        quantity = quantity - value;
    }

    public void reclaim(int value){
        quantity = quantity + value;
    }

    public String toCurrency(double value){
        return String.format("R$ %.2f", price);
    }
}
