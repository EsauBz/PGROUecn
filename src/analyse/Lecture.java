/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Lecture {

    /**
     * fichier stocke le fichier Json Ã  lire sous la forme d'un objet JSONObject
     * liste contient la liste contenue dans le fichier sous la forme d'un objet JSONArray
     */
    private final JSONObject fichier;
    private final JSONArray liste;
    
    /**
     * initialise les attributs fichier et liste avec les paramètres d'entrée
     * @param nomFichier
     * @param nomListe
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException 
     */
    public Lecture(String nomFichier, String nomListe) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(nomFichier));
        JSONObject jsonObject = (JSONObject) object;
        this.fichier = jsonObject;
        this.liste = (JSONArray) jsonObject.get(nomListe);
    }

    /**
     * retourne la valeur du paramètre nom à la ligne numLigne
     * @param numLigne
     * @param nom
     * @return 
     */
    public long getVal(int numLigne, String nom) {
        JSONObject ligne = (JSONObject) this.liste.get(numLigne);
        long res = new Double(ligne.get(nom).toString() ).longValue();
        return res;
    }
    /**
     * retourne le nombre de lignes dans la liste
     * @return 
     */
    public long getNbLignes(){
        return (long) this.fichier.get("CurrentRecordCount");
    }
}
