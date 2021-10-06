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
import model.vo.DatosTarjetas;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosTarjetasDao {
    
    public ArrayList<DatosTarjetas> listaTarjetasDebito() throws SQLException{
        
        ArrayList<DatosTarjetas> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT num_tarjeta, fecha_vencimiento, cod_seguridad, "
                    + "nombre_titular, cedula_titular FROM tarjeta "
                    + "WHERE num_tarjeta IN "
                    + "(SELECT num_tarjeta FROM tarjeta_debito)";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosTarjetas consulta = new DatosTarjetas();
                consulta.setNum_tarjeta(resultado.getInt(1));
                consulta.setFecha_vencimiento(resultado.getString(2));
                consulta.setCod_seguridad(resultado.getInt(3));
                consulta.setNombre_titular(resultado.getString(4));
                consulta.setCedula_titular(resultado.getString(5));
                
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
    
    public ArrayList<DatosTarjetas> listaTarjetasCredito() throws SQLException{
        
        ArrayList<DatosTarjetas> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT num_tarjeta, fecha_vencimiento, cod_seguridad, "
                    + "nombre_titular, cedula_titular FROM tarjeta "
                    + "WHERE num_tarjeta IN "
                    + "(SELECT num_tarjeta FROM tarjeta_credito)";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosTarjetas consulta = new DatosTarjetas();
                consulta.setNum_tarjeta(resultado.getInt(1));
                consulta.setFecha_vencimiento(resultado.getString(2));
                consulta.setCod_seguridad(resultado.getInt(3));
                consulta.setNombre_titular(resultado.getString(4));
                consulta.setCedula_titular(resultado.getString(5));
                
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