/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elise
 */
public class Gravite {
    //private String nomFichier;
    private ArrayList<Alerte> alertes;
    
    //il faut modifier transmettre pour pas avoir de texte superflu
    public void Gravite(String nomFichier){
        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader(nomFichier));
            String ligne;
            String delimiteurs = " ,.;";
            ligne = fichier.readLine();
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
            while (ligne!=null){
                long date=Long.parseLong(tokenizer.nextToken()); //revoir
                String type=tokenizer.nextToken();
                float valeur = Float.parseFloat(tokenizer.nextToken());
                alertes.add(new Alerte(type,valeur,date));
                ligne=fichier.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Gravite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Gravite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fichier.close();
            } catch (IOException ex) {
                Logger.getLogger(Gravite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public float frequence(long dateDeb, long dateFin){
        return 0;
    }
    
}
