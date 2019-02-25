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
public class Poids extends MesureVariation {

    public Poids(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("WeightValue");
    }
    
    //Compare avec la valeur de la variation avec la valueur limite

    /**
     *
     * @param p paramètres du patient
     */
    @Override
    public void analyse(Parametres p){
        if (this.variation()>p.getVariationPoids()){
            Alerte alerte = new Alerte("PoidsVariation", this.variation(), this.getDate(), 1);
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(Poids.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
