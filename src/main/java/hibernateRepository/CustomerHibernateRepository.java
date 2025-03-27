package hibernateRepository;

import jakarta.persistence.EntityManager;

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
}
