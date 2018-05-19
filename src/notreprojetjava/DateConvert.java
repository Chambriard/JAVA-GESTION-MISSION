/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Utilisateur
 */
public class DateConvert {
    
    // Méthodes
    public Date currentDate(){
        return new Date();
    }
    
    /**
     * Convertie une date extraite d'un fichier CSV en format Date
     * @param date
     * @return date 
     * @throws ParseException 
     */
    public Date convertStrDate(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.parse(date);
    }
    
    /**
     * Convertie une Date en String afin de la sauvegarder dans un fichier CSV
     * @param date
     * @return date
     */
    public String convertDateStr(Date date){
        DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return shortDateFormat.format(date) ;
    }
    
}
