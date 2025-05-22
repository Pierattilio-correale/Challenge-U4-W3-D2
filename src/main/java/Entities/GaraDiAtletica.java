package Entities;

import Entities.Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class GaraDiAtletica extends Evento {

    @ManyToMany
    @JoinTable(
            name = "atleti_gara",
            joinColumns = @JoinColumn(name = "gara_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id")
    )
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String descrizione, Set<Persona> atleti, Persona vincitore) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti, descrizione);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" + super.toString() +
                ", atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}