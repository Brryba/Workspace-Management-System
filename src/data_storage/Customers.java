package data_storage;

import services.customers.Customer;

import java.util.ArrayList;
import java.util.Optional;

public class Customers extends ArrayList<Customer> {
    public Customer getOrCreate(String name) {
        Optional<Customer> optionalCustomer = this.stream()
                .filter(customer -> customer.getName().equals(name))
                .findAny();

        if (optionalCustomer.isPresent()) {
            return optionalCustomer.get();
        }

        Customer newCustomer = new Customer(name);
        this.add(newCustomer);
        return newCustomer;
    }
}
