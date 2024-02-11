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
public class PrenotazioneAlloggioVillaggio extends PrenotazioneAlloggio<PrenotazioneAlloggioVillaggio>
        implements Comparable<PrenotazioneAlloggioVillaggio> {

    private TipoStrutturaVillaggio tipoSrutturaVillaggio;

    private int codice;
    private boolean cucina;
    private boolean parcheggio;
    private boolean animaliDomestici;
    private boolean animazione;

    public PrenotazioneAlloggioVillaggio(int codice, String nomeCliente, TipoStrutturaVillaggio tipoSrutturaVillaggio,
            LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno,
            boolean cucina, boolean parcheggio, boolean animaliDomestici, boolean animazione) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.codice = codice;
        this.tipoSrutturaVillaggio = tipoSrutturaVillaggio;
        this.cucina = cucina;
        this.parcheggio = parcheggio;
        this.animaliDomestici = animaliDomestici;
        this.animazione = animazione;
    }

    public int getCodice() {
        return codice;
    }

    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = 0;
        prezzo += (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoSrutturaVillaggio.costoPerNotte;
        if (this.animazione)
            prezzo += 20 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.animaliDomestici)
            prezzo += 5 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.cucina)
            prezzo += 15 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.parcheggio)
            prezzo += 8 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        return prezzo;
    }

    public TipoStrutturaVillaggio getTipoStrutturaVillaggio() {
        return tipoSrutturaVillaggio;
    }

    public void setTipoSrutturaVillaggio(TipoStrutturaVillaggio tipoSrutturaVillaggio) {
        this.tipoSrutturaVillaggio = tipoSrutturaVillaggio;
    }

    public boolean getCucina() {
        return cucina;
    }

    public void setCucina(boolean cucina) {
        this.cucina = cucina;
    }

    public boolean getParcheggio() {
        return parcheggio;
    }

    public void setParcheggio(boolean parcheggio) {
        this.parcheggio = parcheggio;
    }

    public boolean getAnimaliDomestici() {
        return animaliDomestici;
    }

    public void setAnimaliDomestici(boolean animaliDomestici) {
        this.animaliDomestici = animaliDomestici;
    }

    public boolean getAnimazione() {
        return animazione;
    }

    public void setAnimazione(boolean animazione) {
        this.animazione = animazione;
    }

    public TipoStrutturaVillaggio getTipoSrutturaVillaggio() {
        return tipoSrutturaVillaggio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.codice);
        hash = 89 * hash + Objects.hashCode(this.tipoSrutturaVillaggio);
        hash = 89 * hash + (this.cucina ? 1 : 0);
        hash = 89 * hash + (this.parcheggio ? 1 : 0);
        hash = 89 * hash + (this.animaliDomestici ? 1 : 0);
        hash = 89 * hash + (this.animazione ? 1 : 0);
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
        final PrenotazioneAlloggioVillaggio other = (PrenotazioneAlloggioVillaggio) obj;
        if (this.cucina != other.cucina) {
            return false;
        }
        if (this.parcheggio != other.parcheggio) {
            return false;
        }
        if (this.animaliDomestici != other.animaliDomestici) {
            return false;
        }
        if (this.animazione != other.animazione) {
            return false;
        }
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        if (this.tipoSrutturaVillaggio != other.tipoSrutturaVillaggio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String stringa = "\nPrenotazione Alloggio Villaggio\n" +
                "Codice: " + this.codice + "\n" +
                super.toString() + "\n" +
                "Tipologia struttura abitazione nel villaggio: " + tipoSrutturaVillaggio;
    
        if (!cucina && !parcheggio && !animaliDomestici && !animazione) {
            stringa += "\nLa prenotazione non prevede costi aggiuntivi";
        } else {
            stringa += "\nLa prenotazione prevede costi aggiuntivi, ovvero: ";
            if (cucina) {
                stringa += "\n- Cucina";
            }
            if (animaliDomestici) {
                stringa += "\n- Animali domestici";
            }
            if (parcheggio) {
                stringa += "\n- Parcheggio";
            }
            if (animazione) {
                stringa += "\n- Animazione";
            }
        }
    
        stringa += "\nPrezzo Soggiorno: " + calcolaPrezzoSoggiorno();
        stringa += "\n---------------------------------\n";
    
        return stringa;
    }
    

    @Override
    public int compareTo(PrenotazioneAlloggioVillaggio pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }

    @Override
    public PrenotazioneAlloggioVillaggio clone() throws CloneNotSupportedException {
        return (PrenotazioneAlloggioVillaggio) super.clone();
    }
}
