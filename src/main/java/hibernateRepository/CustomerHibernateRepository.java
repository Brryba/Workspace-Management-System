package hibernateRepository;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import services.customers.CurrentCustomer;

public class CustomerHibernateRepository {
    private static final CustomerHibernateRepository customerRepository =
            new CustomerHibernateRepository();
    private final EntityManager entityManager;
    private CustomerHibernateRepository() {
        this.entityManager = HibernateUtil.getEntityManager();
    }

    public static CustomerHibernateRepository getInstance() {
        return customerRepository;
    }

    public CurrentCustomer findCustomer(String customerName) {
        return this.entityManager
                .find(CurrentCustomer.class, customerName);
    }

    public void insertCustomer(String customerName) {
        CurrentCustomer customer = new CurrentCustomer();
        customer.setName(customerName);
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(customer);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        }
    }
}
