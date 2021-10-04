/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.dao.DatosEmpleadosDao;
import model.vo.DatosEmpleados;
import view.ConsultaEmpleadosGUI;
import view.ModificacionEmpleadosGUI;
import view.RegistroEmpleadosGUI;
/**
 *
 * @author usuario
 */
public class Controlador {
    
    //Atributos objetos del modelo
    private final DatosEmpleadosDao datosEmpleadosDao;
    
    //Atributos vista o interfaz
    private final ConsultaEmpleadosGUI consultaEmpleadosGUI;
    private ModificacionEmpleadosGUI modificacionEmpleadosGUI;
    private RegistroEmpleadosGUI registroEmpleadosGUI;
    
    public Controlador(){
        this.datosEmpleadosDao = new DatosEmpleadosDao();
        
        //Instanciar la interfaz principal
        this.consultaEmpleadosGUI = new ConsultaEmpleadosGUI();
    }
    
    public ArrayList<DatosEmpleados> datosEmpleados() throws SQLException{
        return this.datosEmpleadosDao.listaEmpleados();
    }
    
    /*public void mostrarEmpleados() {
        //Se defin el table model
        DefaultTableModel tEmpleados = new DefaultTableModel();
        JTable tableEmpleados = new javax.swing.JTable();
        ConsultaEmpleadosGUI consultaGUI = new ConsultaEmpleadosGUI();
        
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
        consultaGUI.getTableEmpleados().setModel(tEmpleados);
        
        //Se obtiene el numero de columnas
        int numColumnas=tEmpleados.getColumnCount();
        
        //Se crea un objeto de este tipo debido a que alli se encuentra el metodo que obtiene la lista de elementos de tipo consulta empleados
        DatosEmpleadosDao c = new DatosEmpleadosDao();
        
        //Este objeto es el que tiene los datos de la base de datos, los metodos para obtener dichos valores
        ArrayList<DatosEmpleados> lista = c.listaEmpleados();
        
        //El objeto se covierte a un arreglo usando el metodo de esta clase el cual recibe el arraylist del tipo consultaEmpleados y el numero de columnas
        String[][] lista2 = consultaGUI.formatoRegistros(lista, numColumnas);
        
        //Se agregan de la lista obtenida en array los datos de la base de datos
        for(int i = 0; i<lista.size(); i++){
            tEmpleados.addRow(lista2[i]);
        }
        
        //Se vuelve a setear para agregar los elementos de la BD
        consultaGUI.getTableEmpleados().setModel(tEmpleados);
    
    }*/
    
    public void iniciarAplicacion(){
        consultaEmpleadosGUI.setVisible(true);
    }
}