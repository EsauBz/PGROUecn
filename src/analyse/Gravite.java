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
    public Gravite(String nomFichier){
        BufferedReader fichier = null;
        try {
            fichier = new BufferedReader(new FileReader(nomFichier));
            String ligne;
            String delimiteurs = " ,.;";
            ligne = fichier.readLine();
            StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs);
            alertes = new ArrayList<>();
            while (ligne!=null){               
                long date=Long.parseLong(tokenizer.nextToken()); //revoir
                String type=tokenizer.nextToken();
                float valeur = Float.parseFloat(tokenizer.nextToken());
                alertes.add(new Alerte(type,valeur,date));
                ligne=fichier.readLine();
                if(ligne != null){
                    tokenizer = new StringTokenizer(ligne, delimiteurs);
                }
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

    public ArrayList<Alerte> getAlertes() {
        return alertes;
    }
    
    public int frequence(Date dateDeb, Date dateFin, String type){
        int c=0;
        int duree=(int) ((dateFin.getTime()-dateDeb.getTime())/86400000);  //getTime donne des ms, on veut un résultat en jour
        for (int i=0; i<alertes.size(); i++){
            Date dateA=new Date(alertes.get(i).getDate()*1000);
            if (dateA.after(dateDeb) && dateA.before(dateFin) && alertes.get(i).getType().equals(type)){
                c=c+1;
            }
        }
        return (c/duree); //moyenne du nb d'alertes par jour sur un intervalle donné
    }
    
    public int symptomes(long dateDeb, long dateFin){
        int i = 0;
        int nbSympt = 0;
        ArrayList<String> types = new ArrayList();
        while (i<alertes.size()){
            if ((alertes.get(i).date>=dateDeb)&&(alertes.get(i).date<=dateFin)){
                if (!types.contains(alertes.get(i).type)){
                    nbSympt++;
                    types.add(alertes.get(i).type);
                } 
            }
            i++;
        }
        return nbSympt;
    }
    
    public int niveauAlerte(long dateD, long dateF, String typeAlerte){
        Date dateA=new Date(dateD);
        Date dateB=new Date(dateF);
        //0.4 : 3 alertes sur une semaine
        if ((symptomes(dateD, dateF)==1)&&(frequence(dateA, dateB, "alerteSystem.txt")<0.4)){
            typeAlerte = "Gravite Type 1";
            return 1;
        }
        if ((symptomes(dateD, dateF)>1)||(frequence(dateA, dateB, "alerteSystem.txt")>0.4)){
            typeAlerte = "Gravite Type 2";
            return 2;
        }
        if ((symptomes( dateD, dateF)>1)&&(frequence(dateA, dateB, "alerteSystem.txt")>0.4)){
            typeAlerte = "Gravite Type 3";
            return 3;
        }
        return 0;
    }
    
}
