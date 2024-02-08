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
public class PrenotazioneNonTrovata extends AgenziaException{
      private int codice;

    public PrenotazioneNonTrovata(int codice) {
        this.codice = codice;
    }

    public int getPosizione() {
        return this.codice;
    }

    @Override
    public String toString() {
        return "La prenotazione ricercata numero "+codice+" non è presente!";
    }

}
