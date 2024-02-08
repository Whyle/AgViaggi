/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

/**
 *
 * @author User
 */
public class PrenotazioneGiaInserita extends AgenziaException {

    public PrenotazioneGiaInserita() {
    }

    @Override
    public String toString() {
        return "La prenotazione di questo cliente nella data richiesta è già stata inserita!";
    }

}