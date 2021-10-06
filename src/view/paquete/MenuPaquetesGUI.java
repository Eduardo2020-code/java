/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.paquete;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.dao.DatosPaquetesDao;
import model.vo.DatosClientes;
import model.vo.DatosPaquetes;
import view.ModificacionEmpleadosGUI;
import view.envio.MedioPagoGUI;
/**
 *
 * @author usuario
 */
public class MenuPaquetesGUI extends javax.swing.JFrame {

    //Atributos
    DefaultTableModel tPaquetes = new DefaultTableModel();
    int id_cliente=0;
    int[] id_destinatarios;
    int [] idCliente;
    String[] cedulaCliente;
    String ced="";
    
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public MenuPaquetesGUI(){
        initComponents();
        mostrarPaquetes();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);
        this.setTitle("Paquetes");
        this.setResizable(false);
        
        
    }
    
    
    
    private void mostrarPaquetes() {
        //Se defin el table model globalmente
       
        
        
        
        //Se agregan las columnas de la tabla a mostrar
        tPaquetes.addColumn("Tamaño");
        tPaquetes.addColumn("Peso");
        tPaquetes.addColumn("Tipo");
        tPaquetes.addColumn("Valor");
        tPaquetes.addColumn("Valor Impuesto");
        tPaquetes.addColumn("Valor Seguro");
        tPaquetes.addColumn("Id_Destinatario");
        
        //Se setea el modelo
        tablePaquetes.setModel(tPaquetes);
        
        //Se obtiene el numero de columnas
        int numColumnas=tPaquetes.getColumnCount();
        
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosPaquetesDao c = new DatosPaquetesDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosPaquetes> lista = c.listaPaquetes();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = formatoRegistros(lista);
        
        for(int i = 0; i<lista2.length;i++){
            tPaquetes.addRow(lista2[i]);
        }
           
        
        
        
        //Se vuelve a setear para agregar los elementos de la BD
        tablePaquetes.setModel(tPaquetes);
    }
    
    public String[][] formatoRegistros(ArrayList<DatosPaquetes> consulta){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][7];        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = consulta.get(i).getTamanio_paq();
            registros[i][1] = Double.toString(consulta.get(i).getPeso_paq());
            registros[i][2] = consulta.get(i).getTipo_paq();
            registros[i][3] = Integer.toString(consulta.get(i).getValor_paq());
            registros[i][4] = Integer.toString(consulta.get(i).getValor_imp());
            registros[i][5] = Integer.toString(consulta.get(i).getValor_seguro());
            registros[i][6] = Integer.toString(consulta.get(i).getId_dest());
        }

        //Retornar registros en formato JTable
        return registros;

    }
    
    public void formatoRegistrosCliente(ArrayList<DatosClientes> consulta){
        
        //Declaración del contenedor de retorno
        cedulaCliente = new String[consulta.size()];        
        idCliente = new int [consulta.size()];

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            idCliente[i] = consulta.get(i).getId_cliente();
            cedulaCliente[i] = consulta.get(i).getNum_cedula();
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
        jPanel2 = new javax.swing.JPanel();
        lTtitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePaquetes = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lTtitulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        lTtitulo.setForeground(new java.awt.Color(238, 112, 82));
        lTtitulo.setText("PAQUETES A ENVIAR");
        jPanel2.add(lTtitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 300, 30));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(440, 402));

        tablePaquetes.setAutoCreateRowSorter(true);
        tablePaquetes.setBackground(new java.awt.Color(255, 208, 164));
        tablePaquetes.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tablePaquetes.setForeground(new java.awt.Color(238, 112, 82));
        tablePaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tamaño", "Peso", "Tipo", "Valor", "Impuesto (19%)", "Valor seguro", "Destinatario", "null"
            }
        ));
        tablePaquetes.setGridColor(new java.awt.Color(238, 112, 82));
        tablePaquetes.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tablePaquetes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablePaquetes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 760, 70));

        btnPagar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel2.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 200, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // TODO add your handling code here:
        MedioPagoGUI medio;
        try {
            medio = new MedioPagoGUI();
            this.setVisible(false);
            medio.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuPaquetesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnPagarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new MenuPaquetesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lTtitulo;
    private javax.swing.JTable tablePaquetes;
    // End of variables declaration//GEN-END:variables
}
