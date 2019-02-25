/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * Attention : pour les classes héritées de celle-ci, analise
 * @author antoi
 */
public abstract class MesureMoyenneJournee extends Mesure{
    private int nbMesure;
    private float moyenneJournee;
    private long debut;

    public MesureMoyenneJournee(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier,liste);
        this.nbMesure = 0;
        this.moyenneJournee = 0;
        this.debut=0;
    }

    public int getNbMesure() {
        return nbMesure;
    }

    public void setNbMesure(int nbMesure) {
        this.nbMesure = nbMesure;
    }

    public float getMoyenneJournee() {
        return moyenneJournee;
    }

    public void setMoyenneJournee(float moyenneJournee) {
        this.moyenneJournee = moyenneJournee;
    }

    public long getDebut() {
        return debut;
    }

    public void setDebut(long debut) {
        this.debut = debut;
    }
    
    
    //On lit la valeur suivante, si la date est identique on met à jour la valeur et on fait +1 sur le nbMesure
    //Sinon, on lance analyse sur la moyenne, on met à 1 nb mesure et moyenne à la valeur mesurée

    /**
     *On lit la valeur suivante, si la date est identique on met à jour la valeur et on fait +1 sur le nbMesure
     *Sinon, on lance analyse sur la moyenne, on met à 1 nb mesure et moyenne à la valeur mesurée
     * @param p paramètre du patient
     */
    @Override
    public void miseAjour(Parametres p) {
        if (this.lire())
                 {
            if (this.getDate() - this.debut < 86400) {
                this.moyenneJournee = (this.moyenneJournee * this.nbMesure + this.getValeur()) / (this.nbMesure + 1);
                this.nbMesure++;
            } else {
                this.analyse(p);
                this.moyenneJournee = this.getValeur();
                this.nbMesure = 1;
                this.debut=this.getDate();
            }
        }
    }

}
