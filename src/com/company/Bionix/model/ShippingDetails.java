package com.company.Bionix.model;

import java.math.BigDecimal;

public class ShippingDetails {
    public BigDecimal price;
    public String address;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}