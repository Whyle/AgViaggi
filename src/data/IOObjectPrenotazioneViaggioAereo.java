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
import model.PrenotazioneAlloggioAppartamento;
import model.PrenotazioneViaggioAereo;
import model.TipoClasseMezzo;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneViaggioAereo extends IOObjectFile<PrenotazioneViaggioAereo>  {

   public IOObjectPrenotazioneViaggioAereo(String fileName,String separator) {
        super(fileName, separator);

    }

   @Override
     public String serialize(PrenotazioneViaggioAereo p){
        return p.getNomeCliente()+separator+p.getnPasseggeri()+separator+p.getTipoClasseMezzo()+
                separator+p.getLuogoPartenza()+separator+p.getDataPartenza().format(DateTimeIT.DATETIME)
                +separator+p.getLuogoArrivo()+separator+p.
                        getDataArrivo().format(DateTimeIT.DATETIME)+separator+p.getBagaglio();
    }
    //array ottenuto con metodo split da riga di files
     @Override
    public PrenotazioneViaggioAereo deserialize(String[]attributes){
       return new PrenotazioneViaggioAereo(attributes[0],Integer.parseInt(attributes[1]),
       TipoClasseMezzo.valueOf(attributes[2]),(attributes[3]),LocalDateTime.parse(attributes[4], DateTimeIT.DATETIME),
             attributes[5],LocalDateTime.parse(attributes[6], DateTimeIT.DATETIME),
              Boolean.parseBoolean(attributes[7])); 
    }
    
}
