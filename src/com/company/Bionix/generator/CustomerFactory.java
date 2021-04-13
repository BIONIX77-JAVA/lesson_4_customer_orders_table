package com.company.Bionix.generator;

import com.company.Bionix.model.Customer;

public class CustomerFactory {

    public Customer create() {
        Customer customer = new Customer();
        customer.setId((int) (Math.random() * 100));
        return customer;
    }

}