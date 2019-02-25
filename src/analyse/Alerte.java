/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;
//test Elise 2
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
    private String type;
    private float valeur;
    private long date;
    private int gravite;

    public Alerte(String type, float valeur, long date, int gravite) {
        this.type = type;
        this.valeur = valeur;
        this.date = date;
        this.gravite = gravite;
    }
    
    public Alerte (){
        this.type = "";
        this.valeur = 0;
        this.date =0;
        this.gravite = 0;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getGravite() {
        return gravite;
    }

    public void setGravite(int gravite) {
        this.gravite = gravite;
    }
    
    
    /*
    écrit l'alerte dans un fichier nommé alertes.txt. si le fichier n'existe pas, il est créé. 
    Si il existe, l'alerte est écrite à la suite dans le fichier.
    */
    public void transmettre() throws IOException{
        try (BufferedWriter fichier = new BufferedWriter(new FileWriter("alertes.txt",true))) {
        fichier.append("Date : "+new Date(this.date * 1000) +" // Alerte de type "+this.gravite+" : "+ this.type+" a atteint "+ this.valeur);
        fichier.newLine();
        }
        
    }
}
