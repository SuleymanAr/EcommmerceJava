package com.ecommerce.orders;
import com.ecommerce.Customer;
import com.ecommerce.Product;
import java.util.List;

public class Order {
    private String orderID;
    private Customer customer;
    private List<Product> products;
    private double orderTotal;

    public Order(String orderID, Customer customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
        this.orderTotal = calculateOrderTotal();
    }

    //Calculation total of all the product prices
    private double calculateOrderTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    //GetSet Functions
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        this.orderTotal = calculateOrderTotal();
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    //Order Summary Function to display all the info
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order ID: ").append(orderID)
               .append("\nCustomer: ").append(customer.getName())
               .append("\nProducts: \n");
        for (Product product : products) {
            summary.append(product.toString()).append("\n");
        }
        summary.append("Total: $ ").append(orderTotal);
        return summary.toString();
    }

    @Override
    public String toString() {
        return "Order [ID=" + orderID + ", Customer=" + customer.getName() + ", Total= $" + orderTotal + "]";
    }
}
