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
public class CSVFileMissEmp extends CSVFile {
    
    // Attributs
    private String oldFile;
    private String newFile;
    
    // Constructeur
    /**
     * Constructeur qui permet de définir le CSV a intéroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileMissEmp() throws FileNotFoundException {
        nom = "mission_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        oldFile = "";
        newFile = "";
    }
    
    // Méthodes
    
    /**
     * Permet de récupérer une Mission d'une liste via son ID
     * @param id
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
     * Permet de récupérer un Employe d'une liste via son ID
     * @param id
     * @param listeEmployes
     * @return 
     */
    public Employe recupEmpById(String id, ArrayList<Employe> listeEmployes){
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
     * Permet de récupérer les informations du fichier "mission_competences.csv" ...
     * ... puis remplit la Hashmap de compétences des missions concernées 
     * @param listeEmployes
     * @param listeMissions 
     */
    public void recupMissEmp(ArrayList<Employe> listeEmployes, ArrayList<Mission> listeMissions){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            Mission m = recupMissById(chaineDecoupe[0], listeMissions);
            
            int i = 1;
            while(i < chaineDecoupe.length){
                if(m.eqNotComplete()){
                    m.addEmpMiss(recupEmpById(chaineDecoupe[i], listeEmployes));
                    i++;
                }
            }
            
        }
    }
    
    /**
     * Génère une chaîne de caractère au format CSV pour l'équipe d'une mission.
     * @param listeMissions
     * @return csv
     */
    public String genererCSV(ArrayList<Mission> listeMissions){      // voir lireListe()
        String csv = "";

        for(Mission m : listeMissions){
            csv += m.formatCSVEmp();
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
        
        System.out.println("Equipes des missions enregistrées !");
    }
}
