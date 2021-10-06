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
import model.vo.DatosDestinatarios;
import model.vo.DatosEnvios;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosDestinatariosDao {
    
    public DatosDestinatarios registrarDestinatario(DatosDestinatarios nuevoDestinatario) throws SQLException{
        DatosDestinatarios destinatarioRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO destinatario(nombre_dest, cedula_dest,"
                    + "dir_dest, ciudad_dest, tel_dest) VALUES(?,?,?,?,?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, nuevoDestinatario.getNombre());
            statement.setString(2, nuevoDestinatario.getCedula());
            statement.setString(3, nuevoDestinatario.getDireccion());
            statement.setString(4, nuevoDestinatario.getCiudad());
            statement.setString(5, nuevoDestinatario.getTelefono());
            

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            destinatarioRegistrado = nuevoDestinatario;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return destinatarioRegistrado; 
    }
    
    public ArrayList<DatosDestinatarios> consultaDestinatarios() throws SQLException{
        
        ArrayList<DatosDestinatarios> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT id_dest FROM destinatario "
                    + "ORDER BY id_dest DESC "
                    + "LIMIT 1";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosDestinatarios consulta = new DatosDestinatarios();
                consulta.setId_destinatario(Integer.parseInt(resultado.getString(1)));
                
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