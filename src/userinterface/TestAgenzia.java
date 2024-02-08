/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import utils.LeggiConsole;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.GestioneAgenzia;
import model.PrenotazioneAlloggioAppartamento;
import model.PrenotazioneAlloggioCasaIndipendente;
import model.PrenotazioneAlloggioHotel;
import model.PrenotazioneAlloggioVillaggio;
import model.PrenotazioneViaggioAereo;
import model.PrenotazioneViaggioAutobus;
import model.PrenotazioneViaggioTreno;
import model.TipoAppartamento;
import model.TipoCamera;
import model.TipoCasaIndipendente;
import model.TipoClasseMezzo;
import model.TipoPensione;
import model.TipoStrutturaVillaggio;
import myExceptions.AgenziaException;

/**
 *
 * @author jessi
 */
public class TestAgenzia {

    private GestioneAgenzia ga;

    public TestAgenzia(GestioneAgenzia ga) {
        this.ga = ga;

    }

    public void inserisciPrenotazioneAlloggioHotel() {

        try {
            //input dei parametri
            System.out.println("inserisci i dati della prenotazione");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
          
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale(in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            TipoCamera tipoCamera = utils.LeggiConsole.getCamera("inserisci il tipo di camera che desidera"
                    + " inserire " + TipoCamera.listOfConstants(), "errore! la tipologia di camera da lei selezionata non è valida, i tipi di camera previsti sono:" + TipoCamera.listOfConstants());
            TipoPensione tipoPensione = utils.LeggiConsole.getTipoPensione("inserisci il tipo di pensione che desidera"
                    + " inserire " + TipoPensione.listOfConstants(), "errore! la tipologia di pensione da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoPensione.listOfConstants());
            
            boolean wifi=LeggiConsole.getYesNo("inserisci true(se include il wifi) o false(se non include il wifi) ", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci true(se include il parcheggio) o false(se non include il parcheggio) ", "errore");
            boolean balcone=LeggiConsole.getYesNo("inserisci true(se include il balcone) o false(se non include il balcone) ", "errore");
            
            try {
                try {
                    ga.addPrenotazioneAlloggioHotel(new PrenotazioneAlloggioHotel(nomeCliente, tipoCamera, tipoPensione,
                            dataInizioSoggiorno, dataFineSoggiorno, wifi, parcheggio, balcone));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println("errore nella clonazione dell'oggetto prenotazione");
                }
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("errore nella creazione dell'oggetto prenotazione");
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("errore nella lettura dei dati");
        }

    }

    public void inserisciPrenotazioneAlloggioAppartamento() {

        
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale(in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale (in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento("inserisci il tipo di appartamento che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci true(se include il cucina) o false(se non include il cucina) ", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci true(se include il parcheggio) o false(se non include il parcheggio) ", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci true(se include il animaliDomestici) o false(se non include il animaliDomestici) ", "errore");
            
        try {
            ga.addPrenotazioneAlloggioAppartamento(new PrenotazioneAlloggioAppartamento(nomeCliente, tipoAppartamento,
                    dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici));
        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    public void inserisciPrenotazioneAlloggioCasaIndipendente() {

        try {
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale(in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale(in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente("inserisci il tipo di casa indipendente che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci true(se include il cucina) o false(se non include il cucina) ", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci true(se include il animaliDomestici) o false(se non include il animaliDomestici) ", "errore");
            boolean piscina=LeggiConsole.getYesNo("inserisci true(se include il piscina) o false(se non include il piscina) ", "errore");
            
            try {
                try {
                    ga.addPrenotazioneAlloggioCasaIndipendente(new PrenotazioneAlloggioCasaIndipendente(nomeCliente, tipoCasaIndipendente,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, animaliDomestici, piscina));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inserisciPrenotazioneAlloggioVillaggio() {

        try {
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale(in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale(in formato dd-MM-yyyy : ", "il formato non è corretto ( reinserisci nel formato dd-MM-yyyy)");
            TipoStrutturaVillaggio tipoSrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio("inserisci il tipo di struttura nel villaggio che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci true(se include il cucina) o false(se non include il cucina) ", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci true(se include il parcheggio) o false(se non include il parcheggio) ", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci true(se include il animaliDomestici) o false(se non include il animaliDomestici) ", "errore");
            boolean animazione=LeggiConsole.getYesNo("inserisci true(se include il animazione) o false(se non include il animazione) ", "errore");
            
            try {
                try {
                    ga.addPrenotazioneAlloggioVillaggio(new PrenotazioneAlloggioVillaggio(nomeCliente, tipoSrutturaVillaggio,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici, animazione));
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inserisciPrenotazioneViaggioAereo() {

        try {
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            int nPasseggeri = LeggiConsole.getInt("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data iniziale nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data finale nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di inzio sosta oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo: ");
            TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean bagaglio=LeggiConsole.getYesNo("inserisci true(se include il bagaglio) o false(se non include il bagaglio) ", "errore");
            
            try {
                ga.addPrenotazioneViaggioAereo(new PrenotazioneViaggioAereo(nomeCliente, nPasseggeri, tipoClasseMezzo, LuogoPartenza, dataPartenza,  LuogoArrivo, dataArrivo,  bagaglio));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inserisciPrenotazioneViaggioAutobus() {

        try {
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            int nPasseggeri = LeggiConsole.getInt("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data iniziale nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data finale nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di inzio sosta oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
             TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean finestrino=LeggiConsole.getYesNo("inserisci true(se include il finestrino) o false(se non include il finestrino) ", "errore");
            boolean wifi=LeggiConsole.getYesNo("inserisci true(se include il wifi) o false(se non include il wifi) ", "errore");
            
            
            try {
                ga.addPrenotazioneViaggioAutobus(new PrenotazioneViaggioAutobus(nomeCliente, nPasseggeri,
                        tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo,  finestrino, wifi));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inserisciPrenotazioneViaggioTreno() {

        try {
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            int nPasseggeri = LeggiConsole.getInt("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data iniziale nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data finale nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di inzio sosta oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
             TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean finestrino=LeggiConsole.getYesNo("inserisci true(se include il finestrino) o false(se non include il finestrino) ", "errore");
            
            try {
                ga.addPrenotazioneViaggioTreno(new PrenotazioneViaggioTreno(nomeCliente, nPasseggeri,
                        tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo,  finestrino));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneAlloggioHotel() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneAlloggioHotel(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneAlloggioAppartamento() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneAlloggioAppartamento(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneAlloggioCasaIndipendente() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneAlloggioCasaIndipendente(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneAlloggioVillaggio() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneAlloggioVillaggio(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneViaggioAereo() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneViaggioAereo(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneViaggioAutobus() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneViaggioAutobus(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaPrenotazioneViaggioTreno() {
        try {
            //input dei parametri
          int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.removePrenotazioneViaggioTreno(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazionee e sostituirla con una nuova
     *
     */

    public void modificaPrenotazioneAlloggioHotel() {

        try {
            //input dei parametri
             int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale: ", "errore");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale: ", "errore");
             TipoCamera tipoCamera = utils.LeggiConsole.getCamera("inserisci il tipo di camera che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di camera previsti sono:" + TipoCamera.listOfConstants());
            TipoPensione tipoPensione = utils.LeggiConsole.getTipoPensione("inserisci il tipo di pensione che desidera"
                    + " inserire", "errore! la tipologia di pensione da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoPensione.listOfConstants());
            
            boolean wifi=LeggiConsole.getYesNo("inserisci Y se il wifi è incluso oppure N se il finestrino non è incluso", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y se il parcheggio è incluso oppure N se il parcheggio non è incluso", "errore");
            boolean balcone=LeggiConsole.getYesNo("inserisci Y se il balcone è incluso oppure N se il balcone non è incluso", "errore");
            
            try {
                ga.setPrenotazioneAlloggioHotel(codice,new PrenotazioneAlloggioHotel(nomeCliente, tipoCamera, tipoPensione,
                        dataInizioSoggiorno, dataFineSoggiorno, wifi, parcheggio, balcone));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaPrenotazioneAlloggioAppartamento() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale: ", "errore");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale: ", "errore");
             TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento("inserisci il tipo di appartamento che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y se la cucina è incluso oppure N se la cucina non è incluso", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y se il parcheggio è incluso oppure N se il parcheggio non è incluso", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y se l'opzione animali domestici è inclusa oppure N se l'opzione animali domestici non è inclusa", "errore");
            
            try {
                ga.setPrenotazioneAlloggioAppartamento(codice,new PrenotazioneAlloggioAppartamento(nomeCliente, tipoAppartamento,
                        dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaPrenotazioneAlloggioCasaIndipendente() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale: ", "errore");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale: ", "errore");
           TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente("inserisci il tipo di casa indipendente che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y se la cucina è incluso oppure N se la cucina non è incluso", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y se l'opzione animali domestici è inclusa oppure N se l'opzione animali domestici non è inclusa", "errore");
            boolean piscina=LeggiConsole.getYesNo("inserisci Y se la piscina è incluso oppure N se la piscina non è incluso", "errore");
            
            try {
                ga.setPrenotazioneAlloggioCasaIndipendente(codice,new PrenotazioneAlloggioCasaIndipendente(nomeCliente, tipoCasaIndipendente,
                        dataInizioSoggiorno, dataFineSoggiorno, cucina, animaliDomestici, piscina));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaPrenotazioneAlloggioVillaggio() {
        try {
            //input dei parametri
             int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale: ", "errore");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDate("inserisci la data finale: ", "errore");
             TipoStrutturaVillaggio tipoSrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio("inserisci il tipo di struttura nel villaggio che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants());
            
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y se la cucina è incluso oppure N se la cucina non è incluso", "errore");
            
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y se il parcheggio è incluso oppure N se il parcheggio non è incluso", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y se l'opzione animali domestici è inclusa oppure N se l'opzione animali domestici non è inclusa", "errore");
            
            
            boolean animazione=LeggiConsole.getYesNo("inserisci Y se l animazione è inclusa oppure N se l'animazione non è inclusa", "errore");
            
            try {
                ga.setPrenotazioneAlloggioVillaggio(codice,new PrenotazioneAlloggioVillaggio(nomeCliente, tipoSrutturaVillaggio,
                        dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici, animazione));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaPrenotazioneViaggioAereo() {
        try {
            //input dei parametri
             int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            int nPasseggeri = LeggiConsole.getInt("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data iniziale nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data finale nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di inzio sosta oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
             TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean bagaglio=LeggiConsole.getYesNo("inserisci Y se il bagaglio è incluso oppure N se il bagaglio non è incluso", "errore");
            
            try {
                ga.setPrenotazioneViaggioAereo(codice,new PrenotazioneViaggioAereo(nomeCliente, nPasseggeri, tipoClasseMezzo, LuogoPartenza, dataPartenza,  LuogoArrivo, dataArrivo,  bagaglio));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificaPrenotazioneViaggioAutobus() {
        try {
            //input dei parametri
              int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            int nPasseggeri = LeggiConsole.getInt("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data iniziale nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data finale nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di inzio sosta oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
            TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean finestrino=LeggiConsole.getYesNo("inserisci Y se il finestrino è incluso oppure N se il finestrino non è incluso", "errore");
            boolean wifi=LeggiConsole.getYesNo("inserisci Y se il wifi è incluso oppure N se il finestrino non è incluso", "errore");
            
            try {
                ga.setPrenotazioneViaggioAutobus(codice,new PrenotazioneViaggioAutobus(nomeCliente, nPasseggeri,
                        tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo, finestrino,wifi));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaPrenotazioneViaggioTreno() {

        try {
            //input dei parametri
          int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome della nuova prenotazione: ");
            int nPasseggeri = LeggiConsole.getInt("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data iniziale nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data finale nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di inzio sosta oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
            TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire", "errore! la tipologia di camera da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean finestrino=LeggiConsole.getYesNo("inserisci Y se il finestrino è incluso oppure N se il finestrino non è incluso", "errore");
            
            try {
                ga.setPrenotazioneViaggioTreno(codice,new PrenotazioneViaggioTreno(nomeCliente, nPasseggeri,
                        tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo,  finestrino));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneAlloggioHotel() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneAlloggioHotel(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneAlloggioAppartamento() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneAlloggioAppartamento(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneAlloggioCasaIndipendente() {
        try {
          int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneAlloggioCasaIndipendente(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneAlloggioVillaggio() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneAlloggioVillaggio(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneViaggioAereo() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneViaggioAereo(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneViaggioAutobus() {
        try {
            //input dei parametri
          int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneViaggioAutobus(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ricercaPrenotazioneViaggioTreno() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getInt("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                ga.getPrenotazioneViaggioTreno(codice);
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per stampare la lista delle prenotazioni +
     *
     */
    public void stampaListaPrenotazioniAlloggioHotel() throws IOException {
        ga.stampaListaPrenotazioniAlloggioHotel();
    }

    public void stampaListaPrenotazioniAlloggioAppartamento() throws IOException {
        ga.stampaListaPrenotazioniAlloggioAppartamento();
    }

    public void stampaListaPrenotazioniAlloggioCasaIndipendente() throws IOException {
        ga.stampaListaPrenotazioniAlloggioCasaIndipendente();
    }

    public void stampaListaPrenotazioniAlloggioVillaggio() throws IOException {
        ga.stampaListaPrenotazioniAlloggioVillaggio();
    }

    public void stampaListaPrenotazioniViaggioAereo() throws IOException {
        ga.stampaListaPrenotazioniViaggioAereo();
    }

    public void stampaListaPrenotazioniViaggioAutobus() throws IOException {
        ga.stampaListaPrenotazioniViaggioAutobus();
    }

    public void stampaListaPrenotazioniViaggioTreno() throws IOException {
        ga.stampaListaPrenotazioniViaggioTreno();
    }

    /**
     * funzione per mettere in ordine le prenotazioni
     *
     */
    public void sortPrenotazioniHotel() throws IOException {
        ga.sortPrenotazioniHotel();
    }

    public void sortPrenotazioniAppartamenti() throws IOException {
        ga.sortPrenotazioniAppartamenti();
    }

    public void sortPrenotazioniCaseIndipendenti() throws IOException {
        ga.sortPrenotazioniCaseIndipendenti();
    }

    public void sortPrenotazioniStruttureVillaggio() throws IOException {
        ga.sortPrenotazioniStruttureVillaggio();
    }

    public void sortPrenotazioniAereo() throws IOException {
        ga.sortPrenotazioniAereo();
    }

    public void sortPrenotazioniAutobus() throws IOException {
        ga.sortPrenotazioniAutobus();
    }

    public void sortPrenotazioniTreno() throws IOException {
        ga.sortPrenotazioniTreno();
    }
    public void sortPrenotazioniAgenzia() throws IOException{
         ga.sortPrenotazioniAgenzia();
    }
public void calcolaIncassoAnnualeTotaleAgenzia() throws IOException{
 int anno = LeggiConsole.getInt("inserisci l'anno desiderato della prenotazione da ricercare: ","errore");
        ///elimino LA PRENOTYAZIONE 
        ga.calcolaIncassoAnnualeTotaleAgenzia(anno);
}
public void TrovaFonteMaxGuadagnoAnnuale() throws IOException{
int anno = LeggiConsole.getInt("inserisci l'anno desiderato della prenotazione da ricercare: ","errore");
        ///elimino LA PRENOTYAZIONE 
        ga.TrovaFonteMaxGuadagnoAnnuale(anno);
}
}
