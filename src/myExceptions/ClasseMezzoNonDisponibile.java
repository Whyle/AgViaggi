/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

import model.TipoClasseMezzo;

/**
 *
 * @author User
 */
public class ClasseMezzoNonDisponibile extends AgenziaException {

    private TipoClasseMezzo mezzo;

    public ClasseMezzoNonDisponibile(TipoClasseMezzo mezzo) {
        this.mezzo= mezzo;

    }

    public TipoClasseMezzo getClasseMezzo() {
        return mezzo;
    }

    @Override
    public String toString() {
        return "Nelle ore richieste non ci sono più posti disponibili nella "+mezzo 
                + " class!\n";

    }

}