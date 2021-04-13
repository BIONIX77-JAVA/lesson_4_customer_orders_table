package com.company.Bionix;

import com.company.Bionix.model.OrderStatus;
import com.company.Bionix.model.ShippingDetails;

import java.math.BigDecimal;

public class TableItem {
    public int orderId;
    public int dayOfMonth;
    public OrderStatus orderStatus;
    public String productName;
    public int quantity;
    public String customerName;
    public BigDecimal totalPrice;
    public boolean isShipping;
    public BigDecimal shippingDetailsPrice;

    public int compareTo(TableItem other) {
        int dayOfMonthResult = Integer.compare(
                other.dayOfMonth, this.dayOfMonth);
        if (dayOfMonthResult != 0) {
            return dayOfMonthResult;
        }

        int statusResult = Integer.compare(
                this.orderStatus.ordinal(),
                other.orderStatus.ordinal());
        if (statusResult != 0) {
            return statusResult;
        }

        int customerResult = this.customerName.compareTo(other.customerName);
        if (customerResult != 0) {
            return customerResult;
        }

        int priceResult = other.totalPrice.compareTo(this.totalPrice);
        if (priceResult != 0) {
            return priceResult;
        }

        int shippingPriceResult = other.shippingDetailsPrice.compareTo(this.shippingDetailsPrice);
        if (shippingPriceResult != 0) {
            return shippingPriceResult;
        }
        return 0;
    }

    public int compareToPrice(TableItem other) {
        int priceResult = other.totalPrice.compareTo(this.totalPrice);
        if (priceResult != 0) {
            return priceResult;
        }

        return 0;
    }

    public int compareToQuantity(TableItem other) {
        int quantityResult = Integer.compare(
                other.quantity, this.quantity);
        if (quantityResult != 0) {
            return quantityResult;
        }
        return 0;
    }
}