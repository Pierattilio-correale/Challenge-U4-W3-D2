package Dao;
import Entities.Location;
import Entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class PartecipazioneDao {

    private EntityManager em;


    public PartecipazioneDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void inserisciPartecipazione(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }
}