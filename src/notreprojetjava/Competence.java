/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

/**
 * 
 * @author Utilisateur
 */
public class Competence implements IEntite {
    
    // Attributs
    private String id;
    private String libelleEN;
    private String libelleFR;
    
    // Accesseurs
    public String getId(){
        return id ;
    }
    
    public String getLibelleFR(){
        return libelleFR ;
    }
    
    public String getLibelleEN(){
        return libelleEN ;
    }
    
    // Constructeur
    public Competence (String id, String nomAng, String nomFra){
        this.id = id;
        this.libelleEN = nomAng;
        this.libelleFR = nomFra;
    }
    
    // Méthodes
    
    // Ce toString est nécessaire pour la sauvegarde du fichier missions_competences
    public String toString(){
        return id;
        //return id + "\nLibellé Anglais : " + libelleEN + "\nLibellé Français : " + libelleFR;
    }
    
    /*public String returnFormat(){
        return id + ";" + libelleEN + ";" + libelleFR + ";";
    }*/
    
    /**
     * Retourne la compétence au format CSV.
     * @return 
     */
    public String formatCSV(){
        return id + ";" + libelleEN + ";" + libelleFR + ";\n";
    }
}
