/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author jessi
 */
public class PrenotazioneViaggioTreno extends PrenotazioneViaggio<PrenotazioneViaggioTreno> implements Comparable<PrenotazioneViaggioTreno>{
    private static int nCodice = 0;
    private static int lastCodice;
    private final int codice;//chiave
    protected TipoClasseMezzo tipoClasseMezzo;
    protected boolean finestrino;
    //protected boolean tavolino;
    private  int generaNextCodice() {
        return ++nCodice;
    }
   public  int getCodice() {
        return codice;
    }
public static void setLastCodice(int lastCodice) {
        PrenotazioneViaggioTreno.lastCodice= lastCodice;
    }
    public PrenotazioneViaggioTreno(String nomeCliente, int nPasseggeri,TipoClasseMezzo tipoClasseMezzo, String LuogoPartenza, LocalDateTime dataPartenza,
            String LuogoArrivo, LocalDateTime dataArrivo, boolean finestrino) {
        super(nomeCliente, nPasseggeri, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo);
        this.codice=getCodice();
        this.tipoClasseMezzo = tipoClasseMezzo;
        this.finestrino = finestrino;
    }
    /*
    public PrenotazioneViaggioTreno(PrenotazioneViaggioTreno p) {
        this.nomeCliente = p.nomeCliente;
       this.LuogoPartenza = p.LuogoPartenza;
        this.dataPartenza = p.dataPartenza;
        this.oraPartenza = p.oraPartenza;
        this.LuogoArrivo = p.LuogoArrivo;
        this.dataArrivo = p.dataArrivo;
        this.oraArrivo = p.oraArrivo;
      this.finestrino = p.finestrino;
        this.tipoClasseMezzo = p.tipoClasseMezzo;
        this.codice = p.codice;
    }    
*/


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
 @Override
    public int calcolaPrezzoViaggio() {
        int prezzo = nPasseggeri * tipoClasseMezzo.costoPerPersona;
        if (this.finestrino) {
            prezzo += 60;
        }
        return prezzo;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codice);
        hash = 79 * hash + Objects.hashCode(this.tipoClasseMezzo);
        hash = 79 * hash + (this.finestrino ? 1 : 0);
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
        final PrenotazioneViaggioTreno other = (PrenotazioneViaggioTreno) obj;
        return true;
    }

     @Override
    public String toString() {
        String stringa= "PrenotazioneViaggioTreno\n" + "codice: " + codice +super.toString()+""
                + "\ntipologia classe: " + tipoClasseMezzo;
        if(!finestrino){
            stringa+="\nla prenotazione non prevede costi aggiuntivi";
        }else{
            System.out.println("la prenotazione prevede costi aggiuntivi: ");
            if(finestrino){
                stringa+="finestrino";
            }
        }
        stringa+="Prezzo Soggiorno: "+calcolaPrezzoViaggio();
        return stringa;
    }
    @Override
    public int compareTo(PrenotazioneViaggioTreno pA) {
        // ordinamento per codice crescente
        return this.codice - pA.codice;
    }
     @Override
    public PrenotazioneViaggioTreno clone() throws CloneNotSupportedException {
        return (PrenotazioneViaggioTreno) super.clone();
    }
}