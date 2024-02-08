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
public class PrenotazioneAlloggioAppartamento extends PrenotazioneAlloggio<PrenotazioneAlloggioAppartamento> implements Comparable<PrenotazioneAlloggioAppartamento>{

    protected TipoAppartamento tipoAppartamento;
    private final int codice ;
    private static int nCodice = 0;//chiave
    private static int lastCodice;
    protected boolean cucina;
    protected boolean parcheggio;
    protected boolean animaliDomestici;

    public PrenotazioneAlloggioAppartamento(String nomeCliente,TipoAppartamento 
            tipoAppartamento,  LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno,boolean
                    cucina, boolean parcheggio, boolean animaliDomestici) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.codice = getCodice();
        this.tipoAppartamento = tipoAppartamento;
        this.cucina = cucina;
        this.parcheggio = parcheggio;
        this.animaliDomestici = animaliDomestici;
    }
 
    private  int generaNextCodice() {
        return ++nCodice;
    }

   
    public  int getCodice() {
        return codice;
    }


    
public static void setLastCodice(int lastCodice) {
        PrenotazioneAlloggioAppartamento.lastCodice= lastCodice;
    }
    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoAppartamento.costoPerNotte;
        if (this.cucina) {
            prezzo += 60;
        }
        if (this.animaliDomestici) {
            prezzo += 60;
        }
        if (this.parcheggio) {
            prezzo += 60;
        }
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
        String stringa= "PrenotazioneAlloggioAppartamento\n" + ", codice=" + codice +super.toString()+""
                + "\ntipologia appartamento: " + tipoAppartamento;
        if(!cucina&&!parcheggio&&!animaliDomestici){
            stringa+="\nla prenotazione non prevede costi aggiuntivi";
        }else{
            System.out.println("la prenotazione prevede costi aggiuntivi: ");
            if(cucina){
                stringa+="cucina";
            }
            if(animaliDomestici){
                stringa+="animali domestici";
            }
            if(parcheggio){
                stringa+="parcheggio";
            }
        }
        stringa+="Prezzo Soggiorno: "+calcolaPrezzoSoggiorno();
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
