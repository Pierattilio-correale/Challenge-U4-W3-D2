import java.time.LocalDate;
import java.util.Random;

public class MainEvento {
    public static void main(String[] args) {
EventoDao dao= new EventoDao();
Evento e1 = new Evento(new Random().nextInt(10,1000) , "Evento in spiaggia", LocalDate.of(2025,6,8) , TipoEvento.PUBBLICO , 15,"La spiaggia più bella che ci sia!");

dao.salvaEvento(e1);
        System.out.println(dao.getById(e1.getId()));
dao.deleteEvento(e1.getId());
    }
}
