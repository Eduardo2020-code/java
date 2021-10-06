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
import model.vo.DatosEmpleados;
import model.vo.DatosEnvios;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosEnviosDao {
    
    public DatosEnvios registrarEnvio(DatosEnvios nuevoEnvio) throws SQLException{
        DatosEnvios envioRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO envio(valor_envio) VALUES(?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setInt(1, nuevoEnvio.getValor_envio());

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            envioRegistrado = nuevoEnvio;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return envioRegistrado; 
    }
    
    public ArrayList<DatosEnvios> consultaEnvio() throws SQLException{
        
        ArrayList<DatosEnvios> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT id_envio, valor_envio FROM envio "
                    + "ORDER BY id_envio DESC "
                    + "LIMIT 1";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEnvios consulta = new DatosEnvios();
                consulta.setId_envio(resultado.getInt(1));
                consulta.setValor_envio(resultado.getInt(2));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
}