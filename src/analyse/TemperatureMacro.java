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
public class TemperatureMacro extends MesureMoyenneJournee{

    public TemperatureMacro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("");
    }
    
    @Override
    public void analyse(Parametres p){
        if (p.getTemperatureHautJour()<this.getMoyenneJournee()||p.getTemperatureBasJour()>this.getMoyenneJournee()||this.getMoyenneJournee()!=0){
            Alerte alerte = new Alerte("TemperatureMacro", this.getMoyenneJournee(), this.getDebut(), 2);
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(TemperatureMacro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
