/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author achambri
 */
public class CSVFileListeMission extends CSVFile{
    
    // Attributs
    ArrayList<Mission> ensembleMission; 
    
    
   /**
    * Constructeur qui permet de définir le CSV a intéroger et d'intancier le scanner 
    * pour pouvoir parcourir le CSV
    * @throws FileNotFoundException 
    */
    public CSVFileListeMission() throws FileNotFoundException {
        nom = "liste_Mission.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path));
        ensembleMission = new ArrayList<Mission>();   
    }
    
    // Accesseurs
    public ArrayList<Mission> getList(){
        return ensembleMission ;
    }
    
    // Méthodes
    /**
     * Permet de récupérer les missions dans le CSV et de les instancier dans la 
     * liste de Mission ensembleMission
     * @throws FileNotFoundException
     * @throws ParseException 
     */
    public void recupMission() throws FileNotFoundException, ParseException{
        while(sc.hasNextLine()) {
            int statut ;
            int nbPersoMax;
            Date dateDeb ;
            Date dateFin ;
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            statut = Integer.parseInt(chaineDecoupe[2]);
            nbPersoMax = Integer.parseInt(chaineDecoupe[5]);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            dateDeb = formatter.parse(chaineDecoupe[3]);
            dateFin = formatter.parse(chaineDecoupe[4]);
            ensembleMission.add(new Mission(chaineDecoupe[0], chaineDecoupe[1], statut, dateDeb,dateFin,nbPersoMax));
        }
    }
    
    public void afficher(){
        for(Mission maMission : ensembleMission){
            System.out.println(maMission.toString());
        }
    }
    
}