/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myExceptions;

import java.time.LocalDateTime;

/**
 *
 * @author jessi
 */
public class RangeDataTimeNonValido extends AgenziaException{
     private LocalDateTime dataIniziale;
    private LocalDateTime dataFinale;

    public RangeDataTimeNonValido(LocalDateTime dataIniziale, LocalDateTime dataFinale) {
        this.dataIniziale = dataIniziale;
        this.dataFinale = dataFinale;
    }

    @Override
    public String toString() {

        if (dataFinale.isBefore(dataIniziale)) {
            return "La data finale deve essere successiva alla data iniziale!";
        } else {
            return "data non valida!";
        }
    }
}
