package Dao;

import Entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {
    private EntityManager em;


    public LocationDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void inserisciLocation(Location location) {
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }


}