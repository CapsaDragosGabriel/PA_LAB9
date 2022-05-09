package repositories;

import entities.City;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CityRepository extends AbstractRepository<City, Integer> {
    public CityRepository(EntityManager em) {
        super(em);
    }

    @Override
    @Transactional
    public void save(City entity) {
        em.persist(entity);
    }

    public City findByName(String name) {
        return (City) em.createNamedQuery("City.findByName")
                .setParameter(1, name)
                .getSingleResult();
    }

    public List<City> findAll() {
        return (List<City>) em.createNamedQuery("City.findAll")
                .getResultList();
    }
}

/*
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
*/