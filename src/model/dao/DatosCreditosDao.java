/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.DatosClientes;
import model.vo.DatosCreditos;
import model.vo.DatosTarjetasDebito;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosCreditosDao {
    
    
    public DatosCreditos registrarCredito(DatosCreditos nuevoCredito) throws SQLException{
        DatosCreditos creditoRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO credito(num_tarjeta, cuotas, "
                    + "valor_pagar) VALUES(?,?,?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setInt(1, nuevoCredito.getNum_tarjeta());
            statement.setInt(2, nuevoCredito.getCuotas());
            statement.setInt(3, nuevoCredito.getValor_pagar());
            

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            creditoRegistrado = nuevoCredito;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return creditoRegistrado; 
    }
    
}