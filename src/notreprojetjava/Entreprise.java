/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Utilisateur
 */
public class Entreprise {
    
    // Attributs
    private ArrayList<Employe> listeEmployes;
    private ArrayList<Competence> listeCompetences;
    private ArrayList<Mission> listeMissions;
    private CSVFileEmployes CSVFE;
    private CSVFileCompetences CSVFC;
    private CSVFileEmpComp CSVFCE;
    private CSVFileMissions CSVFM;
    private CSVFileMissComp CSVFMC;
    private CSVFileMissEmp CSVFME;
    
    // Constructeur
    /**
     * Génère toute les listes, et les remplit en fonction du contenu des fichiers CSV.
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public Entreprise() throws FileNotFoundException, ParseException{
        listeEmployes = new ArrayList<Employe>();
        listeCompetences = new ArrayList<Competence>();
        listeMissions = new ArrayList<Mission>();
        CSVFE = new CSVFileEmployes();
        listeEmployes = CSVFE.recupEmployes(listeEmployes);
        CSVFC = new CSVFileCompetences();
        listeCompetences = CSVFC.recupCompetences(listeCompetences);
        CSVFCE = new CSVFileEmpComp();
        CSVFCE.recupEmpComp(listeCompetences, listeEmployes);
        CSVFM = new CSVFileMissions();
        listeMissions = CSVFM.recupMissions(listeMissions);
        CSVFMC = new CSVFileMissComp();
        CSVFMC.recupMissComp(listeCompetences, listeMissions);
        CSVFME = new CSVFileMissEmp();
        CSVFME.recupMissEmp(listeEmployes, listeMissions);
        //generateStatut();
    }
    
    // Accesseurs
    public ArrayList<Employe> getListeEmployes(){
        return listeEmployes;
    }
    
    public ArrayList<Competence> getListeCompetences(){
        return listeCompetences;
    }
    
    public ArrayList<Mission> getListeMissions(){
        return listeMissions;
    }
    
    public CSVFileEmployes getCVSFileEmployes(){
        return CSVFE;
    }
    
    public CSVFileCompetences getCVSFileCompetences(){
        return CSVFC;
    }

    // Méthodes
    /**
     * Affiche la liste des Employés
     */
    public void afficherEmployes(){
        for(Employe e : listeEmployes){
            System.out.println(e.toString());
        }
    }
    
    /**
     * Affiche la liste des Compétences
     */
    public void afficherCompetences(){
        for(Competence c : listeCompetences){
            System.out.println(c.toString());
        }
    }
    
    /**
     * Affiche la liste des Missions
     */
    public void afficherMissions(){
        for(Mission m : listeMissions){
            System.out.println(m.toString());
        }
    }
    
    /**
     * Affiche les compétences d'un employé précis
     * @param e 
     */
    public void afficherEmpComp(Employe e){
        e.afficherComp();
    }
    
    /**
     * Affiche les compétences requises pour une mission
     * @param m 
     */
    public void afficherMissComp(Mission m){
        m.afficherCompReq();
    }
    
    /**
     * Affiche l'équipe actuelle d'une mission
     * @param m 
     */
    public void afficherMissEmp(Mission m){
        m.afficherEquipe();
    }

    /**
     * Récupère l'id le plus grand de la liste des Employés
     * Utile pour attribuer un ID automatique à un nouvel employé
     * @return 
     */
    public int recupIdMaxEmp(){
        if(this.listeEmployes.isEmpty())
            return 1;
        else{
            Employe e = listeEmployes.get(this.listeEmployes.size() - 1);
            return Integer.valueOf(e.getId());
        }
    }
    
    /**
     * Récupère un employé selon un ID
     * @param id
     * @return 
     */
    public Employe recupEmpById(String id){
        boolean trouve = false;
        int i = 0;
        Employe res = null;
        while((!trouve) && (i < listeEmployes.size())){
            if(listeEmployes.get(i).getId().equals(id)){
                trouve = true;
                res = listeEmployes.get(i);
            }
            i++;
        }
        return res;
    }
    
    /**
     * Récupère une compétence selon un ID
     * @param id
     * @return 
     */
    public Competence recupCompById(String id){
        boolean trouve = false;
        int i = 0;
        Competence res = null;
        while((!trouve) && (i < listeCompetences.size())){
            if(listeCompetences.get(i).getId().equals(id)){
                trouve = true;
                res = listeCompetences.get(i);
            }
            i++;
        }
        return res;
    }
    
    /**
     * Récupère une mission selon son ID
     * @param id
     * @return 
     */
    public Mission recupMissById(String id){
        boolean trouve = false;
        int i = 0;
        Mission res = null;
        while((!trouve) && (i < listeMissions.size())){
            if(listeMissions.get(i).getId().equals(id)){
                trouve = true;
                res = listeMissions.get(i);
            }
            i++;
        }
        return res;
    }
    
    public void generateStatut(){
        for(Mission m : listeMissions){
            m.generateStatut();
            System.out.print(m.getStatut());
        }
    }
    
    public void generateStatut(Mission m){
        
            m.generateStatut();
         
    }
    
    /**
     * Créer un nouvel employé et l'ajoute à la liste des employés de l'entreprise
     * @param nom
     * @param prenom
     * @param date
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public void creerEmp(String nom, String prenom, String date) throws FileNotFoundException, ParseException{
        // Récupération automatique de l'ID
        listeEmployes.add(new Employe(String.valueOf(this.recupIdMaxEmp() + 1), nom, prenom, date));
    }
    
    /**
     * Supprime un employé
     * @param e 
     */
    public void delEmp(Employe e){
        listeEmployes.remove(e);
    }
    
    /**
     * Crééer une mission et l'ajoute à la liste des missions de l'entreprise
     * @param id
     * @param libelle
     * @param dateDeb
     * @param dateFin
     * @param nbMaxEmp
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public void creerMission(String id, String libelle, String dateDeb, String dateFin, int nbMaxEmp) throws FileNotFoundException, ParseException{
        listeMissions.add(new Mission(id, libelle, nbMaxEmp, dateDeb, dateFin, 1));
    }
    
    /**
     * Supprime une mission
     * @param m 
     */
    public void delMission(Mission m){
        listeMissions.remove(m);
    }
    
    /**
     * Ajoute une compétence à un employé
     * @param e
     * @param c 
     */
    public void addCompEmp(Employe e, Competence c){
        e.addComp(c);
    }
    
    /**
     * Supprime une compétence d'un employé
     * @param e
     * @param c 
     */
    public void delCompEmp(Employe e, Competence c){
        e.delComp(c);
    }
    
    /**
     * Ajoute une compétence requise pour une mission
     * @param m
     * @param c
     * @param nb 
     */
    public void addCompMiss(Mission m, Competence c, Integer nb){
        m.addCompMiss(c, nb);
    }
    
    /**
     * Ajoute un employé à l'équipe d'une mission
     * @param m
     * @param e 
     */
    public void addEmpMiss(Mission m, Employe e){
        m.addEmpMiss(e);
    }
    
    /**
     * Supprime une compétence d'une mission
     * @param m
     * @param c 
     */
    public void delCompMiss(Mission m, Competence c){
        m.delCompMiss(c);
    }
    
    /**
     * Supprime un employé de l'équipe d'une mission
     * @param m
     * @param e 
     */
    public void delEmpMiss(Mission m, Employe e){
        m.delEmpMiss(e);
    }
    
    // SAUVEGARDE
    /**
     * Sauvegarde les Employés et leurs compétences
     * @throws IOException 
     */
    public void saveEmp() throws IOException{
        CSVFE.sauvegarder(listeEmployes);
        CSVFCE.sauvegarder(listeEmployes);
    }
    
    /**
     * Sauvegarde les compétences
     * @throws IOException 
     */
    public void saveComp() throws IOException{
        CSVFC.sauvegarder(listeCompetences);
    }
    
    /**
     * Sauvegarde les missions, leur équipe et les compétences demandées.
     * @throws IOException 
     */
    public void saveMiss() throws IOException{
        CSVFM.sauvegarder(listeMissions);
        CSVFME.sauvegarder(listeMissions);
        CSVFMC.sauvegarder(listeMissions);
    }
}
