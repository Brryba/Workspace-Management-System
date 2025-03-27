package hibernateRepository;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import services.customers.Customer;

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

    public Customer findCustomer(String customerName) {
        return this.entityManager
                .find(Customer.class, customerName);
    }

    public void insertCustomer(String customerName) {
        Customer customer = new Customer();
        customer.setName(customerName);
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(customer);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            if (this.entityManager.getTransaction().isActive()) {
                this.entityManager.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
        }
    }
}
