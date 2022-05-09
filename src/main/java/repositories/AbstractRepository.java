package repositories;

import entities.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractRepository<T, ID> {
    @PersistenceContext
    protected final EntityManager em; //create it somehow
    private T object = ((T) new Object());

    public AbstractRepository(EntityManager em) {
        this.em = em;
    }

    public long count() {
        return (int) em.createQuery("SELECT COUNT(t) from " + object.getClass().getName() + " t", object.getClass())
                .getSingleResult();
    }

    public void delete(T entity) {
        em.remove(entity);
    }

    public void deleteAll() {
        em.createQuery("DELETE FROM " + object.getClass().getName() + "", object.getClass()).executeUpdate();
    }

    public void deleteAllById(Iterable<? extends ID> ids) {
        for (ID id : ids) {
            em.createNamedQuery("DELETE FROM " + object.getClass().getName() + " t where t.id=?1", object.getClass())
                    .setParameter(1, id)
                    .executeUpdate();
        }
    }

    public void deleteById(ID id) {
        em.createNamedQuery("DELETE FROM " + object.getClass().getName() + " t where t.id=?1", object.getClass())
                .setParameter(1, id)
                .executeUpdate();

    }

    public boolean existsById(ID id) {
        return em.createNamedQuery("select t from " + object.getClass().getName() + " t where t.id = ?1", object.getClass())
                .setParameter(1, id)
                .getSingleResult() != null;

    }


    public Iterable<T> findAll() {
        return (Iterable<T>) em.createQuery("select t from " + object.getClass().getName() + " t", object.getClass()).getResultList();

    }

    public T findById(ID id) {
        return (T) em.createQuery("select t from " + object.getClass().getName() + " t where t.id = ?1", object.getClass())
                .setParameter(1, id)
                .getSingleResult();
    }

    @Transactional
    public void save(T entity) {
        em.persist(entity);
    }

    @Transactional
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        for (S entity : entities) {
            em.persist(entity);
        }
        return entities;
    }
}