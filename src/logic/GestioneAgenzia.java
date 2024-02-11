/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.IOObjectPrenotazioneAlloggioAppartamento;
import data.IOObjectPrenotazioneAlloggioCasaIndipendente;
import data.IOObjectPrenotazioneAlloggioHotel;
import data.IOObjectPrenotazioneAlloggioVillaggio;
import data.IOObjectPrenotazioneViaggioAereo;
import data.IOObjectPrenotazioneViaggioAutobus;
import data.IOObjectPrenotazioneViaggioTreno;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.ArrayList;
import java.util.Collections;
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
import model.TipoStrutturaVillaggio;
import myExceptions.*;

/**
 *
 * @author jessi
 */
public class GestioneAgenzia {

    private final int N_MONOLOCALE;
    private final int N_BILOCALE;
    private final int N_TRILOCALE;
    private final int N_QUADRILOCALE;

    private final int N_SINGOLE;
    private final int N_DOPPIE;
    private final int N_TRIPLE;
    private final int N_QUADRUPLE;

    private final int N_UNIFAMILIARE;
    private final int N_BIFAMILIARE;
    private final int N_A_SCHIERA;

    private final int N_CAMPER;
    private final int N_ROULOTTE;
    private final int N_BUNGALOW;
    private final int N_TENDA;

    private final int N_FIRST;
    private final int N_BUSINESS;
    private final int N_ECONOMY;

    // in questo caso non servono nè la variabile che fissa la dimensione
    // dell'array(N)
    // nè quella che tiene conto del numero di oggetti presenti nell'array (n)
    private IOObjectPrenotazioneAlloggioAppartamento ioPAAppartamento;
    private IOObjectPrenotazioneAlloggioCasaIndipendente ioPACasaIndipendente;
    private IOObjectPrenotazioneAlloggioHotel ioPAHotel;
    private IOObjectPrenotazioneAlloggioVillaggio ioPAVillaggio;
    private IOObjectPrenotazioneViaggioAereo ioPVAereo;
    private IOObjectPrenotazioneViaggioAutobus ioPVAutobus;
    private IOObjectPrenotazioneViaggioTreno ioPVTreno;

    public GestioneAgenzia(String nomeAgenzia, String separator) throws IOException {
        String fileAppartamenti = nomeAgenzia + "_prenotazioniAppartamenti.txt";
        String fileCaseIndipendenti = nomeAgenzia + "_prenotazioniCaseIndipendenti.txt";
        String fileHotel = nomeAgenzia + "_prenotazioniHotel.txt";
        String fileStruttureVillaggio = nomeAgenzia + "_prenotazioniStruttureVillaggio.txt";
        String fileTreno = nomeAgenzia + "_prenotazioniTreno.txt";
        String fileAutobus = nomeAgenzia + "_prenotazioniAutobus.txt";
        String fileAereo = nomeAgenzia + "_prenotazioniAereo.txt";

        ioPAAppartamento = new IOObjectPrenotazioneAlloggioAppartamento(fileAppartamenti, separator);
        ioPACasaIndipendente = new IOObjectPrenotazioneAlloggioCasaIndipendente(fileCaseIndipendenti, separator);
        ioPAHotel = new IOObjectPrenotazioneAlloggioHotel(fileHotel, separator);
        ioPAVillaggio = new IOObjectPrenotazioneAlloggioVillaggio(fileStruttureVillaggio, separator);
        ioPVAereo = new IOObjectPrenotazioneViaggioAereo(fileAereo, separator);
        ioPVAutobus = new IOObjectPrenotazioneViaggioAutobus(fileAutobus, separator);
        ioPVTreno = new IOObjectPrenotazioneViaggioTreno(fileTreno, separator);

        N_MONOLOCALE = 20;
        N_BILOCALE = 10;
        N_TRILOCALE = 10;
        N_QUADRILOCALE = 10;

        N_SINGOLE = 10;
        N_DOPPIE = 10;
        N_TRIPLE = 5;
        N_QUADRUPLE = 5;

        N_UNIFAMILIARE = 10;
        N_BIFAMILIARE = 10;
        N_A_SCHIERA = 10;

        N_CAMPER = 10;
        N_ROULOTTE = 10;
        N_BUNGALOW = 6;
        N_TENDA = 10;

        N_FIRST = 2;
        N_BUSINESS = 5;
        N_ECONOMY = 10;
    }

    public GestioneAgenzia(String nomeAgenzia, String separator, int nMonolocali, int nBilocali, int nTrilocali,
            int nQuadrilocali, int nSingole, int nDoppie,
            int nTriple, int nQuadruple, int nUnifamiliari, int nBifamiliari, int nASchiera, int nCamper, int nRoulotte,
            int nBungalow, int nTende, int nFirst, int nBusiness, int nEconomy) throws IOException {

        String fileName = nomeAgenzia + "_prenotazioni.txt";
        ioPAAppartamento = new IOObjectPrenotazioneAlloggioAppartamento(fileName, separator);
        ioPACasaIndipendente = new IOObjectPrenotazioneAlloggioCasaIndipendente(fileName, separator);
        ioPAHotel = new IOObjectPrenotazioneAlloggioHotel(fileName, separator);
        ioPAVillaggio = new IOObjectPrenotazioneAlloggioVillaggio(fileName, separator);
        ioPVAereo = new IOObjectPrenotazioneViaggioAereo(fileName, separator);
        ioPVAutobus = new IOObjectPrenotazioneViaggioAutobus(fileName, separator);
        ioPVTreno = new IOObjectPrenotazioneViaggioTreno(fileName, separator);

        N_MONOLOCALE = nMonolocali;
        N_BILOCALE = nBilocali;
        N_TRILOCALE = nTrilocali;
        N_QUADRILOCALE = nQuadrilocali;

        N_SINGOLE = nSingole;
        N_DOPPIE = nDoppie;
        N_TRIPLE = nTriple;
        N_QUADRUPLE = nQuadruple;

        N_UNIFAMILIARE = nUnifamiliari;
        N_BIFAMILIARE = nBifamiliari;
        N_A_SCHIERA = nASchiera;

        N_CAMPER = nCamper;
        N_ROULOTTE = nRoulotte;
        N_BUNGALOW = nBungalow;
        N_TENDA = nTende;

        N_FIRST = nFirst;
        N_BUSINESS = nBusiness;
        N_ECONOMY = nEconomy;
    }

    /**
     * metodo che restituisce il numero di camere dell'albergo del tipo dato in
     * input
     *
     * @param camera tipo di camera
     * @return il numero di camere del tipo dato presenti nell'albergo di cui
     *         dispone l'agenzia
     */
    public int getNCamere(TipoCamera camera) {
        int n = 0;
        switch (camera) {
            case SINGOLA:
                n = N_SINGOLE;
                break;
            case DOPPIA:
                n = N_DOPPIE;
                break;
            case TRIPLA:
                n = N_TRIPLE;
                break;
            case QUADRUPLA:
                n = N_QUADRUPLE;
                break;
        }
        return n;
    }

    /**
     * metodo che restituisce il numero di appartamenti dell'agenzia del tipo dato
     * in input
     *
     * @param appartamento tipo di appartamento
     * @return il numero di appartamenti del tipo dato presenti di cui dispone
     *         l'agenzia
     */
    public int getNAppartamenti(TipoAppartamento appartamento) {
        int n = 0;
        switch (appartamento) {
            case MONOLOCALE:
                n = N_MONOLOCALE;
                break;
            case BILOCALE:
                n = N_BILOCALE;
                break;
            case TRILOCALE:
                n = N_TRILOCALE;
                break;
            case QUADRILOCALE:
                n = N_QUADRILOCALE;
                break;
        }
        return n;
    }

    /**
     * metodo che restituisce il numero di strutture presenti nel villaggio
     * dell'agenzia del tipo
     * dato in input
     *
     * @param strutturaVillaggio tipo di struttura nel villaggio
     * @return il numero di strutture presenti nel villaggio del tipo dato di cui
     *         dispone l'agenzia
     */
    public int getNStruttureVillaggio(TipoStrutturaVillaggio strutturaVillaggio) {
        int n = 0;
        switch (strutturaVillaggio) {
            case CAMPER:
                n = N_CAMPER;
                break;
            case ROULOTTE:
                n = N_ROULOTTE;
                break;
            case BUNGALOW:
                n = N_BUNGALOW;
                break;
            case TENDA:
                n = N_TENDA;
                break;
        }
        return n;
    }

    /**
     * metodo che restituisce il numero di case indipendenti dell'albergo del tipo
     * dato in input
     *
     * @param casaIndipendente tipo di casa indipendente
     * @return il numero di case indipendenti del tipo dato presenti di cui dispone
     *         l'agenzia
     */
    public int getNCaseIndipendenti(TipoCasaIndipendente casaIndipendente) {
        int n = 0;
        switch (casaIndipendente) {
            case UNIFAMILIARE:
                n = N_UNIFAMILIARE;
                break;
            case BIFAMILIARE:
                n = N_BIFAMILIARE;
                break;
            case A_SCHIERA:
                n = N_A_SCHIERA;
                break;
        }
        return n;
    }

    /**
     * metodo che restituisce il numero di posti del tipo di classe dato in input
     * presenti nel
     * mezzo di trasporto(che può essere treno, autobus o aereo)
     *
     * @param classeMezzo tipo di classe
     * @return il numero di posti presenti nel mezzo di trasporto(che può essere
     *         treno, autobus o
     *         aereo) di cui dispone l'agenzia del tipo dato
     */
    public int getNClasseMezzi(TipoClasseMezzo classeMezzo) {
        int n = 0;
        switch (classeMezzo) {
            case FIRST:
                n = N_FIRST;
                break;
            case BUSINESS:
                n = N_BUSINESS;
                break;
            case ECONOMY:
                n = N_ECONOMY;
                break;
        }
        return n;
    }

    /**
     * metodo che verifica la disponibilità del tipo di camera dell'albergo, preso
     * in input, nella data
     * selezionata
     * 
     * @param tipoCamera tipo di camera
     * @param data       data in cui verificare la disponibilità
     * @return true se il tipo di camera preso in input in quella data è disponibile
     *         o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaHotel(TipoCamera tipoCamera, LocalDate data) throws IOException {
        int camereOccupate = 0;
        ArrayList<PrenotazioneAlloggioHotel> prenotazioniAlloggioHotel = ioPAHotel.loadData();
        for (int i = 0; i < prenotazioniAlloggioHotel.size(); i++) {
            if ((prenotazioniAlloggioHotel.get(i).getDataInizioSoggiorno().isBefore(data)
                    || prenotazioniAlloggioHotel.get(i).getDataInizioSoggiorno().equals(data))
                    && prenotazioniAlloggioHotel.get(i).getDataFineSoggiorno().isAfter(data)
                    && prenotazioniAlloggioHotel.get(i).getTipoCamera() == tipoCamera) {
                camereOccupate++;
            }
        }
        return camereOccupate < getNCamere(tipoCamera);
    }

    /**
     * metodo che verifica la disponibilità del tipo di appartamento, preso in
     * input, nella data
     * selezionata
     * 
     * @param tipoAppartamento tipo di appartamento
     * @param data             data in cui verificare la disponibilità
     * @return true se il tipo di appartamento preso in input in quella data è
     *         disponibile o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaAppartamento(TipoAppartamento tipoAppartamento, LocalDate data)
            throws IOException {
        int appartamentiOccupati = 0;
        ArrayList<PrenotazioneAlloggioAppartamento> prenotazioniAlloggioAppartamento = ioPAAppartamento.loadData();
        for (int i = 0; i < prenotazioniAlloggioAppartamento.size(); i++) {
            if ((prenotazioniAlloggioAppartamento.get(i).getDataInizioSoggiorno().isBefore(data)
                    || prenotazioniAlloggioAppartamento.get(i).getDataInizioSoggiorno().equals(data))
                    && prenotazioniAlloggioAppartamento.get(i).getDataFineSoggiorno().isAfter(data)
                    && prenotazioniAlloggioAppartamento.get(i).getTipoAppartamento() == tipoAppartamento) {
                appartamentiOccupati++;
            }
        }
        return appartamentiOccupati < getNAppartamenti(tipoAppartamento);
    }

    /**
     * metodo che verifica la disponibilità del tipo di casa indipendente, preso in
     * input, nella data
     * selezionata
     * 
     * @param tipoCasaIndipendente tipo di casa indipendente
     * @param data                 data in cui verificare la disponibilità
     * @return true se il tipo di casa indipendente preso in input in quella data è
     *         disponibile o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaCasaIndipendente(TipoCasaIndipendente tipoCasaIndipendente, LocalDate data)
            throws IOException {
        int caseIndipendentiOccupate = 0;
        ArrayList<PrenotazioneAlloggioCasaIndipendente> prenotazioniAlloggioCasaIndipendente = ioPACasaIndipendente
                .loadData();
        for (int i = 0; i < prenotazioniAlloggioCasaIndipendente.size(); i++) {
            if ((prenotazioniAlloggioCasaIndipendente.get(i).getDataInizioSoggiorno().isBefore(data)
                    || prenotazioniAlloggioCasaIndipendente.get(i).getDataInizioSoggiorno().equals(data))
                    && prenotazioniAlloggioCasaIndipendente.get(i).getDataFineSoggiorno().isAfter(data)
                    && prenotazioniAlloggioCasaIndipendente.get(i).getTipoCasaIndipendente() == tipoCasaIndipendente) {
                caseIndipendentiOccupate++;
            }
        }
        return caseIndipendentiOccupate < getNCaseIndipendenti(tipoCasaIndipendente);
    }

    /**
     * metodo che verifica la disponibilità del tipo di struttura nel villaggio,
     * preso in input, nella
     * data selezionata
     * 
     * @param tipoStrutturaVillaggio tipo di struttura nel villaggio
     * @param data                   data in cui verificare la disponibilità
     * @return true se il tipo di struttura nel villaggio preso in input in quella
     *         data è disponibile
     *         o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaStrutturaVillaggio(TipoStrutturaVillaggio tipoStrutturaVillaggio,
            LocalDate data) throws IOException {
        int struttureVillaggioOccupate = 0;
        ArrayList<PrenotazioneAlloggioVillaggio> prenotazioniAlloggioVillaggio = ioPAVillaggio.loadData();
        for (int i = 0; i < prenotazioniAlloggioVillaggio.size(); i++) {
            if ((prenotazioniAlloggioVillaggio.get(i).getDataInizioSoggiorno().isBefore(data)
                    || prenotazioniAlloggioVillaggio.get(i).getDataInizioSoggiorno().equals(data))
                    && prenotazioniAlloggioVillaggio.get(i).getDataFineSoggiorno().isAfter(data)
                    && prenotazioniAlloggioVillaggio.get(i).getTipoStrutturaVillaggio() == tipoStrutturaVillaggio) {
                struttureVillaggioOccupate++;
            }
        }
        return struttureVillaggioOccupate < getNStruttureVillaggio(tipoStrutturaVillaggio);
    }

    /**
     * metodo che verifica la disponibilità di posti disponibili del tipo di classe
     * dell'aereo
     * nella data selezionata
     * 
     * @param tipoClasseMezzo tipo di classe del mezzo
     * @param data            data in cui verificare la disponibilità
     * @param luogoPartenza   luogo di partenza
     * @param luogoArrivo     luogo di arrivo
     * @return true se ci sono posti del tipo di classe preso in input in quella
     *         data è disponibile
     *         o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaAereo(TipoClasseMezzo tipoClasseMezzo, LocalDateTime data, String luogoPartenza,
            String luogoArrivo) throws IOException {
        int postiClasseOccupati = 0;
        ArrayList<PrenotazioneViaggioAereo> prenotazioniViaggioAereo = ioPVAereo.loadData();
        for (int i = 0; i < prenotazioniViaggioAereo.size(); i++) {
            if ((prenotazioniViaggioAereo.get(i).getDataPartenza().isBefore(data)
                    || prenotazioniViaggioAereo.get(i).getDataPartenza().equals(data))
                    && prenotazioniViaggioAereo.get(i).getDataArrivo().isAfter(data)
                    && prenotazioniViaggioAereo.get(i).getLuogoPartenza().equals(luogoPartenza)
                    && prenotazioniViaggioAereo.get(i).getLuogoArrivo().equals(luogoArrivo)
                    && prenotazioniViaggioAereo.get(i).getTipoClasseMezzo() == tipoClasseMezzo) {
                postiClasseOccupati++;
            }
        }
        return postiClasseOccupati < getNClasseMezzi(tipoClasseMezzo);
    }

    /**
     * metodo che verifica la disponibilità di posti disponibili del tipo di classe
     * del treno
     * nella data selezionata
     * 
     * @param tipoClasseMezzo tipo di classe del mezzo
     * @param data            data in cui verificare la disponibilità
     * @param luogoPartenza   luogo di partenza
     * @param luogoArrivo     luogo di arrivo
     * @return true se ci sono posti del tipo di classe preso in input in quella
     *         data è disponibile
     *         o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaTreno(TipoClasseMezzo tipoClasseMezzo, LocalDateTime data, String luogoPartenza,
            String luogoArrivo) throws IOException {
        int postiClasseOccupati = 0;
        ArrayList<PrenotazioneViaggioTreno> prenotazioniViaggioTreno = ioPVTreno.loadData();
        for (int i = 0; i < prenotazioniViaggioTreno.size(); i++) {
            if ((prenotazioniViaggioTreno.get(i).getDataPartenza().isBefore(data)
                    || prenotazioniViaggioTreno.get(i).getDataPartenza().equals(data))
                    && prenotazioniViaggioTreno.get(i).getDataArrivo().isAfter(data)
                    && prenotazioniViaggioTreno.get(i).getLuogoPartenza().equals(luogoPartenza)
                    && prenotazioniViaggioTreno.get(i).getLuogoArrivo().equals(luogoArrivo)
                    && prenotazioniViaggioTreno.get(i).getTipoClasseMezzo() == tipoClasseMezzo) {
                postiClasseOccupati++;
            }
        }
        return postiClasseOccupati < getNClasseMezzi(tipoClasseMezzo);
    }

    /**
     * metodo che verifica la disponibilità di posti disponibili del tipo di classe
     * dell'autobus
     * nella data selezionata
     * 
     * @param tipoClasseMezzo tipo di classe del mezzo
     * @param data            data in cui verificare la disponibilità
     * @param luogoPartenza   luogo di partenza
     * @param luogoArrivo     luogo di arrivo
     * @return true se ci sono posti del tipo di classe preso in input in quella
     *         data è disponibile
     *         o false se non lo è
     * @throws IOException
     */
    public boolean verificaDisponibilitaAutobus(TipoClasseMezzo tipoClasseMezzo, LocalDateTime data,
            String luogoPartenza, String luogoArrivo) throws IOException {
        int postiClasseOccupati = 0;
        ArrayList<PrenotazioneViaggioAutobus> prenotazioniViaggioAutobus = ioPVAutobus.loadData();
        for (int i = 0; i < prenotazioniViaggioAutobus.size(); i++) {
            if ((prenotazioniViaggioAutobus.get(i).getDataPartenza().isBefore(data)
                    || prenotazioniViaggioAutobus.get(i).getDataPartenza().equals(data))
                    && prenotazioniViaggioAutobus.get(i).getDataArrivo().isAfter(data)
                    && prenotazioniViaggioAutobus.get(i).getLuogoPartenza().equals(luogoPartenza)
                    && prenotazioniViaggioAutobus.get(i).getLuogoArrivo().equals(luogoArrivo)
                    && prenotazioniViaggioAutobus.get(i).getTipoClasseMezzo() == tipoClasseMezzo) {
                postiClasseOccupati++;
            }
        }
        return postiClasseOccupati < getNClasseMezzi(tipoClasseMezzo);
    }

    /**
     * metodo ADD che aggiunge una prenotazione all'albergo come copia dell'oggetto
     * fornito
     *
     * @param pH oggetto prenotazione camera d'hotel da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneAlloggioHotel(PrenotazioneAlloggioHotel pH)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneAlloggioHotel> prenotazioniAlloggioHotel = ioPAHotel.loadData();
        // verifico che le date siano in ordine cronologico corretto
        if (pH.getDataInizioSoggiorno().isAfter(pH.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pH.getDataInizioSoggiorno(), pH.getDataFineSoggiorno());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniAlloggioHotel.contains(pH)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutte le giornate della prenotazione ci sia una camera
        // disponibile
        int giorni_prenotazione = (int) DAYS.between(pH.getDataInizioSoggiorno(), pH.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaHotel(pH.getTipoCamera(), pH.getDataInizioSoggiorno().plusDays(g))) {
                throw new CameraNonDisponibile(pH.getTipoCamera());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniAlloggioHotel.add(pH.clone());
        ioPAHotel.saveData(prenotazioniAlloggioHotel);
    }

    /**
     * metodo ADD che aggiunge una prenotazione all'appartamento come copia
     * dell'oggetto fornito
     *
     * @param pA oggetto prenotazione appartamento da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneAlloggioAppartamento(PrenotazioneAlloggioAppartamento pA)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneAlloggioAppartamento> prenotazioniAlloggioAppartamento = ioPAAppartamento.loadData();
        // verifico che le date siano in ordine cronologico corretto
        if (pA.getDataInizioSoggiorno().isAfter(pA.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pA.getDataInizioSoggiorno(), pA.getDataFineSoggiorno());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniAlloggioAppartamento.contains(pA)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutte le giornate della prenotazione ci sia un appartamento
        // disponibile
        int giorni_prenotazione = (int) DAYS.between(pA.getDataInizioSoggiorno(), pA.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaAppartamento(pA.getTipoAppartamento(), pA.getDataInizioSoggiorno().plusDays(g))) {
                throw new AppartamentoNonDisponibile(pA.getTipoAppartamento());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniAlloggioAppartamento.add(pA.clone());
        ioPAAppartamento.saveData(prenotazioniAlloggioAppartamento);

    }

    /**
     * metodo ADD che aggiunge una prenotazione alla casa indipendente come copia
     * dell'oggetto
     * fornito
     *
     * @param pC oggetto prenotazione casa indipendente da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneAlloggioCasaIndipendente(PrenotazioneAlloggioCasaIndipendente pC)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneAlloggioCasaIndipendente> prenotazioniAlloggioCasaIndipendente = ioPACasaIndipendente
                .loadData();
        // verifico che le d ate siano in ordine cronologico corretto
        if (pC.getDataInizioSoggiorno().isAfter(pC.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pC.getDataInizioSoggiorno(), pC.getDataFineSoggiorno());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniAlloggioCasaIndipendente.contains(pC)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutte le giornate della prenotazione ci sia una casa
        // indipendente disponibile
        int giorni_prenotazione = (int) DAYS.between(pC.getDataInizioSoggiorno(), pC.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaCasaIndipendente(pC.getTipoCasaIndipendente(),
                    pC.getDataInizioSoggiorno().plusDays(g))) {
                throw new CasaIndipendenteNonDisponibile(pC.getTipoCasaIndipendente());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniAlloggioCasaIndipendente.add(pC.clone());
        ioPACasaIndipendente.saveData(prenotazioniAlloggioCasaIndipendente);

    }

    /**
     * metodo ADD che aggiunge una prenotazione al villaggio come copia dell'oggetto
     * fornito
     *
     * @param pV oggetto prenotazione struttura villaggio da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneAlloggioVillaggio(PrenotazioneAlloggioVillaggio pV)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneAlloggioVillaggio> prenotazioniAlloggioVillaggio = ioPAVillaggio.loadData();
        // verifico che le date siano in ordine cronologico corretto
        if (pV.getDataInizioSoggiorno().isAfter(pV.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pV.getDataInizioSoggiorno(), pV.getDataFineSoggiorno());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniAlloggioVillaggio.contains(pV)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutte le giornate della prenotazione ci sia una strutture del
        // villaggio disponibile
        int giorni_prenotazione = (int) DAYS.between(pV.getDataInizioSoggiorno(), pV.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaStrutturaVillaggio(pV.getTipoStrutturaVillaggio(),
                    pV.getDataInizioSoggiorno().plusDays(g))) {
                throw new StrutturaVillaggioNonDisponibile(pV.getTipoStrutturaVillaggio());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniAlloggioVillaggio.add(pV.clone());
        ioPAVillaggio.saveData(prenotazioniAlloggioVillaggio);

    }

    /**
     * metodo ADD che aggiunge una prenotazione all'aereo come copia dell'oggetto
     * fornito
     *
     * @param pA oggetto prenotazione aereo da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneViaggioAereo(PrenotazioneViaggioAereo pA)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneViaggioAereo> prenotazioniViaggioAereo = ioPVAereo.loadData();
        // verifico che gli orari siano in ordine cronologico corretto
        if (pA.getDataPartenza().isAfter(pA.getDataArrivo())) {
            throw new RangeDataTimeNonValido(pA.getDataPartenza(), pA.getDataArrivo());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniViaggioAereo.contains(pA)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutto il tempo della prenotazione del viaggio ci sia un posto
        // disponibile
        int secondi_viaggio = (int) SECONDS.between(pA.getDataPartenza(), pA.getDataArrivo());
        for (int s = 0; s < secondi_viaggio; s++) {
            if (!verificaDisponibilitaAereo(pA.getTipoClasseMezzo(), pA.getDataPartenza().plusSeconds(s),
                    pA.getLuogoPartenza(), pA.getLuogoArrivo())) {
                throw new ClasseMezzoNonDisponibile(pA.getTipoClasseMezzo());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniViaggioAereo.add(pA.clone());
        ioPVAereo.saveData(prenotazioniViaggioAereo);

    }

    /**
     * metodo ADD che aggiunge una prenotazione all'autobus come copia dell'oggetto
     * fornito
     *
     * @param pA oggetto prenotazione autobus da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneViaggioAutobus(PrenotazioneViaggioAutobus pA)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneViaggioAutobus> prenotazioniViaggioAutobus = ioPVAutobus.loadData();
        // verifico che le date siano in ordine cronologico corretto
        if (pA.getDataPartenza().isAfter(pA.getDataArrivo())) {
            throw new RangeDataTimeNonValido(pA.getDataPartenza(), pA.getDataArrivo());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniViaggioAutobus.contains(pA)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutto il tempo della prenotazione del viaggio ci sia un posto
        // disponibile
        int secondi_viaggio = (int) SECONDS.between(pA.getDataPartenza(), pA.getDataArrivo());
        for (int s = 0; s < secondi_viaggio; s++) {
            if (!verificaDisponibilitaAereo(pA.getTipoClasseMezzo(), pA.getDataPartenza().plusSeconds(s),
                    pA.getLuogoPartenza(), pA.getLuogoArrivo())) {
                throw new ClasseMezzoNonDisponibile(pA.getTipoClasseMezzo());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniViaggioAutobus.add(pA.clone());
        ioPVAutobus.saveData(prenotazioniViaggioAutobus);

    }

    /**
     * metodo ADD che aggiunge una prenotazione al treno come copia dell'oggetto
     * fornito
     *
     * @param pT oggetto prenotazione treno da aggiungere
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void addPrenotazioneViaggioTreno(PrenotazioneViaggioTreno pT)
            throws AgenziaException, IOException, CloneNotSupportedException {
        ArrayList<PrenotazioneViaggioTreno> prenotazioniViaggioTreno = ioPVTreno.loadData();
        // verifico che le date siano in ordine cronologico corretto
        if (pT.getDataPartenza().isAfter(pT.getDataArrivo())) {
            throw new RangeDataTimeNonValido(pT.getDataPartenza(), pT.getDataArrivo());
        }
        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        if (prenotazioniViaggioTreno.contains(pT)) {
            throw new PrenotazioneGiaInserita();
        }
        // verifico che in tutto il tempo della prenotazione del viaggio ci sia un posto
        // disponibile
        int secondi_viaggio = (int) SECONDS.between(pT.getDataPartenza(), pT.getDataArrivo());
        for (int s = 0; s < secondi_viaggio; s++) {
            if (!verificaDisponibilitaAereo(pT.getTipoClasseMezzo(), pT.getDataPartenza().plusSeconds(s),
                    pT.getLuogoPartenza(), pT.getLuogoArrivo())) {
                throw new ClasseMezzoNonDisponibile(pT.getTipoClasseMezzo());
            }
        }
        // aggiungo una copia con il metodo add
        prenotazioniViaggioTreno.add(pT.clone());
        ioPVTreno.saveData(prenotazioniViaggioTreno);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di una camera d'hotel fornendo il
     * numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneAlloggioHotel(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioHotel(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPAHotel.remove(line_prenotazione);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di un appartamento fornendo il
     * numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneAlloggioAppartamento(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioAppartamento(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPAAppartamento.remove(line_prenotazione);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di una casa indipendente fornendo
     * il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneAlloggioCasaIndipendente(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioCasaIndipendente(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPACasaIndipendente.remove(line_prenotazione);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di una struttura del villaggio
     * fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneAlloggioVillaggio(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioVillaggio(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPAVillaggio.remove(line_prenotazione);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di posti sull'aereo fornendo il
     * numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneViaggioAereo(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneViaggioAereo(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPVAereo.remove(line_prenotazione);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di posti sull'autobus fornendo il
     * numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneViaggioAutobus(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneViaggioAutobus(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPVAutobus.remove(line_prenotazione);

    }

    /**
     * metodo REMOVE che elimina una prenotazione di posti sul treno fornendo il
     * numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @throws AgenziaException
     * @throws IOException
     */
    public void removePrenotazioneViaggioTreno(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneViaggioTreno(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        ioPVTreno.remove(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di una camera
     * d'hotel fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneAlloggioHotel getPrenotazioneAlloggioHotel(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioHotel(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPAHotel.get(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di un appartamento
     * fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneAlloggioAppartamento getPrenotazioneAlloggioAppartamento(int codice)
            throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioAppartamento(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPAAppartamento.get(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di una casa
     * indipendente fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneAlloggioCasaIndipendente getPrenotazioneAlloggioCasaIndipendente(int codice)
            throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioCasaIndipendente(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPACasaIndipendente.get(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di una struttura del
     * villaggio fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneAlloggioVillaggio getPrenotazioneAlloggioVillaggio(int codice)
            throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneAlloggioVillaggio(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPAVillaggio.get(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di posti sull'aereo
     * fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneViaggioAereo getPrenotazioneViaggioAereo(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneViaggioAereo(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPVAereo.get(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di posti
     * sull'autobus fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneViaggioAutobus getPrenotazioneViaggioAutobus(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneViaggioAutobus(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPVAutobus.get(line_prenotazione);

    }

    /**
     * metodo GET prenotazione che restituisce una prenotazione di posti sul treno
     * fornendo il numero di codice
     *
     * @param codice univoco che identifica la prenotazione
     * @return il riferimento all'oggetto (accesso in modifica)
     * @throws AgenziaException
     * @throws IOException
     */
    public PrenotazioneViaggioTreno getPrenotazioneViaggioTreno(int codice) throws AgenziaException, IOException {
        int line_prenotazione = getLinePrenotazioneViaggioTreno(codice);
        if (line_prenotazione == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        return ioPVTreno.get(line_prenotazione);

    }

    /**
     * metodo SET prenotazione di una camera d'hotel che modifica una prenotazione
     * esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pH     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneAlloggioHotel(int codice, PrenotazioneAlloggioHotel pH)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto
        if (pH.getDataInizioSoggiorno().isAfter(pH.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pH.getDataInizioSoggiorno(), pH.getDataFineSoggiorno());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneAlloggioHotel(pH.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutte le giornate della prenotazione ci sia una camera
        // disponibile
        int giorni_prenotazione = (int) DAYS.between(pH.getDataInizioSoggiorno(), pH.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaHotel(pH.getTipoCamera(), pH.getDataInizioSoggiorno().plusDays(g))) {
                throw new CameraNonDisponibile(pH.getTipoCamera());
            }
        }

        int line_prenotazione2 = getLinePrenotazioneAlloggioHotel(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPAHotel.set(line_prenotazione2, pH.clone());

    }

    /**
     * metodo SET prenotazione di un appartamento che modifica una prenotazione
     * esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pA     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneAlloggioAppartamento(int codice, PrenotazioneAlloggioAppartamento pA)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto
        if (pA.getDataInizioSoggiorno().isAfter(pA.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pA.getDataInizioSoggiorno(), pA.getDataFineSoggiorno());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneAlloggioAppartamento(pA.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutte le giornate della prenotazione ci sia una camera
        // disponibile
        int giorni_prenotazione = (int) DAYS.between(pA.getDataInizioSoggiorno(), pA.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaAppartamento(pA.getTipoAppartamento(), pA.getDataInizioSoggiorno().plusDays(g))) {
                throw new AppartamentoNonDisponibile(pA.getTipoAppartamento());
            }
        }

        int line_prenotazione2 = getLinePrenotazioneAlloggioAppartamento(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPAAppartamento.set(line_prenotazione2, pA.clone());

    }

    /**
     * metodo SET prenotazione di una casa indipendente che modifica una
     * prenotazione esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pC     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneAlloggioCasaIndipendente(int codice, PrenotazioneAlloggioCasaIndipendente pC)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto
        if (pC.getDataInizioSoggiorno().isAfter(pC.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pC.getDataInizioSoggiorno(), pC.getDataFineSoggiorno());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneAlloggioCasaIndipendente(pC.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutte le giornate della prenotazione ci sia una camera
        // disponibile
        int giorni_prenotazione = (int) DAYS.between(pC.getDataInizioSoggiorno(), pC.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaCasaIndipendente(pC.getTipoCasaIndipendente(),
                    pC.getDataInizioSoggiorno().plusDays(g))) {
                throw new CasaIndipendenteNonDisponibile(pC.getTipoCasaIndipendente());
            }
        }

        int line_prenotazione2 = getLinePrenotazioneAlloggioCasaIndipendente(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPACasaIndipendente.set(line_prenotazione2, pC.clone());

    }

    /**
     * metodo SET prenotazione di una struttura del villaggio che modifica una
     * prenotazione esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pV     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneAlloggioVillaggio(int codice, PrenotazioneAlloggioVillaggio pV)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto
        if (pV.getDataInizioSoggiorno().isAfter(pV.getDataFineSoggiorno())) {
            throw new RangeDataNonValido(pV.getDataInizioSoggiorno(), pV.getDataFineSoggiorno());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneAlloggioVillaggio(pV.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutte le giornate della prenotazione ci sia una camera
        // disponibile
        int giorni_prenotazione = (int) DAYS.between(pV.getDataInizioSoggiorno(), pV.getDataFineSoggiorno());
        for (int g = 0; g < giorni_prenotazione; g++) {
            if (!verificaDisponibilitaStrutturaVillaggio(pV.getTipoStrutturaVillaggio(),
                    pV.getDataInizioSoggiorno().plusDays(g))) {
                throw new StrutturaVillaggioNonDisponibile(pV.getTipoStrutturaVillaggio());
            }
        }

        int line_prenotazione2 = getLinePrenotazioneAlloggioVillaggio(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPAVillaggio.set(line_prenotazione2, pV.clone());

    }

    /**
     * metodo SET prenotazione di posti sull'aereo che modifica una prenotazione
     * esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pA     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneViaggioAereo(int codice, PrenotazioneViaggioAereo pA)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto
        if (pA.getDataPartenza().isAfter(pA.getDataArrivo())) {
            throw new RangeDataTimeNonValido(pA.getDataPartenza(), pA.getDataArrivo());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneViaggioAereo(pA.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutto il tempo della prenotazione del viaggio ci sia un posto
        // disponibile
        int secondi_viaggio = (int) SECONDS.between(pA.getDataPartenza(), pA.getDataArrivo());
        for (int s = 0; s < secondi_viaggio; s++) {
            if (!verificaDisponibilitaAereo(pA.getTipoClasseMezzo(), pA.getDataPartenza().plusSeconds(s),
                    pA.getLuogoPartenza(), pA.getLuogoArrivo())) {
                throw new ClasseMezzoNonDisponibile(pA.getTipoClasseMezzo());
            }
        }

        int line_prenotazione2 = getLinePrenotazioneViaggioAereo(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPVAereo.set(line_prenotazione2, pA.clone());

    }

    /**
     * metodo SET prenotazione di posti sul treno che modifica una prenotazione
     * esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pT     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneViaggioTreno(int codice, PrenotazioneViaggioTreno pT)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto

        // verifico che gli orari siano in ordine cronologico corretto
        if (pT.getDataPartenza().isAfter(pT.getDataArrivo())) {
            throw new RangeDataTimeNonValido(pT.getDataPartenza(), pT.getDataArrivo());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneViaggioTreno(pT.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutto il tempo della prenotazione del viaggio ci sia un posto
        // disponibile
        int secondi_viaggio = (int) SECONDS.between(pT.getDataPartenza(), pT.getDataArrivo());
        for (int s = 0; s < secondi_viaggio; s++) {
            if (!verificaDisponibilitaAereo(pT.getTipoClasseMezzo(), pT.getDataPartenza().plusSeconds(s),
                    pT.getLuogoPartenza(), pT.getLuogoArrivo())) {
                throw new ClasseMezzoNonDisponibile(pT.getTipoClasseMezzo());
            }
        }

        int line_prenotazione2 = getLinePrenotazioneViaggioTreno(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPVTreno.set(line_prenotazione2, pT.clone());

    }

    /**
     * metodo SET prenotazione di posti sull'autobus che modifica una prenotazione
     * esistente, ricercata tramite il codice
     * che la indentifica, con un'altra prenotazione che la sostituisce
     *
     * @param codice univoco che identifica la prenotazione
     * @param pA     prenotazione con cui sostituire quella ricercata
     * @throws AgenziaException
     * @throws IOException
     * @throws CloneNotSupportedException
     */
    public void setPrenotazioneViaggioAutobus(int codice, PrenotazioneViaggioAutobus pA)
            throws AgenziaException, IOException, CloneNotSupportedException {
        // verifico che le date siano in ordine cronologico corretto
        if (pA.getDataPartenza().isAfter(pA.getDataArrivo())) {
            throw new RangeDataTimeNonValido(pA.getDataPartenza(), pA.getDataArrivo());
        }

        // verifico che non sia già stata inserita una prenotazione con lo stesso codice
        int line_prenotazione = getLinePrenotazioneViaggioAutobus(pA.getCodice());
        if (line_prenotazione >= 0) {
            throw new PrenotazioneNonTrovata(codice);
        }

        // verifico che in tutto il tempo della prenotazione del viaggio ci sia un posto
        // disponibile
        int secondi_viaggio = (int) SECONDS.between(pA.getDataPartenza(), pA.getDataArrivo());
        for (int s = 0; s < secondi_viaggio; s++) {
            if (!verificaDisponibilitaAereo(pA.getTipoClasseMezzo(), pA.getDataPartenza().plusSeconds(s),
                    pA.getLuogoPartenza(), pA.getLuogoArrivo())) {
                throw new ClasseMezzoNonDisponibile(pA.getTipoClasseMezzo());
            }
        }
        int line_prenotazione2 = getLinePrenotazioneViaggioAutobus(codice);
        if (line_prenotazione2 == -1) {
            throw new PrenotazioneNonTrovata(codice);
        }
        // inserisco la nuova prenotaizone (in copia) sostituendola all'indice trovato
        ioPVAutobus.set(line_prenotazione2, pA.clone());

    }

    /**
     * metodo per calcolare l'incasso annuale dell'hotel
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni dell'hotel la cui data
     *         finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleHotel(int anno) throws IOException {

        ArrayList<PrenotazioneAlloggioHotel> prenotazioniAlloggioHotel = ioPAHotel.loadData();
        int incasso_tot_per_anno = 0;
        for (int i = 0; i < prenotazioniAlloggioHotel.size(); i++) {
            if (prenotazioniAlloggioHotel.get(i).getDataFineSoggiorno().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniAlloggioHotel.get(i).calcolaPrezzoSoggiorno();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale degli appartamenti
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni degli appartamenti la
     *         cui data finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleAppartamenti(int anno) throws IOException {

        ArrayList<PrenotazioneAlloggioAppartamento> prenotazioniAlloggioAppartamento = ioPAAppartamento.loadData();
        int incasso_tot_per_anno = 0;

        for (int i = 0; i < prenotazioniAlloggioAppartamento.size(); i++) {
            if (prenotazioniAlloggioAppartamento.get(i).getDataFineSoggiorno().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniAlloggioAppartamento.get(i).calcolaPrezzoSoggiorno();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale delle case indipendenti
     * 
     * @param anno
     * @return l'incasso derivante da tutte le prenotazioni delle case indipendenti
     *         la cui data finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleCaseIndipendenti(int anno) throws IOException {

        ArrayList<PrenotazioneAlloggioCasaIndipendente> prenotazioniAlloggioCasaIndipendente = ioPACasaIndipendente
                .loadData();
        int incasso_tot_per_anno = 0;

        for (int i = 0; i < prenotazioniAlloggioCasaIndipendente.size(); i++) {
            if (prenotazioniAlloggioCasaIndipendente.get(i).getDataFineSoggiorno().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniAlloggioCasaIndipendente.get(i).calcolaPrezzoSoggiorno();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale del villaggio
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni del villaggio la cui
     *         data finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleVillaggio(int anno) throws IOException {

        ArrayList<PrenotazioneAlloggioVillaggio> prenotazioniAlloggioVillaggio = ioPAVillaggio.loadData();
        int incasso_tot_per_anno = 0;

        for (int i = 0; i < prenotazioniAlloggioVillaggio.size(); i++) {
            if (prenotazioniAlloggioVillaggio.get(i).getDataFineSoggiorno().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniAlloggioVillaggio.get(i).calcolaPrezzoSoggiorno();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale dell'aereo
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni dell'aereo la cui data
     *         finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleAereo(int anno) throws IOException {

        ArrayList<PrenotazioneViaggioAereo> prenotazioniViaggioAereo = ioPVAereo.loadData();
        int incasso_tot_per_anno = 0;
        for (int i = 0; i < prenotazioniViaggioAereo.size(); i++) {
            if (prenotazioniViaggioAereo.get(i).getDataPartenza().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniViaggioAereo.get(i).calcolaPrezzoViaggio();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale dell'autobus
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni dell'autobus la cui data
     *         finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleAutobus(int anno) throws IOException {

        ArrayList<PrenotazioneViaggioAutobus> prenotazioniViaggioAutobus = ioPVAutobus.loadData();
        int incasso_tot_per_anno = 0;
        for (int i = 0; i < prenotazioniViaggioAutobus.size(); i++) {
            if (prenotazioniViaggioAutobus.get(i).getDataPartenza().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniViaggioAutobus.get(i).calcolaPrezzoViaggio();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale del treno
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni del treno la cui data
     *         finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleTreno(int anno) throws IOException {

        ArrayList<PrenotazioneViaggioTreno> prenotazioniViaggioTreno = ioPVTreno.loadData();
        int incasso_tot_per_anno = 0;
        for (int i = 0; i < prenotazioniViaggioTreno.size(); i++) {
            if (prenotazioniViaggioTreno.get(i).getDataPartenza().getYear() == anno) {
                incasso_tot_per_anno += prenotazioniViaggioTreno.get(i).calcolaPrezzoViaggio();
            }
        }

        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale degli alloggi
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni inerenti agli alloggi la
     *         cui data finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleAlloggi(int anno) throws IOException {

        int incasso_tot_per_anno = calcolaIncassoAnnualeTotaleHotel(anno) +
                calcolaIncassoAnnualeTotaleAppartamenti(anno) +
                calcolaIncassoAnnualeTotaleCaseIndipendenti(anno) + calcolaIncassoAnnualeTotaleVillaggio(anno);
        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale dei mezzi di trasporto
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni inerenti ai mezzi di
     *         trasporto la cui
     *         data finale icade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleMezziTrasporto(int anno) throws IOException {

        int incasso_tot_per_anno = calcolaIncassoAnnualeTotaleAereo(anno) + calcolaIncassoAnnualeTotaleAutobus(anno) +
                calcolaIncassoAnnualeTotaleTreno(anno);
        return incasso_tot_per_anno;
    }

    /**
     * metodo per calcolare l'incasso annuale dell'agenzia sommando gli incassi di
     * ogni tipo di
     * prenotazione
     * 
     * @param anno di cui calcolare l'incasso totale
     * @return l'incasso derivante da tutte le prenotazioni dell'agenzia la cui data
     *         finale
     *         ricade nell'anno dato in input
     * @throws IOException
     */
    public int calcolaIncassoAnnualeTotaleAgenzia(int anno) throws IOException {

        int incasso_tot_per_anno = calcolaIncassoAnnualeTotaleHotel(anno) +
                calcolaIncassoAnnualeTotaleAppartamenti(anno) +
                calcolaIncassoAnnualeTotaleCaseIndipendenti(anno) + calcolaIncassoAnnualeTotaleVillaggio(anno) +
                calcolaIncassoAnnualeTotaleAereo(anno) + calcolaIncassoAnnualeTotaleAutobus(anno) +
                calcolaIncassoAnnualeTotaleTreno(anno);
        return incasso_tot_per_anno;
    }

    /**
     * metodo per trovare la/le massima/e/i fonte di guadagno annuale dell'agenzia
     * 
     * @param anno di cui trovare la/le massima/e/i fonte di guadagno
     * @return stringa che indica la/le massima/e/i fonte di guadagno con il
     *         rispettivo guadagno
     * @throws IOException
     */
    public String TrovaFonteMaxGuadagnoAnnuale(int anno) throws IOException {
        String fonte_incasso_max = "la/le principale/i fonte/i di guadagno nell'anno " + anno + " è/sono ";
        int incasso_tot_max;
        int incasso_tot_per_anno_prenotazioniAlloggioHotel = calcolaIncassoAnnualeTotaleHotel(anno);

        int incasso_tot_per_anno_prenotazioniAlloggioAppartamento = calcolaIncassoAnnualeTotaleAppartamenti(anno);
        incasso_tot_max = Math.max(incasso_tot_per_anno_prenotazioniAlloggioHotel,
                incasso_tot_per_anno_prenotazioniAlloggioAppartamento);

        int incasso_tot_per_anno_prenotazioniAlloggioCasaIndipendente = calcolaIncassoAnnualeTotaleCaseIndipendenti(
                anno);
        incasso_tot_max = Math.max(incasso_tot_max,
                incasso_tot_per_anno_prenotazioniAlloggioCasaIndipendente);

        int incasso_tot_per_anno_prenotazioniAlloggioVillaggio = calcolaIncassoAnnualeTotaleVillaggio(anno);
        incasso_tot_max = Math.max(incasso_tot_max,
                incasso_tot_per_anno_prenotazioniAlloggioVillaggio);

        int incasso_tot_per_anno_prenotazioniViaggioAereo = calcolaIncassoAnnualeTotaleAereo(anno);
        incasso_tot_max = Math.max(incasso_tot_max,
                incasso_tot_per_anno_prenotazioniViaggioAereo);

        int incasso_tot_per_anno_prenotazioniViaggioAutobus = calcolaIncassoAnnualeTotaleAutobus(anno);
        incasso_tot_max = Math.max(incasso_tot_max,
                incasso_tot_per_anno_prenotazioniViaggioAutobus);

        int incasso_tot_per_anno_prenotazioniViaggioTreno = calcolaIncassoAnnualeTotaleTreno(anno);
        incasso_tot_max = Math.max(incasso_tot_max,
                incasso_tot_per_anno_prenotazioniViaggioTreno);
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniAlloggioHotel) {
            fonte_incasso_max += "le camere d'hotel, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniAlloggioCasaIndipendente) {
            fonte_incasso_max += "le case indipendenti, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniAlloggioVillaggio) {
            fonte_incasso_max += "le sttrutture nel villaggio, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniViaggioAereo) {
            fonte_incasso_max += "gli aerei, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniAlloggioAppartamento) {
            fonte_incasso_max += "gli appartamenti, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniViaggioAutobus) {
            fonte_incasso_max += "gli autobus, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == incasso_tot_per_anno_prenotazioniViaggioTreno) {
            fonte_incasso_max += "i treni, per un totale di " + incasso_tot_max;
        }
        if (incasso_tot_max == 0) {
            return "nell'anno " + anno + " non è stato registrato nessun guadagno";

        } else {

            return fonte_incasso_max;

        }
    }

    /**
     * metodo per stampare la lista delle prenotazioni delle camere d'hotel
     *
     * @return ArrayList delle prenotazioni delle camere d'hotel
     * @throws IOException
     */
    public ArrayList<PrenotazioneAlloggioHotel> stampaListaPrenotazioniAlloggioHotel() throws IOException {
        return ioPAHotel.loadData();
    }

    /**
     * metodo per stampare la lista delle prenotazioni delle case indipendenti
     *
     * @return ArrayList delle prenotazioni delle case indipendenti
     * @throws IOException
     */
    public ArrayList<PrenotazioneAlloggioCasaIndipendente> stampaListaPrenotazioniAlloggioCasaIndipendente()
            throws IOException {
        return ioPACasaIndipendente.loadData();
    }

    /**
     * metodo per stampare la lista delle prenotazioni degli appartamenti
     *
     * @return ArrayList delle prenotazioni degli appartamenti
     * @throws IOException
     */
    public ArrayList<PrenotazioneAlloggioAppartamento> stampaListaPrenotazioniAlloggioAppartamento()
            throws IOException {
        return ioPAAppartamento.loadData();
    }

    /**
     * metodo per stampare la lista delle prenotazioni delle strutture villaggio
     *
     * @return ArrayList delle prenotazioni delle strutture villaggio
     * @throws IOException
     */
    public ArrayList<PrenotazioneAlloggioVillaggio> stampaListaPrenotazioniAlloggioVillaggio() throws IOException {
        return ioPAVillaggio.loadData();
    }

    /**
     * metodo per stampare la lista delle prenotazioni dei posti dell'aereo
     *
     * @return ArrayList delle prenotazioni dei posti dell'aereo
     * @throws IOException
     */
    public ArrayList<PrenotazioneViaggioAereo> stampaListaPrenotazioniViaggioAereo() throws IOException {
        return ioPVAereo.loadData();
    }

    /**
     * metodo per stampare la lista delle prenotazioni dei posti del treno
     *
     * @return ArrayList delle prenotazioni dei posti del treno
     * @throws IOException
     */
    public ArrayList<PrenotazioneViaggioTreno> stampaListaPrenotazioniViaggioTreno() throws IOException {
        return ioPVTreno.loadData();
    }

    /**
     * metodo per stampare la lista delle prenotazioni dei posti dell'autobus
     *
     * @return ArrayList delle prenotazioni dei posti dell'autobus
     * @throws IOException
     */
    public ArrayList<PrenotazioneViaggioAutobus> stampaListaPrenotazioniViaggioAutobus() throws IOException {
        return ioPVAutobus.loadData();
    }

    /**
     * metodo per stampare la lista di tutte le prenotazioni dell'agenzia divise per
     * categoria,
     * rispettivamente vengono stampate nell'ordine: hotel, case indipendenti,
     * appartamenti, villaggio,
     * aereo,treno,autobus
     * 
     * @throws IOException
     */
    public void stampaListaPrenotazioniAgenzia() throws IOException {
        System.out.println("PRENOTAZIONI RIGUARDANTI L'HOTEL");
        System.out.println(stampaListaPrenotazioniAlloggioHotel());
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("PRENOTAZIONI RIGUARDANTI LE CASE INDIPENDENTI");
        System.out.println(stampaListaPrenotazioniAlloggioCasaIndipendente());
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("PRENOTAZIONI RIGUARDANTI GLI APPARTAMENTI");
        System.out.println(stampaListaPrenotazioniAlloggioAppartamento());
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("PRENOTAZIONI RIGUARDANTI IL VILLAGGIO");
        System.out.println(stampaListaPrenotazioniAlloggioVillaggio());
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("PRENOTAZIONI RIGUARDANTI L'AEREO");
        System.out.println(stampaListaPrenotazioniViaggioAereo());
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("PRENOTAZIONI RIGUARDANTI Il TRENO");
        System.out.println(stampaListaPrenotazioniViaggioTreno());
        System.out.println("-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-o-");
        System.out.println("PRENOTAZIONI RIGUARDANTI L'AUTOBUS");
        System.out.println(stampaListaPrenotazioniViaggioAutobus());

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni dell'hotel chiamando il
     * metodo sort della
     * classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniHotel() throws IOException {
        ArrayList<PrenotazioneAlloggioHotel> prenotazioniAlloggioHotel = ioPAHotel.loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniAlloggioHotel);
        // cancello tutto quello che era scritto nel file
        ioPAHotel.clear();
        // riscrivo l'arrayList cancellato
        ioPAHotel.saveData(prenotazioniAlloggioHotel);

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni delgli appartamenti
     * chiamando il metodo
     * sort della classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniAppartamenti() throws IOException {
        ArrayList<PrenotazioneAlloggioAppartamento> prenotazioniAlloggioAppartamento = ioPAAppartamento.loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniAlloggioAppartamento);
        // cancello tutto quello che era scritto nel file
        ioPAAppartamento.clear();
        // riscrivo l'arrayList cancellato
        ioPAAppartamento.saveData(prenotazioniAlloggioAppartamento);

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni delle strutture del
     * villaggio chiamando il
     * metodo sort della classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniStruttureVillaggio() throws IOException {
        ArrayList<PrenotazioneAlloggioVillaggio> prenotazioniAlloggioVillaggio = ioPAVillaggio.loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniAlloggioVillaggio);
        // cancello tutto quello che era scritto nel file
        ioPAVillaggio.clear();
        // riscrivo l'arrayList cancellato
        ioPAVillaggio.saveData(prenotazioniAlloggioVillaggio);

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni delle case indipendenti
     * chiamando il metodo
     * sort della classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniCaseIndipendenti() throws IOException {
        ArrayList<PrenotazioneAlloggioCasaIndipendente> prenotazioniAlloggioCasaIndipendente = ioPACasaIndipendente
                .loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniAlloggioCasaIndipendente);
        // cancello tutto quello che era scritto nel file
        ioPACasaIndipendente.clear();
        // riscrivo l'arrayList cancellato
        ioPACasaIndipendente.saveData(prenotazioniAlloggioCasaIndipendente);

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni dei posti sull'aereo
     * chiamando il metodo
     * sort della classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniAereo() throws IOException {
        ArrayList<PrenotazioneViaggioAereo> prenotazioniViaggioAereo = ioPVAereo.loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniViaggioAereo);
        // cancello tutto quello che era scritto nel file
        ioPVAereo.clear();
        // riscrivo l'arrayList cancellato
        ioPVAereo.saveData(prenotazioniViaggioAereo);

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni dei posti sull'autobus
     * chiamando il metodo
     * sort della classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniAutobus() throws IOException {
        ArrayList<PrenotazioneViaggioAutobus> prenotazioniViaggioAutobus = ioPVAutobus.loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniViaggioAutobus);
        // cancello tutto quello che era scritto nel file
        ioPVAutobus.clear();
        // riscrivo l'arrayList cancellato
        ioPVAutobus.saveData(prenotazioniViaggioAutobus);

    }

    /**
     * metodo per ordinare un arraylist di prenotazioni dei posti dul treno
     * chiamando il metodo
     * sort della classe Collections
     *
     * @throws IOException
     */
    public void sortPrenotazioniTreno() throws IOException {
        ArrayList<PrenotazioneViaggioTreno> prenotazioniViaggioTreno = ioPVTreno.loadData();
        // ordino i dati nell'arraylist
        Collections.sort(prenotazioniViaggioTreno);
        // cancello tutto quello che era scritto nel file
        ioPVTreno.clear();
        // riscrivo l'arrayList cancellato
        ioPVTreno.saveData(prenotazioniViaggioTreno);

    }

    /**
     * metodo per ordinare un arraylist di tutte le prenotazioni dell'agenzia
     * chiamando i metodi
     * personalizzati sort di ogni tipo oggetto prenotazione
     *
     * @throws IOException
     */
    public void sortPrenotazioniAgenzia() throws IOException {
        sortPrenotazioniAereo();
        sortPrenotazioniAppartamenti();
        sortPrenotazioniAutobus();
        sortPrenotazioniCaseIndipendenti();
        sortPrenotazioniHotel();
        sortPrenotazioniStruttureVillaggio();
        sortPrenotazioniTreno();

    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneAlloggioHotel(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneAlloggioHotel> prenotazioniAlloggioHotel = ioPAHotel.loadData();
        for (int i = 0; !prenotazione_trovata && i < prenotazioniAlloggioHotel.size(); i++) {
            if (prenotazioniAlloggioHotel.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;
            }
        }
        return line_prenotazione;
    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneAlloggioAppartamento(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneAlloggioAppartamento> prenotazioniAlloggioAppartamento = ioPAAppartamento.loadData();
        for (int i = 0; !prenotazione_trovata && i < prenotazioniAlloggioAppartamento.size(); i++) {
            if (prenotazioniAlloggioAppartamento.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;
            }
        }
        return line_prenotazione;
    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneAlloggioCasaIndipendente(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneAlloggioCasaIndipendente> prenotazioniAlloggioCasaIndipendente = ioPACasaIndipendente
                .loadData();
        for (int i = 0; !prenotazione_trovata && i < prenotazioniAlloggioCasaIndipendente.size(); i++) {
            if (prenotazioniAlloggioCasaIndipendente.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;
            }
        }
        return line_prenotazione;
    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneAlloggioVillaggio(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneAlloggioVillaggio> prenotazioniAlloggioVillaggio = ioPAVillaggio.loadData();
        for (int i = 0; !prenotazione_trovata && i < prenotazioniAlloggioVillaggio.size(); i++) {
            if (prenotazioniAlloggioVillaggio.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;
            }
        }
        return line_prenotazione;
    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneViaggioAereo(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneViaggioAereo> prenotazioniViaggioAereo = ioPVAereo.loadData();
        for (int i = 0; !prenotazione_trovata && i < prenotazioniViaggioAereo.size(); i++) {
            if (prenotazioniViaggioAereo.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;
            }
        }
        return line_prenotazione;
    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneViaggioAutobus(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneViaggioAutobus> prenotazioniViaggioAutobus = ioPVAutobus.loadData();
        for (int i = 0; !prenotazione_trovata && i < prenotazioniViaggioAutobus.size(); i++) {
            if (prenotazioniViaggioAutobus.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;

            }
        }
        return line_prenotazione;
    }

    /**
     * metodo che restituisce il numero della riga in cui è presente la prenotazione
     * come int
     * 
     * @param codice
     * @return il numero della riga in cui è presente la prenotazione come int
     * @throws IOException
     */
    private int getLinePrenotazioneViaggioTreno(int codice) throws IOException {
        boolean prenotazione_trovata = false;
        int line_prenotazione = -1;
        // carico provisoriamnete i dati in un arraylist per fare la ricerca
        ArrayList<PrenotazioneViaggioTreno> prenotazioniViaggioTreno = ioPVTreno.loadData();

        for (int i = 0; !prenotazione_trovata && i < prenotazioniViaggioTreno.size(); i++) {
            if (prenotazioniViaggioTreno.get(i).getCodice() == codice) {
                prenotazione_trovata = true;
                line_prenotazione = i;

            }
        }
        return line_prenotazione;
    }

}
