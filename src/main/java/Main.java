import entities.Continent;
/*import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        //PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = EntityManagerSingleton.getInstance();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Continent myContinent=new Continent("Asia");
        myContinent.setName("Asia");
        entityManager.persist(myContinent);
        Continent c= (Continent) entityManager.createQuery(
                "select id from continents where name='Europe'"
        ).getSingleResult();
        System.out.println(c);

    }
}
