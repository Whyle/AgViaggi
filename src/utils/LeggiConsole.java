/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            valore = scan.nextLine();
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
            valore = scan.nextLine();
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
            valore = scan.nextLine();
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
            valore = scan.nextLine();
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
            valore = scan.nextLine();
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
            valore = scan.nextLine();
            if (!EnumParser.checkStrutturaVillaggio(valore)) {
                System.out.println(messaggioErrore);
            }
        } while (!EnumParser.checkStrutturaVillaggio(valore));
        return TipoStrutturaVillaggio.valueOf(valore);
    }






    public static String getStringNonVuota(String messaggio){
        Scanner scan = new Scanner(System.in);
        String valore;
        do {
            System.out.print(messaggio);
            valore = scan.nextLine();
            if (valore.isEmpty()) {
                System.out.println("Il campo non può essere vuoto");
            }
        } while (valore.isEmpty());
        return valore;
    }

    // dd-MM-yyyy
    public static LocalDate getLocalDate(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore = scan.nextLine();
            if (!valore.matches("\\d{2}-\\d{2}-\\d{4}")) {
                System.out.println(messaggioErrore);
            }
        } while (!valore.matches("\\d{2}-\\d{2}-\\d{4}"));
        return LocalDate.parse(valore, DateTimeIT.DATE);
    }

    public static boolean getYesNo(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore = scan.nextLine();
            if (!valore.equalsIgnoreCase("true") && !valore.equalsIgnoreCase("false")) {
                System.out.println(messaggioErrore);
            }
        } while (!valore.equalsIgnoreCase("true") && !valore.equalsIgnoreCase("false"));
        return valore.equalsIgnoreCase("true");
    }

    public static int getInt(String messaggio, String messaggioErrore) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore = scan.nextLine();
            if (!valore.matches("\\d+")) {
                System.out.println(messaggioErrore);
            }
        } while (!valore.matches("\\d+"));
        return Integer.parseInt(valore);
    }

    public static LocalDateTime getLocalDateTime(String messaggio, String messaggioErrore, String formato) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore = scan.nextLine();
            if (!valore.matches(formato)) {
                System.out.println(messaggioErrore);
            }
        } while (!valore.matches(formato));
        return LocalDateTime.parse(valore, DateTimeIT.DATETIME);
    }

    public static LocalDateTime getLocalDateTimeAfter(String messaggio, String messaggioErrore, String formato, LocalDateTime dataInizio) {
        Scanner scan = new Scanner(System.in);
        System.out.print(messaggio);
        String valore;
        do {
            valore = scan.nextLine();
            if (!valore.matches(formato) || LocalDateTime.parse(valore).isBefore(dataInizio)) {
                System.out.println(messaggioErrore);
            }
        } while (!valore.matches(formato) || LocalDateTime.parse(valore).isBefore(dataInizio));
        return LocalDateTime.parse(valore, DateTimeIT.DATETIME);
    }
}
