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
public class TensionMacro extends MesureMoyenneJournee{

    public TensionMacro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("");
    }
    
    
     @Override
    //compare la moyenne de la journée à la valeur définie dans les paramètres
    public void analyse(Parametres p){
        if (p.getTensionHautJour()<this.getMoyenneJournee()||p.getTensionBasJour()>this.getMoyenneJournee()||this.getMoyenneJournee()!=0){
            Alerte alerte = new Alerte("TensionMacro", this.getMoyenneJournee(), this.getDebut());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(TensionMacro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
