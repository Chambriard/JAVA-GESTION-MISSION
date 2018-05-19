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
public class CSVFileEmpComp extends CSVFile {
    
    // Attributs
    private String oldFile;
    private String newFile;
       
    /**
     * Constructeur qui permet de définir le CSV a interroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileEmpComp() throws FileNotFoundException {
        nom = "competences_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        oldFile = "";
        newFile = "";
    }
        
    /**
     * Permet de récupérer un Employe d'une liste via son ID
     * @param string id
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
     * Permet de récupérer les informations du fichier "competences_personnel.csv" ...
     * ... puis remplit la liste de compétences des employés concernés
     * @param listeCompetences
     * @param listeEmployes 
     */
    public void recupEmpComp(ArrayList<Competence> listeCompetences, ArrayList<Employe> listeEmployes){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            Employe e = recupEmpById(chaineDecoupe[0], listeEmployes);
            
            int i = 1;
            while(i < chaineDecoupe.length){
                e.getCompetences().add(recupCompById(chaineDecoupe[i], listeCompetences));
                i++;
            }
            
        }
    }
    
    /**
     * Génère une chaîne de caractère au format CSV pour les compétences d'un employé.
     * @param listeEmployes
     * @return 
     */
    public String genererCSV(ArrayList<Employe> listeEmployes){      // voir lireListe()
        String csv = "";

        for(Employe e : listeEmployes){
            csv += e.formatCSVComp();
        }
        //newFile = csv;
        return csv;
    }
    
    /**
     * Sauvegarde la liste actuelle des Employes dans un fichier
     * @param listeEmployes
     * @throws IOException 
     */
    public void sauvegarder(ArrayList<Employe> listeEmployes) throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(genererCSV(listeEmployes));
        fichier.close();
        
        System.out.println("Compétences des employés enregistrées !");
    }
    
}
