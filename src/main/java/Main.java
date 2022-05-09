import entities.City;
import entities.Continent;
import entityManager.EntityManagerSingleton;
import repositories.CityRepository;
import repositories.ContinentRepository;
import repositories.CountryRepository;
import tools.Loader;
/*import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

public class Main {
    public static void populateDbs(EntityManager em) {
        try {
            var continents = new ContinentRepository(em);
            var countries = new CountryRepository(em);
            var cities = new CityRepository(em);

            Loader.loadCities(cities);


        } catch (SQLException e) {
            System.err.println(e);
        }

    }

    public static void main(String[] args) {
        //PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = EntityManagerSingleton.getInstance();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //  entityManager.getTransaction().begin();
        entityManager.getTransaction().begin();
        populateDbs(entityManager);
        entityManager.getTransaction().commit();
        // entityManager.persist(myContinent);
        //entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();
    }
}
