/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.awt.Rectangle;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ACHAMBRI
 */
public class Accueil extends javax.swing.JFrame {

    /**
     * Creates new form Accueil
     */
    static Entreprise entreprise;
    public Accueil() throws FileNotFoundException, ParseException {
        //this.pack();
        //this.setDefaultLookAndFeelDecorated(true);
        //this.setExtendedState(this.MAXIMIZED_BOTH);
        initComponents();
        entreprise = new Entreprise();
        
        TPane.setTitleAt(0, "Gestion des Missions");
        TPane.setTitleAt(1, "Gestion des Employés");
        TPane.setTitleAt(2, "Compétences de l'entreprise");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N°");
        model.addColumn("Libellé");
        model.addColumn("Statut");
        model.addColumn("Reste à faire");

        for(Mission maMission : entreprise.getListeMissions()){
            model.addRow(new String[]{maMission.getId(),maMission.getLibelle(), maMission.colorStatut(), maMission.getRaf()});
        }   
        JTableMission.setModel(model);
        TableColumnModel tcm = JTableMission.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(10);
        tcm.getColumn(1).setPreferredWidth(200);
        tcm.getColumn(2).setPreferredWidth(20);
        tcm.getColumn(3).setPreferredWidth(500);
        
        
        DefaultTableModel modelEmp = new DefaultTableModel();
        modelEmp.addColumn("Numéro");
        modelEmp.addColumn("Prénom");
        modelEmp.addColumn("Nom");
        for(Employe e : entreprise.getListeEmployes()){
            modelEmp.addRow(new String[]{e.getId(),e.getPrenom(), e.getNom()});
        }   
        jTableEmp.setModel(modelEmp);  
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        DefaultTableModel modelComp = new DefaultTableModel();
        modelComp.addColumn("Numéro");
        modelComp.addColumn("Libellé Anglais");
        modelComp.addColumn("Libellé Français");
        for(Competence c : entreprise.getListeCompetences()){
            modelComp.addRow(new String[]{c.getId(),c.getLibelleEN(), c.getLibelleFR()});
        }   
        jTableComp.setModel(modelComp);  
        TableColumnModel tcmComp = jTableComp.getColumnModel();
        tcmComp.getColumn(0).setPreferredWidth(30);
        tcmComp.getColumn(1).setPreferredWidth(350);
        tcmComp.getColumn(2).setPreferredWidth(350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        for(Competence c : entreprise.getListeCompetences()){
            cbFiltreComp.addItem(c.getLibelleFR());
        }   
        
        lblFiltre.setVisible(false);
        cbFiltreComp.setVisible(false);
        this.setResizable(false);
        
        lblDetail.setVisible(true);
        ajoutMiss.setVisible(true);
        ajoutEmp.setVisible(false);
        ajoutComp.setVisible(false);
        
        lblStatut.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        jLabel9.setVisible(true);
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        
        
        ImageIcon img = new ImageIcon("img/icone.png");
        this.setIconImage(img.getImage());
        
        Icon imgRefresh = new ImageIcon("img/refresh.png");
        BTNRefresh.setIcon(imgRefresh);
        
        Icon imgAjout = new ImageIcon("img/ajout.png");
        ajoutMiss.setIcon(imgAjout);
        ajoutEmp.setIcon(imgAjout);
        ajoutComp.setIcon(imgAjout);
        
        
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

        lblDetail = new javax.swing.JLabel();
        TPane = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableMission = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmp = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableComp = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblStatut = new javax.swing.JLabel();
        cbFiltreComp = new javax.swing.JComboBox<>();
        lblFiltre = new javax.swing.JLabel();
        ajoutMiss = new javax.swing.JButton();
        ajoutEmp = new javax.swing.JButton();
        BTNRefresh = new javax.swing.JButton();
        ajoutComp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblDetail.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        lblDetail.setText("* Cliquez sur une mission pour accéder aux détails correspondants");

        TPane.setToolTipText("");
        TPane.setName(""); // NOI18N
        TPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPaneMouseClicked(evt);
            }
        });

        JTableMission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Numéro", "Libellé", "Statut"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        JTableMission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTableMissionMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(JTableMission);
        if (JTableMission.getColumnModel().getColumnCount() > 0) {
            JTableMission.getColumnModel().getColumn(2).setPreferredWidth(2);
        }

        TPane.addTab("tab1", jScrollPane2);

        jTableEmp.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableEmpMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmp);

        TPane.addTab("tab2", jScrollPane1);

        jTableComp.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableCompMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTableComp);

        TPane.addTab("tab3", jScrollPane3);

        jLabel5.setText("<html><font color = red >25%</font></html>");

        jLabel6.setText("<html><font color = orange >50%</font></html>");

        jLabel7.setText("<html><font color = green >75%</font></html>");

        jLabel8.setText("<html><font color = black >100%</font></html>");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Mission en préparation");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("Mission planifiée");

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setText("Mission en cours");

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setText("Mission terminée");

        lblStatut.setText("Statut des missions :");

        cbFiltreComp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aucune sélection" }));
        cbFiltreComp.setEnabled(false);

        lblFiltre.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblFiltre.setText("Filtrer selon une compétence sélectionnée :");

        ajoutMiss.setText("Ajouter une mission");
        ajoutMiss.setPreferredSize(new java.awt.Dimension(170, 32));
        ajoutMiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutMissActionPerformed(evt);
            }
        });

        ajoutEmp.setText("Ajouter un employé");
        ajoutEmp.setPreferredSize(new java.awt.Dimension(170, 32));
        ajoutEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutEmpActionPerformed(evt);
            }
        });

        BTNRefresh.setBackground(new java.awt.Color(117, 169, 255));
        BTNRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRefreshActionPerformed(evt);
            }
        });

        ajoutComp.setText("Ajouter une compétence");
        ajoutComp.setPreferredSize(new java.awt.Dimension(170, 32));
        ajoutComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutCompActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(167, 214, 229));
        jPanel1.setForeground(new java.awt.Color(125, 209, 237));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jLabel2.setText("GESTION DE L'ENTREPRISE");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Accueil");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(228, 228, 228)))
                .addGap(251, 251, 251))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStatut)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TPane, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(ajoutMiss, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ajoutEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ajoutComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTNRefresh))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(lblDetail)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbFiltreComp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFiltre, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(88, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TPane, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ajoutMiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ajoutEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ajoutComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BTNRefresh, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblFiltre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltreComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDetail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStatut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );

        TPane.getAccessibleContext().setAccessibleName("Missions");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableMissionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMissionMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            JDetailMission frameDetailMission = null ;
            int Ligne = JTableMission.getSelectedRow();
            int colonne = 0;
            String codeMiss = (String) JTableMission.getValueAt(Ligne, colonne);
            //frameDetailMission = new JDetailMission(entreprise, entreprise.recupMissById(codeMiss));
            //frameDetailMission.setVisible(true);
            for(Mission maMission : entreprise.getListeMissions()){
                if(maMission.getId().equals(codeMiss)){
                    try { 
                        frameDetailMission = new JDetailMission(entreprise, maMission);
                    } catch (ParseException ex) {
                        Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    frameDetailMission.setLocationRelativeTo(null);
                    frameDetailMission.setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_JTableMissionMousePressed

    private void jTableEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpMousePressed
        if(evt.getClickCount() == 2){
            JDetailEmploye frameDetailEmploye = null ;
            int Ligne = jTableEmp.getSelectedRow();
            int colonne = 0;
            String codeEmp = (String) jTableEmp.getValueAt(Ligne, colonne);
            //frameDetailMission = new JDetailMission(entreprise, entreprise.recupMissById(codeMiss));
            //frameDetailMission.setVisible(true);
            for(Employe e : entreprise.getListeEmployes()){
                if(e.getId().equals(codeEmp)){
                    frameDetailEmploye = new JDetailEmploye(entreprise, e);
                    frameDetailEmploye.setLocationRelativeTo(null);
                    frameDetailEmploye.setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_jTableEmpMousePressed

    private void TPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPaneMouseClicked
        
        if(TPane.getSelectedComponent().equals(jScrollPane1)) {
            ajoutMiss.setVisible(false);
            ajoutEmp.setVisible(true);
            ajoutComp.setVisible(false);

            lblStatut.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
        } else {
            if(TPane.getSelectedComponent().equals(jScrollPane3)) {
                ajoutMiss.setVisible(false);
                ajoutEmp.setVisible(false);
                ajoutComp.setVisible(true);

                lblStatut.setVisible(false);
                jLabel5.setVisible(false);
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jLabel8.setVisible(false);
                jLabel9.setVisible(false);
                jLabel10.setVisible(false);
                jLabel11.setVisible(false);
                jLabel12.setVisible(false);
            }
            else {
                ajoutMiss.setVisible(true);
                ajoutEmp.setVisible(false);
                ajoutComp.setVisible(false);

                lblStatut.setVisible(true);
                jLabel5.setVisible(true);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jLabel9.setVisible(true);
                jLabel10.setVisible(true);
                jLabel11.setVisible(true);
                jLabel12.setVisible(true);
            }
        }
    }//GEN-LAST:event_TPaneMouseClicked

    private void ajoutMissActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutMissActionPerformed
        // TODO add your handling code here:
        AjoutMission framCreerMission = null ;
        framCreerMission = new AjoutMission(entreprise);
        framCreerMission.setLocationRelativeTo(null);
        framCreerMission.setVisible(true);
    }//GEN-LAST:event_ajoutMissActionPerformed

    private void ajoutEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutEmpActionPerformed
        // TODO add your handling code here:
        AjoutEmploye framCreerEmploye = null ;
        framCreerEmploye = new AjoutEmploye(entreprise);
        framCreerEmploye.setLocationRelativeTo(null);
        framCreerEmploye.setVisible(true);
    }//GEN-LAST:event_ajoutEmpActionPerformed

    private void BTNRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRefreshActionPerformed
        TPane.setTitleAt(0, "Gestion des Missions");
        TPane.setTitleAt(1, "Gestion des Employés");
        TPane.setTitleAt(2, "Compétences de l'entreprise");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("N°");
        model.addColumn("Libellé");
        model.addColumn("Statut");
        model.addColumn("Reste à faire");

        for(Mission maMission : entreprise.getListeMissions()){
            model.addRow(new String[]{maMission.getId(),maMission.getLibelle(), maMission.colorStatut(), maMission.getRaf()});
        }   
        JTableMission.setModel(model);
        TableColumnModel tcm = JTableMission.getColumnModel();
        tcm.getColumn(0).setPreferredWidth(10);
        tcm.getColumn(1).setPreferredWidth(200);
        tcm.getColumn(2).setPreferredWidth(20);
        tcm.getColumn(3).setPreferredWidth(500);
        
        
        DefaultTableModel modelEmp = new DefaultTableModel();
        modelEmp.addColumn("Numéro");
        modelEmp.addColumn("Prénom");
        modelEmp.addColumn("Nom");
        for(Employe e : entreprise.getListeEmployes()){
            modelEmp.addRow(new String[]{e.getId(),e.getPrenom(), e.getNom()});
        }   
        jTableEmp.setModel(modelEmp);  
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        DefaultTableModel modelComp = new DefaultTableModel();
        modelComp.addColumn("Numéro");
        modelComp.addColumn("Libellé Anglais");
        modelComp.addColumn("Libellé Français");
        for(Competence c : entreprise.getListeCompetences()){
            modelComp.addRow(new String[]{c.getId(),c.getLibelleEN(), c.getLibelleFR()});
        }   
        jTableComp.setModel(modelComp);  
        TableColumnModel tcmComp = jTableComp.getColumnModel();
        tcmComp.getColumn(0).setPreferredWidth(30);
        tcmComp.getColumn(1).setPreferredWidth(350);
        tcmComp.getColumn(2).setPreferredWidth(350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        for(Competence c : entreprise.getListeCompetences()){
            cbFiltreComp.addItem(c.getLibelleFR());
        }
        
        entreprise.generateRaf();
        entreprise.generateStatut();
    }//GEN-LAST:event_BTNRefreshActionPerformed

    private void ajoutCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutCompActionPerformed
        // TODO add your handling code here:
        AjoutComp framCreerComp = null ;
        framCreerComp = new AjoutComp(entreprise);
        framCreerComp.setLocationRelativeTo(null);
        framCreerComp.setVisible(true);
    }//GEN-LAST:event_ajoutCompActionPerformed

    private void jTableCompMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCompMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            JDetailComp frameDetailComp = null ;
            int Ligne = jTableComp.getSelectedRow();
            int colonne = 0;
            String id = (String) jTableComp.getValueAt(Ligne, colonne);
            //frameDetailMission = new JDetailMission(entreprise, entreprise.recupMissById(codeMiss));
            //frameDetailMission.setVisible(true);
            for(Competence c : entreprise.getListeCompetences()){
                if(c.getId().equals(id)){
                    frameDetailComp = new JDetailComp(entreprise, c);
                    frameDetailComp.setLocationRelativeTo(null);
                    frameDetailComp.setVisible(true);
                }
            }

        }
    }//GEN-LAST:event_jTableCompMousePressed

 
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
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Accueil().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNRefresh;
    private javax.swing.JTable JTableMission;
    private javax.swing.JTabbedPane TPane;
    private javax.swing.JButton ajoutComp;
    private javax.swing.JButton ajoutEmp;
    private javax.swing.JButton ajoutMiss;
    private javax.swing.JComboBox<String> cbFiltreComp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableComp;
    private javax.swing.JTable jTableEmp;
    private javax.swing.JLabel lblDetail;
    private javax.swing.JLabel lblFiltre;
    private javax.swing.JLabel lblStatut;
    // End of variables declaration//GEN-END:variables
}
