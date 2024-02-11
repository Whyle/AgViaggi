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
import model.PrenotazioneAlloggioAppartamento;
import model.PrenotazioneAlloggioVillaggio;
import model.TipoStrutturaVillaggio;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneAlloggioVillaggio extends IOObjectFile<PrenotazioneAlloggioVillaggio>  {
     public IOObjectPrenotazioneAlloggioVillaggio(String fileName, String separator) {
        super(fileName, separator);
    }
      @Override
    public String serialize(PrenotazioneAlloggioVillaggio p){
       return p.getNomeCliente()+separator+p.getTipoStrutturaVillaggio()+
                separator+p.getDataInizioSoggiorno().format(DateTimeIT.DATE) +separator+p.getDataFineSoggiorno().format(DateTimeIT.DATE)+separator+p.getCucina()+separator+p.getParcheggio()
                +separator+p.getAnimaliDomestici()+separator+p.getAnimazione();
    }
    //array ottenuto con metodo split da riga di files
     @Override
    public PrenotazioneAlloggioVillaggio deserialize(String[]attributes){
       return new PrenotazioneAlloggioVillaggio(attributes[0],TipoStrutturaVillaggio.valueOf(attributes[1]),LocalDate.parse(attributes[2], DateTimeIT.DATE),
       LocalDate.parse(attributes[3], DateTimeIT.DATE),Boolean.parseBoolean(attributes[4]),Boolean.parseBoolean(attributes[5]),
               Boolean.parseBoolean(attributes[6]),Boolean.parseBoolean(attributes[7]));
    }
}
