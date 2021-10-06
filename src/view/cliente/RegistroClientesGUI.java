/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.DatosClientesDao;
import model.vo.DatosClientes;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class RegistroClientesGUI extends javax.swing.JFrame {

    //Atributos
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public RegistroClientesGUI(){
        initComponents();
        obtenerSedes();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);

        this.setTitle("Empleados");
        this.setResizable(false);
        
        
    }
    
    public void registrarCliente(){
        
        DatosClientesDao c = new DatosClientesDao();
        
        //Este objeto es el que tiene los datos de la base de datos pero para la verificacion
        ArrayList<DatosClientes> lista = c.datosRegistroClientes();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista);
        
        String cedula="";
        
        for(int i = 0; i<lista.size(); i++){
            if(lista2[i][0].equals(tfNum_cedula.getText())){
                cedula=lista2[i][0];
            }
        }
        if(tfNombre.getText().length()!=0
                && tfNum_cedula.getText().length()!=0
                && tfTelefono.getText().length()!=0
                && tfDireccion.getText().length()!=0
                && tfCiudad.getText().length()!=0){
            if(!cedula.equals(tfNum_cedula.getText())){
                
                DatosClientes nuevoCliente = new DatosClientes();

                nuevoCliente.setNombre(tfNombre.getText());
                nuevoCliente.setNum_cedula(tfNum_cedula.getText());
                nuevoCliente.setTelefono(tfTelefono.getText());
                nuevoCliente.setDireccion(tfDireccion.getText());
                nuevoCliente.setCiudad(tfCiudad.getText());
                nuevoCliente.setId_sede((String) cbId_sede.getSelectedItem());


                //Se solicita que se registre un elemento de tipo empleado
                DatosClientes clienteRegistrado = null;
                DatosClientesDao d = new DatosClientesDao();

                try {
                    clienteRegistrado = d.registrarCliente(nuevoCliente);
                    
                    this.setVisible(false);
                    InformacionClientesGUI consulta = new InformacionClientesGUI();
                    consulta.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroClientesGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Reportar exito de la accion
                if(clienteRegistrado != null){
                    JOptionPane.showMessageDialog(null, "El cliente se registró correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "No se completó el registro");
                }
                    
            }else{
                JOptionPane.showMessageDialog(null, "La cedula ya se encuentra registrada, verifique los datos");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "No pueden haber elementos vacios");
        }
    }
    
    
    public String[][] formatoRegistros(ArrayList<DatosClientes> consulta){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][1];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {
            registros[i][0] = consulta.get(i).getNum_cedula();
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
            Logger.getLogger(RegistroClientesGUI.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        lAtras = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCiudad = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        cbId_sede = new javax.swing.JComboBox<>();
        tfNombre = new javax.swing.JTextField();
        tfNum_cedula = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("REGISTRO DE CLIENTE");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        lAtras.setBackground(new java.awt.Color(255, 255, 255));
        lAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        lAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lAtrasMouseClicked(evt);
            }
        });
        jPanel1.add(lAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel4.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Atrás");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel14.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(238, 112, 82));
        jLabel14.setText("ID Sede: ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, -1, -1));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 112, 82));
        jLabel15.setText("Atrás");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(238, 112, 82));
        jLabel19.setText("Nombre Completo: ");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jLabel20.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(238, 112, 82));
        jLabel20.setText("Cédula: ");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 112, 82));
        jLabel21.setText("Teléfono: ");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        jLabel22.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(238, 112, 82));
        jLabel22.setText("Ciudad: ");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Dirección:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 90, -1));

        tfCiudad.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCiudad.setForeground(new java.awt.Color(153, 153, 153));
        tfCiudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 170, 25));

        tfTelefono.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfTelefono.setForeground(new java.awt.Color(153, 153, 153));
        tfTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 170, 25));

        tfDireccion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfDireccion.setForeground(new java.awt.Color(153, 153, 153));
        tfDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 170, 25));

        cbId_sede.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbId_sede.setForeground(new java.awt.Color(153, 153, 153));
        cbId_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbId_sedeActionPerformed(evt);
            }
        });
        jPanel2.add(cbId_sede, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 170, 25));

        tfNombre.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNombre.setForeground(new java.awt.Color(153, 153, 153));
        tfNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 170, 25));

        tfNum_cedula.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNum_cedula.setForeground(new java.awt.Color(153, 153, 153));
        tfNum_cedula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNum_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 170, 25));

        btnRegistrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar.setText("Registrar Cliente");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 200, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        registrarCliente();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void lAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lAtrasMouseClicked
        // TODO add your handling code here:
        InformacionClientesGUI consulta = new InformacionClientesGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lAtrasMouseClicked

    private void cbId_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbId_sedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbId_sedeActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroClientesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegistroClientesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbId_sede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel lAtras;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNum_cedula;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
