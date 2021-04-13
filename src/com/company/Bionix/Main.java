package com.company.Bionix;

import com.company.Bionix.model.*;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(123);
        customer.setName("Вася");

        Customer customer1 = new Customer();
        customer1.setId(156);
        customer1.setName("Антон");

        Customer customer2 = new Customer();
        customer2.setId(156);
        customer2.setName("Петрос");

        Customer customer3 = new Customer();
        customer3.setId(190);
        customer3.setName("Роман");

        Customer customer4 = new Customer();
        customer4.setId(210);
        customer4.setName("Дюндар");

        Product product1 = new Product();
        product1.setId(1);
        product1.setName("apples");
        product1.setPrice(new BigDecimal("123.44"));

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("bananas");
        product2.setPrice(new BigDecimal("452.44"));

        Product product3 = new Product();
        product3.setId(3);
        product3.setName("oranges");
        product3.setPrice(new BigDecimal("232.33"));

        Product product4 = new Product();
        product4.setId(4);
        product4.setName("lemon");
        product4.setPrice(new BigDecimal("210.45"));

        ShippingDetails shippingDetails = new ShippingDetails();
        shippingDetails.setPrice(new BigDecimal("170.44"));
        shippingDetails.setAddress("here");

        Order order1 = new Order();
        order1.setId(1);
        order1.setCustomer(customer);
        order1.setProducts(new Product[]{product1, product2});
        order1.setStatus(OrderStatus.Paid);
        order1.setDayOfMonth(26);
        order1.setShippingDetails(null);

        Order order2 = new Order();
        order2.setId(2);
        order2.setCustomer(customer);
        order2.setProducts(new Product[]{product1});
        order2.setStatus(OrderStatus.Completed);
        order2.setDayOfMonth(27);
        order2.setShippingDetails(shippingDetails);

        ShippingDetails shippingDetails1 = new ShippingDetails();
        shippingDetails1.setPrice(new BigDecimal("40.44"));
        shippingDetails1.setAddress("Malta, Jonior st. 12 fl 564773");

        Order order3 = new Order();
        order3.setId(3);
        order3.setCustomer(customer1);
        order3.setProducts(new Product[]{product1, product1, product2, product3});
        order3.setStatus(OrderStatus.Paid);
        order3.setDayOfMonth(16);
        order3.setShippingDetails(shippingDetails1);

        Order order4 = new Order();
        order4.setId(4);
        order4.setCustomer(customer1);
        order4.setProducts(new Product[]{product3, product4, product4});
        order4.setStatus(OrderStatus.Shipping);
        order4.setDayOfMonth(14);
        order4.setShippingDetails(shippingDetails1);

        ShippingDetails shippingDetails2 = new ShippingDetails();
        shippingDetails2.setPrice(new BigDecimal("55.44"));
        shippingDetails2.setAddress("Wadenstown,Tofinwill");

        Order order5 = new Order();
        order5.setId(5);
        order5.setCustomer(customer2);
        order5.setProducts(new Product[]{product1, product1, product1, product1, product2, product3});
        order5.setStatus(OrderStatus.Shipping);
        order5.setDayOfMonth(24);
        order5.setShippingDetails(shippingDetails2);

        ShippingDetails shippingDetails3 = new ShippingDetails();
        shippingDetails3.setPrice(new BigDecimal("65.44"));
        shippingDetails3.setAddress("Greece");

        Order order6 = new Order();
        order6.setId(6);
        order6.setCustomer(customer3);
        order6.setProducts(new Product[]{product1, product1, product2, product3, product4, product4, product4});
        order6.setStatus(OrderStatus.DeliveryExpected);
        order6.setDayOfMonth(17);
        order6.setShippingDetails(shippingDetails3);


        ShippingDetails shippingDetails4 = new ShippingDetails();
        shippingDetails4.setPrice(new BigDecimal("76.44"));
        shippingDetails4.setAddress("Spain");

        Order order7 = new Order();
        order7.setId(7);
        order7.setCustomer(customer4);
        order7.setProducts(new Product[]{product1, product1, product2, product3, product4});
        order7.setStatus(OrderStatus.DeliveryExpected);
        order7.setDayOfMonth(19);
        order7.setShippingDetails(shippingDetails4);


        Order[] orders = new Order[]{order1, order2, order3, order4, order5, order6, order7};

        System.out.println("Products with Delivery expected status  : ");
        for (Order order : orders) {
            if (OrderStatus.DeliveryExpected == order.getStatus()) {
                String address = order.getShippingDetails() == null
                        ? "no shipping" : order.getShippingDetails().address;
                System.out.println("id   " + order.getId() + "\nname          "
                        + order.getCustomer().getName() + "\ncustomer ID   " + order.getCustomer().getId() + "\naddress       " + address + "\n");
            }
        }

        int apple = 0, banana = 0, orange = 0, lemon = 0;
        for (Order order : orders) {
            for (Product product : order.getProducts()) {
                switch (product.getName()) {
                    case "apples":
                        apple++;
                        break;
                    case "bananas":
                        banana++;
                        break;
                    case "oranges":
                        orange++;
                        break;
                    case "lemon":
                        lemon++;
                        break;
                }
            }
        }
        System.out.println("Ordered products : " + "\n" +
                "Apples : " + apple + "\n" +
                "Bananas : " + banana + "\n" +
                "Oranges : " + orange + "\n" +
                "Lemon : " + lemon + "\n");


        int vasiliOrdersCount = 0, dundarOrdersCount = 0, romanOrdersCount = 0, petrosOrdersCount = 0, antonOrdersCount = 0;
        BigDecimal vasiliOrdersCost = BigDecimal.ZERO, dundarOrdersCost = BigDecimal.ZERO, romanOrdersCost = BigDecimal.ZERO,
                petrosOrdersCost = BigDecimal.ZERO, antonOrdersCost = BigDecimal.ZERO;
        BigDecimal vasiliDeliveryCost = BigDecimal.ZERO, dundarDeliveryCost = BigDecimal.ZERO, romanDeliveryCost = BigDecimal.ZERO,
                petrosDeliveryCost = BigDecimal.ZERO, antonDeliveryCost = BigDecimal.ZERO;

        for (Order order : orders) {
            switch (order.getCustomer().getName()) {
                case "Вася":
                    vasiliOrdersCount++;
                    vasiliOrdersCost = vasiliOrdersCost.add(order.getCost());
                    vasiliDeliveryCost = vasiliDeliveryCost.add(order.getShippingDetails() == null ?
                            BigDecimal.ZERO : order.getShippingDetails().getPrice());
                    break;
                case "Петрос":
                    petrosOrdersCount++;
                    petrosOrdersCost = petrosOrdersCost.add(order.getCost());
                    petrosDeliveryCost = petrosDeliveryCost.add(order.getShippingDetails() == null ?
                            BigDecimal.ZERO : order.getShippingDetails().getPrice());
                    break;
                case "Роман":
                    romanOrdersCount++;
                    romanOrdersCost = romanOrdersCost.add(order.getCost());
                    romanDeliveryCost = romanDeliveryCost.add(order.getShippingDetails() == null ?
                            BigDecimal.ZERO : order.getShippingDetails().getPrice());
                    break;
                case "Антон":
                    antonOrdersCount++;
                    antonOrdersCost = antonOrdersCost.add(order.getCost());
                    antonDeliveryCost = antonDeliveryCost.add(order.getShippingDetails() == null ?
                            BigDecimal.ZERO : order.getShippingDetails().getPrice());
                    break;
                case "Дюндар":
                    dundarOrdersCount++;
                    dundarOrdersCost = dundarOrdersCost.add(order.getCost());
                    dundarDeliveryCost = dundarDeliveryCost.add(order.getShippingDetails() == null ?
                            BigDecimal.ZERO : order.getShippingDetails().getPrice());
                    break;

            }
        }
        System.out.println("Vasili's orders :  " + vasiliOrdersCount + ",   cost : " + vasiliOrdersCost + ",    Delivery : " + vasiliDeliveryCost + "\n" +
                "Petros's orders :  " + petrosOrdersCount + ",   cost : " + petrosOrdersCost + ",   Delivery : " + petrosDeliveryCost + "\n" +
                "Dundar's orders :  " + dundarOrdersCount + ",   cost : " + dundarOrdersCost + ",    Delivery : " + dundarDeliveryCost + "\n" +
                "Anton's orders  :  " + antonOrdersCount + ",   cost : " + antonOrdersCost + ",   Delivery : " + antonDeliveryCost + "\n" +
                "Roman's orders  :  " + romanOrdersCount + ",   cost : " + romanOrdersCost + ",    Delivery : " + romanDeliveryCost + "\n");


        TablePrinter tablePrinter = new TablePrinter();
        System.out.println("Table sorted dy quantity  :\n");
        tablePrinter.printTableQuantity(orders);
        System.out.println();

        System.out.println("Table sorted dy money  :\n");
        tablePrinter.printTableMoney(orders);
        System.out.println();
    }
}