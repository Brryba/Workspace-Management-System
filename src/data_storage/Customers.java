package data_storage;

import services.customers.Customer;

import java.util.ArrayList;

public class Customers extends ArrayList<Customer> {
    public Customer getOrCreate(String name) {
        for (Customer curr : this) {
            if (curr.getName().equals(name)) {
                return curr;
            }
        }

        Customer newCustomer = new Customer(name);
        this.add(newCustomer);
        return newCustomer;
    }
}
