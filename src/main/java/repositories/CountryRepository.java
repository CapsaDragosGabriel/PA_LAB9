package repositories;

import entities.Continent;
import entities.Country;
import entities.Country;
import entityManager.EntityManagerSingleton;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class CountryRepository {
    private EntityManager em; //create it somehow

    public void create(Country Country) {

    }

    public Country findById(int pk) {
        return (Country) em.createNamedQuery("Country.findById")
                .setParameter(1, pk)
                .getSingleResult();

    }

    public List<Country> findByName(String name) {
        return (List<Country>) em.createNamedQuery("Country.findByName")
                .setParameter(1, name)
                .getResultList();

    }

    public List<Country> findByContinent(Continent continent) {
        return (List<Country>) em.createNamedQuery("Country.findByContinent")
                .setParameter(1, continent)
                .getResultList();

    }
}