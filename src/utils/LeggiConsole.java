/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Scanner;
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
public class LeggiConsole {
    /**
     * 
     * @param messaggio
     * @param messaggioErrore
     * @return 
     */
    public static TipoAppartamento getTipoAppartamento(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore= scan.nextLine().toUpperCase();
            if (!EnumParser.checkAppartamento(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkAppartamento(valore));
        return TipoAppartamento.valueOf(valore);
    }
    /**
     * 
     * @param messaggio
     * @param messaggioErrore
     * @return 
     */
    public static TipoCamera getCamera(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
valore= scan.nextLine().toUpperCase();
if (!EnumParser.checkCamera(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkCamera(valore));
        return TipoCamera.valueOf(valore);
    }
     /**
     * 
     * @param messaggio
     * @param messaggioErrore
     * @return 
     */
    public static TipoCasaIndipendente getTipoCasaIndipendente(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
           valore= scan.nextLine().toUpperCase();
            if (!EnumParser.checkCasaIndipendente(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkCasaIndipendente(valore));
        return TipoCasaIndipendente.valueOf(valore);
    }
    /**
     * 
     * @param messaggio
     * @param messaggioErrore
     * @return 
     */
    public static TipoClasseMezzo getTipoClasseMezzo(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore= scan.nextLine().toUpperCase();
            if (!EnumParser.checkClasseMezzo(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkClasseMezzo(valore));
        return TipoClasseMezzo.valueOf(valore);
    }
     /**
     * 
     * @param messaggio
     * @param messaggioErrore
     * @return 
     */
    public static TipoPensione getTipoPensione(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore= scan.nextLine().toUpperCase();
            if (!EnumParser.checkPensione(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkPensione(valore));
        return TipoPensione.valueOf(valore);
    }
     /**
     * 
     * @param messaggio
     * @param messaggioErrore
     * @return 
     */
    public static TipoStrutturaVillaggio getTipoStrutturaVillaggio(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore= scan.nextLine().toUpperCase();
            if (!EnumParser.checkStrutturaVillaggio(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkStrutturaVillaggio(valore));
        return TipoStrutturaVillaggio.valueOf(valore);
    }
}
