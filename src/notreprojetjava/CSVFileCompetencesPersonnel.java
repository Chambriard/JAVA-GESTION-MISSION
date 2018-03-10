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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileCompetencesPersonnel extends CSVFile {
    
    // Attributs
    private HashMap<String, ArrayList<String>> lesCompEmployes;
    
    // Accesseurs
     public HashMap<String, ArrayList<String>> getList(){
        return lesCompEmployes ;
    }
    
    /**
     * Constructeur sans argument permet de définir le fichier à intéroger
     * et de d'instancier le scanner pour lire le fichier
     * @throws FileNotFoundException 
     */
    public CSVFileCompetencesPersonnel() throws FileNotFoundException {
        nom = "competences_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        lesCompEmployes = new HashMap<String, ArrayList<String>>();
    }
    /**
     * Permet pour chaque employé de la liste lesEmp, de lui affecter les compétences
     * qu'il détient. les compétences que détient un employé sont décritent dans le fichier
     * CSV compétence_personnel.
     * lesComp est une liste de compétences qui détient toutes les compétences
     * lesEmp est une liste d'employé qui détient tout les employés don les compétences
     * ne sont pas instanciés
     * @param lesComp
     * @param lesEmp 
     */
    public void recupCompetencesPersonnel(ArrayList<Competence> lesComp, ArrayList<Employe> lesEmp){
        //récupération des num employés dans la list du CSVEmployé avec leur compétence associé 
        // dans la list du CSVComp
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            String idEmp ;
            chaineDecoupe = sc.nextLine().split(";");
            // Je met dans idEmp l'id de l'employé pris dans le fichier CSV
            idEmp = chaineDecoupe[0];
            // je définie un nouvelle employé avec cette id
            Employe monEmpFichier = new Employe(idEmp) ;
            // Je parcour la list des employé donnée en paramêtre, cette liste est
            //composé de tout les employés de l'entreprise mais il manque leurs compétences
            for(Employe unEmpList : lesEmp){
                if (unEmpList.equals(monEmpFichier)){
                    int i = 1; 
                    // dans le CSVFile la première Colonne donc la case 0 pour notre
                    // tableau chaineDecoupe correspond à l'id de l'employé
                    // ici nous parton donc de l'indice 1 qui correspond à la
                    // desième colonne dans le fichier CSV et qui contient la première
                    // Compétence de l'employé. Ensuit tant qu'il reste des compétence
                    // nous continuons à parcourir les colonnes du CSV présente maintenant 
                    // dans notre tableau chaineDecoupe
                    while(i< chaineDecoupe.length){
                        Competence uneComFiche = new Competence(chaineDecoupe[i]);
                        for(Competence uneCompList : lesComp){
                            if(uneComFiche.equals(uneCompList)){
                                unEmpList.ajouterComp(uneCompList);
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }
    
    // Recupération dans une HashMap des infos telles quelles
    public void recup2(){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            
            ArrayList<String> listeComp = new ArrayList<String>();
            
            int cpt = 1;
            while(cpt < chaineDecoupe.length){
                listeComp.add(chaineDecoupe[cpt]);
                cpt++;
            }
            
            this.lesCompEmployes.put(chaineDecoupe[0], listeComp);
            //System.out.print("ok");
            //SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
            //Date d = sdf.parse(chaineDecoupe[2]);
            //lesEmployes.add(new Employe(chaineDecoupe[3], chaineDecoupe[1], chaineDecoupe[0], chaineDecoupe[2]));
        }
    }
    
    /**
     * Retourne la liste des Competences des Employes au format CSV.
     * Utilisée pour la sauvegarde.
     * @return 
     */
    public String lireListe(){
        String liste = "";
        
        for(String key : lesCompEmployes.keySet()){
            liste += key + ";";
            
            ArrayList<String> LesComp = lesCompEmployes.get(key);
            for(String c : LesComp){
                liste += c + ";";
            }
            
            liste += "\r\n";
        }
        
        return liste;
    }
    
    /**
     * Sauvegarde la liste actuelle des Competences des Employes dans un fichier
     * @throws IOException 
     */
    public void sauvegarder() throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(lireListe());
        fichier.close();
        
        System.out.println("Ecriture OK");
    }
    
    //public void ajoutComp()
    
}
