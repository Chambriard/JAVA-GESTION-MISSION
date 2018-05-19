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
public class CSVFileCompetences extends CSVFile {
    
    // Attributs
    private String oldFile;
    private String newFile;

    // Constructeur
    /**
     * Constructeur qui permet de définir le CSV a interroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileCompetences() throws FileNotFoundException {
        nom = "liste_competences.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        oldFile = "";
        newFile = "";
    }
    
    /**
     * Permet de récupérer les compétences du fichier CSV et de les instancier
     * dans une liste passée en paramètre.
     * @param  listeCompetences
     * @return 
     */
    public ArrayList<Competence> recupCompetences(ArrayList<Competence> listeCompetences){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            Competence maComp = new Competence(chaineDecoupe[0],chaineDecoupe[1],chaineDecoupe[2]);
            listeCompetences.add(maComp);
        }
        return listeCompetences;
    }
    
    /**
     * Génère une chaîne de caractère au format CSV pour les compétences.
     * @param listeCompetences
     * @return 
     */
    public String genererCSV(ArrayList<Competence> listeCompetences){
        String csv = "";

        for(Competence c : listeCompetences){
            csv += c.formatCSV();
        }
        //newFile = csv;
        return csv;
    }
    
    /**
     * Sauvegarde la liste actuelle des Employes dans un fichier
     * @param listeCompetences
     * @throws IOException 
     */
    public void sauvegarder(ArrayList<Competence> listeCompetences) throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(genererCSV(listeCompetences));
        fichier.close();
        
        System.out.println("Compétences enregistrées !");
    }
    
}
