/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

/**
 *
 * @author jessi
 */
abstract public class PrenotazioneViaggio <T>{
    protected String nomeCliente;
    protected int nPasseggeri;
    protected String LuogoPartenza;
    protected LocalDateTime dataPartenza;
    protected String LuogoArrivo;
    protected LocalDateTime dataArrivo;
    
    protected static final DateTimeFormatter DATE_TIME_FORMAT
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm", Locale.ITALY);

    
    public PrenotazioneViaggio(String nomeCliente,int nPasseggeri, String LuogoPartenza, 
            LocalDateTime dataPartenza, String LuogoArrivo, LocalDateTime dataArrivo) {
        this.nomeCliente = nomeCliente;
        this.nPasseggeri=nPasseggeri;
        this.LuogoPartenza = LuogoPartenza;
        this.dataPartenza = dataPartenza;
        this.LuogoArrivo = LuogoArrivo;
        this.dataArrivo = dataArrivo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getnPasseggeri() {
        return nPasseggeri;
    }

    public void setnPasseggeri(int nPasseggeri) {
        this.nPasseggeri = nPasseggeri;
    }

    public String getLuogoPartenza() {
        return LuogoPartenza;
    }

    public void setLuogoPartenza(String LuogoPartenza) {
        this.LuogoPartenza = LuogoPartenza;
    }

    public LocalDateTime getDataPartenza() {
        return dataPartenza;
    }

    public void setDataPartenza(LocalDateTime dataPartenza) {
        this.dataPartenza = dataPartenza;
    }

  
    public String getLuogoArrivo() {
        return LuogoArrivo;
    }

    public void setLuogoArrivo(String LuogoArrivo) {
        this.LuogoArrivo = LuogoArrivo;
    }

    public LocalDateTime getDataArrivo() {
        return dataArrivo;
    }

    public void setDataArrivo(LocalDateTime dataArrivo) {
        this.dataArrivo = dataArrivo;
    }

   
    
      abstract public int calcolaPrezzoViaggio();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nomeCliente);
        hash = 41 * hash + Objects.hashCode(this.LuogoPartenza);
        hash = 41 * hash + Objects.hashCode(this.dataPartenza);
        hash = 41 * hash + Objects.hashCode(this.LuogoArrivo);
        hash = 41 * hash + Objects.hashCode(this.dataArrivo);
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
        final PrenotazioneViaggio other = (PrenotazioneViaggio) obj;
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.LuogoPartenza, other.LuogoPartenza)) {
            return false;
        }
        if (!Objects.equals(this.LuogoArrivo, other.LuogoArrivo)) {
            return false;
        }
        if (!Objects.equals(this.dataPartenza, other.dataPartenza)) {
            return false;
        }
        if (!Objects.equals(this.dataArrivo, other.dataArrivo)) {
            return false;
        }
        return true;
    }
    abstract public int compareTo(T object);
    @Override
    public PrenotazioneViaggio clone() throws CloneNotSupportedException {
        return (PrenotazioneViaggio) super.clone();
    }
      @Override
    public String toString() {
        return "\nNome Cliente: " + nomeCliente.toUpperCase()
                + "\nData Inizio Soggiorno: " + DATE_TIME_FORMAT.format(dataPartenza)
                + "\nData Fine Soggiorno: " + DATE_TIME_FORMAT.format(dataArrivo);
    }
}
