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
public class SpirometrieMacro extends MesureVariation{

    public SpirometrieMacro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("");
    }
    //Compare avec la valeur de la variation avec la valeur limite
    @Override
    public void analyse(Parametres p){
        if (this.variation()>p.getVariationSpiro()){
            Alerte alerte = new Alerte("SpirometrieMacroVariation", this.variation(), this.getDate(), 1);
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(SpirometrieMacro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (this.getValeur()>p.getSpirometrieHaut()||this.getValeur()<p.getSpirometrieBas()){
            Alerte alerte = new Alerte("SpirometrieMacro", this.getValeur(), this.getDate(), 2);
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(SpirometrieMacro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //appelle lire de mesureVariation, avec t le temps min entre deux mesures

    
}
