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
        
        
    }
    
    
}
