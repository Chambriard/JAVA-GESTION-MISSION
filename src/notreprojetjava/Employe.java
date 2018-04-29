/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Utilisateur
 */
public class Employe implements IEntite {
    
    // Attributs
    private String id;
    private String nom;
    private String prenom;
    private Date dateE;
    private ArrayList<Competence> lesCompetences;
    
    // Constructeur
    public Employe (String id , String nom, String prenom, String dateE) throws FileNotFoundException, ParseException{
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        DateConvert dc = new DateConvert();
        this.dateE = dc.convertStrDate(dateE);
        lesCompetences = new ArrayList<Competence>() ;
    }
    
    // Accesseurs
    public String getId(){
        return id ;
    }
    
    public String getPrenom(){
        return prenom ;
    }
    
    public String getNom(){
        return nom ;
    }
    
    public Date getDate(){
        return dateE;
    }
    
    public ArrayList<Competence> getCompetences(){
        return lesCompetences;
    }
    
    public void setNom(String n){
        nom = n;
    }
    
    public void setPrenom(String p){
        prenom = p;
    }
    
    public void setDateE(String d) throws ParseException{
        DateConvert dc = new DateConvert();
        this.dateE = dc.convertStrDate(d);
    }
    
    // Méthodes
    
    /**
     * Affiche les compétences de l'employé
     */
    public void afficherComp(){
        System.out.println("Compétences de " + prenom + " " + nom + " : \n");
        for(Competence c : lesCompetences){
            System.out.println(c.toString());
        }
    }
    
    /**
     * Ajoute une compétence à l'employé
     * @param c 
     */
    public void addComp(Competence c){
        System.out.print("COUCOU3");
        System.out.println(c.getId());
        lesCompetences.add(c);
    }
    
    /**
     * Supprime une compétence de l'employé
     * @param c 
     */
    public void delComp(Competence c){
        if(lesCompetences.contains(c))
            lesCompetences.remove(c);
    }
    
    /**
     * Description de l'employé
     * @return 
     */
    public String toString(){
        DateConvert dc = new DateConvert();
        String date = dc.convertDateStr(dateE);
        String chaine;
        chaine =  prenom + " " + nom + " - Date d'entrée en entreprise : " + date + ".";
        
        return chaine ;
    }
    
    /**
     * Renvoie l'employé au format CSV
     * @return 
     */
    public String formatCSV(){
        DateConvert dc = new DateConvert();
        String date = dc.convertDateStr(dateE);
        return prenom + ";" + nom + ";" + date + ";" + id + "\n";
    }
    
    /**
     * Renvoie les compétences de l'employé au format CSV
     * @return 
     */
    public String formatCSVComp(){
        String res = id + ";";
        for(Competence c : lesCompetences){
            res += c.getId() + ";";
        }
        res += "\n";
        return res;
    }

    
}
