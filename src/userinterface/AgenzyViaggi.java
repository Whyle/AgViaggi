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
public class AgenzyViaggi {

    public static void printMenu() {

        System.out.println("---------------------------------------------------");
        System.out.println("BENVENUTO/A NELLA NOSTRA AGENZIA! Quale azione scegli? ");
        System.out.println("1 --> INSERISCI PRENOTAZIONE DI UN ALLOGGIO (hotel / appartamento / casa indipendente / strutture nel villaggio)");
        System.out.println("2 --> INSERISCI PRENOTAZIONE DI UN MEZZO DI TRASPORTO (treno / aereo / autobus)");
        System.out.println("3 --> MODIFICA PRENOTAZIONE DI UN ALLOGGIO (per codice) ");
        System.out.println("4 --> MODIFICA PRENOTAZIONE DI UN MEZZO DI TRASPORTO (per codice) ");
        System.out.println("5 --> RICERCA PRENOTAZIONE DI UNA TIPOLOGIA DI ALLOGGIO (per codice)  ");
        System.out.println("6 --> RICERCA PRENOTAZIONE DI UNA TIPOLOGIA DI MEZZO DI TRASPORTO (per codice)  ");
        System.out.println("7 --> ELIMINA PRENOTAZIONE DI UNA TIPOLOGIA DI ALLOGGIO (per codice)");
        System.out.println("8-->  ELIMINA PRENOTAZIONE DI UNA TIPOLOGIA DI MEZZO DI TRASPORTO (per codice)");
        System.out.println("9 --> STAMPA PRENOTAZIONI DI UNA TIPOLOGIA DI ALLOGGIO");
        System.out.println("10--> STAMPA PRENOTAZIONI DI UNA TIPOLOGIA DI MEZZO DI TRASPORTO"); 
        System.out.println("11--> STAMPA TUTTE LE PRENOTAZIONI (DIVISE PER CATEGORIA) ");
        System.out.println("12--> VERIFICA DISPONIBILITÀ DI UN ALLOGGIO");
        System.out.println("13--> VERIFICA DISPONIBILITÀ DI UN MEZZO DI TRASPORTO");
        System.out.println("14--> ORDINA PRENOTAZIONI DI UNA TIPOLOGIA DI ALLOGGIO (ordine cronologico di effettuazione della prenotazione)");
        System.out.println("15--> ORDINA PRENOTAZIONI DI UNA TIPOLOGIA DI MEZZO DI TRASPORTO (ordine cronologico di effettuazione della prenotazione)");
        System.out.println("16--> ORDINA TUTTE LE PRENOTAZIONI DIVISE PER CATEGORIA (le prenotazioni di ogni categoria verranno ordinate in ordine cronologico)");
        System.out.println("17--> CALCOLARE L'INCASSO ANNUALE TOTALE ALLOGGI (tutti i tipi di alloggio)");
        System.out.println("18--> CALCOLARE L'INCASSO ANNUALE TOTALE GUADAGNATO SOLO GRAZIE AI MEZZI DI TRASPORTO (tutti i tipi di mezzo)");
        System.out.println("19--> CALCOLARE L'INCASSO ANNUALE TOTALE  (alloggi+mezzi di trasporto)");
        System.out.println("20--> VISUALIZZARE LA PRINCIPALE FONTE DI GUADAGNO ANNUALE");
        System.out.println("0-->  PER TERMINARE");
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
                        case "1":
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");
                            String sceltaTipologiaAlloggio;
                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio) {
                                case "1":
                                    ta.inserisciPrenotazioneAlloggioHotel();
                                    break;
                                case "2":
                                    ta.inserisciPrenotazioneAlloggioAppartamento();
                                    break;
                                case "3":
                                    ta.inserisciPrenotazioneAlloggioCasaIndipendente();
                                    break;

                                case "4":
                                    ta.inserisciPrenotazioneAlloggioVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "2":
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");
                            String sceltaTipologiaMezzo;
                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.inserisciPrenotazioneViaggioTreno();
                                    break;
                                case "2":
                                    ta.inserisciPrenotazioneViaggioAereo();
                                    break;
                                case "3":
                                    ta.inserisciPrenotazioneViaggioAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "3":
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio.toUpperCase()) {
                                case "1":
                                    ta.modificaPrenotazioneAlloggioHotel();
                                    break;
                                case "2":
                                    ta.modificaPrenotazioneAlloggioAppartamento();
                                    break;
                                case "3":
                                    ta.modificaPrenotazioneAlloggioCasaIndipendente();
                                    break;

                                case "4":
                                    ta.modificaPrenotazioneAlloggioVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "4":
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.modificaPrenotazioneViaggioTreno();
                                    break;
                                case "2":
                                    ta.modificaPrenotazioneViaggioAereo();
                                    break;
                                case "3":
                                    ta.modificaPrenotazioneViaggioAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "5":
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio.toUpperCase()) {
                                case "1":
                                    ta.ricercaPrenotazioneAlloggioHotel();
                                    break;
                                case "2":
                                    ta.ricercaPrenotazioneAlloggioAppartamento();
                                    break;
                                case "3":
                                    ta.ricercaPrenotazioneAlloggioCasaIndipendente();
                                    break;

                                case "4":
                                    ta.ricercaPrenotazioneAlloggioVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "6":
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.ricercaPrenotazioneViaggioTreno();
                                    break;
                                case "2":
                                    ta.ricercaPrenotazioneViaggioAereo();
                                    break;
                                case "3":
                                    ta.ricercaPrenotazioneViaggioAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "7":
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio.toUpperCase()) {
                                case "1":
                                    ta.eliminaPrenotazioneAlloggioHotel();
                                    break;
                                case "2":
                                    ta.eliminaPrenotazioneAlloggioAppartamento();
                                    break;
                                case "3":
                                    ta.eliminaPrenotazioneAlloggioCasaIndipendente();
                                    break;

                                case "4":
                                    ta.eliminaPrenotazioneAlloggioVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                       
                            break;
                        case "8":
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.eliminaPrenotazioneViaggioTreno();
                                    break;
                                case "2":
                                    ta.eliminaPrenotazioneViaggioAereo();
                                    break;
                                case "3":
                                    ta.eliminaPrenotazioneViaggioAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "9":
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio.toUpperCase()) {
                                case "1":
                                    ta.stampaListaPrenotazioniAlloggioHotel();
                                    break;
                                case "2":
                                    ta.stampaListaPrenotazioniAlloggioAppartamento();
                                    break;
                                case "3":
                                    ta.stampaListaPrenotazioniAlloggioCasaIndipendente();
                                    break;

                                case "4":
                                    ta.stampaListaPrenotazioniAlloggioVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "10":
                            System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.stampaListaPrenotazioniViaggioTreno();
                                    break;
                                case "2":
                                    ta.stampaListaPrenotazioniViaggioAereo();
                                    break;
                                case "3":
                                    ta.stampaListaPrenotazioniViaggioAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "11":
                            
                           ta.stampaListaPrenotazioniAgenzia();
                            break;
                           
                             case "12":
                            System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio.toUpperCase()) {
                                case "1":
                                    ta.verificaDisponibilitaHotel();
                                    break;
                                case "2":
                                    ta.verificaDisponibilitaAppartamento();
                                    break;
                                case "3":
                                    ta.verificaDisponibilitaCasaIndipendente();
                                    break;

                                case "4":
                                    ta.verificaDisponibilitaStrutturaVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                        case "13":
                             System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.verificaDisponibilitaTreno();
                                    break;
                                case "2":
                                    ta.verificaDisponibilitaAereo();
                                    break;
                                case "3":
                                    ta.verificaDisponibilitaAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                             case "14":
                             System.out.println("di che tipologia di alloggio ti vuoi occupare?(1.HOTEL 2.APPARTAMENTO 3.CASA INDIPENDENTE 4.STRUTTURE NEL VILLAGGIO)");

                            sceltaTipologiaAlloggio = scan.nextLine();
                            switch (sceltaTipologiaAlloggio.toUpperCase()) {
                                case "1":
                                    ta.sortPrenotazioniHotel();
                                    break;
                                case "2":
                                    ta.sortPrenotazioniAppartamenti();
                                    break;
                                case "3":
                                    ta.sortPrenotazioniCaseIndipendenti();
                                    break;

                                case "4":
                                    ta.sortPrenotazioniStruttureVillaggio();
                                    break;
                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                             
                             case "15":
                                  System.out.println("di che tipologia di mezzo ti vuoi occupare?(1.TRENO 2.AEREO 3. AUTOBUS )");

                            sceltaTipologiaMezzo = scan.nextLine();
                            switch (sceltaTipologiaMezzo.toUpperCase()) {
                                case "1":
                                    ta.sortPrenotazioniTreno();
                                    break;
                                case "2":
                                    ta.sortPrenotazioniAereo();
                                    break;
                                case "3":
                                    ta.sortPrenotazioniAutobus();
                                    break;

                                default:
                                    System.out.println("scelta non valida, inserire un'altra opzione");
                                    break;
                            }
                            break;
                                 
                             case "16":
                            ta.sortPrenotazioniAgenzia();
                            break;
                             case "17":
                                 ta.calcolaIncassoAnnualeTotaleAlloggi();
                                 break;
                             
                             case "18":
                                 ta.calcolaIncassoAnnualeTotaleMezziTrasporto();
                                 break;
                                 
                       
                        case "19": 
                           
                            ta.calcolaIncassoAnnualeTotaleAgenzia();
                        
                        break;

                        case "20": 
                            ta.TrovaFonteMaxGuadagnoAnnuale();
                        break;
                       
                        default:
                            System.out.println("opzione non in menù, scegli un'altra opzione.");
                            break;
                    }
                    System.out.println("---------------------------------------------------");
                }

            } while (!s.equals("0"));
        } catch (IOException ex) {
            Logger.getLogger(AgenzyViaggi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
