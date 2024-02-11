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
public class PrenotazioneViaggioAutobus extends PrenotazioneViaggio<PrenotazioneViaggioAutobus>
        implements Comparable<PrenotazioneViaggioAutobus> {

    private TipoClasseMezzo tipoClasseMezzo;

    private int codice;// chiave
    private boolean finestrino;
    private boolean wifi;

    public int getCodice() {
        return codice;
    }

    public PrenotazioneViaggioAutobus(int codice, String nomeCliente, int nPasseggeri, TipoClasseMezzo tipoClasseMezzo,
            String LuogoPartenza, LocalDateTime dataPartenza, String LuogoArrivo, LocalDateTime dataArrivo,
            boolean finestrino, boolean wifi) {
        super(nomeCliente, nPasseggeri, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo);
        this.tipoClasseMezzo = tipoClasseMezzo;

        this.codice = codice;
        this.finestrino = finestrino;
        this.wifi = wifi;
    }

    public TipoClasseMezzo getTipoClasseMezzo() {
        return tipoClasseMezzo;
    }

    public void setTipoClasseMezzo(TipoClasseMezzo tipoClasseMezzo) {
        this.tipoClasseMezzo = tipoClasseMezzo;
    }

    public boolean getFinestrino() {
        return finestrino;
    }

    public void setFinestrino(boolean finestrino) {
        this.finestrino = finestrino;
    }

    public boolean getWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.codice);
        hash = 23 * hash + (this.finestrino ? 1 : 0);
        hash = 23 * hash + (this.wifi ? 1 : 0);
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
        final PrenotazioneViaggioAutobus other = (PrenotazioneViaggioAutobus) obj;
        if (this.finestrino != other.finestrino) {
            return false;
        }
        if (this.wifi != other.wifi) {
            return false;
        }
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        return true;
    }

    @Override
    public int calcolaPrezzoViaggio() {
        int prezzo = 0;
        prezzo += nPasseggeri * tipoClasseMezzo.costoPerPersona;
        if (this.finestrino) {
            prezzo += 3;
        }
        if (this.wifi) {
            prezzo += 60;
        }
        return prezzo;
    }

    @Override
    public String toString() {
        String stringa = "\nPrenotazione Viaggio Autobus\n" +
                "Codice: " + this.codice + "\n" +
                super.toString() + "\n" +
                "Tipologia classe: " + tipoClasseMezzo;
    
        if (!finestrino && !wifi) {
            stringa += "\nLa prenotazione non prevede costi aggiuntivi";
        } else {
            stringa += "\nLa prenotazione prevede costi aggiuntivi, ovvero: ";
            if (wifi) {
                stringa += "\n- Wifi";
            }
            if (finestrino) {
                stringa += "\n- Finestrino";
            }
        }
    
        stringa += "\nPrezzo Soggiorno: " + calcolaPrezzoViaggio();
        stringa += "\n---------------------------------\n";
    
        return stringa;
    }
    

    @Override
    public int compareTo(PrenotazioneViaggioAutobus pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }

    @Override
    public PrenotazioneViaggioAutobus clone() throws CloneNotSupportedException {
        return (PrenotazioneViaggioAutobus) super.clone();
    }
}
