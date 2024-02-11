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
public class PrenotazioneAlloggioCasaIndipendente extends PrenotazioneAlloggio<PrenotazioneAlloggioCasaIndipendente>
        implements Comparable<PrenotazioneAlloggioCasaIndipendente> {

    private TipoCasaIndipendente tipoCasaIndipendente;

    private int codice;
    private boolean animaliDomestici;
    private boolean piscina;
    private boolean cucina;

    public PrenotazioneAlloggioCasaIndipendente(int codice, String nomeCliente,
            TipoCasaIndipendente tipoCasaIndipendente,
            LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno,
            boolean cucina, boolean animaliDomestici, boolean piscina) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.tipoCasaIndipendente = tipoCasaIndipendente;
        this.animaliDomestici = animaliDomestici;
        this.piscina = piscina;
        this.codice = codice;
    }

    public int getCodice() {
        return codice;
    }

    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = 0;
        prezzo += (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoCasaIndipendente.costoPerNotte;
        if (this.piscina)
            prezzo += 40;
        if (this.animaliDomestici)
            prezzo += 8 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.cucina)
            prezzo += 15 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        return prezzo;
    }

    public boolean getCucina() {
        return cucina;
    }

    public void setCucina(boolean cucina) {
        this.cucina = cucina;
    }

    public boolean getAnimaliDomestici() {
        return animaliDomestici;
    }

    public void setAnimaliDomestici(boolean animaliDomestici) {
        this.animaliDomestici = animaliDomestici;
    }

    public boolean getPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public TipoCasaIndipendente getTipoCasaIndipendente() {
        return tipoCasaIndipendente;
    }

    public void setTipoCasaIndipendente(TipoCasaIndipendente tipoCasaIndipendente) {
        this.tipoCasaIndipendente = tipoCasaIndipendente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.codice);
        hash = 73 * hash + (this.animaliDomestici ? 1 : 0);
        hash = 73 * hash + (this.piscina ? 1 : 0);
        hash = 73 * hash + Objects.hashCode(this.tipoCasaIndipendente);
        hash = 73 * hash + (this.cucina ? 1 : 0);
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
        final PrenotazioneAlloggioCasaIndipendente other = (PrenotazioneAlloggioCasaIndipendente) obj;
        if (this.animaliDomestici != other.animaliDomestici) {
            return false;
        }
        if (this.piscina != other.piscina) {
            return false;
        }
        if (this.cucina != other.cucina) {
            return false;
        }
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        if (this.tipoCasaIndipendente != other.tipoCasaIndipendente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String stringa = "\nPrenotazione Alloggio Casa Indipendente\n" +
                "Codice: " + this.codice + "\n" +
                super.toString() + "\n" +
                "Tipologia casa indipendente: " + tipoCasaIndipendente;

        if (!cucina && !piscina && !animaliDomestici) {
            stringa += "\nLa prenotazione non prevede costi aggiuntivi";
        } else {
            stringa += "\nLa prenotazione prevede costi aggiuntivi, ovvero: ";
            if (cucina) {
                stringa += "\n- Cucina";
            }
            if (animaliDomestici) {
                stringa += "\n- Animali domestici";
            }
            if (piscina) {
                stringa += "\n- Piscina";
            }
        }

        stringa += "\nPrezzo Soggiorno: " + calcolaPrezzoSoggiorno();
        stringa += "\n---------------------------------\n";

        return stringa;
    }

    @Override
    public int compareTo(PrenotazioneAlloggioCasaIndipendente pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }

    @Override
    public PrenotazioneAlloggioCasaIndipendente clone() throws CloneNotSupportedException {
        return (PrenotazioneAlloggioCasaIndipendente) super.clone();
    }
}
