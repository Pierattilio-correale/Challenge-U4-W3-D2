package Entities;

import Entities.Enum.Genere;
import Entities.Enum.TipoEvento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;
@Entity

public class Concerto extends Evento{
    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;

    public Concerto(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String descrizione, Genere genere, boolean inStreaming) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti, descrizione);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" + super.toString()+
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
