/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author antoi
 */
public class TemperatureMicro extends MesureVariation{

    public TemperatureMicro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("");
    }
    
    //Compare avec la valeur de la variation avec la valeur limite
    @Override
    public void analyse(Parametres p){
        if (this.variation()>p.getVariationTemperature()){
             Alerte alerte = new Alerte("TemperatureMicroVariation", this.variation(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(TemperatureMicro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getValeur()>p.getTemperatureHaut()||this.getValeur()<p.getTemperatureBas()){
            Alerte alerte = new Alerte("TemperatureMicro", this.getValeur(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(TemperatureMicro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
