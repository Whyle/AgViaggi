/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

import model.TipoCasaIndipendente;

/**
 *
 * @author User
 */
public class CasaIndipendenteNonDisponibile extends AgenziaException {

    private TipoCasaIndipendente casaIndipendente;

    public CasaIndipendenteNonDisponibile(TipoCasaIndipendente casaIndipendente) {
        this.casaIndipendente= casaIndipendente;

    }

    public TipoCasaIndipendente getCasaIndipendente() {
        return casaIndipendente;
    }

    @Override
    public String toString() {
        return "Nelle date richieste non ci sono più case indipendenti di tipo " + casaIndipendente
                + " disponibili per la prenotazione!\n";

    }

}