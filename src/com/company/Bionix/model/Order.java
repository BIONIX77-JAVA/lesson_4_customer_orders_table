package com.company.Bionix.model;

import java.math.BigDecimal;

public class Order {
    private int id;
    private Product[] products;
    private Customer customer;
    private ShippingDetails shippingDetails;
    private int dayOfMonth;
    private OrderStatus status;

    public BigDecimal getCost(){
        BigDecimal cost = BigDecimal.ZERO;
        for (Product product : products) {
            cost=cost.add(product.getPrice());
        }
        return cost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Product[] getProducts() {
        return products;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}