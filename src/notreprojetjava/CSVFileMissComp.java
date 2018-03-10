/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileMissComp extends CSVFile{
    
    // Attributs
    private String oldFile;
    private String newFile;
    
    // Constructeur
    /**
     * Constructeur qui permet de définir le CSV a intéroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileMissComp() throws FileNotFoundException {
        nom = "mission_competences.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        oldFile = "";
        newFile = "";
    }
    
    // Méthodes
    
    /**
     * Permet de récupérer une Mission d'une liste via son ID
     * @param id
     * @param listeMissions
     * @return 
     */
    public Mission recupMissById(String id, ArrayList<Mission> listeMissions){
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
    
    /**
     * Permet de récupérer une Compétence d'une liste via son ID
     * @param id
     * @param listeCompetences
     * @return 
     */
    public Competence recupCompById(String id, ArrayList<Competence> listeCompetences){
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
     * Permet de récupérer les informations du fichier "mission_competences.csv" ...
     * ... puis remplit la Hashmap de compétences des missions concernées
     * @param listeCompetences 
     * @param listeMissions 
     */
    public void recupMissComp(ArrayList<Competence> listeCompetences, ArrayList<Mission> listeMissions){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            Mission m = recupMissById(chaineDecoupe[0], listeMissions);
            
            int i = 1;
            while(i < chaineDecoupe.length){
                m.getCompRemp().put(recupCompById(chaineDecoupe[i], listeCompetences), Integer.parseInt(chaineDecoupe[i + 1]));
                m.getCompReq().put(recupCompById(chaineDecoupe[i], listeCompetences), Integer.parseInt(chaineDecoupe[i + 1]));
                i = i + 2;
            }
            
        }
    }
    
    /**
     * Génère une chaîne de caractère au format CSV pour les compétences d'une mission.
     * @param listeMissions
     * @return 
     */
    public String genererCSV(ArrayList<Mission> listeMissions){
        String csv = "";

        for(Mission m : listeMissions){
            csv += m.formatCSVComp();
        }
        //newFile = csv;
        return csv;
    }
    
    /**
     * Sauvegarde la liste actuelle des Employes dans un fichier
     * @throws IOException 
     */
    public void sauvegarder(ArrayList<Mission> listeMissions) throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(genererCSV(listeMissions));
        fichier.close();
        
        System.out.println("Compétences requises pour les missions enregistrées !");
    }
}
