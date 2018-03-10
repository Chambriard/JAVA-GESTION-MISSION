/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Utilisateur
 */
public class Mission implements IEntite {
    
    // Attributs
    private String id;
    private String libelle;
    private int nbMaxEmp;
    private Date dateDeb;
    private Date dateFin;
    private int statut;
    HashMap<Competence, Integer> compReq;
    ArrayList<Employe> equipe;
    
    // Constructeur
    public Mission(String id, String libelle, int nbMaxEmp, String dateDeb, String dateFin, int statut) throws ParseException{
        this.id = id;
        this.libelle = libelle;
        this.statut = statut;
        DateConvert dc = new DateConvert();
        this.dateDeb = dc.convertStrDate(dateDeb);
        this.dateFin = dc.convertStrDate(dateFin);
        this.nbMaxEmp = nbMaxEmp;
        compReq = new HashMap<Competence, Integer>();
        equipe = new ArrayList<Employe>();
    }
    
   
    // Accesseurs
    // Getter
    public String getId(){
        return id;
    }
    
    public String getLibelle(){
        return libelle;
    }
    
    public int getStatut(){
        return statut;
    }
        
    public Date getDateDeb(){
        return dateDeb;
    }
    
    public Date getDateFin(){
        return dateFin;
    }
    
    public int getNbMaxEmp(){
        return nbMaxEmp;
    }
    
    public HashMap<Competence, Integer> getCompReq(){
        return compReq;
    }
    
    public ArrayList<Employe> getEquipe(){
        return equipe;
    }
    
    // Setter
    public void setStatut(int s){
        statut = s;
    }
    
    public void setNbMaxEmp(int nb){
        nbMaxEmp = nb;
    }
        
    // Méthodes

    public void afficherCompReq(){
        System.out.println("Compétences requises pour la mission " + id + " - " + libelle + " : \n");
        for (Map.Entry c : compReq.entrySet()){
            System.out.println(c.getKey());
            System.out.println("Nombre de personnes requises : " + c.getValue() + ".");
        }
    }
    
    public void afficherEquipe(){
        System.out.println("Equipe de la mission " + id + " - " + libelle + " : \n");
        for(Employe e : equipe){
            System.out.println(e.toString());
        }
    }
    
    public String toString(){
        DateConvert dc = new DateConvert();
        String dateD = dc.convertDateStr(this.dateDeb);
        String dateF = dc.convertDateStr(this.dateFin);
        String chaine;
        chaine =  id + " - " + libelle + " :\nStatut actuel : " + statut + "\nPériode : " + dateD + " - " + dateF + "\nNombre maximum d'amployés : " + nbMaxEmp;
        /*chaine += " - Competences :\n" ;
        for(Competence uneComp : lesCompetences){
            //chaine += uneComp.toStringId();
        }*/
        return chaine ;
    }

    
    /**
     * Permet l'ajout d'une compétence nécessaire à la mission
     * @param comp
     * @param nb 
     */
    public void addCompMiss(Competence c, Integer nbReq){
        if(!compReq.containsKey(c))
            compReq.put(c, nbReq);
        else
            System.out.println("La compétence existe déjà dans la mission");
    }
    
    /**
     * Supprime une compétence nécessaire à la mission 
     * @param c
     */
    public void delCompMiss(Competence c){
        if(compReq.containsKey(c))
            compReq.remove(c);
        else
            System.out.println("La compétence n'existe pas dans la mission");
    }
    
    /**
     * Modifie le nombre d'itération d'une compétence nécessaire
     * @param comp
     * @param nb 
     */
    public void modifNbComp(Competence c, Integer nbReq){
        compReq.put(c, nbReq);
        if((statut == 2) && (!checkCompReq())){
            statut = 1;
            System.out.println("Il faut davantage de personnel maîtrisant la compétence " + c.getLibelleFR());
        }
        if((statut == 1) && (checkCompReq())){
            statut = 2;
        }
    }
    
    public boolean eqComplete(){
        if(equipe.size() < nbMaxEmp)
            return true;
        else
            return false;
    }
    
    /**
     * Ajoute un employé à la mission
     * @param e 
     */
    public void addEmpMiss(Employe e){

            equipe.add(e);
            int nb;
            // On désincrémente de 1 chaque compétence de la mission que l'employé dispose.
            for(Competence c : e.getCompetences()){
                if(compReq.containsKey(c)){
                    nb = compReq.get(c);
                    nb--;
                    compReq.put(c, nb);
                }
            }
           
    }
    
    /**
     * Supprime un employé d'une mission
     * @param e 
     */
    public void delEmpMiss(Employe e){
        if(equipe.contains(e)){
            equipe.remove(e);
            int nb;
            // On incrémente de 1 chaque compétence de la mission que l'employé dispose.
            for(Competence c : e.getCompetences()){
                if(compReq.containsKey(c)){
                    nb = compReq.get(c);
                    nb++;
                    compReq.put(c, nb);
                }
            }
        }
    }
    
    /**
     * Remplace un employé par un autre lorsque le statut de la mission est 2.
     * Si le nouvel employé ne complète pas les compétences, l'ancienne équipe est rétablie.
     * @param current
     * @param futur 
     */
    public void replaceEmp(Employe current, Employe futur){
        delEmpMiss(current);
        addEmpMiss(futur);
        if(!checkCompReq()){
            delEmpMiss(futur);
            addEmpMiss(current);
            System.out.println("Le nouveau salarié ne remplit pas les conditions de la mission.");
        }
    }
    
    /**
     * Remplace un employé par un autre lorsque le statut de la mission est 2.
     * Si le nouvel employé ne complète pas les compétences, l'ancienne équipe est rétablie.
     * @param current
     * @param futur 
     */
    public void replaceEmp2(Employe current, Employe futur){
        delEmpMiss(current);
        addEmpMiss(futur);
        if(!checkCompReq()){
            statut = 1;
            System.out.println("Attention, le nouveau salarié ne remplit pas les conditions de la mission.");
        }
    }
    
    public void changeStatut(){
        switch (statut){
            case 1 :
                if((equipe.size() == nbMaxEmp) && (checkCompReq()))
                    setStatut(2);
                break;
            case 2 :
                if(new Date().after(dateDeb))
                    setStatut(3);
                break;
            case 3 :
                if(new Date().after(dateFin))
                    setStatut(4);
                break;
        }
    }
    
    public boolean checkCompReq(){
        boolean check = true;
        for (Map.Entry c : compReq.entrySet()){
            if(check && (Integer.parseInt(c.getValue().toString()) > 0))
                check = false;
        }
        return check;
    }
    
    public String formatCSV(){
        DateConvert dc = new DateConvert();
        return id + ";" + libelle + ";" + nbMaxEmp + ";" + dc.convertDateStr(dateDeb) + ";" + dc.convertDateStr(dateFin) + ";" + statut + "\n";
    }
    
    public String formatCSVEmp(){
        String res = id + ";";
        for(Employe e : equipe){
            res += e.getId() + ";";
        }
        res += "\n";
        return res;
    }
    
    public String formatCSVComp(){
        String res = id + ";";
        for (Map.Entry c : compReq.entrySet()){
            res += c.getKey() + ";" + c.getValue() + ";";
        }
        res += "\n";
        return res;
    }
    
}
