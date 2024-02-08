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
public enum TipoCasaIndipendente {
    UNIFAMILIARE(80),
    BIFAMILIARE(120),
    A_SCHIERA(150);

    public final int costoPerNotte;

    private TipoCasaIndipendente(int costoPerNotte) {
        this.costoPerNotte = costoPerNotte;
    }
    
    public static String listOfConstants() {
        TipoCasaIndipendente[] values = TipoCasaIndipendente.values();
        String res = "";
        int i;
        for ( i = 0; i < values.length-1; i++) {
            res += values[i].name()+", ";
        }
        res+=values[i];
        return res;
    }
}
