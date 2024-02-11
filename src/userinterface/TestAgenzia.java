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
import myExceptions.PrenotazioneNonTrovata;
import utils.CodiceIdGenerator;

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
     * Funzione per inserire una prenotazione
     */
    public void inserisciPrenotazioneAlloggioHotel() {

        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.",
                "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);

        TipoCamera tipoCamera = utils.LeggiConsole.getCamera(
                "Inserisci il tipo di camera che desideri inserire. I tipi di camera previsti sono: "
                        + TipoCamera.listOfConstants() + ": ",
                "Errore! La tipologia di camera selezionata non è valida. I tipi di camera previsti sono: "
                        + TipoCamera.listOfConstants());

        TipoPensione tipoPensione = utils.LeggiConsole.getTipoPensione(
                "Inserisci il tipo di pensione che desideri inserire. I tipi di pensione previsti sono: "
                        + TipoPensione.listOfConstants() + ": ",
                "Errore! La tipologia di pensione selezionata non è valida. I tipi di pensione previsti sono: "
                        + TipoPensione.listOfConstants());

        boolean wifi = LeggiConsole.getYesNo("Inserisci Y (se include il wifi) o N (se non include il wifi): ",
                "Errore");
        boolean parcheggio = LeggiConsole
                .getYesNo("Inserisci Y (se include il parcheggio) o N (se non include il parcheggio): ", "Errore");
        boolean balcone = LeggiConsole.getYesNo("Inserisci Y (se include il balcone) o N (se non include il balcone): ",
                "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneAlloggioHotel(new PrenotazioneAlloggioHotel(codice_prenotazione,
                    nomeCliente, tipoCamera, tipoPensione,
                    dataInizioSoggiorno, dataFineSoggiorno, wifi, parcheggio, balcone));
            System.out.println(
                    "Prenotazione registrata correttamente! Il tuo codice prenotazione è: " + codice_prenotazione);
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per inserire una Prenotazione delgli appartamenti
     */
    public void inserisciPrenotazioneAlloggioAppartamento() {

        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.",
                "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);

        TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento(
                "Inserisci il tipo di appartamento che desideri inserire. I tipi di appartamento previsti sono: "
                        + TipoAppartamento.listOfConstants() + ": ",
                "Errore! La tipologia di appartamento selezionata non è valida. I tipi di appartamento previsti sono: "
                        + TipoAppartamento.listOfConstants());

        boolean cucina = LeggiConsole.getYesNo("Inserisci Y (se include la cucina) o N (se non include la cucina): ",
                "Errore");
        boolean parcheggio = LeggiConsole
                .getYesNo("Inserisci Y (se include il parcheggio) o N (se non include il parcheggio): ", "Errore");
        boolean animaliDomestici = LeggiConsole.getYesNo(
                "Inserisci Y (se include gli animali domestici) o N (se non include gli animali domestici): ",
                "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneAlloggioAppartamento(
                    new PrenotazioneAlloggioAppartamento(codice_prenotazione, nomeCliente, tipoAppartamento,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici));
            System.out.println(
                    "Prenotazione registrata correttamente!, il tuo codice prenotazione è: " + codice_prenotazione);

        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per inserire una Prenotazione delle case indipnedenti
     */
    public void inserisciPrenotazioneAlloggioCasaIndipendente() {
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.",
                "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);

        TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente(
                "Inserisci il tipo di casa indipendente che desideri inserire. I tipi di casa indipendente previsti sono: "
                        +
                        TipoCasaIndipendente.listOfConstants() + ": ",
                "Errore! La tipologia di casa indipendente selezionata non è valida. I tipi di casa indipendente previsti sono: "
                        +
                        TipoCasaIndipendente.listOfConstants());

        boolean cucina = LeggiConsole.getYesNo("Inserisci Y (se include la cucina) o N (se non include la cucina): ",
                "Errore");
        boolean animaliDomestici = LeggiConsole.getYesNo(
                "Inserisci Y (se include gli animali domestici) o N (se non include gli animali domestici): ",
                "Errore");
        boolean piscina = LeggiConsole.getYesNo("Inserisci Y (se include la piscina) o N (se non include la piscina): ",
                "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneAlloggioCasaIndipendente(
                    new PrenotazioneAlloggioCasaIndipendente(codice_prenotazione, nomeCliente, tipoCasaIndipendente,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, animaliDomestici, piscina));
            System.out.println(
                    "Prenotazione registrata correttamente0!, il tuo codice prenotazione è: " + codice_prenotazione);

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
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.",
                "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno oppure il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);

        TipoStrutturaVillaggio tipoStrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio(
                "Inserisci il tipo di struttura nel villaggio che desideri inserire. I tipi di struttura nel villaggio previsti sono: "
                        +
                        TipoStrutturaVillaggio.listOfConstants() + ": ",
                "Errore! La tipologia di struttura selezionata non è valida. I tipi di struttura nel villaggio previsti sono: "
                        +
                        TipoStrutturaVillaggio.listOfConstants());

        boolean cucina = LeggiConsole
                .getYesNo("Inserisci Y (se include la cucina) o false (se non include la cucina): ", "Errore");
        boolean parcheggio = LeggiConsole
                .getYesNo("Inserisci Y (se include il parcheggio) o N (se non include il parcheggio): ", "Errore");
        boolean animaliDomestici = LeggiConsole.getYesNo(
                "Inserisci Y (se include gli animali domestici) o N (se non include gli animali domestici): ",
                "Errore");
        boolean animazione = LeggiConsole
                .getYesNo("Inserisci Y (se include l'animazione) o N (se non include l'animazione): ", "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneAlloggioVillaggio(
                    new PrenotazioneAlloggioVillaggio(codice_prenotazione, nomeCliente, tipoStrutturaVillaggio,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici, animazione));
            System.out.println(
                    "prenotazione registrata correttamente!, il tuo codice prenotazione è: " + codice_prenotazione);

        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per inserire una Prenotazione dell'aereo
     */
    public void inserisciPrenotazioneViaggioAereo() {
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        int nPasseggeri = LeggiConsole.getIntPositivo("Inserisci il numero di passeggeri: ", "Errore");
        LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il luogo di partenza: ");
        LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter(
                "Inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ",
                "La data deve essere successiva a quella di partenza o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy HH:mm", dataPartenza);
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il luogo di arrivo: ");
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: " +
                        TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: " +
                        TipoClasseMezzo.listOfConstants());

        boolean bagaglio = LeggiConsole
                .getYesNo("Inserisci Y (se include il bagaglio) o N (se non include il bagaglio): ", "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneViaggioAereo(
                    new PrenotazioneViaggioAereo(codice_prenotazione, nomeCliente, nPasseggeri, tipoClasseMezzo,
                            luogoPartenza, dataPartenza, luogoArrivo, dataArrivo, bagaglio));
            System.out.println(
                    "prenotazione registrata correttamente!, il tuo codice prenotazione è: " + codice_prenotazione);
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per inserire una Prenotazione dell'autobus
     */
    public void inserisciPrenotazioneViaggioAutobus() {

        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        int nPasseggeri = LeggiConsole.getIntPositivo("Inserisci il numero di passeggeri: ", "Errore");
        LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il luogo di partenza del cliente: ");
        LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter(
                "Inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ",
                "La data deve essere successiva a quella di partenza o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy HH:mm", dataPartenza);
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il luogo di arrivo del cliente: ");
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: " +
                        TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: " +
                        TipoClasseMezzo.listOfConstants());
        boolean finestrino = LeggiConsole
                .getYesNo("Inserisci Y (se include il finestrino) o N (se non include il finestrino): ", "Errore");
        boolean wifi = LeggiConsole.getYesNo("Inserisci Y (se include il wifi) o N (se non include il wifi): ",
                "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneViaggioAutobus(
                    new PrenotazioneViaggioAutobus(codice_prenotazione, nomeCliente, nPasseggeri,
                            tipoClasseMezzo, luogoPartenza, dataPartenza, luogoArrivo, dataArrivo, finestrino, wifi));
            System.out.println(
                    "prenotazione registrata correttamente!, il tuo codice prenotazione è: " + codice_prenotazione);

        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per inserire una Prenotazione del treno
     */
    public void inserisciPrenotazioneViaggioTreno() {

        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome del cliente: ");
        int nPasseggeri = LeggiConsole.getIntPositivo("Inserisci il numero di passeggeri: ", "Errore");
        LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il luogo di partenza del cliente: ");
        LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter(
                "Inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ",
                "La data deve essere successiva a quella di partenza o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy HH:mm", dataPartenza);
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il luogo di arrivo del cliente: ");
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: " +
                        TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: " +
                        TipoClasseMezzo.listOfConstants());
        boolean finestrino = LeggiConsole
                .getYesNo("Inserisci Y (se include il finestrino) o N (se non include il finestrino): ", "Errore");

        try {
            int codice_prenotazione = CodiceIdGenerator.generaCodiceId();
            ga.addPrenotazioneViaggioTreno(new PrenotazioneViaggioTreno(codice_prenotazione, nomeCliente, nPasseggeri,
                    tipoClasseMezzo, luogoPartenza, dataPartenza, luogoArrivo, dataArrivo, finestrino));
            System.out.println(
                    "prenotazione registrata correttamente!, il tuo codice prenotazione è: " + codice_prenotazione);

        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per eliminare una Prenotazione dell'hotel
     */
    public void eliminaPrenotazioneAlloggioHotel() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioHotel(codice);
            System.out.println("prenotazione correttamente eliminata.");
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per eliminare una Prenotazione delgli appartamenti
     */
    public void eliminaPrenotazioneAlloggioAppartamento() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");

        try {
            /// elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioAppartamento(codice);
            System.out.println("prenotazione correttamente eliminata.");
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per eliminare una Prenotazione
     */
    public void eliminaPrenotazioneAlloggioCasaIndipendente() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");

        try {
            /// elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioCasaIndipendente(codice);
            System.out.println("prenotazione correttamente eliminata.");
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per eliminare una Prenotazione del villaggio
     */
    public void eliminaPrenotazioneAlloggioVillaggio() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");

        try {
            /// elimino LA PRENOTYAZIONE
            ga.removePrenotazioneAlloggioVillaggio(codice);
            System.out.println("prenotazione correttamente eliminata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per eliminare una Prenotazione dell'aereo
     */
    public void eliminaPrenotazioneViaggioAereo() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");

        try {
            /// elimino LA PRENOTYAZIONE
            ga.removePrenotazioneViaggioAereo(codice);
            System.out.println("prenotazione correttamente eliminata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per eliminare una Prenotazione dell'autobus
     */
    public void eliminaPrenotazioneViaggioAutobus() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");

        try {
            /// elimino LA PRENOTAZIONE
            ga.removePrenotazioneViaggioAutobus(codice);
            System.out.println("prenotazione correttamente eliminata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per eliminare una Prenotazione del treno
     */
    public void eliminaPrenotazioneViaggioTreno() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da eliminare: ", "errore");

        try {
            /// elimino LA PRENOTYAZIONE
            ga.removePrenotazioneViaggioTreno(codice);
            System.out.println("prenotazione correttamente eliminata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazione dell'hotel e sostituirla con una
     * nuova
     *
     */

    public void modificaPrenotazioneAlloggioHotel() {

        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);
        TipoCamera tipoCamera = utils.LeggiConsole.getCamera(
                "Inserisci il tipo di camera che desideri inserire. I tipi di camera previsti sono: "
                        + TipoCamera.listOfConstants() + ": ",
                "Errore! La tipologia di camera selezionata non è valida. I tipi di camera previsti sono: "
                        + TipoCamera.listOfConstants());
        TipoPensione tipoPensione = utils.LeggiConsole.getTipoPensione(
                "Inserisci il tipo di pensione che desideri inserire. I tipi di pensione previsti sono: "
                        + TipoPensione.listOfConstants() + ": ",
                "Errore! La tipologia di pensione selezionata non è valida. I tipi di pensione previsti sono: "
                        + TipoPensione.listOfConstants());

        boolean wifi = LeggiConsole.getYesNo("Inserisci Y se il wifi è incluso o N se il wifi non è incluso: ",
                "Errore");
        boolean parcheggio = LeggiConsole
                .getYesNo("Inserisci Y se il parcheggio è incluso o N se il parcheggio non è incluso: ", "Errore");
        boolean balcone = LeggiConsole.getYesNo("Inserisci Y se il balcone è incluso o N se il balcone non è incluso: ",
                "Errore");

        try {
            ga.setPrenotazioneAlloggioHotel(codice,
                    new PrenotazioneAlloggioHotel(codice, nomeCliente, tipoCamera, tipoPensione,
                            dataInizioSoggiorno, dataFineSoggiorno, wifi, parcheggio, balcone));
            System.out.println("prenotazione correttamente modificata.");
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazione delgli appartamenti e sostituirla
     * con una nuova
     */
    public void modificaPrenotazioneAlloggioAppartamento() {

        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);
        TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento(
                "Inserisci il tipo di appartamento che desideri inserire. I tipi di appartamento previsti sono: "
                        + TipoAppartamento.listOfConstants() + ": ",
                "Errore! La tipologia di appartamento selezionata non è valida. I tipi di appartamento previsti sono: "
                        + TipoAppartamento.listOfConstants());

        boolean cucina = LeggiConsole.getYesNo("Inserisci Y se la cucina è inclusa o N se la cucina non è inclusa: ",
                "Errore");
        boolean parcheggio = LeggiConsole
                .getYesNo("Inserisci Y se il parcheggio è incluso o N se il parcheggio non è incluso: ", "Errore");
        boolean animaliDomestici = LeggiConsole.getYesNo(
                "Inserisci Y se l'opzione animali domestici è inclusa o N se l'opzione animali domestici non è inclusa: ",
                "Errore");

        try {
            ga.setPrenotazioneAlloggioAppartamento(codice,
                    new PrenotazioneAlloggioAppartamento(codice, nomeCliente, tipoAppartamento,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici));
            System.out.println("prenotazione correttamente modificata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazione delle case indipnedenti e
     * sostituirla con una nuova
     */
    public void modificaPrenotazioneAlloggioCasaIndipendente() {

        // Input dei parametri
        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);
        TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente(
                "Inserisci il tipo di casa indipendente che desideri inserire. I tipi di casa indipendente previsti sono: "
                        + TipoCasaIndipendente.listOfConstants() + ": ",
                "Errore! La tipologia di casa indipendente selezionata non è valida. I tipi di casa indipendente previsti sono: "
                        + TipoCasaIndipendente.listOfConstants());

        boolean cucina = LeggiConsole.getYesNo("Inserisci Y se la cucina è inclusa o N se la cucina non è inclusa: ",
                "Errore");
        boolean animaliDomestici = LeggiConsole.getYesNo(
                "Inserisci Y se l'opzione animali domestici è inclusa o N se l'opzione animali domestici non è inclusa: ",
                "Errore");
        boolean piscina = LeggiConsole.getYesNo("Inserisci Y se la piscina è inclusa o N se la piscina non è inclusa: ",
                "Errore");

        try {
            ga.setPrenotazioneAlloggioCasaIndipendente(codice,
                    new PrenotazioneAlloggioCasaIndipendente(codice, nomeCliente, tipoCasaIndipendente,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, animaliDomestici, piscina));
            System.out.println("prenotazione correttamente modificata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazione del villaggio e sostituirla con una
     * nuova
     */
    public void modificaPrenotazioneAlloggioVillaggio() {

        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        LocalDate dataInizioSoggiorno = LeggiConsole.getLocalDate(
                "Inserisci la data iniziale (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");
        LocalDate dataFineSoggiorno = LeggiConsole.getLocalDateAfter(
                "Inserisci la data finale (in formato dd-MM-yyyy): ",
                "La data deve essere successiva a quella di inizio soggiorno o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy", dataInizioSoggiorno);
        TipoStrutturaVillaggio tipoSrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio(
                "Inserisci il tipo di struttura nel villaggio che desideri inserire. I tipi di struttura nel villaggio previsti sono: "
                        + TipoStrutturaVillaggio.listOfConstants() + ": ",
                "Errore! La tipologia di struttura selezionata non è valida. I tipi di struttura nel villaggio previsti sono: "
                        + TipoStrutturaVillaggio.listOfConstants());

        boolean cucina = LeggiConsole.getYesNo("Inserisci Y se la cucina è inclusa o N se la cucina non è inclusa: ",
                "Errore");
        boolean parcheggio = LeggiConsole.getYesNo(
                "Inserisci Y se il parcheggio è incluso o N se il parcheggio non è incluso: ", "Errore");
        boolean animaliDomestici = LeggiConsole.getYesNo(
                "Inserisci Y se l'opzione animali domestici è inclusa o N se l'opzione animali domestici non è inclusa: ",
                "Errore");
        boolean animazione = LeggiConsole.getYesNo(
                "Inserisci Y se l'animazione è inclusa o N se l'animazione non è inclusa: ", "Errore");

        try {
            ga.setPrenotazioneAlloggioVillaggio(codice,
                    new PrenotazioneAlloggioVillaggio(codice, nomeCliente, tipoSrutturaVillaggio,
                            dataInizioSoggiorno, dataFineSoggiorno, cucina, parcheggio, animaliDomestici,
                            animazione));
            System.out.println("prenotazione correttamente modificata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazione dell'aereo e sostituirla con una
     * nuova
     */
    public void modificaPrenotazioneViaggioAereo() {

        // Input dei parametri
        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        int nPasseggeri = LeggiConsole.getIntPositivo("Inserisci il numero di passeggeri: ", "Errore");
        LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        String LuogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il LuogoPartenza del cliente: ");
        LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter(
                "Inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ",
                "La data deve essere successiva a quella di partenza o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy HH:mm", dataPartenza);
        String LuogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il LuogoArrivo del cliente: ");
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants());
        boolean bagaglio = LeggiConsole
                .getYesNo("Inserisci Y se il bagaglio è incluso o N se il bagaglio non è incluso: ", "Errore");

        try {
            ga.setPrenotazioneViaggioAereo(codice, new PrenotazioneViaggioAereo(codice, nomeCliente, nPasseggeri,
                    tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo, bagaglio));
            System.out.println("prenotazione correttamente modificata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per modificare una Prenotazione dell'autobus e sostituirla con una
     * nuova
     */
    public void modificaPrenotazioneViaggioAutobus() {

        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        int nPasseggeri = LeggiConsole.getIntPositivo("Inserisci il numero di passeggeri: ", "Errore");
        LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        String LuogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il LuogoPartenza del cliente: ");

        LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter(
                "Inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ",
                "La data deve essere successiva a quella di partenza o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy HH:mm", dataPartenza);
        String LuogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il LuogoArrivo del cliente: ");
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants());
        boolean finestrino = LeggiConsole.getYesNo(
                "Inserisci Y se il finestrino è incluso o N se il finestrino non è incluso", "Errore");
        boolean wifi = LeggiConsole
                .getYesNo("Inserisci Y se il wifi è incluso o N se il wifi non è incluso", "Errore");

        try {
            ga.setPrenotazioneViaggioAutobus(codice, new PrenotazioneViaggioAutobus(codice, nomeCliente, nPasseggeri,
                    tipoClasseMezzo, LuogoPartenza, dataPartenza, LuogoArrivo, dataArrivo, finestrino, wifi));
            System.out.println("prenotazione correttamente modificata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per modificare una Prenotazione del treno e sostituirla con una
     * nuova
     */
    public void modificaPrenotazioneViaggioTreno() {

        int codice = LeggiConsole.getIntPositivo("Inserisci il codice della prenotazione da eliminare: ", "Errore");
        String nomeCliente = LeggiConsole.getStringNonVuota("Inserisci il nome cliente della nuova prenotazione: ");
        int nPasseggeri = LeggiConsole.getIntPositivo("Inserisci il numero di passeggeri: ", "Errore");
        LocalDateTime dataPartenza = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");
        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il luogo di partenza del cliente: ");
        LocalDateTime dataArrivo = LeggiConsole.getLocalDateTimeAfter(
                "Inserisci la data di arrivo nel formato (dd-MM-yyyy HH:mm): ",
                "La data deve essere successiva a quella di partenza o il formato inserito non è corretto, reinserisci.",
                "dd-MM-yyyy HH:mm", dataPartenza);
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il luogo di arrivo del cliente: ");
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants());
        boolean finestrino = LeggiConsole.getYesNo(
                "Inserisci Y se il finestrino è incluso o N se il finestrino non è incluso", "Errore");

        try {
            ga.setPrenotazioneViaggioTreno(codice, new PrenotazioneViaggioTreno(codice, nomeCliente, nPasseggeri,
                    tipoClasseMezzo, luogoPartenza, dataPartenza, luogoArrivo, dataArrivo, finestrino));
            System.out.println("prenotazione correttamente modificata.");

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per ricercare una Prenotazione dell'hotel
     */
    public void ricercaPrenotazioneAlloggioHotel() {
        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneAlloggioHotel(codice));
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per ricercare una Prenotazione delgli appartamenti
     */
    public void ricercaPrenotazioneAlloggioAppartamento() {
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneAlloggioAppartamento(codice));
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * funzione per ricercare una Prenotazione delle case indipnedenti
     */
    public void ricercaPrenotazioneAlloggioCasaIndipendente() {

        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneAlloggioCasaIndipendente(codice));
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per ricercare una Prenotazione del villaggio
     */
    public void ricercaPrenotazioneAlloggioVillaggio() {

        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneAlloggioVillaggio(codice));
        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per ricercare una Prenotazione dell'aereo
     */
    public void ricercaPrenotazioneViaggioAereo() {

        // input dei parametri
        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneViaggioAereo(codice));

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per ricercare una Prenotazione dell'autobus
     */
    public void ricercaPrenotazioneViaggioAutobus() {

        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneViaggioAutobus(codice));

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
            Logger.getLogger(TestAgenzia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * funzione per ricercare una Prenotazione del treno
     */
    public void ricercaPrenotazioneViaggioTreno() {

        int codice = LeggiConsole.getIntPositivo("inserisci il codice della prenotazione da ricercare: ", "errore");
        try {
            /// elimino LA PRENOTYAZIONE
            System.out.println(ga.getPrenotazioneViaggioTreno(codice));

        } catch (PrenotazioneNonTrovata pnt) {
            System.err.println("prentazione non trovata");
        } catch (Exception ex) {
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
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaHotel() throws IOException {
        TipoCamera tipoCamera = utils.LeggiConsole.getCamera(
                "Inserisci il tipo di camera che desideri inserire. I tipi di camera previsti sono: "
                        + TipoCamera.listOfConstants() + ": ",
                "Errore! La tipologia di camera selezionata non è valida. I tipi di camera previsti sono: "
                        + TipoCamera.listOfConstants());
        LocalDate data = LeggiConsole.getLocalDate(
                "Inserisci la data in cui verificare la disponibilità (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");

        if (ga.verificaDisponibilitaHotel(tipoCamera, data)) {
            System.out.println("La camera " + tipoCamera + " risulta disponibile il " + data);
        } else {
            System.out.println("La camera " + tipoCamera + " NON risulta disponibile il " + data);
        }

    }

    /**
     * funzione per verificare la disponibilità del tipo di appartamento
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaAppartamento() throws IOException {
        TipoAppartamento tipoAppartamento = utils.LeggiConsole.getTipoAppartamento(
                "Inserisci il tipo di appartamento che desideri inserire. I tipi di appartamento previsti sono: "
                        + TipoAppartamento.listOfConstants() + ": ",
                "Errore! La tipologia di appartamento selezionata non è valida. I tipi di appartamento previsti sono: "
                        + TipoAppartamento.listOfConstants());

        LocalDate data = LeggiConsole.getLocalDate(
                "Inserisci la data in cui verificare la disponibilità (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");

        if (ga.verificaDisponibilitaAppartamento(tipoAppartamento, data)) {
            System.out.println("L'appartamento " + tipoAppartamento + " risulta disponibile il " + data);
        } else {
            System.out.println("L'appartamento " + tipoAppartamento + " NON risulta disponibile il " + data);
        }

    }

    /**
     * funzione per verificare la disponibilità del tipo di casa indipendente
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaCasaIndipendente() throws IOException {
        TipoCasaIndipendente tipoCasaIndipendente = utils.LeggiConsole.getTipoCasaIndipendente(
                "Inserisci il tipo di casa indipendente che desideri inserire. I tipi di casa indipendente previsti sono: "
                        + TipoCasaIndipendente.listOfConstants() + ": ",
                "Errore! La tipologia di casa indipendente selezionata non è valida. I tipi di casa indipendente previsti sono: "
                        + TipoCasaIndipendente.listOfConstants());

        LocalDate data = LeggiConsole.getLocalDate(
                "Inserisci la data in cui verificare la disponibilità (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");

        if (ga.verificaDisponibilitaCasaIndipendente(tipoCasaIndipendente, data)) {
            System.out.println("La casa indipendente " + tipoCasaIndipendente + " risulta disponibile il " + data);
        } else {
            System.out.println("La casa indipendente " + tipoCasaIndipendente + " NON risulta disponibile il " + data);
        }

    }

    /**
     * funzione per verificare la disponibilità del tipo di struttura del villaggio
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaStrutturaVillaggio() throws IOException {
        TipoStrutturaVillaggio tipoStrutturaVillaggio = utils.LeggiConsole.getTipoStrutturaVillaggio(
                "Inserisci il tipo di struttura nel villaggio che desideri inserire. I tipi di struttura nel villaggio previsti sono: "
                        + TipoStrutturaVillaggio.listOfConstants() + ": ",
                "Errore! La tipologia di struttura selezionata non è valida. I tipi di struttura nel villaggio previsti sono: "
                        + TipoStrutturaVillaggio.listOfConstants());

        LocalDate data = LeggiConsole.getLocalDate(
                "Inserisci la data in cui verificare la disponibilità (in formato dd-MM-yyyy): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy");

        if (ga.verificaDisponibilitaStrutturaVillaggio(tipoStrutturaVillaggio, data)) {
            System.out.println("La struttura " + tipoStrutturaVillaggio + " risulta disponibile il " + data);
        } else {
            System.out.println("La struttura " + tipoStrutturaVillaggio + " NON risulta disponibile il " + data);
        }

    }

    /**
     * funzione per verificare la disponibilità di posti nel tipo di classe
     * dell'aereo
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaAereo() throws IOException {
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants());

        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il luogo di partenza: ");
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il luogo di arrivo: ");
        LocalDateTime data = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");

        if (ga.verificaDisponibilitaAereo(tipoClasseMezzo, data, luogoPartenza, luogoArrivo)) {
            System.out.println("La classe " + tipoClasseMezzo + " risulta disponibile il " + data
                    + " per il viaggio da " + luogoPartenza + " a " + luogoArrivo);
        } else {
            System.out.println("La classe " + tipoClasseMezzo + " NON risulta disponibile il " + data
                    + " per il viaggio da " + luogoPartenza + " a " + luogoArrivo);
        }

    }

    /**
     * funzione per verificare la disponibilità di posti nel tipo di classe del
     * treno
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaTreno() throws IOException {
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants());

        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il LuogoPartenza: ");
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il LuogoArrivo: ");
        LocalDateTime data = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");

        if (ga.verificaDisponibilitaTreno(tipoClasseMezzo, data, luogoPartenza, luogoArrivo)) {
            System.out.println("La classe " + tipoClasseMezzo + " risulta disponibile il " + data
                    + " per il viaggio da " + luogoPartenza + " a " + luogoArrivo);
        } else {
            System.out.println("La classe " + tipoClasseMezzo + " NON risulta disponibile il " + data
                    + " per il viaggio da " + luogoPartenza + " a " + luogoArrivo);
        }

    }

    /**
     * funzione per verificare la disponibilità di posti nel tipo di classe
     * dell'autobus
     * 
     * @throws IOException
     */
    public void verificaDisponibilitaAutobus() throws IOException {
        TipoClasseMezzo tipoClasseMezzo = utils.LeggiConsole.getTipoClasseMezzo(
                "Inserisci la classe del mezzo che desideri inserire. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants() + ": ",
                "Errore! La tipologia di classe selezionata non è valida. I tipi di classe previsti sono: "
                        + TipoClasseMezzo.listOfConstants());

        String luogoPartenza = LeggiConsole.getStringNonVuota("Inserisci il LuogoPartenza: ");
        String luogoArrivo = LeggiConsole.getStringNonVuota("Inserisci il LuogoArrivo: ");
        LocalDateTime data = LeggiConsole.getLocalDateTime(
                "Inserisci la data di partenza nel formato (dd-MM-yyyy HH:mm): ",
                "Il formato non è corretto, reinserisci.", "dd-MM-yyyy HH:mm");

        if (ga.verificaDisponibilitaAutobus(tipoClasseMezzo, data, luogoPartenza, luogoArrivo)) {
            System.out.println("La classe " + tipoClasseMezzo + " risulta disponibile il " + data
                    + " per il viaggio da " + luogoPartenza + " a " + luogoArrivo);
        } else {
            System.out.println("La classe " + tipoClasseMezzo + " NON risulta disponibile il " + data
                    + " per il viaggio da " + luogoPartenza + " a " + luogoArrivo);
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
     * 
     * @throws IOException
     */

    public void sortPrenotazioniAppartamenti() throws IOException {
        ga.sortPrenotazioniAppartamenti();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per mettere in ordine le prenotazioni delle case indipendenti
     * 
     * @throws IOException
     */
    public void sortPrenotazioniCaseIndipendenti() throws IOException {
        ga.sortPrenotazioniCaseIndipendenti();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per mettere in ordine le prenotazioni delle strutture del villaggio
     * 
     * @throws IOException
     */
    public void sortPrenotazioniStruttureVillaggio() throws IOException {
        ga.sortPrenotazioniStruttureVillaggio();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per mettere in ordine le prenotazioni dell'aereo
     * 
     * @throws IOException
     */
    public void sortPrenotazioniAereo() throws IOException {
        ga.sortPrenotazioniAereo();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per mettere in ordine le prenotazioni dell'autobus
     * 
     * @throws IOException
     */
    public void sortPrenotazioniAutobus() throws IOException {
        ga.sortPrenotazioniAutobus();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per mettere in ordine le prenotazioni del treno
     * 
     * @throws IOException
     */
    public void sortPrenotazioniTreno() throws IOException {
        ga.sortPrenotazioniTreno();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per mettere in ordine tutte le prenotazioni dell'agenzia
     * 
     * @throws IOException
     */
    public void sortPrenotazioniAgenzia() throws IOException {
        ga.sortPrenotazioniAgenzia();
        System.out.println("ordinamento effettuato correttamente.");

    }

    /**
     * funzione per calcolare l'incasso annuale totale dell'hotel
     */
    public void calcolaIncassoAnnualeTotaleHotel() {
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");

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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");

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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
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
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");
        try {
            System.out.println("incasso totale: " + ga.calcolaIncassoAnnualeTotaleAlloggi(anno) + "€");

        } catch (IOException ex) {
            System.out.println("errore in lettura/scrittura su file");
            System.out.println(ex);
        }

    }

    /**
     * funzione per trovare la massima fonte di guadagno annuale
     * 
     * @throws IOException
     */
    public void TrovaFonteMaxGuadagnoAnnuale() throws IOException {
        int anno = LeggiConsole.getIntPositivo("inserisci l'anno desiderato: ",
                "errore, l'anno deve essere positivo, reinserici!");

        System.out.println(ga.TrovaFonteMaxGuadagnoAnnuale(anno));
    }
}
