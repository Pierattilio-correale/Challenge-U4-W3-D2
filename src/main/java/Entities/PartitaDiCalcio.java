package Entities;

import Entities.Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
@NamedQueries({
        @NamedQuery(
                name = "getPartiteVinteInCasa",
                query = "select p from PartitaDiCalcio p where p.golSquadraCasa > p.golSquadraOspite"
        ),
        @NamedQuery(
                name = "getPartiteVinteInTrasferta",
                query = "select p from PartitaDiCalcio p where p.golSquadraOspite > p.golSquadraCasa"
        ),
        @NamedQuery(
                name = "getPartitePareggiate",
                query = "select p from PartitaDiCalcio p where p.golSquadraCasa = p.golSquadraOspite"
        )
})

@Entity
@Table(name = "partita_di_calcio")
public class PartitaDiCalcio extends Evento{
    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "gol_squadra_casa")
    private int golSquadraCasa;
    @Column(name = "gol_squadra_ospite")
    private int golSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String descrizione, String squadraDiCasa, String squadraOspite, String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        super(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti, descrizione);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                '}';
    }
}
