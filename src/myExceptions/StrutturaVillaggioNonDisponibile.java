/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

import model.TipoStrutturaVillaggio;
/**
 *
 * @author User
 */
public class StrutturaVillaggioNonDisponibile extends AgenziaException {

    private TipoStrutturaVillaggio villaggio;

    public StrutturaVillaggioNonDisponibile(TipoStrutturaVillaggio villaggio) {
        this.villaggio= villaggio;

    }

    public TipoStrutturaVillaggio getVillaggio() {
        return villaggio;
    }

    @Override
    public String toString() {
        return "Nelle date richieste non ci sono più villaggi di tipo " + villaggio
                + " disponibili per la prenotazione!\n";

    }

}