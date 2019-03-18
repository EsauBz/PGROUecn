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
public class BpmMacro extends MesureMoyenneJournee {

    public BpmMacro(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier, liste);
        this.setClef("HR");
    }

    /**
     *
     * @param p les paramètres du patient
     */
    @Override
    //compare la moyenne de la journée à la valeur définie dans les paramètres
    //Si cette valeur est au dessus de la moyenne de la journée +5, on crée une alerte
    public void analyse(Parametres p) {
        if ((p.getBpmHautJour() < this.getMoyenneJournee() || p.getBpmBasJour() > this.getMoyenneJournee())&&this.getMoyenneJournee()!=0) {
            Alerte alerte = new Alerte("BpmMacro", this.getMoyenneJournee(), this.getDebut());
            try {
                alerte.transmettre();
            } catch (IOException ex) {
                Logger.getLogger(BpmMacro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
