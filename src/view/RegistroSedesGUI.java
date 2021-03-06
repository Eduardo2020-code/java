/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.DatosSedesDao;
import model.vo.DatosSedes;
import view.modifysede.ObtenerSedeGUI;

/**
 *
 * @author usuario
 */
public class RegistroSedesGUI extends javax.swing.JFrame {

    //Atributos
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public RegistroSedesGUI(){
        initComponents();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        this.setResizable(false);
        
        
    }
    
    public void registrarSede(){
        
        DatosSedesDao c = new DatosSedesDao();
        
        //Este objeto es el que tiene los datos de la base de datos pero para la verificacion
        ArrayList<DatosSedes> lista = c.listaSedes();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista);
        System.out.println(lista2[0][1]);
        String dir="";
        
        for(int i = 0; i<lista.size(); i++){
            if(lista2[i][1].equals(tfDireccion.getText())){
                dir=lista2[i][1];
            }
        }
        System.out.println(dir);
        if(tfDireccion.getText().length()!=0
                && tfCiudad.getText().length()!=0
                && tfTelefono.getText().length()!=0
                && tfCiudad.getText().length()!=0){
            if(!dir.equals(tfDireccion.getText())){
                
                String direccion=tfDireccion.getText();
                String barrio=tfCiudad.getText();
                String ciudad=tfCiudad.getText();
                String telefono=tfTelefono.getText();
                
                DatosSedes nuevaSede = new DatosSedes(direccion, barrio, ciudad, telefono);
                
                //Se solicita que se registre un elemento de tipo empleado
                DatosSedes sedeRegistrada = null;
                DatosSedesDao d = new DatosSedesDao();
                
                try {
                    sedeRegistrada = d.registrarSede(nuevaSede);
                    this.setVisible(false);
                    ConsultaEmpleadosGUI consulta = new ConsultaEmpleadosGUI();
                    consulta.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroSedesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Reportar exito de la accion
                if(sedeRegistrada != null){
                    JOptionPane.showMessageDialog(null, "La sede se registr?? correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "No se complet?? el registro");
                }
                
            }else {
                JOptionPane.showMessageDialog(null, "Una sede registrada posee la direccion a registrar. Verifique");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No pueden haber elementos vacios");
        }
    }
    
    
    public String[][] formatoRegistros(ArrayList<DatosSedes> consulta){
        
        //Declaraci??n del contenedor de retorno
        String[][] registros = new String[consulta.size()][5];        
        

        //Desenvolver los objetos de la colecci??n
        for (int i = 0; i < consulta.size(); i++) {
            registros[i][0] = String.valueOf(consulta.get(i).getId_sede());
            registros[i][1] = consulta.get(i).getDireccion_sede();
            registros[i][2] = consulta.get(i).getBarrio_sede();
            registros[i][3] = consulta.get(i).getCiudad_sede();
            registros[i][4] = consulta.get(i).getTelefono_sede();
        }

        //Retornar registros en formato JTable
        return registros;

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
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfCiudad = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        tfDireccion = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();
        tfBarrio = new javax.swing.JTextField();

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
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jTextField8.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(153, 153, 153));
        jTextField8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Atr??s");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoSuperchico.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 112, 82));
        jLabel15.setText("Atr??s");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 112, 82));
        jLabel16.setText("Direcci??n:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Barrio:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, -1, -1));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 112, 82));
        jLabel18.setText("Ciudad:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(238, 112, 82));
        jLabel19.setText("Tel??fono:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, -1, -1));

        tfCiudad.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCiudad.setForeground(new java.awt.Color(153, 153, 153));
        tfCiudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCiudadActionPerformed(evt);
            }
        });
        jPanel2.add(tfCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 170, 25));

        tfTelefono.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfTelefono.setForeground(new java.awt.Color(153, 153, 153));
        tfTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 170, 25));

        btnRegistrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar.setText("Registrar Sede");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 200, 50));

        tfDireccion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfDireccion.setForeground(new java.awt.Color(153, 153, 153));
        tfDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDireccionActionPerformed(evt);
            }
        });
        jPanel2.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 170, 25));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("REGISTRO DE SEDE");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        tfBarrio.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfBarrio.setForeground(new java.awt.Color(153, 153, 153));
        tfBarrio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tfBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfBarrioActionPerformed(evt);
            }
        });
        jPanel2.add(tfBarrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 170, 25));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        registrarSede();
        ObtenerSedeGUI sede = new ObtenerSedeGUI();
        this.setVisible(false);
        sede.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ObtenerSedeGUI consulta = new ObtenerSedeGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tfCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCiudadActionPerformed

    private void tfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDireccionActionPerformed

    private void tfBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfBarrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBarrioActionPerformed

    /**
     * @param args the command line arguments
     */
    
    //Aqui en el main es importante cambiar donde dice look and feel, de Nimbus a Windows
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroSedesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroSedesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroSedesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroSedesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroSedesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField tfBarrio;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
