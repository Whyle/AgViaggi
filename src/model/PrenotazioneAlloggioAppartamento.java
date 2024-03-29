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
public class PrenotazioneAlloggioAppartamento extends PrenotazioneAlloggio<PrenotazioneAlloggioAppartamento>
        implements Comparable<PrenotazioneAlloggioAppartamento> {

    private TipoAppartamento tipoAppartamento;

    private int codice;
    private boolean cucina;
    private boolean parcheggio;
    private boolean animaliDomestici;

    public PrenotazioneAlloggioAppartamento(int codice, String nomeCliente, TipoAppartamento tipoAppartamento,
            LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno, boolean cucina, boolean parcheggio,
            boolean animaliDomestici) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.codice = codice;
        this.tipoAppartamento = tipoAppartamento;
        this.cucina = cucina;
        this.parcheggio = parcheggio;
        this.animaliDomestici = animaliDomestici;
    }

    public int getCodice() {
        return codice;
    }

    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = 0;
        prezzo += (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoAppartamento.costoPerNotte;
        if (this.cucina)
            prezzo += 15 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.animaliDomestici)
            prezzo += 10 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        if (this.parcheggio)
            prezzo += 8 * (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno);
        return prezzo;
    }

    public TipoAppartamento getTipoAppartamento() {
        return tipoAppartamento;
    }

    public void setTipoAppartamento(TipoAppartamento tipoAppartamento) {
        this.tipoAppartamento = tipoAppartamento;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.tipoAppartamento);
        hash = 31 * hash + Objects.hashCode(this.codice);
        hash = 31 * hash + (this.cucina ? 1 : 0);
        hash = 31 * hash + (this.parcheggio ? 1 : 0);
        hash = 31 * hash + (this.animaliDomestici ? 1 : 0);
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
        final PrenotazioneAlloggioAppartamento other = (PrenotazioneAlloggioAppartamento) obj;
        if (this.cucina != other.cucina) {
            return false;
        }
        if (this.parcheggio != other.parcheggio) {
            return false;
        }
        if (this.animaliDomestici != other.animaliDomestici) {
            return false;
        }
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        if (this.tipoAppartamento != other.tipoAppartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String stringa = "\nPrenotazione Alloggio Appartamento\n" +
                "Codice: " + this.codice + "\n" +
                super.toString() + "\n" +
                "Tipologia appartamento: " + tipoAppartamento;

        if (!cucina && !parcheggio && !animaliDomestici) {
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
        }

        stringa += "\nPrezzo Soggiorno: " + calcolaPrezzoSoggiorno();
        stringa += "\n---------------------------------\n";

        return stringa;
    }

    @Override
    public int compareTo(PrenotazioneAlloggioAppartamento pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }

    @Override
    public PrenotazioneAlloggioAppartamento clone() throws CloneNotSupportedException {
        return (PrenotazioneAlloggioAppartamento) super.clone();
    }

}
