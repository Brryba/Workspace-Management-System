package services.customers;

import data_storage.Customers;
import data_storage.MainStorage;

public abstract class CustomerSelector {
    public static Customer selectCustomer() {
        Customers customersList = MainStorage.customers;
        System.out.println("Enter your name:");
        return customersList.getOrCreate(MainStorage.scanner.readString());
    }
}
