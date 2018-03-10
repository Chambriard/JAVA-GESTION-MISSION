/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notreprojetjava;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACHAMBRI
 */
public class JMission extends javax.swing.JFrame {

    /**
     * Creates new form JMission
     */
    static ArrayList<Mission> maListeMission ;
    static ArrayList<Employe> listeEmploye ;
    static ArrayList<Competence> listeCompetence ;
   
    public JMission(ArrayList<Mission> maListeMission,ArrayList<Employe> listeEmploye,ArrayList<Competence> listeCompetence  ) throws FileNotFoundException {
        initComponents();
        this.maListeMission = maListeMission ; 
        this.listeCompetence = listeCompetence ;
        this.listeEmploye = listeEmploye ;
        //définition du model d'un jtable, je récpère les infos des mission que je met dans ce model
        //puis j'instancie mon jtable avec ce model 
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Numéro");
        model.addColumn("Libellé");
        model.addColumn("Statut");
        model.addColumn("Détail");
        for(Mission maMission : this.maListeMission){
            model.addRow(new String[]{maMission.getId(),maMission.getLibelle()});
        }   
        JTableMission.setModel(model);  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        JTableMission = new javax.swing.JTable(){
            public boolean isCellEditable(int d, int c){
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTableMission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Numéro", "Libellé", "Statut", "Détail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
            JTableMission.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(305, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableMissionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMissionMousePressed
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            JDetailMission frameDetailMission = null ;
            int Ligne = JTableMission.getSelectedRow();
            int colonne = 0;
            String codeMiss = (String) JTableMission.getValueAt(Ligne, colonne);
            for(Mission maMission : maListeMission){
                if(maMission.getId().equals(codeMiss)){
                    frameDetailMission = new JDetailMission(maMission,listeEmploye,listeCompetence);
                    frameDetailMission.setVisible(true);
                }
            }
           
        }
    }//GEN-LAST:event_JTableMissionMousePressed

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
            java.util.logging.Logger.getLogger(JMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                /*
                try {
                    new JMission(maListeMission).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JMission.class.getName()).log(Level.SEVERE, null, ex);
                }*/  
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableMission;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
