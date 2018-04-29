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
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import static notreprojetjava.Accueil.entreprise;

/**
 *
 * @author ACHAMBRI
 */
public class JDetailMission extends javax.swing.JFrame {

    /**
     * Creates new form JDetailMission
     */
    static Mission maMission ;
    static Entreprise entreprise;
    
    public JDetailMission(Entreprise entreprise, Mission m) {
        //this.setUndecorated(true);
        //this.setDefaultLookAndFeelDecorated(false);
        
        initComponents();
        this.entreprise = entreprise;
        this.maMission = m;
        
        LBLID.setText(m.getId());
        
        lblCompEmp.setText("");
        
        TFMLibelle.setText(m.getLibelle());
        
        TFMnbMax.setText(String.valueOf(m.getNbMaxEmp()));
        
        spnComp.setModel(new javax.swing.SpinnerNumberModel(1, 1, m.getNbMaxEmp(), 1));
        
        
        switch(m.getStatut()){
            case 1 : LBLStatut.setText("En préparation"); break;
            case 2 : LBLStatut.setText("Planifiée"); break;
            case 3 : LBLStatut.setText("En cours"); break;
            case 4 : LBLStatut.setText("Terminée"); break;
        }
        
        
        //DATE :
        SimpleDateFormat formatterJ = new SimpleDateFormat("dd");
        SimpleDateFormat formatterM = new SimpleDateFormat("MM");
        SimpleDateFormat formatterA = new SimpleDateFormat("yyyy");
        dateDebJ.setText(formatterJ.format(maMission.getDateDeb()));
        dateDebM.setText(formatterM.format(maMission.getDateDeb()));
        dateDebA.setText(formatterA.format(maMission.getDateDeb()));
        dateFinJ.setText(formatterJ.format(maMission.getDateFin()));
        dateFinM.setText(formatterM.format(maMission.getDateFin()));
        dateFinA.setText(formatterA.format(maMission.getDateFin()));
        
        
        
        DefaultTableModel modelEmp = new DefaultTableModel();
        modelEmp.addColumn("id");
        modelEmp.addColumn("Nom");
        modelEmp.addColumn("Prenom");
        for(Employe monEmpDuCSVFile : entreprise.getListeEmployes()){
            boolean missione = false ;
            Iterator<Employe>  monEmpDeLaMission  = maMission.equipe.iterator();
            while(monEmpDeLaMission.hasNext() && !missione){
                if(monEmpDuCSVFile.getId().equals(monEmpDeLaMission.next().getId())){
                    missione = true;
                }
            }
            if(!missione){
                modelEmp.addRow(new String[]{monEmpDuCSVFile.getId(), monEmpDuCSVFile.getNom(),monEmpDuCSVFile.getPrenom()});
            }
        }
        lesEmp.setModel(modelEmp);
        
        DefaultTableModel modelEmpMiss = new DefaultTableModel();
        modelEmpMiss.addColumn("id");
        modelEmpMiss.addColumn("Nom");
        modelEmpMiss.addColumn("Prenom");
        for(Employe monEmp : maMission.equipe){
            modelEmpMiss.addRow(new String[]{monEmp.getId(), monEmp.getNom(),monEmp.getPrenom()});
        }
        
        lesEmpDeLaMiss.setModel(modelEmpMiss);
        
        DefaultTableModel modelCompMission = new DefaultTableModel();
        modelCompMission.addColumn("id");
        modelCompMission.addColumn("libelle");
        modelCompMission.addColumn("Requis");
        for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
            Competence key = entry.getKey();
            Integer value = entry.getValue();
            for(Employe monEmp : maMission.equipe){
                if(monEmp.getCompetences().contains(key)){
                    value = value - 1 ;
                }
            }
            if(value < 1){
                value = 0 ;
            }
            if(value != 0){
                modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
            }
            
        }
        compMission.setModel(modelCompMission);
        
        DefaultTableModel modelLesComp = new DefaultTableModel();
        modelLesComp.addColumn("id");
        modelLesComp.addColumn("libelle");
        for(Competence maCompetencesCSV : entreprise.getListeCompetences()){
            boolean missione = false ;
            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
                Competence key = entry.getKey();
                Integer value = entry.getValue();
                if(key.getId().equals(maCompetencesCSV.getId())){
                    missione = true ;
                }
             }
            if(!missione){
                modelLesComp.addRow(new String[]{maCompetencesCSV.getId(), maCompetencesCSV.getLibelleFR()});
            }
        }
        jtableLesCompetences.setModel(modelLesComp);
        this.setDefaultCloseOperation(2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lesEmpDeLaMiss = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lesEmp = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        ajoutEmp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateDebJ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateDebM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateDebA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dateFinJ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dateFinM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        dateFinA = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        compMission = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtableLesCompetences = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ajouterComp = new javax.swing.JButton();
        removeEmp = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        TFMLibelle = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TFMnbMax = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        LBLID = new javax.swing.JLabel();
        LBLStatut = new javax.swing.JLabel();
        BTNSave = new javax.swing.JButton();
        BTNRetour = new javax.swing.JButton();
        spnComp = new javax.swing.JSpinner();
        lblLimit = new javax.swing.JLabel();
        lblLimit2 = new javax.swing.JLabel();
        lblLimit3 = new javax.swing.JLabel();
        removeComp = new javax.swing.JButton();
        spnRemove = new javax.swing.JSpinner();
        lblCompEmp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Employés affectés à la mission :");

        lesEmpDeLaMiss.setModel(new javax.swing.table.DefaultTableModel(
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
        lesEmpDeLaMiss.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lesEmpDeLaMissMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lesEmpDeLaMiss);

        jLabel2.setText("Liste des employés :");

        lesEmp.setModel(new javax.swing.table.DefaultTableModel(
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
        lesEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lesEmpMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lesEmp);

        ajoutEmp.setText("Ajouter >>");
        ajoutEmp.setEnabled(false);
        ajoutEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutEmpActionPerformed(evt);
            }
        });

        jLabel3.setText("ID :");

        jLabel4.setText("Date début :");

        jLabel5.setText("/");

        jLabel6.setText("/");

        jLabel7.setText("Date Fin :");

        jLabel8.setText("/");

        jLabel9.setText("/");

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
        jScrollPane1.setViewportView(compMission);

        jLabel10.setText("Compétences requises pour la mission :");

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
        jtableLesCompetences.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableLesCompetencesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtableLesCompetences);

        jLabel11.setText("Liste des compétences :");

        jLabel12.setText("Requis : ");

        ajouterComp.setText("Ajouter >>");
        ajouterComp.setEnabled(false);
        ajouterComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterCompActionPerformed(evt);
            }
        });

        removeEmp.setText("<< Supprimer");
        removeEmp.setEnabled(false);
        removeEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmpActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel13.setText("Détail de la Mission");

        jLabel14.setText("Libellé :");

        jLabel15.setText("MAX :");

        TFMnbMax.setText("jTextField1");
        TFMnbMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFMnbMaxKeyPressed(evt);
            }
        });

        jLabel16.setText("Statut :");

        LBLID.setText("jLabel17");

        LBLStatut.setText("jLabel17");

        BTNSave.setBackground(new java.awt.Color(132, 204, 132));
        BTNSave.setText("Sauvegarder");
        BTNSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSaveActionPerformed(evt);
            }
        });

        BTNRetour.setBackground(new java.awt.Color(239, 131, 131));
        BTNRetour.setText("Retour");
        BTNRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRetourActionPerformed(evt);
            }
        });

        spnComp.setValue(1);
        spnComp.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnComp.setEnabled(false);
        spnComp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCompStateChanged(evt);
            }
        });

        lblLimit.setText("<html><font color = red >Le nombre requis de compétences</font></html>");
        lblLimit.setVisible(false);

        lblLimit2.setText("<html><font color = red >ne peut pas dépasser le nombre</font></html>");
        lblLimit2.setVisible(false);

        lblLimit3.setText("<html><font color = red >maximum d'employés.</font></html>");
        lblLimit3.setVisible(false);

        removeComp.setText("<< Supprimer");
        removeComp.setEnabled(false);
        removeComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCompActionPerformed(evt);
            }
        });

        spnRemove.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnRemove.setEnabled(false);

        lblCompEmp.setText("jLabel17");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTNRetour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNSave))
                    .addComponent(lblLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLimit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblLimit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(358, 358, 358))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LBLStatut, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TFMLibelle))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LBLID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFinJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateDebJ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateDebM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateFinM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateDebA)
                            .addComponent(dateFinA, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCompEmp)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(removeEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ajoutEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(78, 78, 78)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TFMnbMax, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel12)
                                        .addGap(29, 29, 29)
                                        .addComponent(spnComp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(removeComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(ajouterComp, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(70, 70, 70))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(spnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(dateDebM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(dateDebJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateDebA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBLID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateFinM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(dateFinJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8)
                                .addComponent(dateFinA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(TFMLibelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(LBLStatut))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(TFMnbMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ajoutEmp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeEmp)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(removeComp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(spnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ajouterComp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(spnComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCompEmp)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(lblLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLimit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLimit3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNSave)
                    .addComponent(BTNRetour))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajoutEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutEmpActionPerformed
        // TODO add your handling code here:
       
        //Ajoute l'employé dans la Jtable lesEmpDeLaMiss
        int ligne = lesEmp.getSelectedRow();
        int colonneId = 0 ;
        int colonneNom = 1;
        int colonnePrenom = 2 ;
        String id = (String) lesEmp.getValueAt(ligne, colonneId);
        String nom = (String) lesEmp.getValueAt(ligne, colonneNom);
        String prenom = (String) lesEmp.getValueAt(ligne, colonnePrenom);
 
        if(maMission.eqNotComplete()){
            System.out.println(maMission.getCompRemp());
            Employe e = entreprise.recupEmpById(id);
            entreprise.addEmpMiss(maMission, e);
            System.out.println(maMission.getEquipe());
            System.out.println(maMission.getCompRemp());
            
            DefaultTableModel modelLesEmpDeLaMission =(DefaultTableModel)  lesEmpDeLaMiss.getModel();
            modelLesEmpDeLaMission.addRow(new Object[]{id,nom,prenom});
            lesEmpDeLaMiss.setModel(modelLesEmpDeLaMission);
            //Enlève l'employé das Jtable lesEmp
            DefaultTableModel modelLesEmp =(DefaultTableModel)  lesEmp.getModel();
            modelLesEmp.removeRow(ligne);
            lesEmp.setModel(modelLesEmp);
            
            DefaultTableModel modelCompMission = new DefaultTableModel();
            modelCompMission.addColumn("id");
            modelCompMission.addColumn("libelle");
            modelCompMission.addColumn("Requis");
            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
                Competence key = entry.getKey();
                Integer value = entry.getValue();

                modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
            
            }
            compMission.setModel(modelCompMission);
            entreprise.generateStatut(maMission);
        }
        else
        {
            showMessageDialog(null, "Le nombre maximal d'employé est atteint pour cette mission !", "Erreur", ERROR_MESSAGE);
        }
        
        
        //Ajoute l'employé dans la liste d'employé de la mission et réduir le requis de jtable compMission
        
        DefaultTableModel modelComMission =(DefaultTableModel)  compMission.getModel();
        ajoutEmp.setEnabled(false);
//        for(Employe unEmp : entreprise.getListeEmployes() ){
//            if(unEmp.getId().equals(id)){
//                maMission.equipe.add(unEmp);
//                for(int i=0; i<compMission.getRowCount();i++){
//                    String idCom = (String) compMission.getValueAt(i, 0);
//                    String libelle = (String) compMission.getValueAt(i, 1);
//                    String nbRequisS = (String) compMission.getValueAt(i, 2);
//                    Integer nbRequisI = Integer.parseInt(nbRequisS);
//                    for(Competence uneComp : unEmp.getCompetences()){
//                        if(uneComp.getId().equals(idCom)){
//                            nbRequisI = nbRequisI - 1 ;
//                            modelComMission.removeRow(i);
//                            if(nbRequisI > 0){
//                                modelComMission.addRow(new Object[]{idCom,libelle,nbRequisI.toString()});
//                                compMission.setModel(modelComMission);
//                            }
//                            
//                        }
//                    }
//                }
//            }
//        }
    }//GEN-LAST:event_ajoutEmpActionPerformed

    
    
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
        
        if (spnI > Integer.parseInt(TFMnbMax.getText())){
            lblLimit.setVisible(true);
            lblLimit2.setVisible(true);
            lblLimit3.setVisible(true);
        }
        else {
            lblLimit.setVisible(false);
            lblLimit2.setVisible(false);
            lblLimit3.setVisible(false);
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
            ajouterComp.setEnabled(false);
        }
    }//GEN-LAST:event_ajouterCompActionPerformed

    private void removeEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmpActionPerformed
        // TODO add your handling code here:
        
        int ligne = lesEmpDeLaMiss.getSelectedRow();
        int colonneId = 0 ;
        int colonneNom = 1;
        int colonnePrenom = 2 ;
        String id = (String) lesEmpDeLaMiss.getValueAt(ligne, colonneId);
        String nom = (String) lesEmpDeLaMiss.getValueAt(ligne, colonneNom);
        String prenom = (String) lesEmpDeLaMiss.getValueAt(ligne, colonnePrenom);
        
        DefaultTableModel modelLesEmp =(DefaultTableModel)  lesEmp.getModel();
        modelLesEmp.addRow(new Object[]{id,nom,prenom});
        lesEmp.setModel(modelLesEmp);
        DefaultTableModel modelLesEmpMission =(DefaultTableModel) lesEmpDeLaMiss.getModel();
        modelLesEmpMission.removeRow(ligne);
        lesEmpDeLaMiss.setModel(modelLesEmpMission);
        
        System.out.println(maMission.getCompRemp());
        Employe e = entreprise.recupEmpById(id);
        entreprise.delEmpMiss(maMission, e);
        System.out.println(maMission.getEquipe());
        System.out.println(maMission.getCompRemp());
        
        
        //Retirer employé des liste et rajouter compétence
     
        DefaultTableModel modelCompMission = new DefaultTableModel();
            modelCompMission.addColumn("id");
            modelCompMission.addColumn("libelle");
            modelCompMission.addColumn("Requis");
            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
                Competence key = entry.getKey();
                Integer value = entry.getValue();

                modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
            
            }
            compMission.setModel(modelCompMission);
            entreprise.generateStatut(maMission);
            removeEmp.setEnabled(false);
        /*for(Employe unEmp : entreprise.getListeEmployes() ){
            if(unEmp.getId().equals(id)){
                maMission.equipe.remove(unEmp);
                //PROBLEME
                for(int i=0; i<compMission.getRowCount();i++){
                    String idCom = (String) compMission.getValueAt(i, 0);
                    String libelle = (String) compMission.getValueAt(i, 1);
                    String nbRequisS = (String) compMission.getValueAt(i, 2);
                    Integer nbRequisI = Integer.parseInt(nbRequisS);
                    System.out.println(idCom);
                    System.out.println(libelle);
                    System.out.println(nbRequisS);
                    //System.out.println(unEmp.toString());
                    /*for(Competence uneComp : unEmp.getCompetences()){
                        if(uneComp.getId().equals(idCom)){
                            nbRequisI = nbRequisI + 1 ;
                            modelComMission.removeRow(i);
                            modelComMission.addRow(new Object[]{idCom,libelle,nbRequisI.toString()});
                            compMission.setModel(modelComMission);
                            nbRequisI = 0 ;
                        }
                    }
                    modelComMission.addRow(new Object[]{idCom,libelle,nbRequisI.toString()});
                }
            }
        }*/
    }//GEN-LAST:event_removeEmpActionPerformed

    private void lesEmpMouseClicked(java.awt.event.MouseEvent evt) {                                    
        ajoutEmp.setEnabled(true);
        int Ligne = lesEmp.getSelectedRow();
        int colonne = 0;
        String idEmp = (String) lesEmp.getValueAt(Ligne, colonne);
        Employe monEmp = entreprise.recupEmpById(idEmp);
        lblCompEmp.setText(entreprise.getIdCompByIdEmp(monEmp));
        if(evt.getClickCount() == 2){
            JDetailEmploye frameDetailEmploye = null ;
            frameDetailEmploye = new JDetailEmploye(entreprise, monEmp);
            frameDetailEmploye.setVisible(true);
        }
    }
    
    private void BTNSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSaveActionPerformed
        maMission.setNbMaxEmp(Integer.parseInt(TFMnbMax.getText()));
        maMission.setLibelle(TFMLibelle.getText());
        String datedeb = dateDebJ.getText() + "/" + dateDebM.getText() + "/" + dateDebA.getText();
        String datefin = dateFinJ.getText() + "/" + dateFinM.getText() + "/" + dateFinA.getText();
        try {
            maMission.setDateDeb(datedeb);
            maMission.setDateFin(datefin);
        } catch (ParseException ex) {
            Logger.getLogger(JDetailMission.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(showConfirmDialog(null, "Êtes-vous certain de vouloir sauvegarder les informations ?", "", OK_CANCEL_OPTION) == 0){                
            try {
                entreprise.saveMiss();
                showMessageDialog(null, "Sauvegarde de la mission correctement effectuée !", "", INFORMATION_MESSAGE);
                entreprise.generateStatut();
                this.dispose();
                
            } catch (IOException ex) {
                Logger.getLogger(JDetailMission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BTNSaveActionPerformed

    private void BTNRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRetourActionPerformed
        switch(showConfirmDialog(null, "Attention, si vous quittez sans sauvegarder, toutes modifications sera perdue !\nVoulez-vous sauvegarder avant de quitter ?", "", YES_NO_CANCEL_OPTION)){                
            
            case JOptionPane.YES_OPTION :
                maMission.setNbMaxEmp(Integer.parseInt(TFMnbMax.getText()));
                maMission.setLibelle(TFMLibelle.getText());
                String datedeb = dateDebJ.getText() + "/" + dateDebM.getText() + "/" + dateDebA.getText();
                String datefin = dateFinJ.getText() + "/" + dateFinM.getText() + "/" + dateFinA.getText();
                try {
                    maMission.setDateDeb(datedeb);
                    maMission.setDateFin(datefin);
                } catch (ParseException ex) {
                    Logger.getLogger(JDetailMission.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    entreprise.saveMiss();
                    showMessageDialog(null, "Sauvegarde de la mission correctement effectuée !", "", INFORMATION_MESSAGE);
                    this.dispose();
                } catch (IOException ex) {
                    Logger.getLogger(JDetailMission.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case JOptionPane.NO_OPTION : this.dispose(); break;
        }
        //this.dispose();
    }//GEN-LAST:event_BTNRetourActionPerformed

    private void spnCompStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCompStateChanged
        int spnI = ((Integer) spnComp.getValue()).intValue();
        
        if (spnI >= Integer.parseInt(TFMnbMax.getText())){
            lblLimit.setVisible(true);
            lblLimit2.setVisible(true);
            lblLimit3.setVisible(true);
        }
        else {
            lblLimit.setVisible(false);
            lblLimit2.setVisible(false);
            lblLimit3.setVisible(false);
        }
    }//GEN-LAST:event_spnCompStateChanged

    private void TFMnbMaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFMnbMaxKeyPressed
        int max = Integer.valueOf(TFMnbMax.getText());
        spnComp.setModel(new javax.swing.SpinnerNumberModel(1, 1, max, 1));
        lblLimit.setVisible(false);
        lblLimit2.setVisible(false);
        lblLimit3.setVisible(false);

    }//GEN-LAST:event_TFMnbMaxKeyPressed

    private void jtableLesCompetencesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableLesCompetencesMouseClicked
        ajouterComp.setEnabled(true);
        spnComp.setEnabled(true);
    }//GEN-LAST:event_jtableLesCompetencesMouseClicked

    private void lesEmpDeLaMissMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lesEmpDeLaMissMouseClicked
        removeEmp.setEnabled(true);
    }//GEN-LAST:event_lesEmpDeLaMissMouseClicked

    private void compMissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compMissionMouseClicked
        removeComp.setEnabled(true);
        spnRemove.setEnabled(true);
        //int max = (Integer) compMission.getValueAt(compMission.getSelectedRow(), 2);
        //spnRemove.setModel(new javax.swing.SpinnerNumberModel(1, 1, max, 1));
    }//GEN-LAST:event_compMissionMouseClicked

    private void removeCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCompActionPerformed
        int ligne = compMission.getSelectedRow();
        int colonneId = 0 ;
        int colonneLibelle = 1;
        int colonneRequis = 2 ;
        String id = (String) compMission.getValueAt(ligne, colonneId);
        String libelle = (String) compMission.getValueAt(ligne, colonneLibelle);
        String requisS = (String) compMission.getValueAt(ligne, colonneRequis);
        Integer requis = Integer.parseInt(requisS);
    
        int requisSuppr = ((Integer) spnRemove.getValue()).intValue();
      
     
        if(requis - requisSuppr <= 0){
            
            DefaultTableModel modelLesCompetences =(DefaultTableModel)  jtableLesCompetences.getModel();
            modelLesCompetences.addRow(new Object[]{id,libelle});
            jtableLesCompetences.setModel(modelLesCompetences);
            
            DefaultTableModel modelCompMission = new DefaultTableModel();
            modelCompMission.addColumn("id");
            modelCompMission.addColumn("libelle");
            modelCompMission.addColumn("Requis");
            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
                Competence key = entry.getKey();
                Integer value = entry.getValue();
                for(Employe monEmp : maMission.equipe){
                    if(monEmp.getCompetences().contains(key)){
                        value = value - 1 ;
                    }
                }
                if(key.getId().equals(id)){
                        
                    entreprise.delCompMiss(maMission, entreprise.recupCompById(id) );
                    value = 0;
                }
                if(value < 1){
                    value = 0 ;
                }
                if(!value.equals(0)){
                    System.out.println(" COUCOU " + value);
                    modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
                }
            }
            compMission.setModel(modelCompMission);
            
        }else{
            DefaultTableModel modelCompMission = new DefaultTableModel();
            modelCompMission.addColumn("id");
            modelCompMission.addColumn("libelle");
            modelCompMission.addColumn("Requis");
            for(HashMap.Entry<Competence,Integer> entry : maMission.compRemp.entrySet()){
                Competence key = entry.getKey();
                Integer value = entry.getValue();
                for(Employe monEmp : maMission.equipe){
                    if(monEmp.getCompetences().contains(key)){
                        value = value - 1 ;
                    }
                }
                if(key.getId().equals(id)){
                    value = value - requisSuppr;
                }
                if(value < 1){
                    value = 0 ;
                }
                if(value != 0){
                    modelCompMission.addRow(new String[]{key.getId(), key.getLibelleFR(),value.toString()});
                }
            
            }
            entreprise.delCompRequMiss(maMission, entreprise.recupCompById(id), requisSuppr);
            compMission.setModel(modelCompMission);
        }
        
        
    }//GEN-LAST:event_removeCompActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDetailMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            /*
            public void run() {
                new JDetailMission().setVisible(true);
            }*/
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNRetour;
    private javax.swing.JButton BTNSave;
    private javax.swing.JLabel LBLID;
    private javax.swing.JLabel LBLStatut;
    private javax.swing.JTextField TFMLibelle;
    private javax.swing.JTextField TFMnbMax;
    private javax.swing.JButton ajoutEmp;
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtableLesCompetences;
    private javax.swing.JLabel lblCompEmp;
    private javax.swing.JLabel lblLimit;
    private javax.swing.JLabel lblLimit2;
    private javax.swing.JLabel lblLimit3;
    private javax.swing.JTable lesEmp;
    private javax.swing.JTable lesEmpDeLaMiss;
    private javax.swing.JButton removeComp;
    private javax.swing.JButton removeEmp;
    private javax.swing.JSpinner spnComp;
    private javax.swing.JSpinner spnRemove;
    // End of variables declaration//GEN-END:variables
}
