import Dao.EventoDao;
import Dao.LocationDao;
import Dao.PartecipazioneDao;
import Dao.PersonaDao;
import Entities.*;

import java.time.LocalDate;
import java.util.Random;

public class MainEvento {
    public static void main(String[] args) {
EventoDao dao= new EventoDao();
LocationDao daoLoc= new LocationDao();
PartecipazioneDao partDao = new PartecipazioneDao();
PersonaDao perDao = new PersonaDao();




Location l1 = new Location("Forum", "Milano");
daoLoc.inserisciLocation(l1);


Persona persona1= new Persona("Marco" , "Marchini", "marcomarchini@yahoo.it" , LocalDate.of(2000,10,20), Sesso.MASCHIO );
perDao.inserisciPersona(persona1);

Evento e1 = new Evento(  "Evento in spiaggia", LocalDate.of(2025,6,8) , TipoEvento.PUBBLICO , 15,"La spiaggia più bella che ci sia!");
e1.setLocation(l1);
dao.salvaEvento(e1);

Partecipazione par1=new Partecipazione(Stato.CONFERMATA);
par1.setEvento(e1);
par1.setPersona(persona1);
partDao.inserisciPartecipazione(par1);

//        System.out.println(dao.getById(e1.getId()));
//dao.deleteEvento(e1.getId());
    }
}
