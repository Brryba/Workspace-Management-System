package services.customers;

import UI.utilities.ConsoleScanner;
import hibernateRepository.CustomerHibernateRepository;

public abstract class CustomerSelector {
    private static final CustomerHibernateRepository customerRepository =
            CustomerHibernateRepository.getInstance();

    public static String selectCustomer() {
        System.out.println("Enter your name:");
        String name = ConsoleScanner.getInstance().readString();
        if (customerRepository.findCustomer(name) == null) {
            customerRepository.insertCustomer(name);
        }
        return name;
    }
}
