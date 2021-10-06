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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.DatosEmpleadosDao;
import model.dao.DatosSedesDao;
import model.vo.DatosEmpleados;
import model.vo.DatosSedes;
import util.JDBCUtilities;
import view.MenuPrincipalGUI;
import view.RegistroEmpleadosGUI;

/**
 *
 * @author Windows 10
 */
public class ObtenerSedeGUI extends javax.swing.JFrame {
    DefaultTableModel tSedes = new DefaultTableModel();

    /**
     * Creates new form ObtenerSede
     */
    public ObtenerSedeGUI() {
        initComponents();
        
         this.setLocationRelativeTo(null);
        this.setTitle("Sedes");
        this.setResizable(false);
        mostrarSedes();
        
        
    }
     private void mostrarSedes() {
        //Se defin el table model globalmente
       
        //Se agregan las columnas de la tabla a mostrar
        tSedes.addColumn("id_sede");
        tSedes.addColumn("Direccion");
        tSedes.addColumn("Barrio");
        tSedes.addColumn("Cuidad");
        tSedes.addColumn("Telefono");
        
        
        //Se setea el modelo
        getjTableSedes().setModel(tSedes);
        
        //Se obtiene el numero de columnas
        int numColumnas=tSedes.getColumnCount();
        
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosSedesDao c = new DatosSedesDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosSedes> lista = c.listaSedes();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista, numColumnas);
        
        //Se agregan de la lista obtenida en array los datos de la base de datos
        for(int i = 0; i<lista.size(); i++){
            tSedes.addRow(lista2[i]);
        }
        
        //Se vuelve a setear para agregar los elementos de la BD
        jTableSedes.setModel(tSedes);
    }
    public String[][] formatoRegistros(ArrayList<DatosSedes> consulta, int numeroColumnas){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][numeroColumnas];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {     
            registros[i][0] = String.valueOf (consulta.get(i).getId_sede());
            registros[i][1] = consulta.get(i).getDireccion_sede();
            registros[i][2] = consulta.get(i).getBarrio_sede();
            registros[i][3] = consulta.get(i).getCiudad_sede();
            registros[i][4] = consulta.get(i).getTelefono_sede();
          
            
        }

        //Retornar registros en formato JTable
        return registros;

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSedes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("");
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableSedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id_sede", "dir_sede", "Barrio_sede", "Cuidad_sede", "Tel_sede"
            }
        ));
        jScrollPane1.setViewportView(jTableSedes);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 470, 100));

        jPanel2.setLayout(null);
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 470, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 90));

        titulo1.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo1.setForeground(new java.awt.Color(238, 112, 82));
        titulo1.setText("INFORMACION DE SEDES");
        titulo1.setToolTipText("");
        jPanel3.add(titulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 350, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Atrás");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 60, 50, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            MenuPrincipalGUI menu = new MenuPrincipalGUI();
            this.setVisible(false);
            menu.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(ObtenerSedeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(ObtenerSedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObtenerSedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObtenerSedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObtenerSedeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObtenerSedeGUI().setVisible(true);
            }
        });
    }

    public DefaultTableModel gettSedes() {
        return tSedes;
    }

    public void settSedes(DefaultTableModel tSedes) {
        this.tSedes = tSedes;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getjTableSedes() {
        return jTableSedes;
    }

    public void setjTableSedes(JTable jTableSedes) {
        this.jTableSedes = jTableSedes;
    }

    public JLabel getTitulo1() {
        return titulo1;
    }

    public void setTitulo1(JLabel titulo1) {
        this.titulo1 = titulo1;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSedes;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
