package repositories;

import entities.Country;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CountryRepository extends AbstractRepository<Country, Integer> {
    public CountryRepository(EntityManager em) {
        super(em);
    }

    @Override
    @Transactional
    public void save(Country entity) {
        em.persist(entity);
    }

    public Country findByName(String name) {
        return (Country) em.createNamedQuery("Country.findByName")
                .setParameter(1, name)
                .getSingleResult();

    }

    public List<Country> findAll() {
        return (List<Country>) em.createNamedQuery("Country.findAll")
                .getResultList();
    }

}
/*
 public String findCountryOfCity(City city)
    {
        return (String) em.createNamedQuery("Country.findCountryOfCity")
                .setParameter(1,city.getId())
                .getSingleResult();
    }
 */
/*
  @PersistenceContext
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
 */