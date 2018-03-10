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
 * @author ACHAMBRI
 */
public class CSVFileListeMissionCompetences extends CSVFile{
    
    // Constructeur
    /**
     * Constructeur qui permet de définir le CSV a intéroger et d'intancier le scanner 
     * pour pouvoir parcourir le CSV
     * @throws FileNotFoundException 
     */
    public CSVFileListeMissionCompetences() throws FileNotFoundException {
        nom = "liste_MissionCompetences.csv";
        path = System.getProperty("user.dir") + "\\data\\" + nom;
        this.sc = new Scanner(new FileReader(path)); 
    }
    
    // Méthodes
    /**
     * Cette méthode permet d'intancier les listes de compétence dans les missions de 
     * la liste de mission passé en paramêtre( cette liste sera la liste de mission de la classe CSVFileMission)
     * @param lesMissions
     * @param lesCompetences 
     */
    public void recupCompRequise(ArrayList<Mission> lesMissions,ArrayList<Competence> lesCompetences){
        while(sc.hasNextLine()) {
            String[] chaineDecoupe = null;
            chaineDecoupe = sc.nextLine().split(";");
            for(Mission uneMiss : lesMissions){
                if(uneMiss.getId().equalsIgnoreCase(chaineDecoupe[0])){
                    int i = 1;
                    while(i< chaineDecoupe.length){
                        Competence compRetenus = null;
                        int nbRequis ;
                        for(Competence uneComp : lesCompetences){
                            if(uneComp.getId().equalsIgnoreCase(chaineDecoupe[i])){
                                compRetenus = uneComp ;
                            }
                        }
                        nbRequis = Integer.parseInt(chaineDecoupe[i+1]);
                        uneMiss.CompReq.put(compRetenus, nbRequis) ;
                        i = i + 2 ;
                        
                    }
                }
            }
        }
    }
    
}
