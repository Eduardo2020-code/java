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
import model.vo.DatosTarjetasDebito;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosTarjetasDebitoDao {
    
    public DatosTarjetasDebito actualizarSaldo(DatosTarjetasDebito saldoActualizar) throws SQLException{
        DatosTarjetasDebito saldoActualizado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE tarjeta_debito SET saldo=? "
                    + "WHERE num_tarjeta=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setInt(1, saldoActualizar.getSaldo());
            statement.setInt(2, saldoActualizar.getNum_tarjeta());
            
            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            saldoActualizado = saldoActualizar;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return saldoActualizado;
    }
    
    public ArrayList<DatosTarjetasDebito> datosReduccionSaldo() throws SQLException{
        
        ArrayList<DatosTarjetasDebito> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT num_tarjeta, saldo FROM tarjeta_debito";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosTarjetasDebito consulta = new DatosTarjetasDebito();
                consulta.setNum_tarjeta(resultado.getInt(1));
                consulta.setSaldo(resultado.getInt(2));
                
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