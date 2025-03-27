package hibernateRepository;

import data_storage.Workspaces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import services.workspaces.Workspace;

public class WorkspaceHibernateRepository {
    private final EntityManager entityManager;
    private static final WorkspaceHibernateRepository instance =
            new WorkspaceHibernateRepository();
    private WorkspaceHibernateRepository() {
        this.entityManager = HibernateUtil.getEntityManager();
    }
    public static WorkspaceHibernateRepository getInstance() {
        return instance;
    }

    public void persistWorkspace(Workspace workspace) throws HibernateException {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(workspace);
            this.entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            if (this.entityManager.getTransaction().isActive()) {
                this.entityManager.getTransaction().rollback();
            }
            throw e;
        }
    }

    public Workspace getWorkspace(int workspaceID) {
        return this.entityManager.find(Workspace.class, workspaceID);
    }

    public Workspaces getAllWorkspaces() {
        Query query = this.entityManager.createQuery("from Workspace");
        return new Workspaces(query.getResultList());
    }

    public void removeWorkspace(int workspaceID) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(getWorkspace(workspaceID));
        this.entityManager.getTransaction().commit();
    }
}
