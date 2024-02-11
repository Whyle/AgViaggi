/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dtformatters.DateTimeIT;
import iofiles.ReadFile;
import iofiles.WriteFile;
import java.io.IOException;
import iofiles.IOObjectFile;
import java.time.LocalDate;
import model.PrenotazioneAlloggioAppartamento;
import model.TipoAppartamento;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneAlloggioAppartamento extends IOObjectFile<PrenotazioneAlloggioAppartamento>  {
     public IOObjectPrenotazioneAlloggioAppartamento(String fileName, String separator) {
        super(fileName, separator);
    }
    @Override
   public String serialize(PrenotazioneAlloggioAppartamento p){
        return p.getNomeCliente()+separator+p.getTipoAppartamento()+
                separator+p.getDataInizioSoggiorno().format(DateTimeIT.DATE)+separator+p.getDataFineSoggiorno().format(DateTimeIT.DATE)
                +separator+p.getCucina()+separator+p.getParcheggio()+separator+p.getAnimaliDomestici();
    }
    //array ottenuto con metodo split da riga di files
  
     @Override
    public PrenotazioneAlloggioAppartamento deserialize(String[]attributes){
       return new PrenotazioneAlloggioAppartamento(attributes[0],TipoAppartamento.valueOf(attributes[1]),
       LocalDate.parse(attributes[2], DateTimeIT.DATE),LocalDate.parse(attributes[3], DateTimeIT.DATE),Boolean.parseBoolean(attributes[4]),
               Boolean.parseBoolean(attributes[5]),Boolean.parseBoolean(attributes[6])); 
    } 
}