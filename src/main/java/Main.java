import entities.Continent;
import entityManager.EntityManagerSingleton;
/*import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        //PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = EntityManagerSingleton.getInstance();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //  entityManager.getTransaction().begin();
        Continent myContinent = new Continent("Africa");
        myContinent.setName("Africa");
        // entityManager.persist(myContinent);
        //entityManager.getTransaction().commit();
        Continent c = (Continent) entityManager.createQuery(
                "select e from Continent e where name='Europe'"
        ).getSingleResult();


        System.out.println(c.getName());
        entityManager.close();
        entityManagerFactory.close();
    }
}
