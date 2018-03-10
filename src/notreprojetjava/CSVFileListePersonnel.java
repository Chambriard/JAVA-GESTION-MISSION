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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class CSVFileListePersonnel extends CSVFile {
    
    // Attributs
    private ArrayList<Employe> lesEmployes;
    
    // Accesseurs
     public ArrayList<Employe> getList(){
        return lesEmployes ;
    }
     
    //Constructeur
    /**
     * Constructeur qui permet de définir le CSV a interroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileListePersonnel() throws FileNotFoundException {
        //super();
        nom = "liste_personnel.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        sc = new Scanner(new FileReader(path));
        lesEmployes = new ArrayList<Employe>();
    }
    
   
    //Méthodes
    /**
     * Dans le CSV Liste_personnel nous avons l'ensemble du personnel
     * cette méthode permet de récupérer les employés et de les définir dans la
     * liste lesEmployes
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public void recupEmployes() throws FileNotFoundException, ParseException{
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            //SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy");
            //Date d = sdf.parse(chaineDecoupe[2]);
            lesEmployes.add(new Employe(chaineDecoupe[3], chaineDecoupe[1], chaineDecoupe[0], chaineDecoupe[2]));
        }
    }
    
    public void afficher(){
        for(Employe monEmploye : lesEmployes){
            System.out.println(monEmploye.toString());
        }
    }
    
    /**
     * Retourne la liste des Employes au format CSV.
     * Utilisée pour la sauvegarde.
     * @return 
     */
    public String lireListe(){
        String liste = "";
        
        for(Employe unEmploye : lesEmployes){
            liste += unEmploye.getPrenom() + ";" + unEmploye.getNom() + ";" + unEmploye.getDate() + ";" + unEmploye.getId() + "\r\n";
        }
        
        return liste;
    }
    
    /**
     * Sauvegarde la liste actuelle des Employes dans un fichier
     * @throws IOException 
     */
    public void sauvegarder() throws IOException{
        FileWriter fichier = new FileWriter(this.path);
        fichier.write(lireListe());
        fichier.close();
        
        System.out.println("Ecriture OK");
    }
    
    /**
     * Récupère l'ID max de la liste des employés
     * @return 
     */
    public int recupIdMax(){
        Employe e = lesEmployes.get(this.lesEmployes.size() - 1);
        
        return Integer.valueOf(e.getId());
    }
    
    /**
     * Permet de créer un nouvel Employe, puis l'ajoute à la liste des Employés
     * @param nom
     * @param prenom
     * @param date
     * @throws FileNotFoundException 
     */
    public void ajoutEmp(String nom, String prenom, String date) throws FileNotFoundException{
        // Récupération automatique de l'ID
        Employe e = new Employe(String.valueOf(this.recupIdMax() + 1), nom, prenom, date);
        lesEmployes.add(e);
    }
}
