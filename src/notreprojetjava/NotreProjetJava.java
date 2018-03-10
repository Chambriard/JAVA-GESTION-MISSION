/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class NotreProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
        System.out.println(" *** DEBUT *** ");
        
        Entreprise entreprise = new Entreprise();
        
        Competence c = entreprise.recupCompById("A.1.");
        Mission m = entreprise.recupMissById("M8");
        //m.checkCompReq();
        
        DateConvert d = new DateConvert();
        System.out.println(d.currentDate());
        System.out.println(m.getDateDeb());
    }
    
}
