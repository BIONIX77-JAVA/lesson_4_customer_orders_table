package com.company.Bionix;

import com.company.Bionix.model.Order;
import com.company.Bionix.model.Product;
import com.company.Bionix.model.ShippingDetails;
import com.company.Bionix.TableItem;

import java.math.BigDecimal;

public class TablePrinter {
    private static final String HEADER_FORMAT = "%5s%7s%18s%15s%15s%14s%8s%12s%17s";
    private static final String ROW_FORMAT = "%5d%7d%18s%15s%11d%14s%14s%8s%17f";

    public void printTable(Order[] orders) {
        TableItem[] table = createTable(orders);
        sortTable(table);
        printSortedTable(table);
    }

    public void printTableMoney(Order[] orders) {
        TableItem[] table = createTable(orders);
        sortTableMoney(table);
        printSortedTable(table);
    }

    public void printTableQuantity(Order[] orders) {
        TableItem[] table = createTable(orders);
        sortTableQuantity(table);
        printSortedTable(table);
    }

//    private String getProductsName(Product[] products) {
//        String names = "";
//        for (int i = 0; i < products.length; i++) {
//            names += products[i].getName() + ", ";
//        }
//        return names;
//    }

    private TableItem[] createTable(Order[] orders) {
        TableItem[] result = new TableItem[orders.length];

        for (int i = 0; i < orders.length; i++) {
            Order order = orders[i];

            Product product = order.getProducts()[0];
            boolean isShipping = order.getShippingDetails() != null;

            TableItem tableItem = new TableItem();
            tableItem.orderId = order.getId();
            tableItem.dayOfMonth = order.getDayOfMonth();
            tableItem.orderStatus = order.getStatus();
            tableItem.productName = product.getName();
            tableItem.quantity = order.getProducts().length;
            tableItem.customerName = order.getCustomer().getName();
            tableItem.totalPrice = getTotalPrice(
                    order.getProducts(), order.getShippingDetails());
            tableItem.isShipping = isShipping;
            tableItem.shippingDetailsPrice = getShippingDetailsPrice(order.getProducts(), order.getShippingDetails());
            result[i] = tableItem;
        }
        return result;
    }

    private void sortTable(TableItem[] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[i].compareTo(items[j]) < 0) {
                    TableItem item = items[j];
                    items[j] = items[i];
                    items[i] = item;
                }
            }
        }
    }

    private void sortTableMoney(TableItem[] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[i].compareToPrice(items[j]) < 0) {
                    TableItem item = items[j];
                    items[j] = items[i];
                    items[i] = item;
                }
            }
        }
    }

    private void sortTableQuantity(TableItem[] items) {
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (items[i].compareToQuantity(items[j]) < 0) {
                    TableItem item = items[j];
                    items[j] = items[i];
                    items[i] = item;
                }
            }
        }
    }

    private void printSortedTable(TableItem[] items) {

        System.out.printf(HEADER_FORMAT,
                "ID",
                "Day",
                "Status",
                "Product",
                "Quantity",
                "Customer",
                "Total",
                "Shipping",
                "ShippingPrice");
        System.out.println();

        for (int i = 0; i < items.length; i++) {
            TableItem tableItem = items[i];

            System.out.printf(ROW_FORMAT,
                    tableItem.orderId,
                    tableItem.dayOfMonth,
                    tableItem.orderStatus,
                    tableItem.productName,
                    tableItem.quantity,
                    tableItem.customerName,
                    tableItem.totalPrice,
                    tableItem.isShipping ? "Yes" : "No",
                    tableItem.shippingDetailsPrice
            );
            System.out.println();
        }
    }

    private BigDecimal getTotalPrice(Product[] products,
                                     ShippingDetails shippingDetails) {
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];

            result = result.add(product.getPrice());
        }

        if (shippingDetails != null) {
            result = result.add(shippingDetails.getPrice());
        }

        return result;
    }


    private BigDecimal getTotalPriceForProduct(Product[] products) {
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];

            result = result.add(product.getPrice());
        }
        return result;
    }


    private BigDecimal getShippingDetailsPrice(Product[] products, ShippingDetails shippingDetails) {
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 0; i < products.length; i++) {
            if (shippingDetails != null) {
                result = result.add(shippingDetails.getPrice());
            }
        }
        return result;
    }
}