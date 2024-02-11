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
import model.PrenotazioneAlloggioHotel;
import model.TipoCamera;
import model.TipoPensione;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneAlloggioHotel extends IOObjectFile<PrenotazioneAlloggioHotel> {

    public IOObjectPrenotazioneAlloggioHotel(String fileName, String separator) {
        super(fileName, separator);
    }
     @Override
    public String serialize(PrenotazioneAlloggioHotel p){
        return p.getNomeCliente()+separator+p.getTipoCamera()+separator+
                p.getTipoPensione()+separator+p.getDataInizioSoggiorno().format(DateTimeIT.DATE)+separator+p.getDataFineSoggiorno().format(DateTimeIT.DATE)
+separator+p.getWifi()+separator+p.getParcheggio()
                +separator+p.getBalcone();
    }
    //array ottenuto con metodo split da riga di files
     @Override
    public PrenotazioneAlloggioHotel deserialize(String[]attributes){
       return new PrenotazioneAlloggioHotel(attributes[0],TipoCamera.valueOf(attributes[1]),TipoPensione.valueOf(attributes[2]),
       LocalDate.parse(attributes[3], DateTimeIT.DATE),LocalDate.parse(attributes[4], DateTimeIT.DATE),Boolean.parseBoolean(attributes[5]),
               Boolean.parseBoolean(attributes[6]),Boolean.parseBoolean(attributes[7])); 
    }
}
