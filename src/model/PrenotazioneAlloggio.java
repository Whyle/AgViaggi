/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
/**
 *
 * @author jessi
 * @param <T>
 */
abstract public class PrenotazioneAlloggio<T> implements Cloneable {
    protected String nomeCliente;
    protected LocalDate dataInizioSoggiorno;
    protected LocalDate dataFineSoggiorno;
    private static final DateTimeFormatter DATE_FRMT = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ITALY);
    public PrenotazioneAlloggio(String nomeCliente, LocalDate dataInizioSoggiorno, LocalDate dataFineSoggiorno) {
        this.nomeCliente = nomeCliente;
        this.dataInizioSoggiorno = dataInizioSoggiorno;
        this.dataFineSoggiorno = dataFineSoggiorno;
    }
    public PrenotazioneAlloggio(PrenotazioneAlloggio pA) {
        this.nomeCliente = pA.nomeCliente;
        this.dataInizioSoggiorno = pA.dataInizioSoggiorno;
        this.dataFineSoggiorno = pA.dataFineSoggiorno;
    }
public String getNomeCliente() {
        return nomeCliente;
    }
 public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataInizioSoggiorno() {
        return dataInizioSoggiorno;
    }

    public void setDataInizioSoggiorno(LocalDate dataInizioSoggiorno) {
        this.dataInizioSoggiorno = dataInizioSoggiorno;
    }

    public LocalDate getDataFineSoggiorno() {
        return dataFineSoggiorno;
    }

    public void setDataFineSoggiorno(LocalDate dataFineSoggiorno) {
        this.dataFineSoggiorno = dataFineSoggiorno;
    }
    
 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nomeCliente);
        hash = 29 * hash + Objects.hashCode(this.dataInizioSoggiorno);
        hash = 29 * hash + Objects.hashCode(this.dataFineSoggiorno);
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
        final PrenotazioneAlloggio other = (PrenotazioneAlloggio) obj;
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.dataInizioSoggiorno, other.dataInizioSoggiorno)) {
            return false;
        }
        if (!Objects.equals(this.dataFineSoggiorno, other.dataFineSoggiorno)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param object
     * @return
     */
    abstract public int compareTo(T object);
    

    @Override
    public String toString() {
        return "\n------------------------------------------"
                + "\nNome Cliente: " + nomeCliente.toUpperCase()
                + "\nData Inizio Soggiorno: " + DATE_FRMT.format(dataInizioSoggiorno)
                + "\nData Fine Soggiorno: " + DATE_FRMT.format(dataFineSoggiorno)
                + "\n------------------------------------------";
    }
    /////////////// clone /////////////
    @Override
    public PrenotazioneAlloggio clone() throws CloneNotSupportedException{
        return (PrenotazioneAlloggio)super.clone();
    }
    ////////////////////////////
     abstract public int calcolaPrezzoSoggiorno();

}
