/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author jessi
 */
public class PrenotazioneViaggioAereo extends PrenotazioneViaggio<PrenotazioneViaggioAereo>
        implements Comparable<PrenotazioneViaggioAereo> {

    private TipoClasseMezzo tipoClasseMezzo;

    private int codice;// chiave
    private boolean bagaglio;

    public int getCodice() {
        return codice;
    }

    public PrenotazioneViaggioAereo(int codice, String nomeCliente, int nPasseggeri,
            TipoClasseMezzo tipoClasseMezzo, String LuogoPartenza, LocalDateTime dataPartenza, String LuogoArrivo,
            LocalDateTime dataArrivo, boolean bagaglio) {
        super(nomeCliente, nPasseggeri, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo);
        this.codice = codice;
        this.bagaglio = bagaglio;
        this.tipoClasseMezzo = tipoClasseMezzo;
    }

    public TipoClasseMezzo getTipoClasseMezzo() {
        return tipoClasseMezzo;
    }

    public void setTipoClasseMezzo(TipoClasseMezzo tipoClasseMezzo) {
        this.tipoClasseMezzo = tipoClasseMezzo;
    }

    public boolean getBagaglio() {
        return bagaglio;
    }

    public void setBagaglio(boolean bagaglio) {
        this.bagaglio = bagaglio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.codice);
        hash = 43 * hash + (this.bagaglio ? 1 : 0);
        hash = 43 * hash + Objects.hashCode(this.tipoClasseMezzo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrenotazioneViaggioAereo other = (PrenotazioneViaggioAereo) obj;
        if (this.bagaglio != other.bagaglio) {
            return false;
        }
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        if (this.tipoClasseMezzo != other.tipoClasseMezzo) {
            return false;
        }
        return true;
    }

    @Override
    public int calcolaPrezzoViaggio() {
        int prezzo = 0;
        prezzo += nPasseggeri * tipoClasseMezzo.costoPerPersona;
        if (this.bagaglio) {
            prezzo += 50;
        }
        return prezzo;
    }

    @Override
    public String toString() {
        String stringa = "\nPrenotazione Viaggio Aereo\n" +
                "Codice: " + this.codice + "\n" +
                super.toString() + "\n" +
                "Tipologia classe: " + tipoClasseMezzo;

        if (!bagaglio) {
            stringa += "\nLa prenotazione non prevede costi aggiuntivi";
        } else {
            stringa += "\nLa prenotazione prevede costi aggiuntivi, ovvero: ";
            if (bagaglio) {
                stringa += "\n- Bagaglio";
            }
        }

        stringa += "\nPrezzo Soggiorno: " + calcolaPrezzoViaggio();
        stringa += "\n---------------------------------\n";

        return stringa;
    }

    @Override
    public int compareTo(PrenotazioneViaggioAereo pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }

    @Override
    public PrenotazioneViaggioAereo clone() throws CloneNotSupportedException {
        return (PrenotazioneViaggioAereo) super.clone();
    }
}
