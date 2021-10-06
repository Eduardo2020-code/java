/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.envio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.dao.DatosCreditosDao;
import model.dao.DatosEnviosDao;
import model.dao.DatosTarjetasDao;
import model.dao.DatosTarjetasDebitoDao;
import model.vo.DatosCreditos;
import model.vo.DatosEnvios;
import model.vo.DatosTarjetas;
import model.vo.DatosTarjetasDebito;
import view.ModificacionEmpleadosGUI;
/**
 *
 * @author usuario
 */
public final class TarjetaGUI extends javax.swing.JFrame {

    //Atributos
    int valor_pago=0;
    int saldo_tarjeta=0;
    int numero_tarjeta=0;
    int saldo=0;
    /**
     * Creates new form ConsultaEmpleadosGUI
     * @throws java.sql.SQLException
     */
    public TarjetaGUI() throws SQLException{
        initComponents();
        
        cbCuotas.setEnabled(false);
        tfTotalPago.setEditable(false);
        obtenerValorPago();
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);
        this.setTitle("Empleados");
        this.setResizable(false);
        
        
    }  
    
    public void obtenerValorPago() throws SQLException{
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosEnviosDao c = new DatosEnviosDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosEnvios> lista = c.consultaEnvioTarjeta();

        valor_pago=lista.get(0).getValor_envio();
        tfTotalPago.setText(String.valueOf(valor_pago));
        
    }
    
    public void obtenerSaldoTarjetaDebito() throws SQLException{
        DatosTarjetasDebitoDao c = new DatosTarjetasDebitoDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosTarjetasDebito> lista = c.datosReduccionSaldo();
        
        int [][] lista2 = formatoRegistrosTarjetasDebito(lista);
        
        for(int i=0; i<lista.size();i++){
            if(tfNumero.getText().length()!=0){
                if(Integer.parseInt(tfNumero.getText())==lista2[i][0]){
                saldo_tarjeta=lista2[i][1];
                }
            }
        }
    }
   
    
    public void validarTarjetaDebito() throws SQLException{

        int mes=jcMes.getMonth()+1;
        int anio=jcAnio.getYear();
        
        //Se concatena para que quede en un unico string la fecha de vencimiento
        String fechaVencimiento=String.valueOf(mes)+"/"+String.valueOf(anio);
        
        DatosTarjetasDao c = new DatosTarjetasDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosTarjetas> lista = c.listaTarjetasDebito();
        
        String[][] lista2 = formatoRegistrosTarjetas(lista);
        
        String fecha_vencimiento="";
        int codigo_seguridad=0;
        String nombre_titular="";
        String cedula_titular="";
        
        
        for(int i=0; i<lista.size();i++){
            if(lista2[i][0].equals(tfNumero.getText())){
                numero_tarjeta=Integer.parseInt(lista2[i][0]);
                fecha_vencimiento=lista2[i][1];
                codigo_seguridad=Integer.parseInt(lista2[i][2]);
                nombre_titular=lista2[i][3];
                cedula_titular=lista2[i][4];
            }
        }
        
        if(tfNumero.getText().length()!=0
                && tfCodigoSeg.getText().length()!=0
                && tfNombre.getText().length()!=0
                && tfCedula.getText().length()!=0){
            if(numero_tarjeta==Integer.parseInt(tfNumero.getText())){
                if(fecha_vencimiento.equals(fechaVencimiento)){
                    if(codigo_seguridad==Integer.parseInt(tfCodigoSeg.getText())){
                        if(nombre_titular.equals(tfNombre.getText())){
                            if(cedula_titular.equals(tfCedula.getText())){
                                
                                saldo=saldo_tarjeta-valor_pago;
                                
                                DatosTarjetasDebito saldoActualizar = new DatosTarjetasDebito();

                                saldoActualizar.setSaldo(saldo);
                                saldoActualizar.setNum_tarjeta(Integer.parseInt(tfNumero.getText()));
                                

                                DatosTarjetasDebito saldoActualizado =null;
                                DatosTarjetasDebitoDao d = new DatosTarjetasDebitoDao();

                                saldoActualizado = d.actualizarSaldo(saldoActualizar);

                                if(saldoActualizado != null){
                                    JOptionPane.showMessageDialog(null, "Se registró el pago correctamente");
                                    this.setVisible(false);
                                    ModificacionEmpleadosGUI modificacion = new ModificacionEmpleadosGUI();
                                    modificacion.setVisible(true);

                                }else{
                                    JOptionPane.showMessageDialog(null, "No se completó la actualización de datos");
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "La cedula no es válida");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El nombre del titular no es válido");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El código de seguridad no es válido");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha de vencimiento no es válida");
                }
            }else{
                JOptionPane.showMessageDialog(null, "El número de tarjeta no es válido");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios");
        }
    }
    
    public void validarTarjetaCredito() throws SQLException{

        int mes=jcMes.getMonth()+1;
        int anio=jcAnio.getYear();
        
        //Se concatena para que quede en un unico string la fecha de vencimiento
        String fechaVencimiento=String.valueOf(mes)+"/"+String.valueOf(anio);
        
        DatosTarjetasDao c = new DatosTarjetasDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosTarjetas> lista = c.listaTarjetasCredito();
        
        String[][] lista2 = formatoRegistrosTarjetas(lista);
        
        String fecha_vencimiento="";
        int codigo_seguridad=0;
        String nombre_titular="";
        String cedula_titular="";
        
        
        for(int i=0; i<lista.size();i++){
            if(lista2[i][0].equals(tfNumero.getText())){
                numero_tarjeta=Integer.parseInt(lista2[i][0]);
                fecha_vencimiento=lista2[i][1];
                codigo_seguridad=Integer.parseInt(lista2[i][2]);
                nombre_titular=lista2[i][3];
                cedula_titular=lista2[i][4];
            }
        }
        System.out.println("cedula "+cedula_titular);
        
        if(tfNumero.getText().length()!=0
                && tfCodigoSeg.getText().length()!=0
                && tfNombre.getText().length()!=0
                && tfCedula.getText().length()!=0){
            if(numero_tarjeta==Integer.parseInt(tfNumero.getText())){
                if(fecha_vencimiento.equals(fechaVencimiento)){
                    if(codigo_seguridad==Integer.parseInt(tfCodigoSeg.getText())){
                        if(nombre_titular.equals(tfNombre.getText())){
                            if(cedula_titular.equals(tfCedula.getText())){
                                
                                DatosCreditos creditoCrear = new DatosCreditos();
                                
                                creditoCrear.setNum_tarjeta(Integer.parseInt(tfNumero.getText()));
                                creditoCrear.setCuotas(Integer.parseInt(cbCuotas.getSelectedItem().toString()));
                                creditoCrear.setValor_pagar(valor_pago);


                                DatosCreditos creditoCreado=null;
                                DatosCreditosDao d = new DatosCreditosDao();

                                creditoCreado = d.registrarCredito(creditoCrear);

                                if(creditoCreado != null){
                                    JOptionPane.showMessageDialog(null, "Se generó el crédito correctamente");
                                    this.setVisible(false);
                                    ModificacionEmpleadosGUI modificacion = new ModificacionEmpleadosGUI();
                                    modificacion.setVisible(true);

                                }else{
                                    JOptionPane.showMessageDialog(null, "No se completó la actualización de datos");
                                }
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "La cedula no es válida");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "El nombre del titular no es válido");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El código de seguridad no es válido");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "La fecha de vencimiento no es válida");
                }
            }else{
                JOptionPane.showMessageDialog(null, "El número de tarjeta no es válido");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacios");
        }
    }
    
    public String[][] formatoRegistrosTarjetas(ArrayList<DatosTarjetas> consulta){
        
        //Declaración del contenedor de retorno
        String[][] registros = new String[consulta.size()][5];        
        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = String.valueOf(consulta.get(i).getNum_tarjeta());
            registros[i][1] = consulta.get(i).getFecha_vencimiento();
            registros[i][2] = String.valueOf(consulta.get(i).getCod_seguridad());
            registros[i][3] = consulta.get(i).getNombre_titular();
            registros[i][4] = consulta.get(i).getCedula_titular();
            
        }

        //Retornar registros en formato JTable
        return registros;

    }
    
    public int[][] formatoRegistrosTarjetasDebito(ArrayList<DatosTarjetasDebito> consulta){
        
        //Declaración del contenedor de retorno
        int[][] registros = new int[consulta.size()][2];        
        

        //Desenvolver los objetos de la colección
        for (int i = 0; i < consulta.size(); i++) {            
            registros[i][0] = consulta.get(i).getNum_tarjeta();
            registros[i][1] = consulta.get(i).getSaldo();
            
            
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
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPago = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        tfCedula = new javax.swing.JTextField();
        tfCodigoSeg = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        cbCuotas = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        tfTotalPago = new javax.swing.JTextField();
        jcMes = new com.toedter.calendar.JMonthChooser();
        jcAnio = new com.toedter.calendar.JYearChooser();

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
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 112, 82));
        jLabel15.setText("Atrás");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 112, 82));
        jLabel16.setText("Tipo de tarjeta:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Nombre titular:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, -1, -1));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 112, 82));
        jLabel21.setText("Numero tarjeta:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        titulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(238, 112, 82));
        titulo.setText("PAGO CON TARJETA");
        jPanel2.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 290, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/team_96px.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnPago.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept-circular-button-outline.png"))); // NOI18N
        btnPago.setText("Generar Pago");
        btnPago.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });
        jPanel2.add(btnPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 200, 50));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 112, 82));
        jLabel18.setText("Fecha Vencimiento:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 580, 20));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(238, 112, 82));
        jLabel19.setText("Cédula titular:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        tfNumero.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNumero.setForeground(new java.awt.Color(153, 153, 153));
        tfNumero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 170, 25));

        tfNombre.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNombre.setForeground(new java.awt.Color(153, 153, 153));
        tfNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 170, 25));

        tfCedula.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCedula.setForeground(new java.awt.Color(153, 153, 153));
        tfCedula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 170, 25));

        tfCodigoSeg.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCodigoSeg.setForeground(new java.awt.Color(153, 153, 153));
        tfCodigoSeg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfCodigoSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 170, 25));

        jLabel20.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(238, 112, 82));
        jLabel20.setText("Código de seguridad:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        cbTipo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbTipo.setForeground(new java.awt.Color(153, 153, 153));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Débito", "Crédito" }));
        cbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTipoItemStateChanged(evt);
            }
        });
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        jPanel2.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 170, 25));

        jLabel22.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(238, 112, 82));
        jLabel22.setText("Número de cuotas:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 580, 20));

        cbCuotas.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbCuotas.setForeground(new java.awt.Color(153, 153, 153));
        cbCuotas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuotasActionPerformed(evt);
            }
        });
        jPanel2.add(cbCuotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 170, 25));

        jLabel23.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(238, 112, 82));
        jLabel23.setText("Valor a cancelar:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        tfTotalPago.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfTotalPago.setForeground(new java.awt.Color(153, 153, 153));
        tfTotalPago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfTotalPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 170, 25));
        jPanel2.add(jcMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, -1, -1));
        jPanel2.add(jcAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 320, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 800, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed

        if(cbTipo.getSelectedItem().toString().equals("Débito")){
            try {
                obtenerValorPago();
                obtenerSaldoTarjetaDebito();
                validarTarjetaDebito();
            } catch (SQLException ex) {
                Logger.getLogger(TarjetaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else {
            try {
                obtenerValorPago();
                validarTarjetaCredito();
            } catch (SQLException ex) {
                Logger.getLogger(TarjetaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnPagoActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        MedioPagoGUI medio;
        try {
            medio = new MedioPagoGUI();
            this.setVisible(false);
            medio.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EfectivoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        if(cbTipo.getSelectedItem().toString().equals("Crédito")){
            cbCuotas.setEnabled(true);
        }else{
            cbCuotas.setEnabled(false);
        }
        
        
    }//GEN-LAST:event_cbTipoActionPerformed

    private void cbCuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCuotasActionPerformed

    private void cbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTipoItemStateChanged
        
    }//GEN-LAST:event_cbTipoItemStateChanged

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
            java.util.logging.Logger.getLogger(TarjetaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarjetaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarjetaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarjetaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new TarjetaGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TarjetaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPago;
    private javax.swing.JComboBox<String> cbCuotas;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private com.toedter.calendar.JYearChooser jcAnio;
    private com.toedter.calendar.JMonthChooser jcMes;
    private javax.swing.JTextField tfCedula;
    private javax.swing.JTextField tfCodigoSeg;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNumero;
    private javax.swing.JTextField tfTotalPago;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
