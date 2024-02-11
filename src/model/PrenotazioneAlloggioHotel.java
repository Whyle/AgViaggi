/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.Objects;


/**
 *
 * @author jessi
 */
public class PrenotazioneAlloggioHotel extends PrenotazioneAlloggio<PrenotazioneAlloggioHotel>
        implements Comparable<PrenotazioneAlloggioHotel> {

    private TipoPensione tipoPensione;
    
    private int codice;
    private boolean balcone;
    private boolean parcheggio;
    private boolean wifi;
    private TipoCamera tipoCamera;

    public PrenotazioneAlloggioHotel(int codice, String nomeCliente, TipoCamera tipoCamera, TipoPensione tipoPensione,
            LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno, boolean wifi, boolean parcheggio,
            boolean balcone) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.tipoCamera = tipoCamera;
        this.tipoPensione = tipoPensione;
        this.codice = codice;
        this.balcone = balcone;
        this.parcheggio = parcheggio;
        this.wifi = wifi;
    }

    public int getCodice() {
        return codice;
    }

    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = 0;
        prezzo += (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoCamera.costoPerNotte;
        prezzo += (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoPensione.costoGiornaliero;
        if (this.balcone)
            prezzo += 10 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.wifi)
            prezzo += 3 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.parcheggio)
            prezzo += 8 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        return prezzo;
    }
    ////////////////

    public boolean getBalcone() {
        return balcone;
    }

    public boolean getParcheggio() {
        return parcheggio;
    }

    public boolean getWifi() {
        return wifi;
    }

    public TipoCamera getTipoCamera() {
        return tipoCamera;
    }

    public void setBalcone(boolean balcone) {
        this.balcone = balcone;
    }

    public void setParcheggio(boolean parcheggio) {
        this.parcheggio = parcheggio;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setTipoCamera(TipoCamera tipoCamera) {
        this.tipoCamera = tipoCamera;
    }

    public TipoPensione getTipoPensione() {
        return tipoPensione;
    }

    public void setTipoPensione(TipoPensione tipoPensione) {
        this.tipoPensione = tipoPensione;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.balcone ? 1 : 0);
        hash = 97 * hash + (this.parcheggio ? 1 : 0);
        hash = 97 * hash + (this.wifi ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.tipoPensione);
        hash = 97 * hash + Objects.hashCode(this.tipoCamera);
        hash = 97 * hash + Objects.hashCode(this.codice);
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
        final PrenotazioneAlloggioHotel other = (PrenotazioneAlloggioHotel) obj;
        if (this.balcone != other.balcone) {
            return false;
        }
        if (this.parcheggio != other.parcheggio) {
            return false;
        }
        if (this.wifi != other.wifi) {
            return false;
        }
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        if (this.tipoPensione != other.tipoPensione) {
            return false;
        }
        if (this.tipoCamera != other.tipoCamera) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String stringa = "\nPrenotazione Alloggio Hotel\n" +
                "Codice: " + this.codice + "\n" +
                super.toString() + "\n" +
                "Tipologia camera: " + tipoCamera + "\n" +
                "Tipologia pensione: " + tipoPensione;

        if (!balcone && !parcheggio && !wifi) {
            stringa += "\nLa prenotazione non prevede costi aggiuntivi";
        } else {
            stringa += "\nLa prenotazione prevede costi aggiuntivi, ovvero: ";
            if (balcone) {
                stringa += "\n- Balcone";
            }
            if (wifi) {
                stringa += "\n- Wifi";
            }
            if (parcheggio) {
                stringa += "\n- Parcheggio";
            }
        }

        stringa += "\nPrezzo Soggiorno: " + calcolaPrezzoSoggiorno();
        stringa += "\n---------------------------------\n";

        return stringa;
    }

    @Override
    public int compareTo(PrenotazioneAlloggioHotel pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }

    @Override
    public PrenotazioneAlloggioHotel clone() throws CloneNotSupportedException {
        return (PrenotazioneAlloggioHotel) super.clone();
    }
}
