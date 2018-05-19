/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import static notreprojetjava.JDetailMission.maMission;

/**
 *
 * @author achambri
 */
public class JDetailEmploye extends javax.swing.JFrame {

    /**
     * Creates new form JDetailEmploye
     */
    
    static Employe monEmp ;
    static Entreprise entreprise;
    
    public JDetailEmploye(Entreprise entreprise, Employe e) {
        initComponents();
        this.monEmp = e ;
        this.entreprise = entreprise ;
        
        LBLID.setText(e.getId());
        
        JTNomEmp.setText(monEmp.getNom());
        JTPrenomEmp.setText(monEmp.getPrenom());
        
        //DATE
        SimpleDateFormat formatterJ = new SimpleDateFormat("dd");
        SimpleDateFormat formatterM = new SimpleDateFormat("MM");
        SimpleDateFormat formatterA = new SimpleDateFormat("yyyy");
        dateJ.setText(formatterJ.format(monEmp.getDate()));
        dateM.setText(formatterM.format(monEmp.getDate()));
        dateA.setText(formatterA.format(monEmp.getDate()));
        
        //Gestion des Competences
        DefaultTableModel modelCompEmploye = new DefaultTableModel();
        modelCompEmploye.addColumn("id");
        modelCompEmploye.addColumn("libelle");
        
        for(Competence maComp : monEmp.getCompetences()){
            modelCompEmploye.addRow(new String[]{maComp.getId(), maComp.getLibelleFR()});
        }
        JTCompEmp.setModel(modelCompEmploye);
        
        DefaultTableModel modelLesComp = new DefaultTableModel();
        modelLesComp.addColumn("id");
        modelLesComp.addColumn("libelle");
        for(Competence maCompetencesCSV : entreprise.getListeCompetences()){
            boolean detient = false ;
            for(Competence maComp : monEmp.getCompetences()){
                if(maComp.equals(maCompetencesCSV)){
                    detient = true ;
                }
             }
            if(!detient){
                modelLesComp.addRow(new String[]{maCompetencesCSV.getId(), maCompetencesCSV.getLibelleFR()});
            }
        }
        JTLesComp.setModel(modelLesComp);
        
        this.setResizable(false);
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        JTNomEmp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTPrenomEmp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateJ = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dateA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTLesComp = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTCompEmp = new javax.swing.JTable();
        JTAjoutComp = new javax.swing.JButton();
        JTRemoveComp = new javax.swing.JButton();
        BTNRetour = new javax.swing.JButton();
        LBLID = new javax.swing.JLabel();
        BTNSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nom :");

        jLabel2.setText("Prenom :");

        jLabel3.setText("ID :");

        jLabel4.setText("Date entrée :");

        jLabel5.setText("/");

        jLabel6.setText("/");

        jLabel7.setText("Les Compétences :");

        JTLesComp.setModel(new javax.swing.table.DefaultTableModel(
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
        JTLesComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTLesCompMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTLesComp);

        JTCompEmp.setModel(new javax.swing.table.DefaultTableModel(
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
        JTCompEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTCompEmpMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTCompEmp);

        JTAjoutComp.setText("Ajouter >>");
        JTAjoutComp.setEnabled(false);
        JTAjoutComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTAjoutCompActionPerformed(evt);
            }
        });

        JTRemoveComp.setText("<< Supprimer");
        JTRemoveComp.setEnabled(false);
        JTRemoveComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTRemoveCompActionPerformed(evt);
            }
        });

        BTNRetour.setBackground(new java.awt.Color(239, 131, 131));
        BTNRetour.setText("Retour");
        BTNRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNRetourActionPerformed(evt);
            }
        });

        LBLID.setText("jLabel8");

        BTNSave.setBackground(new java.awt.Color(132, 204, 132));
        BTNSave.setText("Sauvegarder");
        BTNSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNSaveActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(167, 214, 229));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel13.setText("Détail de l'employé");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTRemoveComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTAjoutComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateJ, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(BTNRetour)
                .addGap(18, 18, 18)
                .addComponent(BTNSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LBLID)
                    .addComponent(JTNomEmp, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(JTPrenomEmp))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LBLID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(JTPrenomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(dateJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(JTAjoutComp)
                        .addGap(28, 28, 28)
                        .addComponent(JTRemoveComp)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BTNRetour)
                            .addComponent(BTNSave))
                        .addGap(98, 98, 98))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTAjoutCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTAjoutCompActionPerformed
        // TODO add your handling code here:
        int ligne = JTLesComp.getSelectedRow();
        int colonneId = 0 ;
        int colonneNomFra = 1;
        String id = (String) JTLesComp.getValueAt(ligne, colonneId);
        String nomFra = (String) JTLesComp.getValueAt(ligne, colonneNomFra);
        
        DefaultTableModel modelLesCompEmp =(DefaultTableModel)  JTCompEmp.getModel();
        modelLesCompEmp.addRow(new Object[]{id,nomFra});
        JTCompEmp.setModel(modelLesCompEmp);

        //Enlever la compétence de la Jtable

        DefaultTableModel modelLesComp =(DefaultTableModel)  JTLesComp.getModel();
        modelLesComp.removeRow(ligne);
        JTLesComp.setModel(modelLesComp);
        Competence uneComp = entreprise.recupCompById(id);
        entreprise.addCompEmp(monEmp, uneComp);
        entreprise.afficherEmpComp(monEmp);
        JTAjoutComp.setEnabled(false);
    }//GEN-LAST:event_JTAjoutCompActionPerformed

    private void JTRemoveCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTRemoveCompActionPerformed
        // TODO add your handling code here:
        int ligne = JTCompEmp.getSelectedRow();
        int colonneId = 0 ;
        int colonneNomFra = 1;
        String id = (String) JTCompEmp.getValueAt(ligne, colonneId);
        String nomFra = (String) JTCompEmp.getValueAt(ligne, colonneNomFra);
        
        DefaultTableModel modelLesCompEmp =(DefaultTableModel)  JTCompEmp.getModel();
        modelLesCompEmp.removeRow(ligne);
        JTCompEmp.setModel(modelLesCompEmp);
        
        DefaultTableModel modelLesComp =(DefaultTableModel)  JTLesComp.getModel();
        modelLesComp.addRow(new Object[]{id,nomFra});
        JTLesComp.setModel(modelLesComp);
        
        Competence uneComp = entreprise.recupCompById(id);
        entreprise.delCompEmp(monEmp, uneComp);
        entreprise.afficherEmpComp(monEmp);
        JTRemoveComp.setEnabled(false);
    }//GEN-LAST:event_JTRemoveCompActionPerformed

    private void BTNRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNRetourActionPerformed
        /*
        switch(showConfirmDialog(null, "Attention, si vous quittez sans sauvegarder, toutes modifications sera perdue !\nVoulez-vous sauvegarder avant de quitter ?", "", YES_NO_CANCEL_OPTION)){                
            
            case JOptionPane.YES_OPTION :
                monEmp.setNom(JTNomEmp.getText());
                monEmp.setPrenom(JTPrenomEmp.getText());
                String dateE = dateJ.getText() + "/" + dateM.getText() + "/" + dateA.getText();
                try {
                    monEmp.setDateE(dateE);
                } catch (ParseException ex) {
                    Logger.getLogger(JDetailEmploye.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    entreprise.saveEmp();
                    showMessageDialog(null, "Sauvegarde de l'employé correctement effectuée !", "", INFORMATION_MESSAGE);
                    entreprise.generateStatut();
                    this.dispose();

                } catch (IOException ex) {
                    Logger.getLogger(JDetailMission.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case JOptionPane.NO_OPTION : this.dispose(); break;
        }*/
        this.dispose();
    }//GEN-LAST:event_BTNRetourActionPerformed

    private void JTLesCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTLesCompMouseClicked
        JTAjoutComp.setEnabled(true);
    }//GEN-LAST:event_JTLesCompMouseClicked

    private void JTCompEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTCompEmpMouseClicked
        JTRemoveComp.setEnabled(true);
    }//GEN-LAST:event_JTCompEmpMouseClicked

    private void BTNSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNSaveActionPerformed
        monEmp.setNom(JTNomEmp.getText());
        monEmp.setPrenom(JTPrenomEmp.getText());
        String dateE = dateJ.getText() + "/" + dateM.getText() + "/" + dateA.getText();
        try {
            monEmp.setDateE(dateE);
        } catch (ParseException ex) {
            Logger.getLogger(JDetailEmploye.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(showConfirmDialog(null, "Êtes-vous certain de vouloir sauvegarder les informations ?", "", OK_CANCEL_OPTION) == 0){                
            try {
                entreprise.saveEmp();
                showMessageDialog(null, "Sauvegarde de l'employé correctement effectuée !", "", INFORMATION_MESSAGE);
                entreprise.generateStatut();
                this.dispose();
                
            } catch (IOException ex) {
                Logger.getLogger(JDetailMission.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BTNSaveActionPerformed

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
            java.util.logging.Logger.getLogger(JDetailEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDetailEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDetailEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDetailEmploye.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
//            public void run() {
//                new JDetailEmploye().setVisible(true);
//            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNRetour;
    private javax.swing.JButton BTNSave;
    private javax.swing.JButton JTAjoutComp;
    private javax.swing.JTable JTCompEmp;
    private javax.swing.JTable JTLesComp;
    private javax.swing.JTextField JTNomEmp;
    private javax.swing.JTextField JTPrenomEmp;
    private javax.swing.JButton JTRemoveComp;
    private javax.swing.JLabel LBLID;
    private javax.swing.JTextField dateA;
    private javax.swing.JTextField dateJ;
    private javax.swing.JTextField dateM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
