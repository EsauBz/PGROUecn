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
public class TensionMicro extends Mesure{

    public TensionMicro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("");
    }
    
    //compare la tension aux valeurs limites
    @Override
    public void analyse(Parametres p){
        if (this.getValeur()>p.getTensionHaut()||this.getValeur()<p.getTensionBas()){
             Alerte alerte = new Alerte("TensionMacro", this.getValeur(), this.getDate());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(TensionMicro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void miseAjour(Parametres p) {
        if (this.lire()) {
            this.analyse(p);
        }
    }
    
    
}
