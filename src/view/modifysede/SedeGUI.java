/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.modifysede;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.JDBCUtilities;
import view.ConsultaEmpleadosGUI;

/**
 *
 * @author Windows 10
 */
public class SedeGUI extends javax.swing.JFrame {

    /**
     * Creates new form SedeGUI
     */
    public SedeGUI() {
        initComponents();
    
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        rbtnId_sede = new javax.swing.JRadioButton();
        rbtnTelefono = new javax.swing.JRadioButton();
        rbtnDireccion = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        titulo.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 153, 153));
        titulo.setText("Seleccione el dato que si desea modificiar:");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Atrás");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        titulo1.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo1.setForeground(new java.awt.Color(238, 112, 82));
        titulo1.setText("MODIFICACIÓN DE DATOS DE UNA SEDE");
        jPanel1.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        rbtnId_sede.setBackground(new java.awt.Color(255, 255, 255));
        rbtnId_sede.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        rbtnId_sede.setForeground(new java.awt.Color(238, 112, 82));
        rbtnId_sede.setText("Cuidad");
        rbtnId_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnId_sedeActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnId_sede, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, -1, -1));

        rbtnTelefono.setBackground(new java.awt.Color(255, 255, 255));
        rbtnTelefono.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        rbtnTelefono.setForeground(new java.awt.Color(238, 112, 82));
        rbtnTelefono.setText("Telefono");
        rbtnTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        rbtnDireccion.setBackground(new java.awt.Color(255, 255, 255));
        rbtnDireccion.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        rbtnDireccion.setForeground(new java.awt.Color(238, 112, 82));
        rbtnDireccion.setText("Dirección");
        rbtnDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(rbtnDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    
    
    private void rbtnDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDireccionActionPerformed
        DireccionGUI a = new DireccionGUI();
        a.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_rbtnDireccionActionPerformed

    private void rbtnTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnTelefonoActionPerformed
        TelefonoGUI a = new TelefonoGUI();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_rbtnTelefonoActionPerformed

    private void rbtnId_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnId_sedeActionPerformed
        CuidadGUI a = new CuidadGUI();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_rbtnId_sedeActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ConsultaEmpleadosGUI consulta = new ConsultaEmpleadosGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    private void obtenerSedes() { 
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        ArrayList<Integer> listaSedes = new ArrayList<>();
        try {
            conexion= conex.getConnection();
            Statement leer = conexion.createStatement();
            ResultSet resultado = leer.executeQuery("SELECT id_sede FROM sede");
            while(resultado.next()){
                listaSedes.add(resultado.getInt(1));
            }
            for(int i=0;i<listaSedes.size();i++){
               // rbtnNombre.addItem(Integer.toString(listaSedes.get(i)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SedeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
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
            java.util.logging.Logger.getLogger(SedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SedeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbtnDireccion;
    private javax.swing.JRadioButton rbtnId_sede;
    private javax.swing.JRadioButton rbtnTelefono;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
