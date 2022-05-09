package repositories;

import entities.Continent;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class ContinentRepository extends AbstractRepository<Continent, Integer> {
    public ContinentRepository(EntityManager em) {
        super(em);
    }

    @Override
    @Transactional
    public void save(Continent entity) {
        em.persist(entity);
    }

    public List<Continent> findAll() {
        return (List<Continent>) em.createNamedQuery("Continent.findAll")
                .getResultList();
    }

    public Continent findByName(String name) {
        return (Continent) em.createNamedQuery("Continent.findByName")
                .setParameter(1, name)
                .getSingleResult();
    }

}

/*
    public void create(Continent continent) {

    }

    public Continent findById(int pk) {
        return (Continent) em.createNamedQuery("Continent.findById")
                .setParameter(1, pk)
                .getSingleResult();

    }

    public List<Continent> findByName(String name) {
        return (List<Continent>) em.createNamedQuery("Continent.findByName")
                .setParameter(1, name)
                .getResultList();

    }*/
