/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import ioconsole.LeggiConsole;
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
/**
 * funzione per inserire una Prenotazione dell'hotel
 */
    public void inserisciPrenotazioneAlloggioHotel() {

            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
          
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
            TipoCamera tipoCamera = utils.LeggiConsole.getCamera("inserisci il tipo di camera che desidera"
                    + " inserire, i tipi di camera previsti sono:" + TipoCamera.listOfConstants()+": ","errore! la tipologia di camera da lei selezionata non è valida, i tipi di camera previsti sono:" + TipoCamera.listOfConstants());
            TipoPensione tipoPensione = utils.LeggiConsole.getTipoPensione("inserisci il tipo di pensione che desidera"
                    + " inserire, i tipi di pensione previsti sono:" + TipoPensione.listOfConstants()+": ", "errore! la tipologia di pensione da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoPensione.listOfConstants());
            
            boolean wifi=LeggiConsole.getYesNo("inserisci Y (se include il wifi) o N (se non include il wifi) ", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y(se include il parcheggio) o N (se non include il parcheggio) ", "errore");
            boolean balcone=LeggiConsole.getYesNo("inserisci Y(se include il balcone) o N (se non include il balcone) ", "errore");
        try {
           
            ga.addPrenotazioneAlloggioHotel(new PrenotazioneAlloggioHotel(nomeCliente, tipoCamera, tipoPensione,
                    dataInizioSoggiorno, dataFineSoggiorno, wifi, parcheggio, balcone));
            System.out.println("prenotazione registrata correttamente!");
        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * funzione per inserire una Prenotazione delgli appartamenti
 */
    public void inserisciPrenotazioneAlloggioAppartamento() {

        
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
            TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento("inserisci il tipo di appartamento che desidera"
                    + " inserire, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants()+": ", "errore! la tipologia di appartamento da lei selezionata non è valida, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y (se include il cucina) o N (se non include il cucina) ", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y (se include il parcheggio) o N (se non include il parcheggio) ", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y (se include il animaliDomestici) o N (se non include il animaliDomestici) ", "errore");
            
        try {
            ga.addPrenotazioneAlloggioAppartamento(new PrenotazioneAlloggioAppartamento(nomeCliente, tipoAppartamento,
                    dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici));
                   System.out.println("prenotazione registrata correttamente!");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
/**
 * funzione per inserire una Prenotazione delle case indipnedenti
 */
    public void inserisciPrenotazioneAlloggioCasaIndipendente() {

       
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
            TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente("inserisci il tipo di casa indipendente che desidera"
                    + " inserire, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.listOfConstants()+": ", "errore! la tipologia di casa indipendente da lei selezionata non è valida, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y (se include il cucina) o N (se non include il cucina) ", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y (se include il animaliDomestici) o N (se non include il animaliDomestici) ", "errore");
            boolean piscina=LeggiConsole.getYesNo("inserisci Y (se include il piscina) o N (se non include il piscina) ", "errore");
            
           
        try {
            ga.addPrenotazioneAlloggioCasaIndipendente(new PrenotazioneAlloggioCasaIndipendente(nomeCliente, tipoCasaIndipendente,
                    dataInizioSoggiorno, dataFineSoggiorno, cucina, animaliDomestici, piscina));
                    System.out.println("prenotazione registrata correttamente!");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
               

    }
/**
 * funzione per inserire una Prenotazione del villaggio
 */
    public void inserisciPrenotazioneAlloggioVillaggio() {

        
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
            TipoStrutturaVillaggio tipoSrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio("inserisci il tipo di struttura nel villaggio che desidera"
                    + " inserire,i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants()+": ", "errore! la tipologia di struttura da lei selezionata non è valida, i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y (se include il cucina) o false(se non include il cucina) ", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y (se include il parcheggio) o N (se non include il parcheggio) ", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y (se include il animaliDomestici) o N (se non include il animaliDomestici) ", "errore");
            boolean animazione=LeggiConsole.getYesNo("inserisci Y (se include il animazione) o N (se non include il animazione) ", "errore");
            
            
        try {
            ga.addPrenotazioneAlloggioVillaggio(new PrenotazioneAlloggioVillaggio(nomeCliente, tipoSrutturaVillaggio,
                    dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici, animazione));
                    System.out.println("prenotazione registrata correttamente!");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    }
/**
 * funzione per inserire una Prenotazione dell'aereo
 */
    public void inserisciPrenotazioneViaggioAereo() {

     
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            int nPasseggeri = LeggiConsole.getIntPositivo("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di partenza oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo: ");
            TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());
            
            boolean bagaglio=LeggiConsole.getYesNo("inserisci Y (se include il bagaglio) o N (se non include il bagaglio) ", "errore");
            
          
        try {
            ga.addPrenotazioneViaggioAereo(new PrenotazioneViaggioAereo(nomeCliente, nPasseggeri, tipoClasseMezzo, LuogoPartenza, dataPartenza,  LuogoArrivo, dataArrivo,  bagaglio));
                   System.out.println("prenotazione registrata correttamente!");
            System.out.println("prenotazione registrata correttamente!");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }
/**
 * funzione per inserire una Prenotazione dell'autobus
 */
    public void inserisciPrenotazioneViaggioAutobus() {

     
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            int nPasseggeri = LeggiConsole.getIntPositivo("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di partenza oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
             TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
 + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());            
            boolean finestrino=LeggiConsole.getYesNo("inserisci Y (se include il finestrino) o N (se non include il finestrino) ", "errore");
            boolean wifi=LeggiConsole.getYesNo("inserisci Y (se include il wifi) o N (se non include il wifi) ", "errore");
            
            
          
        try {
            ga.addPrenotazioneViaggioAutobus(new PrenotazioneViaggioAutobus(nomeCliente, nPasseggeri,
                    tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo,  finestrino, wifi));
                    System.out.println("prenotazione registrata correttamente!");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
/**
 * funzione per inserire una Prenotazione del treno
 */
    public void inserisciPrenotazioneViaggioTreno() {

      
            //input dei parametri
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome del cliente: ");
            int nPasseggeri = LeggiConsole.getIntPositivo("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di partenza oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
             TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
 + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());            
            boolean finestrino=LeggiConsole.getYesNo("inserisci Y (se include il finestrino) o N (se non include il finestrino) ", "errore");
            
        
        try {
            ga.addPrenotazioneViaggioTreno(new PrenotazioneViaggioTreno(nomeCliente, nPasseggeri,
                    tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo,  finestrino));
                    System.out.println("prenotazione registrata correttamente!");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
          

    }
    /**
     * funzione per eliminare una Prenotazione dell'hotel
     */

    public void eliminaPrenotazioneAlloggioHotel() {
       
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
           
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioHotel(codice);
         System.out.println("prenotazione correttamente eliminata.");
        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
/**
     * funzione per eliminare una Prenotazione delgli appartamenti
 */
    public void eliminaPrenotazioneAlloggioAppartamento() {
      
            //input dei parametri
           int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioAppartamento(codice);
                     System.out.println("prenotazione correttamente eliminata.");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
/**
     * funzione per eliminare una Prenotazione
 */
    public void eliminaPrenotazioneAlloggioCasaIndipendente() {
      
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
          
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioCasaIndipendente(codice);
                     System.out.println("prenotazione correttamente eliminata.");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
/**
     * funzione per eliminare una Prenotazione del villaggio
 */
    public void eliminaPrenotazioneAlloggioVillaggio() {
        
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
         
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioVillaggio(codice);
                     System.out.println("prenotazione correttamente eliminata.");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }
/**
     * funzione per eliminare una Prenotazione dell'aereo
 */
    public void eliminaPrenotazioneViaggioAereo() {
       
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
           
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneViaggioAereo(codice);
                     System.out.println("prenotazione correttamente eliminata.");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
/**
     * funzione per eliminare una Prenotazione dell'autobus
 */
    public void eliminaPrenotazioneViaggioAutobus() {
     
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneViaggioAutobus(codice);
                     System.out.println("prenotazione correttamente eliminata.");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
/**
     * funzione per eliminare una Prenotazione del treno
 */
    public void eliminaPrenotazioneViaggioTreno() {
       
            //input dei parametri
          int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
           
        try {
            ///elimino LA PRENOTYAZIONE
            ga.removePrenotazioneViaggioTreno(codice);
                     System.out.println("prenotazione correttamente eliminata.");

        } catch (AgenziaException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
           

    }

    /**
     * funzione per modificare una Prenotazione dell'hotel e sostituirla con una nuova
     *
     */

    public void modificaPrenotazioneAlloggioHotel() {

        try {
            //input dei parametri
             int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
             TipoCamera tipoCamera = utils.LeggiConsole.getCamera("inserisci il tipo di camera che desidera"
                    + " inserire, i tipi di camera previsti sono:" + TipoCamera.listOfConstants()+": ","errore! la tipologia di camera da lei selezionata non è valida, i tipi di camera previsti sono:" + TipoCamera.listOfConstants());
            TipoPensione tipoPensione = utils.LeggiConsole.getTipoPensione("inserisci il tipo di pensione che desidera"
                    + " inserire, i tipi di pensione previsti sono:" + TipoPensione.listOfConstants()+": ", "errore! la tipologia di pensione da lei selezionata non è valida, i tipi di pensione previsti sono:" + TipoPensione.listOfConstants());
            
            boolean wifi=LeggiConsole.getYesNo("inserisci Y se il wifi è incluso oppure N se il finestrino non è incluso", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y se il parcheggio è incluso oppure N se il parcheggio non è incluso", "errore");
            boolean balcone=LeggiConsole.getYesNo("inserisci Y se il balcone è incluso oppure N se il balcone non è incluso", "errore");
            
            try {
                ga.setPrenotazioneAlloggioHotel(codice,new PrenotazioneAlloggioHotel(nomeCliente, tipoCamera, tipoPensione,
                        dataInizioSoggiorno, dataFineSoggiorno, wifi, parcheggio, balcone));
                         System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * funzione per modificare una Prenotazione delgli appartamenti e sostituirla con una nuova
 */
    public void modificaPrenotazioneAlloggioAppartamento() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
             TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento("inserisci il tipo di appartamento che desidera"
                    + " inserire, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants()+": ","errore! la tipologia di appartamento da lei selezionata non è valida, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y se la cucina è incluso oppure N se la cucina non è incluso", "errore");
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y se il parcheggio è incluso oppure N se il parcheggio non è incluso", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y se l'opzione animali domestici è inclusa oppure N se l'opzione animali domestici non è inclusa", "errore");
            
            try {
                ga.setPrenotazioneAlloggioAppartamento(codice,new PrenotazioneAlloggioAppartamento(nomeCliente, tipoAppartamento,
                        dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici));
                                         System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * funzione per modificare una Prenotazione delle case indipnedenti e sostituirla con una nuova
 */
    public void modificaPrenotazioneAlloggioCasaIndipendente() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
           TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente("inserisci il tipo di casa indipendente che desidera"
                    + " inserire, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.listOfConstants()+": ",  "errore! la tipologia di casa indipendente da lei selezionata non è valida, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.listOfConstants());
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y se la cucina è incluso oppure N se la cucina non è incluso", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y se l'opzione animali domestici è inclusa oppure N se l'opzione animali domestici non è inclusa", "errore");
            boolean piscina=LeggiConsole.getYesNo("inserisci Y se la piscina è incluso oppure N se la piscina non è incluso", "errore");
            
            try {
                ga.setPrenotazioneAlloggioCasaIndipendente(codice,new PrenotazioneAlloggioCasaIndipendente(nomeCliente, tipoCasaIndipendente,
                        dataInizioSoggiorno, dataFineSoggiorno, cucina, animaliDomestici, piscina));
                                         System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * funzione per modificare una Prenotazione del villaggio e sostituirla con una nuova
 */
    public void modificaPrenotazioneAlloggioVillaggio() {
        try {
            //input dei parametri
             int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate("inserisci la data iniziale  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
            LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter("inserisci la data finale  (in formato dd-MM-yyyy) : ", "la data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy", dataInizioSoggiorno);
             TipoStrutturaVillaggio tipoSrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio("inserisci il tipo di struttura nel villaggio che desidera"
                    + " inserire,i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants()+": ", "errore! la tipologia di struttura da lei selezionata non è valida, i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants());
            
            
            boolean cucina=LeggiConsole.getYesNo("inserisci Y se la cucina è incluso oppure N se la cucina non è incluso", "errore");
            
            boolean parcheggio=LeggiConsole.getYesNo("inserisci Y se il parcheggio è incluso oppure N se il parcheggio non è incluso", "errore");
            boolean animaliDomestici=LeggiConsole.getYesNo("inserisci Y se l'opzione animali domestici è inclusa oppure N se l'opzione animali domestici non è inclusa", "errore");
            
            
            boolean animazione=LeggiConsole.getYesNo("inserisci Y se l animazione è inclusa oppure N se l'animazione non è inclusa", "errore");
            
            try {
                ga.setPrenotazioneAlloggioVillaggio(codice,new PrenotazioneAlloggioVillaggio(nomeCliente, tipoSrutturaVillaggio,
                        dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici, animazione));
                                         System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * funzione per modificare una Prenotazione dell'aereo e sostituirla con una nuova
 */
    public void modificaPrenotazioneViaggioAereo() {
        try {
            //input dei parametri
             int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            int nPasseggeri = LeggiConsole.getIntPositivo("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di partenza oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
             TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
 + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ","errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());            
            boolean bagaglio=LeggiConsole.getYesNo("inserisci Y se il bagaglio è incluso oppure N se il bagaglio non è incluso", "errore");
            
            try {
                ga.setPrenotazioneViaggioAereo(codice,new PrenotazioneViaggioAereo(nomeCliente, nPasseggeri, tipoClasseMezzo, LuogoPartenza, dataPartenza,  LuogoArrivo, dataArrivo,  bagaglio));
                                    System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
     * funzione per modificare una Prenotazione dell'autobus e sostituirla con una nuova
 */
    public void modificaPrenotazioneViaggioAutobus() {
        try {
            //input dei parametri
              int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            int nPasseggeri = LeggiConsole.getIntPositivo("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di partenza oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
            TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
 + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());            
            boolean finestrino=LeggiConsole.getYesNo("inserisci Y se il finestrino è incluso oppure N se il finestrino non è incluso", "errore");
            boolean wifi=LeggiConsole.getYesNo("inserisci Y se il wifi è incluso oppure N se il finestrino non è incluso", "errore");
            
            try {
                ga.setPrenotazioneViaggioAutobus(codice,new PrenotazioneViaggioAutobus(nomeCliente, nPasseggeri,
                        tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo, finestrino,wifi));
                                         System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * funzione per modificare una Prenotazione del treno e sostituirla con una nuova
 */
    public void modificaPrenotazioneViaggioTreno() {

        try {
            //input dei parametri
          int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ","errore");
            String nomeCliente = LeggiConsole.getStringNonVuota("inserisci il nome cliente della nuova prenotazione: ");
            int nPasseggeri = LeggiConsole.getIntPositivo("inserisci il numero di passeggeri : ", "errore");
            LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
            String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza del cliente: ");
            LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter("inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ", "la data deve essere successiva a quella di partenza oppure il formato inserito non è corretto, reinserisci.", "dd-MM-yyyy HH:mm", dataPartenza);
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo del cliente: ");
            TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
 + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ","errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());            
            boolean finestrino=LeggiConsole.getYesNo("inserisci Y se il finestrino è incluso oppure N se il finestrino non è incluso", "errore");
            
            try {
                ga.setPrenotazioneViaggioTreno(codice,new PrenotazioneViaggioTreno(nomeCliente, nPasseggeri,
                        tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo,  finestrino));
                                         System.out.println("prenotazione correttamente modificata.");

            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
     * funzione per ricercare una Prenotazione dell'hotel
 */
    public void ricercaPrenotazioneAlloggioHotel() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println( ga.getPrenotazioneAlloggioHotel(codice));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
* funzione per ricercare una Prenotazione delgli appartamenti
*/
    public void ricercaPrenotazioneAlloggioAppartamento() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println(ga.getPrenotazioneAlloggioAppartamento(codice));
                
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
* funzione per ricercare una Prenotazione delle case indipnedenti
*/
    public void ricercaPrenotazioneAlloggioCasaIndipendente() {
        try {
          int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println(ga.getPrenotazioneAlloggioCasaIndipendente(codice));
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
* funzione per ricercare una Prenotazione del villaggio
 */
    public void ricercaPrenotazioneAlloggioVillaggio() {
        try {
            //input dei parametri
           int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println(ga.getPrenotazioneAlloggioVillaggio(codice));
                
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
* funzione per ricercare una Prenotazione dell'aereo
 */
    public void ricercaPrenotazioneViaggioAereo() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println(ga.getPrenotazioneViaggioAereo(codice));
                
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
* funzione per ricercare una Prenotazione dell'autobus
 */
    public void ricercaPrenotazioneViaggioAutobus() {
        try {
            //input dei parametri
          int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println(ga.getPrenotazioneViaggioAutobus(codice));
                
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
* funzione per ricercare una Prenotazione del treno
 */
    public void ricercaPrenotazioneViaggioTreno() {
        try {
            //input dei parametri
            int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ","errore");
            try {
                ///elimino LA PRENOTYAZIONE
                System.out.println(ga.getPrenotazioneViaggioTreno(codice));
                
            } catch (AgenziaException ex) {
                Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per stampare la lista delle prenotazioni dell'hotel
     */
    public void stampaListaPrenotazioniAlloggioHotel() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniAlloggioHotel()); 
    }
 /**
     * funzione per stampare la lista delle prenotazioni delgli appartamenti
     */
    public void stampaListaPrenotazioniAlloggioAppartamento() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniAlloggioAppartamento());
       
    }
 /**
     * funzione per stampare la lista delle prenotazioni delle case indipnedenti
     */
    public void stampaListaPrenotazioniAlloggioCasaIndipendente() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniAlloggioCasaIndipendente());
    }
 /**
     * funzione per stampare la lista delle prenotazioni del villaggio
     */
    public void stampaListaPrenotazioniAlloggioVillaggio() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniAlloggioVillaggio());
        
    }
 /**
     * funzione per stampare la lista delle prenotazioni dell'aereo
     */
    public void stampaListaPrenotazioniViaggioAereo() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniViaggioAereo());
        
    }
 /**
     * funzione per stampare la lista delle prenotazioni dell'autobus
     */
    public void stampaListaPrenotazioniViaggioAutobus() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniViaggioAutobus()); 
    }
 /**
     * funzione per stampare la lista delle prenotazioni del treno
     */
    public void stampaListaPrenotazioniViaggioTreno() throws IOException {
        System.out.println(ga.stampaListaPrenotazioniViaggioTreno());
    }
     /**
     * funzione per stampare la lista di tutte le prenotazioni dell'agenzia
     */
     public void stampaListaPrenotazioniAgenzia() throws IOException {
        ga.stampaListaPrenotazioniAgenzia();
    }
     /**
      * funzione per verificare la disponibilità del tipo di camera dell'albergo
      * @throws IOException 
      */
     public void verificaDisponibilitaHotel() throws IOException {
          TipoCamera tipoCamera = utils.LeggiConsole.getCamera("inserisci il tipo di camera che desidera"
                    + " inserire, i tipi di camera previsti sono:" + TipoCamera.listOfConstants()+": "
                            + "","errore! la tipologia di camera da lei selezionata non è valida,"
                                    + " i tipi di camera previsti sono:" + TipoCamera.listOfConstants());
            LocalDate data = LeggiConsole.getLocalDate("inserisci la data in cui verificare la disponibilità  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        if(ga.verificaDisponibilitaHotel(tipoCamera,data)){
            System.out.println("la camera "+tipoCamera+" risulta disponibile il "+data);
        }else{
             System.out.println("la camera "+tipoCamera+" NON risulta disponibile il "+data);

        }
    }
     /**
      * funzione per verificare la disponibilità del tipo di appartamento
      * @throws IOException 
      */
      public void verificaDisponibilitaAppartamento() throws IOException {
          TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento("inserisci il tipo di appartamento che desidera"
                    + " inserire, i tipi di appartamento previsti sono:" + TipoAppartamento.listOfConstants()+
                  ": ", "errore! la tipologia di appartamento da lei selezionata non è valida, i tipi"
                          + " di appartamento previsti sono:" + TipoAppartamento.listOfConstants());
            
            LocalDate data = LeggiConsole.getLocalDate("inserisci la data in cui verificare la disponibilità  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
         if(ga.verificaDisponibilitaAppartamento(tipoAppartamento,data)){
            System.out.println("l'appartamento "+tipoAppartamento+" risulta disponibile il "+data);
        }else{
             System.out.println("l'appartamento "+tipoAppartamento+" NON risulta disponibile il "+data);

        }
    }
      /**
       * funzione per verificare la disponibilità del tipo di casa indipendente 
       * @throws IOException 
       */
       public void verificaDisponibilitaCasaIndipendente() throws IOException {
          TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente
        ("inserisci il tipo di casa indipendente che desidera"
                    + " inserire, i tipi di casa indipendente previsti sono:" + TipoCasaIndipendente.
                            listOfConstants()+": ", "errore! la tipologia di casa indipendente da lei"
                                    + " selezionata non è valida, i tipi di casa indipendente previsti "
                                    + "sono:" + TipoCasaIndipendente.listOfConstants());
            
            LocalDate data = LeggiConsole.getLocalDate("inserisci la data in cui verificare la disponibilità  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        if(ga.verificaDisponibilitaCasaIndipendente(tipoCasaIndipendente,data)){
            System.out.println("la casa indipendente "+tipoCasaIndipendente+" risulta disponibile il "+data);
        }else{
             System.out.println("la casa indipendente "+tipoCasaIndipendente+" NON risulta disponibile il "+data);

        }
    }
       /**
        * funzione per verificare la disponibilità del tipo di struttura del villaggio
        * @throws IOException 
        */
        public void verificaDisponibilitaStrutturaVillaggio() throws IOException {
        TipoStrutturaVillaggio tipoSrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio("inserisci il tipo di struttura nel villaggio che desidera"
                    + " inserire,i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants()+": ", "errore! la tipologia di struttura da lei selezionata non è valida, i tipi di struttura nel villaggio previsti sono:" + TipoStrutturaVillaggio.listOfConstants());
            
            LocalDate data = LeggiConsole.getLocalDate("inserisci la data in cui verificare la disponibilità  (in formato dd-MM-yyyy) : ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        if(ga.verificaDisponibilitaStrutturaVillaggio(tipoSrutturaVillaggio,data)){
            System.out.println("la struttura "+tipoSrutturaVillaggio+" risulta disponibile il "+data);
        }else{
             System.out.println("la struttura "+tipoSrutturaVillaggio+" NON risulta disponibile il "+data);

        }
    }
 /**
         * funzione per verificare la disponibilità di posti nel tipo di classe dell'aereo
         * @throws IOException 
         */
         public void verificaDisponibilitaAereo() throws IOException {
          TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());
           String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza: ");
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo: ");
            LocalDateTime data = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        if(ga.verificaDisponibilitaAereo(tipoClasseMezzo,data,LuogoPartenza,LuogoArrivo)){
            System.out.println("la "+tipoClasseMezzo+" class risulta disponibile il "+data+" per il viaggio da "+LuogoPartenza+" a "+LuogoArrivo);
        }else{
             System.out.println("la "+tipoClasseMezzo+" class NON risulta disponibile il "+data+" per il viaggio da "+LuogoPartenza+" a "+LuogoArrivo);

        }
    }
         /**
          * funzione per verificare la disponibilità di posti nel tipo di classe del treno
          * @throws IOException 
          */
         public void verificaDisponibilitaTreno() throws IOException {
           TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());
           String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza: ");
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo: ");
            LocalDateTime data = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        if(ga.verificaDisponibilitaTreno(tipoClasseMezzo,data,LuogoPartenza,LuogoArrivo)){
            System.out.println("la "+tipoClasseMezzo+" class risulta disponibile il "+data+" per il viaggio da "+LuogoPartenza+" a "+LuogoArrivo);
        }else{
             System.out.println("la "+tipoClasseMezzo+" class NON risulta disponibile il "+data+" per il viaggio da "+LuogoPartenza+" a "+LuogoArrivo);

        }
    }
         /**
          * funzione per verificare la disponibilità di posti nel tipo di classe dell'autobus
          * @throws IOException 
          */
         public void verificaDisponibilitaAutobus() throws IOException {
           TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo("inserisci la classe del mezzo che desidera"
                    + " inserire,i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants()+": ", "errore! la tipologia di classe da lei selezionata non è valida, i tipi di classe previsti sono:" + TipoClasseMezzo.listOfConstants());
           String LuogoPartenza = LeggiConsole.getStringNonVuota("inserisci il LuogoPartenza: ");
            String LuogoArrivo = LeggiConsole.getStringNonVuota("inserisci il LuogoArrivo: ");
            LocalDateTime data = LeggiConsole.getLocalDateTime("inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ", "il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
       
        if(ga.verificaDisponibilitaAutobus(tipoClasseMezzo,data,LuogoPartenza,LuogoArrivo)){
            System.out.println("la "+tipoClasseMezzo+" class risulta disponibile il "+data+" per il viaggio da "+LuogoPartenza+" a "+LuogoArrivo);
        }else{
             System.out.println("la "+tipoClasseMezzo+" class NON risulta disponibile il "+data+" per il viaggio da "+LuogoPartenza+" a "+LuogoArrivo);

        }
    }

    /**
     * funzione per mettere in ordine le prenotazioni delle camere d'hotel
     *
     * @throws java.io.IOException
     */
    public void sortPrenotazioniHotel() throws IOException {
        ga.sortPrenotazioniHotel();
            System.out.println("ordinamento effettuato correttamente.");
    }
    /**
     * funzione per mettere in ordine le prenotazioni degli appartamenti
     * @throws IOException 
     */

    public void sortPrenotazioniAppartamenti() throws IOException {
        ga.sortPrenotazioniAppartamenti();
                    System.out.println("ordinamento effettuato correttamente.");

    }
/**
 * funzione per mettere in ordine le prenotazioni delle case indipendenti
 * @throws IOException 
 */
    public void sortPrenotazioniCaseIndipendenti() throws IOException {
        ga.sortPrenotazioniCaseIndipendenti();
                    System.out.println("ordinamento effettuato correttamente.");

    }
/**
 * funzione per mettere in ordine le prenotazioni delle strutture del villaggio
 * @throws IOException 
 */
    public void sortPrenotazioniStruttureVillaggio() throws IOException {
        ga.sortPrenotazioniStruttureVillaggio();
                    System.out.println("ordinamento effettuato correttamente.");

    }
/**
 * funzione per mettere in ordine le prenotazioni dell'aereo
 * @throws IOException 
 */
    public void sortPrenotazioniAereo() throws IOException {
        ga.sortPrenotazioniAereo();
                    System.out.println("ordinamento effettuato correttamente.");

    }
/**
 * funzione per mettere in ordine le prenotazioni dell'autobus
 * @throws IOException 
 */
    public void sortPrenotazioniAutobus() throws IOException {
        ga.sortPrenotazioniAutobus();
                    System.out.println("ordinamento effettuato correttamente.");

    }
/**
 * funzione per mettere in ordine le prenotazioni del treno
 * @throws IOException 
 */
    public void sortPrenotazioniTreno() throws IOException {
        ga.sortPrenotazioniTreno();
                    System.out.println("ordinamento effettuato correttamente.");

    }
    /**
     * funzione per mettere in ordine tutte le prenotazioni dell'agenzia
     * @throws IOException 
     */
    public void sortPrenotazioniAgenzia() throws IOException{
         ga.sortPrenotazioniAgenzia();
                     System.out.println("ordinamento effettuato correttamente.");

    }
    /**
     * funzione per calcolare l'incasso annuale totale dell'hotel
     */
   public void calcolaIncassoAnnualeTotaleHotel() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
    
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleHotel(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
  /**
   * funzione per calcolare l'incasso annuale totale delgli appartamenti
   */
   public void calcolaIncassoAnnualeTotaleAppartamenti() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleAppartamenti(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
   /**
    * funzione per calcolare l'incasso annuale totale delle case indipnedenti
    */
   public void calcolaIncassoAnnualeTotaleCaseIndipendenti() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleCaseIndipendenti(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
   /**
    * funzione per calcolare l'incasso annuale totale del villaggio
    */
   public void calcolaIncassoAnnualeTotaleVillaggio() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleVillaggio(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
   /**
    * funzione per calcolare l'incasso annuale totale dell'autobus
    */
   public void calcolaIncassoAnnualeTotaleAutobus() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleAutobus(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
   /**
    * funzione per calcolare l'incasso annuale totale del treno
    */
   public void calcolaIncassoAnnualeTotaleTreno() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleTreno(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
   /**
    * funzione per calcolare l'incasso annuale totale dell'aereo
    */
   public void calcolaIncassoAnnualeTotaleAereo() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleAereo(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
} 
   /**
    * funzione per calcolare l'incasso annuale totale dell'agenzia
    */
public void calcolaIncassoAnnualeTotaleAgenzia() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleAgenzia(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
}
/**
 * funzione per calcolare l'incasso annuale totale di tutti i mezzi di trasporto
 */
public void calcolaIncassoAnnualeTotaleMezziTrasporto() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleMezziTrasporto(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
}
/**
 * funzione per calcolare l'incasso annuale totale di tutti gli alloggi
 */
public void calcolaIncassoAnnualeTotaleAlloggi() {
 int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleAlloggi(anno) + "€");
       
        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }
        
}
/**
 * funzione per trovare la massima fonte di guadagno annuale 
 * @throws IOException 
 */
public void TrovaFonteMaxGuadagnoAnnuale() throws IOException{
int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ","errore, l'anno deve essere positivo, reinserici!");
        
        System.out.println(ga.TrovaFonteMaxGuadagnoAnnuale(anno));
}
}

