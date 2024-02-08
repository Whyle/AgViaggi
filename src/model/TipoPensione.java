/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jessi
 */
public enum TipoPensione {
    COLAZIONE(10),
    MEZZA_PENSIONE(20),
    PENSIONE_COMPLETA(30);
    
      public final int costoGiornaliero;

    private TipoPensione(int costoGiornaliero) {
        this.costoGiornaliero = costoGiornaliero;
    }
    
    public static String listOfConstants() {
        TipoPensione[] values = TipoPensione.values();
        String res = "";
        int i;
        for ( i = 0; i < values.length-1; i++) {
            res += values[i].name()+", ";
        }
        res+=values[i];
        return res;
    }
}
