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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileMissions extends CSVFile{
    
    // Attributs
    private String oldFile;
    private String newFile;
    
    // Constructeur
   /**
    * Constructeur qui permet de définir le CSV a interroger et d'intancier le scanner 
    * pour pouvoir parcourir le CSV
    * @throws FileNotFoundException 
    */
    public CSVFileMissions() throws FileNotFoundException {
        nom = "liste_mission.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        //ensembleMission = new ArrayList<Mission>();
        oldFile = "";
        newFile = "";
    }
    
    // Méthodes
    /**
     * Permet de récupérer les missions dans le CSV et de les instancier dans une 
     * liste de missions.
     * @param listeMissions
     * @return 
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public ArrayList<Mission> recupMissions(ArrayList<Mission> listeMissions) throws FileNotFoundException, ParseException{
        while(sc.hasNextLine()) {
            //oldFile += sc.nextLine();
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            //listeMissions.add(new Mission(chaineDecoupe[0], chaineDecoupe[1], Integer.parseInt(chaineDecoupe[2]), chaineDecoupe[3], chaineDecoupe[4], Integer.parseInt(chaineDecoupe[5])));
            listeMissions.add(new Mission(chaineDecoupe[0], chaineDecoupe[1], Integer.parseInt(chaineDecoupe[2]), chaineDecoupe[3], chaineDecoupe[4]));
        }
        return listeMissions;        
    }
    
    /**
     * Génère une chaîne de caractère au format CSV pour les missions.
     * @param listeMissions
     * @return 
     */
    public String genererCSV(ArrayList<Mission> listeMissions){      // voir lireListe()
        String csv = "";

        for(Mission m : listeMissions){
            csv += m.formatCSV();
        }
        //newFile = csv;
        return csv;
    }
    
    /**
     * Sauvegarde la liste actuelle des Employes dans un fichier
     * @param listeMissions
     * @throws IOException 
     */
    public void sauvegarder(ArrayList<Mission> listeMissions) throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(genererCSV(listeMissions));
        fichier.close();
        
        System.out.println("Mission enregistrée !");
    }
    
}