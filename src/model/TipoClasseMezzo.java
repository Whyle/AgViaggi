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
public enum TipoClasseMezzo {
    FIRST(120),
    BUSINESS(60),
    ECONOMY(40);

    public final int costoPerPersona;

    private TipoClasseMezzo(int costoPerPersona) {
        this.costoPerPersona = costoPerPersona;
    }

    public static String listOfConstants() {
        TipoClasseMezzo[] values = TipoClasseMezzo.values();
        String res = "";
        int i;
        for (i = 0; i < values.length - 1; i++) {
            res += values[i].name() + ", ";
        }
        res += values[i];
        return res;
    }
}
