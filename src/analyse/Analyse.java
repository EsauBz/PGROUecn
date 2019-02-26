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
 *
 * @author antoi
 */
public class Analyse {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws org.json.simple.parser.ParseException
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException {
        /*Utilisation du programme :
        Créer les paramètres du patient en accord avec le médecin.
        Créer une mesure du type que l'on souhaite analyser. Ne pas oublier de vérifier si la clef correspond à celle dans le fichier
        Pour utiliser le programme, il suffit de lancer la fonction miseAjour(Parametres p)
        */
        Parametres p = new Parametres();
        BpmMicro m = new BpmMicro("Données","BPDataList");
        Poids po = new Poids("DonnéesPoids","WeightDataList");
        for (int i = 0; i < 500; i++) {
            m.miseAjour(p);
            po.miseAjour(p);
        }

    }
    
}
