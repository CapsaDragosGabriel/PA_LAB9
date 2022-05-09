package repositories;

import entities.City;
import entities.Country;
import entityManager.EntityManagerSingleton;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class CityRepository {
    private EntityManager em; //create it somehow

    public void create(City city) {

    }

    public City findById(int pk) {
        return (City) em.createNamedQuery("City.findById")
                .setParameter(1, pk)
                .getSingleResult();

    }

    public List<City> findByName(String name) {
        return (List<City>) em.createNamedQuery("City.findByName")
                .setParameter(1, name)
                .getResultList();

    }

    public List<City> findByCountry(Country country) {
        return (List<City>) em.createNamedQuery("City.findByCountry")
                .setParameter(1, country)
                .getResultList();

    }
}