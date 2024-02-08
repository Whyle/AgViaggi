/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

import model.TipoCamera;
/**
 *
 * @author User
 */
public class CameraNonDisponibile extends AgenziaException {

    private TipoCamera camera;

    public CameraNonDisponibile(TipoCamera camera) {
        this.camera= camera;

    }

    public TipoCamera getCamera() {
        return camera;
    }

    @Override
    public String toString() {
        return "Nelle date richieste non ci sono più camere di tipo " + camera
                + " disponibili per la prenotazione!\n";

    }

}