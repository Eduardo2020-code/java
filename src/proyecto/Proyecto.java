/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import controller.Controlador;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    
    //Atributos
    
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        Controlador controlador = new Controlador();
        controlador.iniciarAplicacion();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*DatosUsuarioDao u = new DatosUsuarioDao();
        ArrayList<DatosUsuario> lista = u.listaUsuario();
        
        for(int i = 0; i<lista.size();i++){
            String usuarioAnt = lista.get(i).getUsuarioAnt();
            String usuarioNuevo = lista.get(i).getUsuarioNuevo();
            String contrasenia = lista.get(i).getContrasenia();
            
            System.out.println(usuarioAnt);
            System.out.println(usuarioNuevo);
        }*/
        
        
        
        
        /*//Los datos de la consulta de todos los elementos
        DatosEmpleadosDao c = new DatosEmpleadosDao();
        ArrayList<DatosEmpleados> lista = c.listaEmpleados();  
        
        for(int i = 0; i<lista.size();i++){
            String usuario = lista.get(i).getUsuario();
            String contrasenia = lista.get(i).getContrasenia();
            String nombre = lista.get(i).getTelefono();
            System.out.println(contrasenia);
        }*/
        
        
        
        /*ConsultaEmpleadosGUI cgui = new ConsultaEmpleadosGUI();
        String[][] lista2 = cgui.formatoRegistros(lista, 8);
        for(int i = 0; i<lista2.length;i++){
            String usuario = lista2[i][0];
            String nombre = lista2[i][1];
            System.out.println(usuario);
            System.out.println(nombre);
        }*/
        
        
        
        
        
        
    }
    
    
}
