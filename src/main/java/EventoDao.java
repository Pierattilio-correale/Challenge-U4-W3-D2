import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {
private EntityManager em;

    public EventoDao() {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("postgres");
        em= emf.createEntityManager();


}
    public void salvaEvento(Evento evento){
em.getTransaction().begin();
em.persist(evento);
em.getTransaction().commit();
    }
    public Evento getById(int id){
return em.find(Evento.class , id);
    }

    public void deleteEvento(int id){
        Evento e = getById(id);
        if(e != null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }else{
            System.out.println("non è stato trovato nessun evento con id " + id);
        }
    }
    public void close(){
        em.close();

    }
}
