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
import javax.swing.JOptionPane;
import model.dao.DatosClientesDao;
import model.dao.DatosDestinatariosDao;
import model.dao.DatosEnviosDao;
import model.dao.DatosPaquetesDao;
import model.vo.DatosClientes;
import model.vo.DatosDestinatarios;
import model.vo.DatosEnvios;
import model.vo.DatosPaquetes;
import view.RegistroEmpleadosGUI;
import view.cliente.InformacionClientesGUI;

/**
 *
 * @author usuario
 */
public class RegistroPaquetesGUI extends javax.swing.JFrame {

    //Atributos
    ArrayList<DatosPaquetes> paquetesL = new ArrayList<>();
    ArrayList<DatosDestinatarios> destinatariosL = new ArrayList<>();
    int id_cliente=0;
    int[] id_destinatarios;
    int [] idCliente;
    String[] cedulaCliente;
    /**
     * Creates new form ConsultaEmpleadosGUI
     */
    public RegistroPaquetesGUI(){
        initComponents();
        btnAdicionar.setEnabled(false);
        validacionCbTamanio();
        
        
        //No olvidar agregar esto para agregarle las animaciones
        this.setLocationRelativeTo(null);

        this.setTitle("Empleados");
        this.setResizable(false);
        
        
    }
    
    
    public void validarCedulaCliente() throws SQLException{
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosClientesDao c = new DatosClientesDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosClientes> lista = c.datosRegistroPaquetes();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        formatoRegistrosCliente(lista);
  
        String ced="";
        
        for(int i = 0; i<lista.size(); i++){
            if(cedulaCliente[i].equals(tfCedulaCliente.getText())){
                id_cliente=idCliente[i];
                ced=cedulaCliente[i];
            }
        }
        
        if(tfCedulaCliente.getText().length()!=0){
            if(ced.equals(tfCedulaCliente.getText())){
                JOptionPane.showMessageDialog(null, "Validación Correcta");
                btnAdicionar.setEnabled(true);
                tfCedulaCliente.setEditable(false);
            }else{
                JOptionPane.showMessageDialog(null, "Escriba bien su cédula");
            }
        }else{
            JOptionPane.showMessageDialog(null, "El campo cedula de cliente no puede estar vacio");
        }
    }
    
    private void validacionCbTamanio() { 
       
        if(cbTipo.getSelectedItem().toString().equals("Sobre")){
            cbTamanio.removeAllItems();
            cbTamanio.addItem("22.5 X 29 cm");
            cbTamanio.addItem("25 X 38 cm");
        }else{
            cbTamanio.removeAllItems();
            cbTamanio.addItem("33 X 22 X 31 cm");
            cbTamanio.addItem("36 X 24 X 27 cm");
            cbTamanio.addItem("37.5 X 25 X 30.5 cm");
            cbTamanio.addItem("40 X 35 X 30 cm");
        }        
    }
    
    public void adicionarPaqueteDestinatarioLocalmente(){
        DatosPaquetes dp= new DatosPaquetes();
        DatosDestinatarios dd = new DatosDestinatarios();
        
        if(tfPeso.getText().length()!=0
                && tfValor.getText().length()!=0
                && tfImpuesto.getText().length()!=0
                && tfSeguro.getText().length()!=0
                
                && tfNum_cedula.getText().length()!=0
                && tfNombre.getText().length()!=0
                && tfDireccion.getText().length()!=0
                && tfCiudad.getText().length()!=0
                && tfTelefono.getText().length()!=0){
                
            dp.setTamanio_paq(cbTamanio.getSelectedItem().toString());
            dp.setPeso_paq(Double.parseDouble(tfPeso.getText()));
            dp.setTipo_paq(cbTipo.getSelectedItem().toString());
            dp.setValor_paq(Integer.parseInt(tfValor.getText()));
            dp.setValor_imp(Integer.parseInt(tfImpuesto.getText()));
            dp.setValor_seguro(Integer.parseInt(tfSeguro.getText()));
            
            dd.setCedula(tfNum_cedula.getText());
            dd.setNombre(tfNombre.getText());
            dd.setDireccion(tfDireccion.getText());
            dd.setCiudad(tfCiudad.getText());
            dd.setTelefono(tfTelefono.getText());
            
            
            paquetesL.add(dp);
            destinatariosL.add(dd);
            
            tfPeso.setText("");
            tfValor.setText("");
            tfImpuesto.setText("");
            tfSeguro.setText("");
            
            tfNum_cedula.setText("");
            tfNombre.setText("");
            tfDireccion.setText("");
            tfCiudad.setText("");
            tfTelefono.setText("");

        }
        
        
    }
    
    public void registrarDestinatarios() throws SQLException{
        id_destinatarios = new int[destinatariosL.size()];
        
        for(int i=0; i<destinatariosL.size();i++){
            DatosDestinatarios nuevoDestinatario = new DatosDestinatarios();
            
            nuevoDestinatario.setCedula(destinatariosL.get(i).getCedula());
            nuevoDestinatario.setNombre(destinatariosL.get(i).getNombre());
            nuevoDestinatario.setDireccion(destinatariosL.get(i).getDireccion());
            nuevoDestinatario.setCiudad(destinatariosL.get(i).getCiudad());
            nuevoDestinatario.setTelefono(destinatariosL.get(i).getTelefono());
            
            DatosDestinatarios destinatarioRegistrado = null;
            DatosDestinatariosDao d = new DatosDestinatariosDao();
            
            try {
                destinatarioRegistrado = d.registrarDestinatario(nuevoDestinatario);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DatosDestinatariosDao c = new DatosDestinatariosDao();
        
            //Este objeto es el que tiene los datos de la base de datos pero para la verificacion
            ArrayList<DatosDestinatarios> lista = c.consultaDestinatarios();

            //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
            id_destinatarios[i]=lista.get(0).getId_destinatario();
        } 

    }
    
    public void registrarEnvio(){
        int suma_valor_paq=0;
        int suma_valor_imp=0;
        int suma_valor_seguro=0;
        int suma_total=0;
        
        for(int i=0; i<paquetesL.size();i++){
            suma_valor_paq=suma_valor_paq+paquetesL.get(i).getValor_paq();
            suma_valor_imp=suma_valor_imp+paquetesL.get(i).getValor_imp();
            suma_valor_seguro=suma_valor_seguro+paquetesL.get(i).getValor_seguro();
        }
        
        suma_total=suma_valor_paq+suma_valor_imp+suma_valor_seguro;
        
        DatosEnvios nuevoEnvio = new DatosEnvios();
        
        nuevoEnvio.setValor_envio(suma_total);
        
        DatosEnvios envioRegistrado = null;
        DatosEnviosDao d = new DatosEnviosDao();
        
        try {
            envioRegistrado = d.registrarEnvio(nuevoEnvio);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void registrarPaquetes() throws SQLException{
        int id_envio;
        DatosEnviosDao c = new DatosEnviosDao();
        
        ArrayList<DatosEnvios> id_envio_array = c.consultaEnvio();
        id_envio=id_envio_array.get(0).getId_envio();
        
        
        
        for(int i=0; i<paquetesL.size();i++){
            DatosPaquetes nuevoPaquete = new DatosPaquetes();
            
            nuevoPaquete.setId_envio(id_envio);
            nuevoPaquete.setTamanio_paq(paquetesL.get(i).getTamanio_paq());
            nuevoPaquete.setPeso_paq(paquetesL.get(i).getPeso_paq());
            nuevoPaquete.setTipo_paq(paquetesL.get(i).getTipo_paq());
            nuevoPaquete.setValor_paq(paquetesL.get(i).getValor_paq());
            nuevoPaquete.setValor_imp(paquetesL.get(i).getValor_imp());
            nuevoPaquete.setValor_seguro(paquetesL.get(i).getValor_seguro());
            nuevoPaquete.setId_cliente(id_cliente);
            nuevoPaquete.setId_dest(id_destinatarios[i]);

            
            DatosPaquetes paqueteRegistrado = null;
            DatosPaquetesDao d = new DatosPaquetesDao();
            
            try {
                paqueteRegistrado = d.registrarPaquete(nuevoPaquete);
            } catch (SQLException ex) {
                Logger.getLogger(RegistroEmpleadosGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        jLabel12 = new javax.swing.JLabel();
        lTitulo2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfPeso = new javax.swing.JTextField();
        tfValor = new javax.swing.JTextField();
        tfImpuesto = new javax.swing.JTextField();
        cbTamanio = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        tfSeguro = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        tfCiudad = new javax.swing.JTextField();
        tfNombre = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        tfNum_cedula = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lTitulo = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tfCedulaCliente = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

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

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoSuperchico.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        lTitulo2.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        lTitulo2.setForeground(new java.awt.Color(238, 112, 82));
        lTitulo2.setText("INFORMACION DESTINATARIO");
        jPanel2.add(lTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Back_64px.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 50, 40));

        jLabel15.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(238, 112, 82));
        jLabel15.setText("Atrás");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel16.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(238, 112, 82));
        jLabel16.setText("Tamaño:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        jLabel17.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(238, 112, 82));
        jLabel17.setText("Peso:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, -1, -1));

        jLabel18.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(238, 112, 82));
        jLabel18.setText("Tipo:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, -1));

        jLabel19.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(238, 112, 82));
        jLabel19.setText("Valor:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        jLabel20.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(238, 112, 82));
        jLabel20.setText("Valor Impuesto:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        jLabel21.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(238, 112, 82));
        jLabel21.setText("Valor seguro:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, -1, -1));

        tfPeso.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfPeso.setForeground(new java.awt.Color(153, 153, 153));
        tfPeso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 170, 25));

        tfValor.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfValor.setForeground(new java.awt.Color(153, 153, 153));
        tfValor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 170, 25));

        tfImpuesto.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfImpuesto.setForeground(new java.awt.Color(153, 153, 153));
        tfImpuesto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 170, 25));

        cbTamanio.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbTamanio.setForeground(new java.awt.Color(153, 153, 153));
        cbTamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTamanioActionPerformed(evt);
            }
        });
        jPanel2.add(cbTamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 170, 25));

        cbTipo.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        cbTipo.setForeground(new java.awt.Color(153, 153, 153));
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sobre", "Caja" }));
        cbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoActionPerformed(evt);
            }
        });
        jPanel2.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 170, 25));

        tfSeguro.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfSeguro.setForeground(new java.awt.Color(153, 153, 153));
        tfSeguro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 170, 25));

        btnAdicionar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnAdicionar.setText("Adicionar Paquete");
        btnAdicionar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, 200, 50));

        tfCiudad.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCiudad.setForeground(new java.awt.Color(153, 153, 153));
        tfCiudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 170, 25));

        tfNombre.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNombre.setForeground(new java.awt.Color(153, 153, 153));
        tfNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 170, 25));

        jLabel22.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(238, 112, 82));
        jLabel22.setText("Nombre Completo: ");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, -1, -1));

        jLabel23.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(238, 112, 82));
        jLabel23.setText("Ciudad: ");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, -1, -1));

        tfNum_cedula.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfNum_cedula.setForeground(new java.awt.Color(153, 153, 153));
        tfNum_cedula.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfNum_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 170, 25));

        jLabel24.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(238, 112, 82));
        jLabel24.setText("Cédula: ");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, -1, -1));

        jLabel3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Dirección:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 90, -1));

        jLabel25.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(238, 112, 82));
        jLabel25.setText("Teléfono: ");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        tfTelefono.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfTelefono.setForeground(new java.awt.Color(153, 153, 153));
        tfTelefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 170, 25));

        tfDireccion.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfDireccion.setForeground(new java.awt.Color(153, 153, 153));
        tfDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 170, 25));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 730, 40));

        lTitulo.setFont(new java.awt.Font("Decker", 1, 28)); // NOI18N
        lTitulo.setForeground(new java.awt.Color(238, 112, 82));
        lTitulo.setText("ADICIONAR PAQUETE");
        jPanel2.add(lTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        btnContinuar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnContinuar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnContinuar.setText("Continuar");
        btnContinuar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel2.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 200, 50));

        jLabel26.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(238, 112, 82));
        jLabel26.setText("Verifique su cédula:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        tfCedulaCliente.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        tfCedulaCliente.setForeground(new java.awt.Color(153, 153, 153));
        tfCedulaCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(tfCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 170, 25));

        btnVerificar.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        btnVerificar.setText("Validar");
        btnVerificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 200, 50));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 730, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        adicionarPaqueteDestinatarioLocalmente();
 
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void cbTamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTamanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTamanioActionPerformed

    private void cbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoActionPerformed
        // TODO add your handling code here:
        validacionCbTamanio();
    }//GEN-LAST:event_cbTipoActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        try {
            registrarDestinatarios();
            registrarEnvio();
            registrarPaquetes();
            JOptionPane.showMessageDialog(null, "Se hizo el registro correctamente");
            
            MenuPaquetesGUI menu = new MenuPaquetesGUI();
            this.setVisible(false);
            menu.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPaquetesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        try {
            // TODO add your handling code here:
            validarCedulaCliente();
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPaquetesGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        InformacionClientesGUI cliente = new InformacionClientesGUI();
        this.setVisible(false);
        cliente.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

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
            java.util.logging.Logger.getLogger(RegistroPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPaquetesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPaquetesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox<String> cbTamanio;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JLabel lTitulo2;
    private javax.swing.JTextField tfCedulaCliente;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfImpuesto;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfNum_cedula;
    private javax.swing.JTextField tfPeso;
    private javax.swing.JTextField tfSeguro;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables
}
