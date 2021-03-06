/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static notreprojetjava.JDetailMission.maMission;

/**
 *
 * @author achambri
 */
public class AjoutMission extends javax.swing.JFrame {

    /**
     * Creates new form AjoutMission
     */
    static Entreprise entreprise;
    private Mission maMission ;
    private ArrayList<Competence> lesCompetences ;
    public AjoutMission(Entreprise entreprise) {
        initComponents();
        ajouterComp.setEnabled(true);
        lesCompetences = new ArrayList<Competence>();
        this.entreprise = entreprise ;
        DefaultTableModel modelLesComp = new DefaultTableModel();
        modelLesComp.addColumn("id");
        modelLesComp.addColumn("libelle");
        for(Competence maCompetencesCSV : entreprise.getListeCompetences()){
                modelLesComp.addRow(new String[]{maCompetencesCSV.getId(), maCompetencesCSV.getLibelleFR()});
        }
        jtableLesCompetences.setModel(modelLesComp);
        TableColumnModel tcm = jtableLesCompetences.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(5);
        tcm.getColumn(1).setPreferredWidth(300);
        
        DefaultTableModel modelCompMission = new DefaultTableModel();
        modelCompMission.addColumn("id");
        modelCompMission.addColumn("libelle");
        modelCompMission.addColumn("Requis");
        
        compMission.setModel(modelCompMission);
        
        
       this.setResizable(false);
        
         //initComponents();
         this.setDefaultCloseOperation(2);
         setBackground(new java.awt.Color(255, 255, 255));
         
         Icon imgSave = new ImageIcon("img/save.png");
      BTNAjout.setIcon(imgSave);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableLesCompetences = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateDebJ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateDebM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTLibelle = new javax.swing.JTextField();
        dateDebA = new javax.swing.JTextField();
        jTNbEmpMax = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateFinJ = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateFinM = new javax.swing.JTextField();
        dateFinA = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        compMission = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ajouterComp = new javax.swing.JButton();
        spnComp = new javax.swing.JSpinner();
        BTNAjout = new javax.swing.JButton();
        BTNRetour = new javax.swing.JButton();
        message = new javax.swing.JLabel();
        removeComp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtableLesCompetences.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtableLesCompetences);

        jLabel1.setText("Libellé :");

        jLabel10.setText("/");

        jLabel5.setText("Date début :");

        jLabel2.setText("Nombre d'employés Maximum :");

        jLabel6.setText("/");

        jLabel7.setText("/");

        jLabel8.setText("Date Fin :");

        jLabel9.setText("/");

        jLabel12.setText("Liste des compétences :");

        compMission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        compMission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compMissionMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(compMission);

        jLabel11.setText("Compétences requises pour la mission :");

        jLabel14.setText("Requis : ");

        ajouterComp.setText("Ajouter >>");
        ajouterComp.setEnabled(false);
        ajouterComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterCompActionPerformed(evt);
            }
        });

        spnComp.setValue(1);
        spnComp.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnComp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCompStateChanged(evt);
            }
        });

        BTNAjout.setBackground(new java.awt.Color(132, 204, 132));
        BTNAjout.setText("Ajouter");
        BTNAjout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAjoutActionPerformed(evt);
            }
        });

        BTNRetour.setBackground(new java.awt.Color(239, 131, 131));
        BTNRetour.setText("Retour");
        BTNRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRetourActionPerformed(evt);
            }
        });

        removeComp.setText("<< Supprimer");
        removeComp.setEnabled(false);
        removeComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(167, 214, 229));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel13.setText("Création de mission :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(272, 272, 272))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ajouterComp, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(29, 29, 29)
                                .addComponent(spnComp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(jLabel8))
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateFinJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateDebJ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateDebM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dateFinM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateDebA)
                                .addComponent(dateFinA, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTNbEmpMax, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTLibelle))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BTNRetour)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(BTNAjout))))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNbEmpMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateDebM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(dateDebJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateDebA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dateFinJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(dateFinA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFinM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(ajouterComp))
                                    .addComponent(removeComp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(spnComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNAjout)
                            .addComponent(BTNRetour))
                        .addGap(94, 94, 94))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterCompActionPerformed
        // TODO add your handling code here:
        int ligne = jtableLesCompetences.getSelectedRow();
        int colonneId = 0 ;
        int colonneNomFra = 1;
        String id = (String) jtableLesCompetences.getValueAt(ligne, colonneId);
        String nomFra = (String) jtableLesCompetences.getValueAt(ligne, colonneNomFra);
        System.out.println(spnComp.getValue());
        int spnI = ((Integer) spnComp.getValue()).intValue();
        String spnS = spnComp.getValue().toString();
        System.out.println(spnS);

     
        DefaultTableModel modelLesCompMission =(DefaultTableModel)  compMission.getModel();
        modelLesCompMission.addRow(new Object[]{id,nomFra,spnS});
        compMission.setModel(modelLesCompMission);

        //Enlever la compétence de la Jtable

        DefaultTableModel modelLesComp =(DefaultTableModel)  jtableLesCompetences.getModel();
        modelLesComp.removeRow(ligne);
        System.out.println(spnI);
        jtableLesCompetences.setModel(modelLesComp);

        for(Competence uneComp : entreprise.getListeCompetences() ){
            if(uneComp.getId().equals(id)){
                entreprise.addCompMiss(maMission, uneComp, spnI);
            }
        }
        entreprise.generateStatut(maMission);
        ajouterComp.setEnabled(true);
        
    }//GEN-LAST:event_ajouterCompActionPerformed

    private void spnCompStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCompStateChanged
    

       
    }//GEN-LAST:event_spnCompStateChanged

    private void BTNAjoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAjoutActionPerformed
        String erreur = "" ;
        String newLine = System.getProperty("line.separator");
        if(jTLibelle.getText().equals("")){
            erreur += " veuillez entrer un libellé" + newLine;
        }
        if(jTNbEmpMax.getText().equals("")){
            erreur += " veuillez entrer un nombre maximum" + newLine;
        }
        if(dateDebA.getText().equals("")){
            erreur += " veuillez entrer l'année de la date de début" + newLine;
        }
        if(dateDebJ.getText().equals("")){
            erreur += " veuillez entrer le jour de la date de début" + newLine;
        }
        if(dateDebM.getText().equals("")){
            erreur += " veuillez entrer le mois de la date de début" + newLine;
        }
        if(dateFinA.getText().equals("")){
            erreur += " veuillez entrer l'année de la date de Fin" + newLine;
        }
        if(dateFinJ.getText().equals("")){
            erreur += " veuillez entrer le jour de la date de Fin" + newLine;
        }
        if(dateFinM.getText().equals("")){
            erreur += " veuillez entrer le mois de la date de Fin" + newLine;
        }
        if(!dateDebA.getText().equals("") && !dateFinM.getText().equals("") && !dateDebM.getText().equals("") && !dateFinA.getText().equals("") ){
            if(Integer.parseInt(dateFinA.getText()) < Integer.parseInt(dateDebA.getText())){
                erreur += " veillez entrer une date de fin supérieur à une date de début " + newLine;
            } else {
                if(Integer.parseInt(dateFinA.getText()) == Integer.parseInt(dateDebA.getText())){
                    if(Integer.parseInt(dateFinM.getText()) < Integer.parseInt(dateDebM.getText())){
                        erreur += " veillez entrer une date de fin supérieur à une date de début " + newLine;
                    }
                }
            }
        }
        
        
        if(erreur != ""){
            message.setText(erreur);
        } else {
            String dateDeb = "" ;
            dateDeb += dateDebJ.getText() + "/";
            dateDeb += dateDebM.getText() + "/";
            dateDeb += dateDebA.getText();
            
            String dateFin = "";
            dateFin += dateFinJ.getText() + "/";
            dateFin += dateFinM.getText() + "/";
            dateFin += dateFinA.getText();
            
            try {
                String id = "M" + (entreprise.getListeMissions().size() + 1) ;
                entreprise.creerMission(id ,jTLibelle.getText() , dateDeb, dateFin, Integer.parseInt(jTNbEmpMax.getText()));
                maMission = new Mission(id ,jTLibelle.getText(), Integer.parseInt(jTNbEmpMax.getText()), dateDeb, dateFin);
//                entreprise.creerMission("MDD" + 1,jTLibelle.getText() , dateDeb, dateFin, Integer.parseInt(jTNbEmpMax.getText()));
//                maMission = new Mission("MDD" + 1,jTLibelle.getText(), Integer.parseInt(jTNbEmpMax.getText()), dateDeb, dateFin);
                int nbCompte = compMission.getRowCount();
                for (int i = 0; i < nbCompte; i++) {
//                    System.out.println("BONJOUR");
                    String idComp = (String)compMission.getValueAt(i, 0);
//                    System.out.println("idComp = " + idComp);
                    String nbRequis = (String)compMission.getValueAt(i, 2);
//                    System.out.println("nbRequis = " + nbRequis);
                    System.out.print(" id mission :"  + maMission.getId());
                    System.out.print(" mission :"  + entreprise.recupMissById(maMission.getId()).toString());
                    entreprise.addCompMiss(entreprise.recupMissById(maMission.getId()), entreprise.recupCompById(idComp), Integer.parseInt(nbRequis));
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AjoutMission.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(AjoutMission.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                System.out.println("mission = " );
                entreprise.afficherMissComp(maMission);
                entreprise.afficherMissions();
                //entreprise.recupMissById(maMission.getId()).afficherCompReq();
                entreprise.saveMiss();
                System.out.println("BONJOUR");
                jTLibelle.setText("");
                jTNbEmpMax.setText("");
                dateDebA.setText("");
                dateDebJ.setText("");
                dateDebM.setText("");
                dateFinA.setText("");
                dateFinM.setText("");
                dateFinJ.setText("");
                
                DefaultTableModel modelCompMission = new DefaultTableModel();
                modelCompMission.addColumn("id");
                modelCompMission.addColumn("libelle");
                modelCompMission.addColumn("Requis");

                compMission.setModel(modelCompMission);
                
                DefaultTableModel modelLesComp = new DefaultTableModel();
                modelLesComp.addColumn("id");
                modelLesComp.addColumn("libelle");
                for(Competence maCompetencesCSV : entreprise.getListeCompetences()){
                        modelLesComp.addRow(new String[]{maCompetencesCSV.getId(), maCompetencesCSV.getLibelleFR()});
                }
                jtableLesCompetences.setModel(modelLesComp);
                
                message.setText("Mission bien ajoutée");
            } catch (IOException ex) {
                Logger.getLogger(AjoutMission.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_BTNAjoutActionPerformed

    private void BTNRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_BTNRetourActionPerformed

    private void removeCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCompActionPerformed
        int ligne = compMission.getSelectedRow();
        int colonneId = 0 ;
        int colonneLibelle = 1;
        int colonneRequis = 2 ;
        String id = (String) compMission.getValueAt(ligne, colonneId);
        String libelle = (String) compMission.getValueAt(ligne, colonneLibelle);
        String requisS = (String) compMission.getValueAt(ligne, colonneRequis);
        Integer requis = Integer.parseInt(requisS);

        int requisSuppr = ((Integer) spnComp.getValue()).intValue();

        if(requis - requisSuppr <= 0){

            DefaultTableModel modelLesCompetences =(DefaultTableModel)  jtableLesCompetences.getModel();
            modelLesCompetences.addRow(new Object[]{id,libelle});
            jtableLesCompetences.setModel(modelLesCompetences);

//            DefaultTableModel modelCompMission = new DefaultTableModel();
//            modelCompMission.addColumn("id");
//            modelCompMission.addColumn("libelle");
//            modelCompMission.addColumn("Requis");
//            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
//                Competence key = entry.getKey();
//                Integer value = entry.getValue();
//                for(Employe monEmp : maMission.equipe){
//                    if(monEmp.getCompetences().contains(key)){
//                        value = value - 1 ;
//                    }
//                }
//                if(key.getId().equals(id)){
//
//                    entreprise.delCompMiss(maMission, entreprise.recupCompById(id) );
//                    value = 0;
//                }
//                if(value < 1){
//                    value = 0 ;
//                }
//                if(!value.equals(0)){
//                    System.out.println(" COUCOU " + value);
//                    modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
//                }
//            }
            DefaultTableModel modelCompMission = (DefaultTableModel)  compMission.getModel();
            int rowSupp = compMission.getSelectedRow();
            System.out.println("COUCOU");
            System.out.println("COUCOU");
            System.out.println(rowSupp);
            System.out.println("COUCOU");
            System.out.println("COUCOU");
            modelCompMission.removeRow(rowSupp);
            compMission.setModel(modelCompMission);

        }else{
            DefaultTableModel modelCompMission = (DefaultTableModel)  compMission.getModel();
//            modelCompMission.addColumn("id");
//            modelCompMission.addColumn("libelle");
//            modelCompMission.addColumn("Requis");
//            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
//                Competence key = entry.getKey();
//                Integer value = entry.getValue();
//                for(Employe monEmp : maMission.equipe){
//                    if(monEmp.getCompetences().contains(key)){
//                        value = value - 1 ;
//                    }
//                }
//                if(key.getId().equals(id)){
//                    value = value - requisSuppr;
//                }
//                if(value < 1){
//                    value = 0 ;
//                }
//                if(value != 0){
//                    modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
//                }
//
//            }
//            entreprise.delCompRequMiss(maMission, entreprise.recupCompById(id), requisSuppr);
            int RowComp = compMission.getSelectedRow();
            colonneId = 0 ;
            colonneLibelle = 1;
            colonneRequis = 2 ;
            id = (String) compMission.getValueAt(ligne, colonneId);
            libelle = (String) compMission.getValueAt(ligne, colonneLibelle);
            String requisString = (String) compMission.getValueAt(ligne, colonneRequis);
            requis = Integer.parseInt(requisString);
            requis = requis - requisSuppr ;
            modelCompMission.removeRow(RowComp);
            modelCompMission.addRow(new Object[]{id,libelle,requis});
            compMission.setModel(modelCompMission);
        }

    }//GEN-LAST:event_removeCompActionPerformed

    private void compMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compMissionMouseClicked
        // TODO add your handling code here:
        removeComp.setEnabled(true);
        spnComp.setEnabled(true);
    }//GEN-LAST:event_compMissionMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); 
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
//            public void run() {
//                new AjoutMission().setVisible(true);
//            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAjout;
    private javax.swing.JButton BTNRetour;
    private javax.swing.JButton ajouterComp;
    private javax.swing.JTable compMission;
    private javax.swing.JTextField dateDebA;
    private javax.swing.JTextField dateDebJ;
    private javax.swing.JTextField dateDebM;
    private javax.swing.JTextField dateFinA;
    private javax.swing.JTextField dateFinJ;
    private javax.swing.JTextField dateFinM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTLibelle;
    private javax.swing.JTextField jTNbEmpMax;
    private javax.swing.JTable jtableLesCompetences;
    private javax.swing.JLabel message;
    private javax.swing.JButton removeComp;
    private javax.swing.JSpinner spnComp;
    // End of variables declaration//GEN-END:variables
}
