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
public class PrenotazioneAlloggioCasaIndipendente extends PrenotazioneAlloggio<PrenotazioneAlloggioCasaIndipendente> implements Comparable<PrenotazioneAlloggioCasaIndipendente>{
    private final int codice;
    private static int nCodice = 0;//chiave
    private static int lastCodice;
    protected boolean animaliDomestici;
    protected boolean piscina;
    protected TipoCasaIndipendente tipoCasaIndipendente;
    protected boolean cucina;

    public PrenotazioneAlloggioCasaIndipendente(String nomeCliente,TipoCasaIndipendente 
            tipoCasaIndipendente,  LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno,
            boolean cucina, boolean animaliDomestici, boolean piscina) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.tipoCasaIndipendente = tipoCasaIndipendente;
        this.animaliDomestici = animaliDomestici;
        this.piscina = piscina;
        this.codice=getCodice() ;
    }
    /*
public PrenotazioneAlloggioCasaIndipendente(PrenotazioneAlloggioCasaIndipendente p) {
        this.nomeCliente = p.nomeCliente;
        this.dataInizioSoggiorno = p.dataInizioSoggiorno;
        this.dataFineSoggiorno = p.dataFineSoggiorno;
        this.tipoCasaIndipendente = p.tipoCasaIndipendente;
       this.animaliDomestici =p. animaliDomestici;
        this.piscina =p. piscina;
        this.codice = p.codice;
    }    
*/
private  int generaNextCodice() {
        return ++nCodice;
    }
 public  int getCodice() {
        return codice;
    }
   
    public static void setLastCodice(int lastCodice) {
        PrenotazioneAlloggioCasaIndipendente.lastCodice= lastCodice;
    }
    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoCasaIndipendente.costoPerNotte;
        if (this.piscina) {
            prezzo += 60;
        }
        if (this.animaliDomestici) {
            prezzo += 60;
        }
        if (this.cucina) {
            prezzo += 60;
        }
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
        String stringa= "PrenotazioneAlloggioCasaIndipendente\n" + "codice: " + codice +super.toString()+""
                + "\ntipologia casa indipendente: " + tipoCasaIndipendente;
        if(!cucina&&!piscina&&!animaliDomestici){
            stringa+="\nla prenotazione non prevede costi aggiuntivi";
        }else{
            System.out.println("la prenotazione prevede costi aggiuntivi: ");
            if(cucina){
                stringa+="cucina";
            }
            if(animaliDomestici){
                stringa+="animali domestici";
            }
            if(piscina){
                stringa+="piscina";
            }
        }
        stringa+="Prezzo Soggiorno: "+calcolaPrezzoSoggiorno();
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
