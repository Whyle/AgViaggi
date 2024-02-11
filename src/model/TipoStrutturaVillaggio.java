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
public enum TipoStrutturaVillaggio {
    CAMPER(80),
    ROULOTTE(120),
    BUNGALOW(150),
    TENDA(180);

    public final int costoPerNotte;

    private TipoStrutturaVillaggio(int costoPerNotte) {
        this.costoPerNotte = costoPerNotte;
    }

    public static String listOfConstants() {
        TipoStrutturaVillaggio[] values = TipoStrutturaVillaggio.values();
        String res = "";
        int i;
        for (i = 0; i < values.length - 1; i++) {
            res += values[i].name() + ", ";
        }
        res += values[i];
        return res;
    }
}
