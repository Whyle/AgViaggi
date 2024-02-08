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
public class PrenotazioneAlloggioVillaggio extends PrenotazioneAlloggio<PrenotazioneAlloggioVillaggio> implements Comparable<PrenotazioneAlloggioVillaggio> {

    private final int codice ;
    private static int nCodice = 0;//chiave  
    private static int lastCodice;
    protected TipoStrutturaVillaggio tipoSrutturaVillaggio;
    protected boolean cucina;
    protected boolean parcheggio;
    protected boolean animaliDomestici;
    protected boolean animazione;

    public PrenotazioneAlloggioVillaggio(String nomeCliente,TipoStrutturaVillaggio tipoSrutturaVillaggio, 
            LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno,
            boolean cucina, boolean parcheggio, boolean animaliDomestici, boolean animazione) {
        super(nomeCliente, dataInizioSoggiorno, dataFineSoggiorno);
        this.codice=getCodice() ;
        this.tipoSrutturaVillaggio = tipoSrutturaVillaggio;
        this.cucina = cucina;
        this.parcheggio = parcheggio;
        this.animaliDomestici = animaliDomestici;
        this.animazione = animazione;
    }
    /*
     public PrenotazioneAlloggioVillaggio(PrenotazioneAlloggioVillaggio p) {
        this.nomeCliente = p.nomeCliente;
        this.dataInizioSoggiorno = p.dataInizioSoggiorno;
        this.dataFineSoggiorno = p.dataFineSoggiorno;
        this.tipoSrutturaVillaggio = p.tipoSrutturaVillaggio;
      this.cucina =p. cucina;
        this.parcheggio = p.parcheggio;
        this.animaliDomestici =p. animaliDomestici;
        this.animazione = p.animazione;
        this.codice = p.codice;
    }    
*/
    private int generaNextCodice() {
        return ++nCodice;
    }
  public  int getCodice() {
        return codice;
    }
    public static void setLastCodice(int lastCodice) {
        PrenotazioneAlloggioVillaggio.lastCodice= lastCodice;
    }
    @Override
    public int calcolaPrezzoSoggiorno() {
        int prezzo = (int) DAYS.between(dataInizioSoggiorno, dataFineSoggiorno) * tipoSrutturaVillaggio.costoPerNotte;
        if (this.animazione) {
            prezzo += 60;
        }
        if (this.animaliDomestici) {
            prezzo += 60;
        }
        if (this.cucina) {
            prezzo += 60;
        }
        if (this.parcheggio) {
            prezzo += 60;
        }
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
        String stringa= "PrenotazioneAlloggioVillaggio\n" + "codice: " + codice +super.toString()+""
                + "\ntipologia sruttura abitazione nel villaggio: " + tipoSrutturaVillaggio;
        if(!cucina&&!parcheggio&&!animaliDomestici&&!animazione){
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
            if(animazione){
                stringa+="animazione";
            }
        }
        stringa+="Prezzo Soggiorno: "+calcolaPrezzoSoggiorno();
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
