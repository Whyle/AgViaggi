/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import dtformatters.DateTimeIT;
import iofiles.IOObjectFile;
import java.time.LocalDate;
import model.PrenotazioneAlloggioAppartamento;
import model.TipoAppartamento;

/**
 *
 * @author jessi
 */
public class IOObjectPrenotazioneAlloggioAppartamento extends IOObjectFile<PrenotazioneAlloggioAppartamento> {
    public IOObjectPrenotazioneAlloggioAppartamento(String fileName, String separator) {
        super(fileName, separator);
    }

    @Override
    public String serialize(PrenotazioneAlloggioAppartamento p) {
        return p.getCodice() + separator + p.getNomeCliente() + separator + p.getTipoAppartamento() + separator + 
               p.getDataInizioSoggiorno().format(DateTimeIT.DATE) + separator + 
               p.getDataFineSoggiorno().format(DateTimeIT.DATE) + separator + 
               p.getCucina() + separator + p.getParcheggio() + separator + 
               p.getAnimaliDomestici();
    }

    @Override
    public PrenotazioneAlloggioAppartamento deserialize(String[] attributes) {
        return new PrenotazioneAlloggioAppartamento(Integer.parseInt(attributes[0]),attributes[1], TipoAppartamento.valueOf(attributes[2]),
                LocalDate.parse(attributes[3], DateTimeIT.DATE), LocalDate.parse(attributes[4], DateTimeIT.DATE),
                Boolean.parseBoolean(attributes[5]),
                Boolean.parseBoolean(attributes[6]), Boolean.parseBoolean(attributes[7]));
    }
}