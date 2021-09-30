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
import javax.swing.JTextField;
import model.dao.DatosEmpleadosDao;
import model.dao.DatosSedesDao;
import model.dao.DatosUsuarioDao;
import model.vo.DatosEmpleados;
import model.vo.DatosSedes;
import model.vo.DatosUsuario;
import view.modifyempleado.UsuarioGUI;

/**
 *
 * @author Windows 10
 */
public class DireccionGUI extends javax.swing.JFrame {
   

    /**
     * Creates new form DireccionGUI
     */
    DatosSedesDao d = new DatosSedesDao();
    DatosSedes dSede = new DatosSedes();
    private JTextField tfConfirmarDir;
    private JTextField tfdireccionAct;
    private JTextField tfDireccionAct;
    public DireccionGUI() {
        initComponents();
                
                 
      // ATEIBUTOS
 
    }
     public void setTfConfirmarDir(JTextField tfConfirmarDir) {
        this.tfConfirmarDir = tfConfirmarDir;
    }
    
    public JTextField getTfDireccionAct() {
        return tfDireccionAct;
     }   
    public JTextField getTfConfirmarDir() {
        return tfConfirmarDir;
     }  
     public void setTfDireccionAct(JTextField tfDireccionAct) {
        this.tfDireccionAct = tfDireccionAct;
    }
     
        public void modificarSedes() throws SQLException{
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosSedesDao c = new DatosSedesDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosSedes> lista = c.listaSedes();
        
         
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoModificar(lista, 3);
        int existeDireccion= c.existeDireccion (getTfConfirmarDir().getText());
        
        
        String DireccionAct="";
        String confirmarDireccion="";
        
        for(int i = 0; i<lista.size(); i++){
            
            if(lista2[i][1].equals(getTfDireccionAct().getText())){
                DireccionAct=lista2[i][1];
            }
            if(lista2[i][2].equals(getTfConfirmarDir().getText())){
                confirmarDireccion=lista2[i][2];
            }
        }
        
        if(getTfDireccionAct().getText().length()!=0
                && getTfDireccionAct().getText().length()!=0
                && getTfConfirmarDir().getText().length()!=0){
            if(DireccionAct.equals(getTfDireccionAct().getText())){
                if(confirmarDireccion.equals(getTfConfirmarDir().getText())){
                    if(!getTfDireccionAct().getText().equals(getTfConfirmarDir().getText())){
                        if(existeDireccion==0){
                            try {
                                DatosSedes usuarioActualizar = new DatosSedes(); 

                                usuarioActualizar.setUsuarioNuevo(getTfUsuarioNuevo().getText());
                                usuarioActualizar.setDireccionAct(getTfDireccionAct().getText());
                                usuarioActualizar.setContrasenia(getTfConfirmarDir().getText());

                                DatosUsuario usuarioActualizado =null;
                                DatosUsuarioDao d = new DatosUsuarioDao();
                                
                                usuarioActualizado = d.actualizarUsuario(usuarioActualizar);
                                
                                if(usuarioActualizado != null){
                                    JOptionPane.showMessageDialog(null, "El usuario del empleado se actualizó correctamente");
                                    this.setVisible(false);
                                    ModificacionEmpleadosGUI modificacion = new ModificacionEmpleadosGUI();
                                    modificacion.setVisible(true);
                                }else{
                                    JOptionPane.showMessageDialog(null, "No se completó la actualización de datos");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(UsuarioGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            
                        }else{
                            JOptionPane.showMessageDialog(null, "El usuario no está disponible. Intente con uno nuevo");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El nuevo usuario no puede ser igual al anterior");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña no valida");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario Anterior Incorrecto");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los datos no pueden estar vacios");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        TfConfirmarDir = new javax.swing.JTextField();
        titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        tfSedemod = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TfDireccionAct = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        titulo1.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo1.setForeground(new java.awt.Color(238, 112, 82));
        titulo1.setText("MODIFICAR DIRECCION DE UNA SEDE ");
        jPanel2.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 112, 82));
        jLabel16.setText("Sede:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Confirmar direccion:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        TfConfirmarDir.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        TfConfirmarDir.setForeground(new java.awt.Color(153, 153, 153));
        TfConfirmarDir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TfConfirmarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfConfirmarDirActionPerformed(evt);
            }
        });
        jPanel2.add(TfConfirmarDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 170, 25));

        titulo.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(153, 153, 153));
        titulo.setText("Llena los siguientes campos para modificar: ");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow.png"))); // NOI18N
        jButton1.setText("ATRÁS");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        btnRegistrar1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar1.setText("Modificar Sede");
        btnRegistrar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 200, 50));

        tfSedemod.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfSedemod.setForeground(new java.awt.Color(153, 153, 153));
        tfSedemod.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfSedemod, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 170, 25));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 112, 82));
        jLabel18.setText("Direccion actual:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 20));

        TfDireccionAct.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        TfDireccionAct.setForeground(new java.awt.Color(153, 153, 153));
        TfDireccionAct.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(TfDireccionAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 170, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       SedeGUI a = new SedeGUI();
      a.setVisible(true);
      this.setVisible(false);
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        String sede, direccionActual, direccionConfir;
        sede = tfSedemod.getText();
        direccionActual = TfDireccionAct.getText();
        direccionConfir = TfConfirmarDir.getText();
        try {
            d.actualizarSede(dSede);
        } catch (SQLException ex) {
            Logger.getLogger(DireccionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog( this , "¿Esta seguro de hacer el cambio de sede?", "Modificar Sede" , JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void TfConfirmarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfConfirmarDirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfConfirmarDirActionPerformed

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
            java.util.logging.Logger.getLogger(DireccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DireccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DireccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DireccionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DireccionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TfConfirmarDir;
    private javax.swing.JTextField TfDireccionAct;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfSedemod;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables

   
}

//sett
 //public int getmodificarUsuario();
  //  return modificarUsuario;

//getter
