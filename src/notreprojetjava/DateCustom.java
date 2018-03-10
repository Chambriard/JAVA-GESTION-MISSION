/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

/**
 *
 * @author achambri
 */
public class DateCustom {
    int jour ;
    int mois ;
    int annee ;
    public DateCustom(int jour, int mois, int annee){
        this.jour = jour ;
        this.annee = annee ;
        this.mois = mois ;
    }
    public DateCustom(String date){
        // REPRENDRE ICI problème de date
        String[] chaineDecoupe = null;
        chaineDecoupe = date.split("/");
        this.jour = Integer.parseInt(chaineDecoupe[0]);
        this.mois = Integer.parseInt(chaineDecoupe[1]);
        this.annee = Integer.parseInt(chaineDecoupe[2]);
    }
    
    public String afficher(){
        String chaine;
        chaine = "" + this.jour + "/" + this.mois + "/" + this.annee;
        return chaine ;
    }
    
}
