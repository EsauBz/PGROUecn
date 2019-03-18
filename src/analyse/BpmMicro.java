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
public class BpmMicro extends MesureVariation{

    public BpmMicro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("HR");
    }
    
    

    /**
     *Compare avec la valeur de la variation avec la valeur limite
     * @param p paramètre du patient
     */
    @Override
    public void analyse(Parametres p){
        if (this.variation()>p.getVariationBpm()){
            Alerte alerte = new Alerte("BpmMicroVariation", this.variation(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(BpmMicro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getValeur()>p.getBpmHaut()||this.getValeur()<p.getBpmBas()){
            Alerte alerte = new Alerte("BpmMicro", this.getValeur(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(BpmMicro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
