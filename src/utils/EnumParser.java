/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.TipoAppartamento;
import model.TipoCamera;
import model.TipoCasaIndipendente;
import model.TipoClasseMezzo;
import model.TipoPensione;
import model.TipoStrutturaVillaggio;

/**
 *
 * @author jessi
 */
public class EnumParser {
    /**
     * 
     * @param valore
     * @return 
     */
     public static boolean checkCamera(String valore) {
        try {
            TipoCamera.valueOf(valore);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
     /**
     * 
     * @param valore
     * @return 
     */
     public static boolean checkAppartamento(String valore) {
        try {
            TipoAppartamento.valueOf(valore);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
     /**
     * 
     * @param valore
     * @return 
     */
     public static boolean checkCasaIndipendente(String valore) {
        try {
            TipoCasaIndipendente.valueOf(valore);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
     /**
     * 
     * @param valore
     * @return 
     */
     public static boolean checkClasseMezzo(String valore) {
        try {
            TipoClasseMezzo.valueOf(valore);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
     /**
     * 
     * @param valore
     * @return 
     */
     public static boolean checkPensione(String valore) {
        try {
            TipoPensione.valueOf(valore);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
     /**
     * 
     * @param valore
     * @return 
     */
     public static boolean checkStrutturaVillaggio(String valore) {
        try {
            TipoStrutturaVillaggio.valueOf(valore);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
   
     
}
