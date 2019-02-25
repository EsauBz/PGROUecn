/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse;

/**
 *
 * @author antoi
 */
public class Parametres {
    
    //constantes du patient
    private String maladiePatient;
    private float bpmRepos; 
    private float bpmEffort;
    private float spirometrieReference; //en Litre
    private float taille; //en cm
    
    //temps entre deux mesures pour les variations en seconde
    private float tempsPoids; //en seconde
    private float tempsBpm; //en seconde
    private float tempsSpiro; //en seconde
    private float tempsTemperature; //en seconde
    private float tempsGlycemie; //en seconde
    
    
    //Seuils d'alerte
    private float bpmHaut;
    private float bpmBas;
    
    private float tensionHaut;
    private float tensionBas;
    
    private float imcHaut;
    private float imcBas;
    
    private float glycemieHaut;
    private float glycemieBas;
    
    private float spirometrieHaut;
    private float spirometrieBas;
    
    private float temperatureHaut;
    private float temperatureBas;
    
    //Seuils variation (en valeur absolue), par seconde
    private float variationBpm;
    private float variationPoids;
    private float variationGlycemie;
    private float variationTemperature;
    private float variationSpiro;
    
    //Seuils moyenne journalière
    private float bpmHautJour; //valeur haute sur une journée
    private float bpmBasJour; //valeur basse sur une journée
    
    private float tensionHautJour; //valeur haute sur une journée
    private float tensionBasJour; //valeur basse sur une journée
    
    private float temperatureHautJour;
    private float temperatureBasJour;
    
    
    private float calorieMin;
    
    
    

    public String getMaladiePatient() {
        return maladiePatient;
    }

    public float getVariationTemperature() {
        return variationTemperature;
    }

    public float getTempsTemperature() {
        return tempsTemperature;
    }

    public void setTempsTemperature(float tempsTemperature) {
        this.tempsTemperature = tempsTemperature;
    }

    public void setVariationTemperature(float variationTemperature) {
        this.variationTemperature = variationTemperature;
    }

    public void setMaladiePatient(String maladiePatient) {
        this.maladiePatient = maladiePatient;
    }

    public float getBpmRepos() {
        return bpmRepos;
    }

    public void setBpmRepos(float bpmRepos) {
        this.bpmRepos = bpmRepos;
    }

    public float getBpmEffort() {
        return bpmEffort;
    }

    public float getTempsGlycemie() {
        return tempsGlycemie;
    }

    public void setTempsGlycemie(float tempsGlycemie) {
        this.tempsGlycemie = tempsGlycemie;
    }

    public void setBpmEffort(float bpmEffort) {
        this.bpmEffort = bpmEffort;
    }

    public float getSpirometrieReference() {
        return spirometrieReference;
    }

    public void setSpirometrieReference(float spirometrieReference) {
        this.spirometrieReference = spirometrieReference;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public float getTempsPoids() {
        return tempsPoids;
    }

    public void setTempsPoids(float tempsPoids) {
        this.tempsPoids = tempsPoids;
    }

    public float getBpmHaut() {
        return bpmHaut;
    }

    public void setBpmHaut(float bpmHaut) {
        this.bpmHaut = bpmHaut;
    }

    public float getBpmBas() {
        return bpmBas;
    }

    public void setBpmBas(float bpmBas) {
        this.bpmBas = bpmBas;
    }

    public float getVariationBpm() {
        return variationBpm;
    }

    public float getBpmHautJour() {
        return bpmHautJour;
    }

    public void setBpmHautJour(float bpmHautJour) {
        this.bpmHautJour = bpmHautJour;
    }

    public float getBpmBasJour() {
        return bpmBasJour;
    }

    public void setBpmBasJour(float bpmBasJour) {
        this.bpmBasJour = bpmBasJour;
    }

    public float getTensionHautJour() {
        return tensionHautJour;
    }

    public void setTensionHautJour(float tensionHautJour) {
        this.tensionHautJour = tensionHautJour;
    }

    public float getTensionBasJour() {
        return tensionBasJour;
    }

    public void setTensionBasJour(float tensionBasJour) {
        this.tensionBasJour = tensionBasJour;
    }

    public float getTemperatureHautJour() {
        return temperatureHautJour;
    }

    public void setTemperatureHautJour(float temperatureHautJour) {
        this.temperatureHautJour = temperatureHautJour;
    }

    public float getTemperatureBasJour() {
        return temperatureBasJour;
    }

    public void setTemperatureBasJour(float temperatureBasJour) {
        this.temperatureBasJour = temperatureBasJour;
    }

    public void setVariationBpm(float variationBpm) {
        this.variationBpm = variationBpm;
    }

    public float getTensionHaut() {
        return tensionHaut;
    }

    public void setTensionHaut(float tensionHaut) {
        this.tensionHaut = tensionHaut;
    }

    public float getTensionBas() {
        return tensionBas;
    }

    public void setTensionBas(float tensionBas) {
        this.tensionBas = tensionBas;
    }

    public float getVariationGlycemie() {
        return variationGlycemie;
    }

    public void setVariationGlycemie(float variationGlycemie) {
        this.variationGlycemie = variationGlycemie;
    }

    public float getImcHaut() {
        return imcHaut;
    }

    public void setImcHaut(float imcHaut) {
        this.imcHaut = imcHaut;
    }

    public float getImcBas() {
        return imcBas;
    }

    public void setImcBas(float imcBas) {
        this.imcBas = imcBas;
    }

    public float getVariationPoids() {
        return variationPoids;
    }

    public void setVariationPoids(float variationPoids) {
        this.variationPoids = variationPoids;
    }

    public float getSpirometrieHaut() {
        return spirometrieHaut;
    }

    public void setSpirometrieHaut(float spirometrieHaut) {
        this.spirometrieHaut = spirometrieHaut;
    }

    public float getSpirometrieBas() {
        return spirometrieBas;
    }

    public void setSpirometrieBas(float spirometrieBas) {
        this.spirometrieBas = spirometrieBas;
    }

    public float getGlycemieHaut() {
        return glycemieHaut;
    }

    public void setGlycemieHaut(float glycemieHaut) {
        this.glycemieHaut = glycemieHaut;
    }

    public float getGlycemieBas() {
        return glycemieBas;
    }

    public void setGlycemieBas(float glycemieBas) {
        this.glycemieBas = glycemieBas;
    }

    public float getCalorieMin() {
        return calorieMin;
    }

    public void setCalorieMin(float calorieMin) {
        this.calorieMin = calorieMin;
    }

    public float getTemperatureHaut() {
        return temperatureHaut;
    }

    public void setTemperatureHaut(float temperatureHaut) {
        this.temperatureHaut = temperatureHaut;
    }

    public float getTemperatureBas() {
        return temperatureBas;
    }

    public void setTemperatureBas(float temperatureBas) {
        this.temperatureBas = temperatureBas;
    }

    public float getVariationSpiro() {
        return variationSpiro;
    }

    public void setVariationSpiro(float variationSpiro) {
        this.variationSpiro = variationSpiro;
    }

    public float getTempsBpm() {
        return tempsBpm;
    }

    public void setTempsBpm(float tempsBpm) {
        this.tempsBpm = tempsBpm;
    }

    public float getTempsSpiro() {
        return tempsSpiro;
    }

    public void setTempsSpiro(float tempsSpiro) {
        this.tempsSpiro = tempsSpiro;
    }
    
    

    

    public Parametres(){
        this.maladiePatient = "";
        this.bpmRepos = 60;
        this.bpmEffort = 110;
        this.spirometrieReference = 80;
        this.taille = 180;
        this.tempsPoids = 100000;
        this.tempsBpm = 10;
        this.tempsSpiro = 30000;
        this.tempsTemperature = 10000;
        this.tempsGlycemie = 50000;
        this.bpmHaut = 100;
        this.bpmBas = 40;
        this.tensionHaut = 20;
        this.tensionBas = 7;
        this.imcHaut = 25;
        this.imcBas = 18;
        this.glycemieHaut = (float) 0.7;
        this.glycemieBas = (float) 1.2;
        this.spirometrieHaut = 28;
        this.spirometrieBas = 42;
        this.temperatureHaut = 39;
        this.temperatureBas = 36;
        this.variationBpm = (float) 0.0001;
        this.variationPoids = (float) 0.0005;
        this.variationGlycemie = (float) 0.0005;
        this.variationTemperature = 1;
        this.variationSpiro = 84;
        this.bpmHautJour = 80;
        this.bpmBasJour = 50;
        this.tensionHautJour = 15;
        this.tensionBasJour = 8;
        this.temperatureHautJour = 38;
        this.temperatureBasJour = 36;
        this.calorieMin = 1500;
    }
    
    /*
    Des fonctions à implémenter qui permettrait de faciliter le remplissage de ce paramètres
    De plus amples recherches sont nécessaires auprès de personnels de santé


    //ajuster constante du patient
    public void miseAJour(){
        
    }
    
    //permet au médecin de personnaliser les seuils
    public void personnaliserSeuils(){
        
    }
    
    //permet à partir d'une mesure de personnaliser les seuils du patient automatiquement
    public void priseMesure(){
        
    }

    */
}
