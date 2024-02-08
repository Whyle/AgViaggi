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
public enum TipoCamera {
     SINGOLA(80),
    DOPPIA(120),
    TRIPLA(150),
    QUADRUPLA(180);

    public final int costoPerNotte;

    private TipoCamera(int costoPerNotte) {
        this.costoPerNotte = costoPerNotte;
    }
    
    public static String listOfConstants() {
        TipoCamera[] values = TipoCamera.values();
        String res = "";
        int i;
        for ( i = 0; i < values.length-1; i++) {
            res += values[i].name()+", ";
        }
        res+=values[i];
        return res;
    }
}
