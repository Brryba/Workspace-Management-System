package services.customers;

import data_storage.MainStorage;
import repository.CustomerRepository;

import java.sql.SQLException;

public abstract class CustomerSelector {
    private static CustomerRepository customerRepository = CustomerRepository.getInstance();

    public static String selectCustomer() {
        System.out.println("Enter your name:");
        String name = MainStorage.scanner.readString();

        try {
            if (!customerRepository.hasCustomer(name)) {
                customerRepository.insertCustomer(name);
            }
            return name;
        } catch (SQLException e) {
            System.err.println(e.getMessage());;
        }

        return null;
    }
}
