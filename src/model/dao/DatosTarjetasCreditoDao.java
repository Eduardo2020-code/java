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
import model.vo.DatosTarjetasCredito;
import model.vo.DatosTarjetasDebito;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosTarjetasCreditoDao {
    
    
    public ArrayList<DatosTarjetasCredito> listaTarjetasCredito() throws SQLException{
        
        ArrayList<DatosTarjetasCredito> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT num_tarjeta FROM tarjeta_credito";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosTarjetasCredito consulta = new DatosTarjetasCredito();
                consulta.setNum_tarjeta(resultado.getInt(1));
                
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