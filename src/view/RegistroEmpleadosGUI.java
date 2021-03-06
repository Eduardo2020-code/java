/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.DatosEmpleadosDao;
import model.vo.DatosEmpleados;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class RegistroEmpleadosGUI extends javax.swing.JFrame {

    //Atributos
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public RegistroEmpleadosGUI(){
        initComponents();
        obtenerSedes();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);

        this.setTitle("Empleados");
        this.setResizable(false);
        
        
    }
    
    public void registrarEmpleado(){
        
        DatosEmpleadosDao c = new DatosEmpleadosDao();
        
        //Este objeto es el que tiene los datos de la base de datos pero para la verificacion
        ArrayList<DatosEmpleados> lista = c.datosRegistroEmpleados();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista);
        
        String user="";
        String num_cedula="";
        
        for(int i = 0; i<lista.size(); i++){
            if(lista2[i][0].equals(tfUsuario.getText())){
                user=lista2[i][0];
                num_cedula=lista2[i][1];
            }
            if(lista2[i][1].equals(tfNum_cedula.getText())){
                num_cedula=lista2[i][1];
            }
        }
        System.out.println("Numero de cedula: "+num_cedula);
        if(tfUsuario.getText().length()!=0
                && tfContrasenia.getText().length()!=0
                && tfNombre.getText().length()!=0
                && tfNum_cedula.getText().length()!=0
                && tfTelefono.getText().length()!=0
                && tfDireccion.getText().length()!=0
                && tfCiudad.getText().length()!=0){
            if(!user.equals(tfUsuario.getText())){
                if(!num_cedula.equals(tfNum_cedula.getText())){
                    if(tfContrasenia.getText().equals(tfContrasenia2.getText())){
                
                        DatosEmpleados nuevoEmpleado = new DatosEmpleados();

                        nuevoEmpleado.setUsuario(tfUsuario.getText());
                        nuevoEmpleado.setContrasenia(tfContrasenia.getText());
                        nuevoEmpleado.setNombre(tfNombre.getText());
                        nuevoEmpleado.setNum_cedula(tfNum_cedula.getText());
                        nuevoEmpleado.setTelefono(tfTelefono.getText());
                        nuevoEmpleado.setDireccion(tfDireccion.getText());
                        nuevoEmpleado.setCiudad(tfCiudad.getText());
                        nuevoEmpleado.setCargo((String) cbCargo.getSelectedItem());
                        nuevoEmpleado.setId_sede((String) cbId_sede.getSelectedItem());


                        //Se solicita que se registre un elemento de tipo empleado
                        DatosEmpleados empleadoRegistrado = null;
                        DatosEmpleadosDao d = new DatosEmpleadosDao();

                        try {
                            empleadoRegistrado = d.registrarEmpleado(nuevoEmpleado);
                            this.setVisible(false);
                            ConsultaEmpleadosGUI consulta = new ConsultaEmpleadosGUI();
                            consulta.setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        //Reportar exito de la accion
                        if(empleadoRegistrado != null){
                            JOptionPane.showMessageDialog(null, "El empleado se registr?? correctamente");
                        }else{
                            JOptionPane.showMessageDialog(null, "No se complet?? el registro");
                        }
                    }else {
                        JOptionPane.showMessageDialog(null, "Las contrase??as no concuerdan");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La cedula ya se encuentra registrada, verifique los datos");
                }
            }else{
                JOptionPane.showMessageDialog(null, "El usuario ya esta registrado, intente con otro diferente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No pueden haber elementos vacios");
        }
    }
    
    
    public String[][] formatoRegistros(ArrayList<DatosEmpleados> consulta){
        
        //Declaraci??n del contenedor de retorno
        String[][] registros = new String[consulta.size()][2];        
        

        //Desenvolver los objetos de la colecci??n
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = consulta.get(i).getUsuario();
            registros[i][1] = consulta.get(i).getNum_cedula();
        }

        //Retornar registros en formato JTable
        return registros;

    }
    
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
                cbId_sede.addItem(Integer.toString(listaSedes.get(i)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnRegistrar1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCiudad = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        cbId_sede = new javax.swing.JComboBox<>();
        cbCargo = new javax.swing.JComboBox<>();
        tfContrasenia2 = new javax.swing.JPasswordField();
        tfContrasenia = new javax.swing.JPasswordField();
        tfNombre = new javax.swing.JTextField();
        tfNum_cedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        btnRegistrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar.setText("Registrar Empleado");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 200, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoSuperchico.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        titulo1.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo1.setForeground(new java.awt.Color(238, 112, 82));
        titulo1.setText("REGISTRO DE EMPLEADO");
        jPanel2.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        jLabel14.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 112, 82));
        jLabel14.setText("ID Sede: ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, -1, -1));

        btnRegistrar1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar1.setText("Registrar Empleado");
        btnRegistrar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 200, 50));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 112, 82));
        jLabel16.setText("Usuario: ");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Contrase??a: ");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 112, 82));
        jLabel18.setText("Repite la contrase??a: ");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(238, 112, 82));
        jLabel19.setText("Nombre Completo: ");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        jLabel20.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(238, 112, 82));
        jLabel20.setText("C??dula: ");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        tfUsuario.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfUsuario.setForeground(new java.awt.Color(153, 153, 153));
        tfUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 170, 25));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 112, 82));
        jLabel21.setText("Tel??fono: ");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jLabel22.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(238, 112, 82));
        jLabel22.setText("Ciudad: ");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 240, -1, -1));

        jLabel11.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(238, 112, 82));
        jLabel11.setText("Cargo: ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Direcci??n:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 90, -1));

        tfCiudad.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCiudad.setForeground(new java.awt.Color(153, 153, 153));
        tfCiudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 170, 25));

        tfTelefono.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfTelefono.setForeground(new java.awt.Color(153, 153, 153));
        tfTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 170, 25));

        tfDireccion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfDireccion.setForeground(new java.awt.Color(153, 153, 153));
        tfDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 170, 25));

        cbId_sede.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbId_sede.setForeground(new java.awt.Color(153, 153, 153));
        cbId_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbId_sedeActionPerformed(evt);
            }
        });
        jPanel2.add(cbId_sede, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 170, 25));

        cbCargo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbCargo.setForeground(new java.awt.Color(153, 153, 153));
        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Operador", "Contador", "Auxiliar de Operaci??n", "Secretaria" }));
        cbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoActionPerformed(evt);
            }
        });
        jPanel2.add(cbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 170, 25));

        tfContrasenia2.setForeground(new java.awt.Color(153, 153, 153));
        tfContrasenia2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfContrasenia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 170, 25));

        tfContrasenia.setForeground(new java.awt.Color(153, 153, 153));
        tfContrasenia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 170, 25));

        tfNombre.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNombre.setForeground(new java.awt.Color(153, 153, 153));
        tfNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 170, 25));

        tfNum_cedula.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNum_cedula.setForeground(new java.awt.Color(153, 153, 153));
        tfNum_cedula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNum_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 170, 25));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Atr??s");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        registrarEmpleado();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void cbId_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbId_sedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbId_sedeActionPerformed

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCargoActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        ConsultaEmpleadosGUI consulta = new ConsultaEmpleadosGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEmpleadosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbId_sede;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JPasswordField tfContrasenia;
    private javax.swing.JPasswordField tfContrasenia2;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNum_cedula;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfUsuario;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
