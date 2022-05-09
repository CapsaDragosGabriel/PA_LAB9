import org.hibernate.engine.internal.AbstractEntityEntry;
import repositories.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class DataRepository
        <T extends AbstractEntity, ID extends Serializable> {
    private EntityManager em; //create it somehow

    public T findById(ID id) {
    }

    public void persist(T entity) {
        try {
            beginTransaction();
            em.persist(entity);
            commit();
            return true;
        } catch (Exception e) {
            handleException(e);
            rollback();
        }
    }
}