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
   public IOObjectPrenotazioneViaggioAutobus(String fileName, String separator) {
      super(fileName, separator);

   }

   @Override
   public String serialize(PrenotazioneViaggioAutobus p) {
      return p.getCodice() + separator + p.getNomeCliente() + separator + p.getnPasseggeri() + separator
            + p.getLuogoPartenza() + separator + p.getDataPartenza().format(DateTimeIT.DATETIME)
            + separator + p.getLuogoArrivo() + separator + p.getDataArrivo().format(DateTimeIT.DATETIME) + separator
            + p.getFinestrino() + separator + p.getWifi();

   }

   // array ottenuto con metodo split da riga di files
   @Override
   public PrenotazioneViaggioAutobus deserialize(String[] attributes) {
      return new PrenotazioneViaggioAutobus(Integer.parseInt(attributes[0]), attributes[1], Integer.parseInt(attributes[2]),
            TipoClasseMezzo.valueOf(attributes[3]),
            attributes[4], LocalDateTime.parse(attributes[5], DateTimeIT.DATETIME),
            attributes[6], LocalDateTime.parse(attributes[7], DateTimeIT.DATETIME), Boolean.parseBoolean(attributes[8]),
            Boolean.parseBoolean(attributes[9]));
   }
}
