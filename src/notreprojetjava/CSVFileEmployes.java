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
public class CSVFileEmployes extends CSVFile {
    
    // Attributs
    private String oldFile;
    private String newFile;

    // Constructeur
    /**
     * Constructeur
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public CSVFileEmployes() throws FileNotFoundException, ParseException {
        nom = "liste_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        sc = new Scanner(new FileReader(path));
        oldFile = "";
        newFile = "";
        //recupEmployes();
        //lesEmployes = new ArrayList<Employe>();
    }

    
    //Méthodes
    /**
     * Dans le CSV Liste_personnel nous avons l'ensemble du personnel
     * cette méthode permet de récupérer les employés et de les définir dans la
     * liste lesEmployes
     * @param listeEmployes
     * @return 
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public ArrayList<Employe> recupEmployes(ArrayList<Employe> listeEmployes) throws FileNotFoundException, ParseException{
        while(sc.hasNextLine()) {
            //oldFile += sc.nextLine();
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            listeEmployes.add(new Employe(chaineDecoupe[3], chaineDecoupe[1], chaineDecoupe[0], chaineDecoupe[2]));
        }
        return listeEmployes;
    }
    
    /**
     * Génère une chaîne de caractère au format CSV pour les employés.
     * @param listeEmployes
     * @return 
     */
    public String genererCSV(ArrayList<Employe> listeEmployes){      // voir lireListe()
        String csv = "";

        for(Employe e : listeEmployes){
            csv += e.formatCSV();
        }
        //newFile = csv;
        return csv;
    }
    
    /**
     * Sauvegarde la liste actuelle des Employes dans un fichier
     * @throws IOException 
     */
    public void sauvegarder(ArrayList<Employe> listeEmployes) throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(genererCSV(listeEmployes));
        fichier.close();
        
        System.out.println("Employé enregistré !");
    }
}
