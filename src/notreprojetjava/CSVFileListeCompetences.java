/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Utilisateur
 */
public class CSVFileListeCompetences extends CSVFile {
    //Attribus
    private ArrayList<Competence> ensembleComp ; 
    //Accesseur
    public ArrayList<Competence> getList(){
        return ensembleComp ;
    }
    /**
     * Constructeur qui permet de définir le CSV a intéroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileListeCompetences() throws FileNotFoundException {
        nom = "liste_competences.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        ensembleComp = new ArrayList<Competence>();   
    }
    /**
     * Pertmet de récuppérer les compétence présentes dans le CSV et de les instancier
     * dans la liste de compétence ensembleComp
     */
    public void recupCompetence(){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            Competence maComp = new Competence(chaineDecoupe[0],chaineDecoupe[1],chaineDecoupe[2]);
            ensembleComp.add(maComp);
        }  
    }
    
    public void afficher(){
        for(Competence comp : ensembleComp){
            System.out.println(comp.toString());
        }
    }
    
}
