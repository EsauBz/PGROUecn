/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author antoi
 * définit les paramètres généraux d'une alerte ainsi que sont écriture dans un fichier texte
 */
public class Alerte {

    /**
     *
     */
    protected String type;

    /**
     *
     */
    protected float valeur;

    /**
     *
     */
    protected long date;
   // private int gravite;

    /**
     *
     * @param type
     * @param valeur
     * @param date
     */
    public  Alerte(String type, float valeur, long date) {
        this.type = type;
        this.valeur = valeur;
        this.date = date;
    }
    
    /**
     *
     */
    public Alerte (){
        this.type = "";
        this.valeur = 0;
        this.date =0;
        //this.gravite = 0;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public float getValeur() {
        return valeur;
    }

    /**
     *
     * @param valeur
     */
    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    /**
     *
     * @return
     */
    public long getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(long date) {
        this.date = date;
    }

   /* public int getGravite() {
        return gravite;
    }

    public void setGravite(int gravite) {
        this.gravite = gravite;
    }*/
    
    
    /*
    écrit l'alerte dans un fichier nommé alertes.txt. si le fichier n'existe pas, il est créé. 
    Si il existe, l'alerte est écrite à la suite dans le fichier.
    */

    /**
     * Ecriture dans un fichier toutes les alertes, au fur et à mesure
     * @throws IOException
     */

    public void transmettre() throws IOException{
        try (BufferedWriter fichier = new BufferedWriter(new FileWriter("dépassements.txt",true))) {
        fichier.append(" Date : " + new Date(this.date * 1000) + " dépassements dans la mesure: " + this.type + " [Varition: "+ this.valeur + "]");
        fichier.newLine();
        }
        
        try (BufferedWriter fichierSystem = new BufferedWriter(new FileWriter("alerteSystem.txt",true))) {
            fichierSystem.append(this.date +" "+ this.type +" " + this.valeur);
            fichierSystem.newLine();
        }
        
    }
    
    /**
     *
     * @param typeA
     * @param dateA
     * @throws IOException
     */
    public void transmissionAlerte(String typeA, long dateA) throws IOException{
        try (BufferedWriter fichier = new BufferedWriter(new FileWriter("Alertes.txt",true))) {
        fichier.append(" Date : " + new Date(dateA) + " Alerte de type: " + typeA);
        fichier.newLine();
        }
        
    }
        
}
