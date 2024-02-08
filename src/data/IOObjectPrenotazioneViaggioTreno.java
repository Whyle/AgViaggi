/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import utils.DateTimeIT;

import java.time.LocalDateTime;
import model.PrenotazioneViaggioTreno;
import model.TipoClasseMezzo;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneViaggioTreno extends IOObjectFile<PrenotazioneViaggioTreno>  {

    public IOObjectPrenotazioneViaggioTreno(String fileName,String separator) {
        super(fileName, separator);

    }

    @Override
  public String serialize(PrenotazioneViaggioTreno p){
        return p.getNomeCliente()+separator+p.getnPasseggeri()+separator+p.getTipoClasseMezzo()+
                separator+p.getLuogoPartenza()+separator+p.getDataPartenza().format(DateTimeIT.DATETIME)
                +separator+p.getLuogoArrivo()+separator+p.
                        getDataArrivo().format(DateTimeIT.DATETIME)+separator+p.getFinestrino();
    }
    //array ottenuto con metodo split da riga di files
     @Override
    public PrenotazioneViaggioTreno deserialize(String[]attributes){
       return new PrenotazioneViaggioTreno(attributes[0],Integer.parseInt(attributes[1]),
       TipoClasseMezzo.valueOf(attributes[2]),attributes[3],LocalDateTime.parse(attributes[4], DateTimeIT.DATETIME),
             attributes[5],LocalDateTime.parse(attributes[6], DateTimeIT.DATETIME),Boolean.parseBoolean(attributes[7])); 
    }
}
