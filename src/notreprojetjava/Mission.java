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
    private String raf;
    HashMap<Competence, Integer> compRemp;
    HashMap<Competence, Integer> compReq;
    ArrayList<Employe> equipe;
    
    // Constructeur
    //public Mission(String id, String libelle, int nbMaxEmp, String dateDeb, String dateFin, int statut) throws ParseException{
    public Mission(String id, String libelle, int nbMaxEmp, String dateDeb, String dateFin) throws ParseException{
        this.id = id;
        this.libelle = libelle;
        DateConvert dc = new DateConvert();
        this.dateDeb = dc.convertStrDate(dateDeb);
        this.dateFin = dc.convertStrDate(dateFin);
        this.nbMaxEmp = nbMaxEmp;
        this.raf = "";
        
        compRemp = new HashMap<Competence, Integer>();
        compReq = new HashMap<Competence, Integer>();
        equipe = new ArrayList<Employe>();
        //this.statut = statut;
        this.statut = generateStatut();
    }
    
   
    // Accesseurs
    // Getter
    public String getId(){
        return id;
    }
    
    public String getLibelle(){
        return libelle;
    }
    
    public String getRaf(){
        return raf;
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
    
    public HashMap<Competence, Integer> getCompRemp(){
        return compRemp;
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
    
    public void setLibelle(String l){
        libelle = l;
    }
    
    public void setDateDeb(String d) throws ParseException{
        DateConvert dc = new DateConvert();
        this.dateDeb = dc.convertStrDate(d);
    }
    
    public void setDateFin(String d) throws ParseException{
        DateConvert dc = new DateConvert();
        this.dateFin = dc.convertStrDate(d);
    }
        
    // Méthodes

    public void afficherCompReq(){
        System.out.println("Compétences requises pour la mission " + id + " - " + libelle + " : \n");
        for (Map.Entry c : compRemp.entrySet()){
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

    public int generateStatut(){
        int st = 1;
        System.out.print(equipe.size());
        if(new Date().before(dateDeb)){
            if(!eqNotComplete() && checkCompRemp())
                st = 2;
        }
        else{
            if(new Date().after(dateFin))
                st = 4;
            else{
                st = 3;
            }
        }
        return st;
    }
    
    /**
     * Permet de générer la chaîne de caratères des  éléments
     * incomplets d'une mission
     */
    public void generateRaf(){
        raf = "";
        switch(statut){
            case 1 :
                raf += "<html><font color = red >";
                // Ajout de l'état de l'équipe si celle-ci n'est pas complète
                if(eqNotComplete())
                    raf += "<strong>Equipe : </strong>" + equipe.size() + "/" + nbMaxEmp;
                if(!checkCompRemp()){
                    if(eqNotComplete())
                        raf += " - ";
                    raf += "<strong>Compétences : &nbsp;&nbsp;&nbsp;</strong>";
                    // Ajoute le nombre de compétences à remplir pour chacune des compétences incomplète au sein de la mission
                    for (Map.Entry c : compRemp.entrySet()){
                        if((Integer.parseInt(c.getValue().toString()) > 0)){
                            // Nombre de compétence déjà remplie = nombre requis - nombre restant
                            int NbDejaComplete = (compReq.get((Competence)c.getKey())-(Integer)c.getValue());
                            raf += c.getKey() + ":" + NbDejaComplete + "/" + compReq.get((Competence)c.getKey()) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                        }
                    }
                }
                raf += "</font></html>";
                break;
            
            default : raf = "<html><strong><font color = green >OK ✔</strong></font></html>"; break;
            /*case 2 :
                raf = "Mission planifiée"; break;
            
            case 3 :
                raf = "Mission en cours"; break;
            
            case 4 :
                raf = "Mission terminée"; break;*/
        }
        
    }
    
    /**
     * Permet l'ajout d'une compétence nécessaire à la mission
     * @param comp
     * @param nb 
     */
    public void addCompMiss(Competence c, Integer nbReq){
        if(!compRemp.containsKey(c)){
            compRemp.put(c, nbReq);
            compReq.put(c, nbReq);
        }
        else
            System.out.println("La compétence existe déjà dans la mission");
    }
    
    /**
     * Supprime une compétence nécessaire à la mission 
     * @param c
     */
    public void delCompMiss(Competence c){
        if(compRemp.containsKey(c)){
            compRemp.remove(c);
            compReq.remove(c);
        }
        else
            System.out.println("La compétence n'existe pas dans la mission");
    }
    
    /**
     * Modifie le nombre d'itération d'une compétence nécessaire
     * @param comp
     * @param nb 
     */
    public void modifNbComp(Competence c, Integer nbReq){
        compRemp.put(c, nbReq);
        compReq.put(c, nbReq);
        if((statut == 2) && (!checkCompRemp())){
            statut = 1;
            System.out.println("Il faut davantage de personnel maîtrisant la compétence " + c.getLibelleFR());
        }
        if((statut == 1) && (checkCompRemp())){
            statut = 2;
        }
    }
    
    public boolean eqNotComplete(){
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
                if(compRemp.containsKey(c)){
                    nb = compRemp.get(c);
                    nb--;
                    compRemp.put(c, nb);
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
                if(compRemp.containsKey(c)){
                    nb = compRemp.get(c);
                    nb++;
                    compRemp.put(c, nb);
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
        if(!checkCompRemp()){
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
        if(!checkCompRemp()){
            statut = 1;
            System.out.println("Attention, le nouveau salarié ne remplit pas les conditions de la mission.");
        }
    }
    
    /**
     * Retourne un code html pour mettre la pastille en couleur selon le statut
     * @param s
     * @return 
     */
    public String colorStatut(){
        String color = "";
        switch(statut){
            case 1 : color = "<html><font color = red >∙</font></html>"; break;
            case 2 : color = "<html><font color = orange >∙</font></html>"; break; 
            case 3 : color = "<html><font color = green >∙</font></html>"; break; 
            case 4 : color = "<html><font color = black >∙</font></html>"; break; 
        }
        return color;
    }
    
    
    public void changeStatut(){
        switch (statut){
            case 1 :
                if((equipe.size() == nbMaxEmp) && (checkCompRemp()))
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
    
    public boolean checkCompRemp(){
        boolean check = true;
        for (Map.Entry c : compRemp.entrySet()){
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
