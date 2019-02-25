/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

import java.io.FileNotFoundException;
import java.io.IOException;
import lectureJson.Lecture;
import org.json.simple.parser.ParseException;

/**
 *
 * @author antoi
 */
public abstract class Mesure {
    private long date; //date de la mesure
    private float valeur; //sa valeur
    private int compteur; //le numéro de la mesure
    private String clef; //l'identifiant de la mesure dans le fichier
    private final Lecture fichier; //objet de lectureJson.Lecture permettant la lecture d'un fichier Json
    
    
    
    /**
     *
     * @param nomFichier le nom du fichier à lire
     * @param liste le nom de la liste dans le fichier
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    public Mesure(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        this.date =0;
        this.valeur = 0;
        this.compteur = -1;
        this.fichier = new Lecture (nomFichier, liste);
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public String getClef() {
        return clef;
    }

    public void setClef(String clef) {
        this.clef = clef;
    }

    
    //cherche à lire la ligne suivante, renvoie vrai si une nouvelle ligne liste est créée
    public boolean lire(){
        if (fichier.getNbLignes()-1>this.compteur){
            compteur++;
            this.valeur = fichier.getVal(this.compteur, this.clef);
            this.date=fichier.getVal(this.compteur, "MDate");
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public abstract void miseAjour(Parametres p);
    public abstract void analyse(Parametres p);
}
