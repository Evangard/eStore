package framework.enums;

import framework.config.TestConfig;
import framework.models.Customer;

public enum Customers {
    TEST_USER(Customer.newBuilder()
            .withPassword(TestConfig.CONFIG.userPassword())
            .withEmail(TestConfig.CONFIG.userEmail())
            .build());

    final Customer customer;

    Customers(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }
}
