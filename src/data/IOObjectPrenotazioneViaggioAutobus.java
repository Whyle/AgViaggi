/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import dtformatters.DateTimeIT;
import iofiles.IOObjectFile;
import iofiles.ReadFile;
import iofiles.WriteFile;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import model.PrenotazioneViaggioAutobus;
import model.TipoClasseMezzo;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneViaggioAutobus extends IOObjectFile<PrenotazioneViaggioAutobus> {
     public IOObjectPrenotazioneViaggioAutobus(String fileName,String separator) {
        super(fileName, separator);

    }
 @Override
   public String serialize(PrenotazioneViaggioAutobus p){
        return p.getNomeCliente()+separator+p.getnPasseggeri()+separator+p.getLuogoPartenza()+separator+p.getDataPartenza().format(DateTimeIT.DATETIME)
                +separator+p.getLuogoArrivo()+separator+p.
                        getDataArrivo().format(DateTimeIT.DATETIME)+separator+p.getFinestrino()+separator+p.getWifi();
        
    }
    //array ottenuto con metodo split da riga di files
     @Override
    public PrenotazioneViaggioAutobus deserialize(String[]attributes){
       return new PrenotazioneViaggioAutobus(attributes[0],Integer.parseInt(attributes[1]), TipoClasseMezzo.valueOf(attributes[2]),
      attributes[3],LocalDateTime.parse(attributes[4], DateTimeIT.DATETIME),
             attributes[5],LocalDateTime.parse(attributes[6], DateTimeIT.DATETIME),Boolean.parseBoolean(attributes[7]),Boolean.parseBoolean(attributes[8])); 
    }
}
