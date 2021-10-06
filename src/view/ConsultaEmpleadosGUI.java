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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.DatosEmpleadosDao;
import model.vo.DatosEmpleados;
import view.modifyempleado.UsuarioGUI;

/**
 *
 * @author usuario
 */
public class ConsultaEmpleadosGUI extends javax.swing.JFrame {

    //Atributos
    DefaultTableModel tEmpleados = new DefaultTableModel();
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public ConsultaEmpleadosGUI(){
        initComponents();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        this.setResizable(false);
        mostrarEmpleados();
        
    }
    
    private void mostrarEmpleados() {
        //Se defin el table model globalmente
       
        //Se agregan las columnas de la tabla a mostrar
        tEmpleados.addColumn("Usuario");
        tEmpleados.addColumn("Nombre");
        tEmpleados.addColumn("Cédula");
        tEmpleados.addColumn("Telefono");
        tEmpleados.addColumn("Direccion");
        tEmpleados.addColumn("Ciudad");
        tEmpleados.addColumn("Cargo");
        tEmpleados.addColumn("ID sede");
        
        //Se setea el modelo
        getTableEmpleados().setModel(tEmpleados);
        
        //Se obtiene el numero de columnas
        int numColumnas=tEmpleados.getColumnCount();
        
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosEmpleadosDao c = new DatosEmpleadosDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosEmpleados> lista = c.listaEmpleados();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista, numColumnas);
        
        //Se agregan de la lista obtenida en array los datos de la base de datos
        for(int i = 0; i<lista.size(); i++){
            tEmpleados.addRow(lista2[i]);
        }
        
        //Se vuelve a setear para agregar los elementos de la BD
        tableEmpleados.setModel(tEmpleados);
    }
    
    public void eliminarEmpleado(){
        
        DatosEmpleados empleadoEliminar = new DatosEmpleados();
        String dato=null;
        if(tableEmpleados.getSelectedRow()!=-1){
            int input = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el empleado?");
            
            if(input==0){
                dato=String.valueOf(tEmpleados.getValueAt(tableEmpleados.getSelectedRow(),0));
                tableEmpleados.getModel(); //TableProducto es el nombre de mi tabla ;)
                tEmpleados.removeRow(tableEmpleados.getSelectedRow());

                empleadoEliminar.setUsuario(dato);
                DatosEmpleados empleadoEliminado = null;
                DatosEmpleadosDao d = new DatosEmpleadosDao();

                try {
                    empleadoEliminado = d.eliminarEmpleado(empleadoEliminar);
                }catch (SQLException ex) {
                    Logger.getLogger(UsuarioGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione un empleado para poder eliminarlo");            
        }
    }
    
    public String[][] formatoRegistros(ArrayList<DatosEmpleados> consulta, int numeroColumnas){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][numeroColumnas];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = consulta.get(i).getUsuario();
            registros[i][1] = consulta.get(i).getNombre();
            registros[i][2] = consulta.get(i).getNum_cedula();
            registros[i][3] = consulta.get(i).getTelefono();
            registros[i][4] = consulta.get(i).getDireccion();
            registros[i][5] = consulta.get(i).getCiudad();
            registros[i][6] = consulta.get(i).getCargo();
            registros[i][7] = consulta.get(i).getId_sede();
            
        }

        //Retornar registros en formato JTable
        return registros;

    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public void setjScrollPane2(JScrollPane jScrollPane2) {
        this.jScrollPane2 = jScrollPane2;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JTable getjTable2() {
        return jTable2;
    }

    public void setjTable2(JTable jTable2) {
        this.jTable2 = jTable2;
    }

    public JTable getTableEmpleados() {
        return tableEmpleados;
    }

    public void setTableEmpleados(JTable tableEmpleados) {
        this.tableEmpleados = tableEmpleados;
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpleados = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(440, 402));

        tableEmpleados.setAutoCreateRowSorter(true);
        tableEmpleados.setBackground(new java.awt.Color(255, 208, 164));
        tableEmpleados.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tableEmpleados.setForeground(new java.awt.Color(238, 112, 82));
        tableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Cédula", "Teléfono", "Dirección", "Ciudad", "Cargo", "ID Sede"
            }
        ));
        tableEmpleados.setGridColor(new java.awt.Color(238, 112, 82));
        tableEmpleados.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tableEmpleados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableEmpleados);
        if (tableEmpleados.getColumnModel().getColumnCount() > 0) {
            tableEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(5).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(6).setResizable(false);
            tableEmpleados.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 760, 90));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("INFORMACIÓN DE LOS EMPLEADOS");
        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
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

        jButton1.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jButton1.setText("Eliminar Empleado");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 200, 50));

        btnRegistrar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnRegistrar.setText("Registrar Empleado");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 200, 50));

        jButton3.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-button.png"))); // NOI18N
        jButton3.setText("Modificar Datos");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        eliminarEmpleado();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        RegistroEmpleadosGUI registro = new RegistroEmpleadosGUI();
        registro.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ModificacionEmpleadosGUI consulta = new ModificacionEmpleadosGUI();
        consulta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            MenuPrincipalGerenteGUI menu = new MenuPrincipalGerenteGUI();
            this.setVisible(false);
            menu.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEmpleadosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEmpleadosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tableEmpleados;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
