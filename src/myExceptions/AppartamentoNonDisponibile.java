/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

/**
 *
 * @author jessi
 */

import model.TipoAppartamento;

/**
 *
 * @author User
 */
public class AppartamentoNonDisponibile extends AgenziaException {

    private TipoAppartamento appartamento;

    public AppartamentoNonDisponibile(TipoAppartamento camera) {
        this.appartamento= appartamento;

    }

    public TipoAppartamento getAppartamento() {
        return appartamento;
    }

    @Override
    public String toString() {
        return "Nelle date richieste non ci sono più appartamenti di tipo " + appartamento
                + " disponibili per la prenotazione!\n";

    }

}