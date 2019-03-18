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
public class Glycemie extends MesureVariation{

    public Glycemie(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("BG");
    }
    
    

    /**
     *Compare avec la valeur de la variation avec la valueur limite
     * @param p Paramètre du patient
     */
    @Override
    public void analyse(Parametres p) {
        if (this.variation()>p.getVariationGlycemie()){
            Alerte alerte = new Alerte("GlycemieVariation", this.variation(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(Glycemie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getValeur()>p.getGlycemieHaut()||this.getValeur()<p.getGlycemieBas()){
            Alerte alerte = new Alerte("Glycemie", this.getValeur(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(Glycemie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
}
