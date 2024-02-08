/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.GestioneAgenzia;

/**
 *
 * @author jessi
 */
public class AgViaggi {

    public static void printMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("1. INSERISCI PRENOTAZIONE DI UN ALLOGGIO");
        System.out.println("2. INSERISCI PRENOTAZIONE DI UN VIAGGIO");
        System.out.println("3. MODIFICA PRENOTAZIONE DI UN ALLOGGIO PER CODICE ");
        System.out.println("4. MODIFICA PRENOTAZIONE DI UN VIAGGIO PER CODICE ");
        System.out.println("5. RICERCA PRENOTAZIONE DI UN ALLOGGIO PER CODICE ");
        System.out.println("6. RICERCA PRENOTAZIONE DI UN VIAGGIO PER CODICE ");
        System.out.println("7. STAMPA PRENOTAZIONE DI UN ALLOGGIO PER CODICE ");
        System.out.println("8. STAMPA PRENOTAZIONE DI UN VIAGGIO PER CODICE ");

        System.out.println("9. ORDINA TUTTE LE PRENOTAZIONI (DIVISE PER CATEGORIA) ");
        System.out.println("10. CALCOLARE L'INCASSO ANNUALE TOTALE  (alloggi+viaggi)");
        System.out.println("11. VISUALIZZARE LA PRINCIPALE FONTE DI GUADAGNO");
        System.out.println("---------------------------------------------------");
        System.out.println("11. ORDINA PRENOTAZIONI DI UN ALLOGGIO");
        System.out.println("12. ORDINA PRENOTAZIONI DI UN VIAGGIO");
        System.out.println("13. CALCOLARE L'INCASSO ANNUALE TOTALE ALLOGGI (tutti i tipi di alloggio)");
        System.out.println("14. CALCOLARE L'INCASSO ANNUALE TOTALE VIAGGI (tutti i tipi di viaggi)");
        System.out.println("15. CALCOLARE L'INCASSO ANNUALE TOTALE  (alloggi+viaggi)");
        System.out.println("16. VISUALIZZARE LA PRINCIPALE FONTE DI GUADAGNO");
        System.out.println("0. ADDIO");
        System.out.println("---------------------------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            String fileAgenzia = "myAgenzia";
            String sep = ";";
            GestioneAgenzia ga = new GestioneAgenzia(fileAgenzia, sep);
            TestAgenzia ta = new TestAgenzia(ga);

            Scanner scan = new Scanner(System.in);
            String s;

            do {
                printMenu();
                s = scan.nextLine();
                if (!s.equals("0")) {

                    switch (s) {
                        case "1": /* PRENOTAZIONE DI UN ALLOGGIO */
                            System.out.println("Di che tipologia di alloggio ti "
                                    + "vuoi occupare?(1.HOTEL 2.APPARTAMENTO "
                                    + "3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");
                            

                            switch (scan.nextLine()) {
                                case "1": /* HOTEL */
                                    ta.inserisciPrenotazioneAlloggioHotel(); break;
                                case "2": /* APPARTAMENTO */
                                    ta.inserisciPrenotazioneAlloggioAppartamento(); break;
                                case "3": /* CASA INDIPENDENTE */
                                    ta.inserisciPrenotazioneAlloggioCasaIndipendente(); break;
                                case "4": /* STRUTTURE NEL VILLAGGIO */
                                    ta.inserisciPrenotazioneAlloggioVillaggio(); break;

                                default: /* DEFAULT */
                                    System.out.println("non valido"); break;
                            }
                        case "2": /* PRENOTAZIONE DI UN VIAGGIO */
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");
                            
                            switch (scan.nextLine().toUpperCase()) {
                                case "1": /* TRENO */
                                    ta.inserisciPrenotazioneViaggioTreno(); break;
                                case "2": /* AEREO */
                                    ta.inserisciPrenotazioneViaggioAereo(); break;
                                case "3": /* AUTOBUS */
                                    ta.inserisciPrenotazioneViaggioAutobus(); break;

                                default: /* DEFAULT */
                                    System.out.println("non valido"); break;
                            }

                        case "3": /* MODIFICA PRENOTAZIONE DI UN ALLOGGIO PER CODICE */
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");


                            switch (scan.nextLine().toUpperCase()) {
                                case "HOTEL":
                                    ta.modificaPrenotazioneAlloggioHotel(); break;
                                case "APPARTAMENTO":
                                    ta.modificaPrenotazioneAlloggioAppartamento();  break;
                                case "CASA INDIPENDENTE":
                                    ta.modificaPrenotazioneAlloggioCasaIndipendente(); break;
                                case "STRUTTURE NEL VILLAGGIO":
                                    ta.modificaPrenotazioneAlloggioVillaggio(); break;

                                default:
                                    System.out.println("non valido"); break;
                            }

                        case "4": /* MODIFICA PRENOTAZIONE DI UN VIAGGIO PER CODICE */
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            switch (scan.nextLine().toUpperCase()) {
                                case "TRENO":
                                    ta.modificaPrenotazioneViaggioTreno(); break;
                                case "AEREO":
                                    ta.modificaPrenotazioneViaggioAereo(); break;
                                case "AUTOBUS":
                                    ta.modificaPrenotazioneViaggioAutobus(); break;

                                default:
                                    System.out.println("non valido"); break;
                            }
                            break;
                        case "5": /* RICERCA PRENOTAZIONE DI UN ALLOGGIO PER CODICE */
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            switch (scan.nextLine().toUpperCase()) {
                                case "HOTEL":                   ta.ricercaPrenotazioneAlloggioHotel(); break;
                                case "APPARTAMENTO":            ta.ricercaPrenotazioneAlloggioAppartamento(); break;
                                case "CASA INDIPENDENTE":       ta.ricercaPrenotazioneAlloggioCasaIndipendente(); break;
                                case "STRUTTURE NEL VILLAGGIO": ta.ricercaPrenotazioneAlloggioVillaggio(); break;

                                default:
                                    System.out.println("non valido");
                                    break;
                            }
                            break;
                        case "6": /* RICERCA PRENOTAZIONE DI UN VIAGGIO PER CODICE */
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            switch (scan.nextLine().toUpperCase()) {
                                case "TRENO":   ta.ricercaPrenotazioneViaggioTreno(); break;
                                case "AEREO":   ta.ricercaPrenotazioneViaggioAereo(); break;
                                case "AUTOBUS": ta.ricercaPrenotazioneViaggioAutobus(); break;

                                default:
                                    System.out.println("non valido"); break;
                            }
                            break;
                        case "7": /* STAMPA PRENOTAZIONE DI UN ALLOGGIO PER CODICE */
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            switch (scan.nextLine().toUpperCase()) {
                                case "HOTEL":                   ta.stampaListaPrenotazioniAlloggioHotel(); break;
                                case "APPARTAMENTO":            ta.stampaListaPrenotazioniAlloggioAppartamento(); break;
                                case "CASA INDIPENDENTE":       ta.stampaListaPrenotazioniAlloggioCasaIndipendente(); break;
                                case "STRUTTURE NEL VILLAGGIO": ta.stampaListaPrenotazioniAlloggioVillaggio(); break;
                                default: System.out.println("non valido"); break;
                            }
                            break;
                        case "8": /* STAMPA PRENOTAZIONE DI UN VIAGGIO PER CODICE */
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            switch (scan.nextLine().toUpperCase()) {
                                case "TRENO":   ta.stampaListaPrenotazioniViaggioTreno(); break;
                                case "AEREO":   ta.stampaListaPrenotazioniViaggioAereo(); break;
                                case "AUTOBUS": ta.stampaListaPrenotazioniViaggioAutobus(); break;

                                default: System.out.println("non valido"); break;
                            }
                            break;
                        case "9":  /* ORDINA TUTTE LE PRENOTAZIONI (DIVISE PER CATEGORIA) */
                            ta.sortPrenotazioniAgenzia();
                            break;
                        case "10":  /* CALCOLARE L'INCASSO ANNUALE TOTALE  (alloggi+viaggi) */
                            try {
                                ta.calcolaIncassoAnnualeTotaleAgenzia();
                            } catch (IOException ex) {
                                Logger.getLogger(AgViaggi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        break;

                        case "11": /* VISUALIZZARE LA PRINCIPALE FONTE DI GUADAGNO */
                            try {
                                ta.TrovaFonteMaxGuadagnoAnnuale();
                            } catch (IOException ex) {
                                Logger.getLogger(AgViaggi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        break;

                        default:
                            System.out.println("opzione non in menù, scegli un'altra opzione.");
                            break;
                    }
                    System.out.println("---------------------------------------------------");
                }

            } while (!s.equals("0"));
        } catch (IOException ex) {
            Logger.getLogger(AgViaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
