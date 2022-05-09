package repositories;

import entities.Continent;
import entities.Continent;
import entities.Continent;
import entityManager.EntityManagerSingleton;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class ContinentRepository {
    private EntityManager em; //create it somehow

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

    }

}