package com.ecommerce;

public class Product {
    private String productID;
    private String name;
    private double price;

    public Product(String productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }
    
    //GetSetFunctions

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

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

    //ToString Override To Show The Details Of The Product
    @Override
    public String toString() {
        return "Product [ID=" + productID + ", Name=" + name + ", Price=" + price + "]";
    }
}
