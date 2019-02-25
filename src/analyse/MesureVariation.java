/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.abs;
import org.json.simple.parser.ParseException;

/**
 *
 * @author antoi
 */
public abstract class MesureVariation extends Mesure {
    //pour les variations, on staock les dernières valeurs collectées
    private float val1;
    private long date1;
    private float val2;
    private long date2;
    private float val3;
    private long date3;

    public MesureVariation(String nomFichier, String liste) throws IOException, FileNotFoundException, ParseException {
        super(nomFichier,liste);
        this.val1 = 0;
        this.val2 = 0;
        this.val3 = 0;
        this.date1=0;
        this.date2=0;
        this.date3=0;
    }

    public long getDate1() {
        return date1;
    }

    public void setDate1(long date1) {
        this.date1 = date1;
    }

    public long getDate2() {
        return date2;
    }

    public void setDate2(long date2) {
        this.date2 = date2;
    }

    public long getDate3() {
        return date3;
    }

    public void setDate3(long date3) {
        this.date3 = date3;
    }

    public float getVal1() {
        return val1;
    }

    public void setVal1(float val1) {
        this.val1 = val1;
    }

    public float getVal2() {
        return val2;
    }

    public void setVal2(float val2) {
        this.val2 = val2;
    }

    public float getVal3() {
        return val3;
    }

    public void setVal3(float val3) {
        this.val3 = val3;
    }
    
    
    //Renvoie la variation sur les valeurs stockées en valeur absolue par unité de temps
    public float variation(){
        if (val3==0){
            return 0;
        }
        return (abs ((val1-val2)/2/(date1-date2)) + abs((val2-val3)/2/(date1-date2)))/2;
    }
    
    /*
    *on appelle lire de super
    *Mettre à jour les valeurs stockées
    *Si la date est trop proche de celle de la dernière valeur stockée (temps t), on ne stock pas la valeur
    */
    @Override
    public void miseAjour(Parametres p) {
        if (super.lire())
        {
            if (this.getDate() - (long) this.date1 > p.getTempsGlycemie()) {
                val3 = val2;
                date3 = date2;
                val2 = val1;
                date2 = date1;
                val1 = this.getValeur();
                date1 = this.getDate();
            }
            this.analyse(p);
        }
    }
    
    

    
}
