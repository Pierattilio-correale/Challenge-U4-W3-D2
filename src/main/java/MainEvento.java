import Dao.EventoDao;
import Dao.LocationDao;
import Dao.PartecipazioneDao;
import Dao.PersonaDao;
import Entities.*;
import Entities.Enum.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MainEvento {
    public static void main(String[] args) {
        EventoDao eventoDao = new EventoDao();
        LocationDao locationDao = new LocationDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();
        PersonaDao personaDao = new PersonaDao();


        Location l1 = new Location("Forum", "Milano");
        Location l2 = new Location("San Siro", "Milano");
        Location l3 = new Location("Stadio Olimpico", "Roma");
        Location l4 = new Location("PalaAlpitour", "Torino");
        Location l5 = new Location("Palalottomatica", "Roma");

        locationDao.inserisciLocation(l1);
        locationDao.inserisciLocation(l2);
        locationDao.inserisciLocation(l3);
        locationDao.inserisciLocation(l4);
        locationDao.inserisciLocation(l5);


        Persona p1 = new Persona("Marco", "Marchini", "marco@email.it", LocalDate.of(2000, 10, 20), Sesso.MASCHIO);
        Persona p2 = new Persona("Giulia", "Rossi", "giulia@email.it", LocalDate.of(1998, 5, 12), Sesso.FEMMINA);

        personaDao.inserisciPersona(p1);
        personaDao.inserisciPersona(p2);


        Concerto concertoStreaming = new Concerto("Rock Live", LocalDate.now(), TipoEvento.PUBBLICO, 100, "Concerto online", Genere.ROCK, true);
        concertoStreaming.setLocation(l1);
        eventoDao.salvaEvento(concertoStreaming);


        PartitaDiCalcio partitaCasa = new PartitaDiCalcio("Derby", LocalDate.now(), TipoEvento.PUBBLICO, 50, "Partita intensa", "Milan", "Inter", "Milan", 3, 1);
        partitaCasa.setLocation(l2);
        eventoDao.salvaEvento(partitaCasa);


        PartitaDiCalcio partitaPareggio = new PartitaDiCalcio("Amichevole", LocalDate.now(), TipoEvento.PRIVATO, 30, "Parità assoluta", "Roma", "Lazio", "Nessuna", 2, 2);
        partitaPareggio.setLocation(l3);
        eventoDao.salvaEvento(partitaPareggio);


        Set<Persona> atleti = new HashSet<>();
        atleti.add(p1);
        atleti.add(p2);

        GaraDiAtletica gara = new GaraDiAtletica("100 metri", LocalDate.now(), TipoEvento.PUBBLICO, 2, "Corsa veloce", atleti, p1);
        gara.setLocation(l4);
        eventoDao.salvaEvento(gara);


        Concerto e1 = new Concerto("Evento Sold Out", LocalDate.now(), TipoEvento.PUBBLICO, 1, "Posti limitati", Genere.ROCK, true);
        e1.setLocation(l5);
        eventoDao.salvaEvento(e1);

        Partecipazione partecipazioneDaConfermare = new Partecipazione(Stato.DA_CONFERMARE);
        partecipazioneDaConfermare.setEvento(e1);
        partecipazioneDaConfermare.setPersona(p2);
        partecipazioneDao.inserisciPartecipazione(partecipazioneDaConfermare);

       
        System.out.println("Concerti in streaming:");
        eventoDao.getConcertiInStreaming(true).forEach(System.out::println);

        System.out.println("Concerti per genere ROCK:");
        eventoDao.getConcertiPerGenere(Genere.ROCK).forEach(System.out::println);

        System.out.println("Partite vinte in casa:");
        eventoDao.getPartiteVinteInCasa().forEach(System.out::println);

        System.out.println("Partite vinte in trasferta:");
        eventoDao.getPartiteVinteInTrasferta().forEach(System.out::println);

        System.out.println("Partite pareggiate:");
        eventoDao.getPartitePareggiate().forEach(System.out::println);

        System.out.println("Gare di atletica vinte da Marco:");
        eventoDao.getGareDiAtleticaPerVincitore(p1).forEach(System.out::println);

        System.out.println("Gare con Giulia partecipante:");
        eventoDao.getGareDiAtleticaPerPartecipante(p2).forEach(System.out::println);

        System.out.println("Eventi sold out:");
        eventoDao.getEventiSoldOut().forEach(System.out::println);

        System.out.println("Partecipazioni da confermare per evento:");
        partecipazioneDao.getPartecipazioniDaConfermarePerEvento(e1).forEach(System.out::println);
    }
}
