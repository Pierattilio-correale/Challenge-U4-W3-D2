package Dao;
import Entities.Enum.Stato;
import Entities.Evento;
import Entities.Location;
import Entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
    public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento) {
        TypedQuery<Partecipazione> query = em.createQuery(
                "SELECT p FROM Partecipazione p WHERE p.evento = :evento AND p.stato = :stato", Partecipazione.class);
        query.setParameter("evento", evento);
        query.setParameter("stato", Stato.DA_CONFERMARE);
        return query.getResultList();
    }
}