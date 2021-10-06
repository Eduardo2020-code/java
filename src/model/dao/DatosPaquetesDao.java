
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.DatosPaquetes;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */

    

public class DatosPaquetesDao {
    
    public DatosPaquetes registrarPaquete(DatosPaquetes nuevoPaquete) throws SQLException{
        DatosPaquetes paqueteRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO paquete(id_envio, tamanio_paq, "
                    + "peso_paq, tipo_paq, valor_paq, valor_imp, valor_seguro, "
                    + "id_cliente, id_dest) VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setInt(1, nuevoPaquete.getId_envio());
            statement.setString(2, nuevoPaquete.getTamanio_paq());
            statement.setDouble(3, nuevoPaquete.getPeso_paq());
            statement.setString(4, nuevoPaquete.getTipo_paq());
            statement.setInt(5, nuevoPaquete.getValor_paq());
            statement.setInt(6, nuevoPaquete.getValor_imp());
            statement.setInt(7, nuevoPaquete.getValor_seguro());
            statement.setInt(8, nuevoPaquete.getId_cliente());
            statement.setInt(9, nuevoPaquete.getId_dest());

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            paqueteRegistrado = nuevoPaquete;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return paqueteRegistrado; 
    }
    
    public ArrayList<DatosPaquetes> listaPaquetes(){
        
        ArrayList<DatosPaquetes> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT tamanio_paq, peso_paq, tipo_paq, valor_paq, "
                    + "valor_imp, valor_seguro, id_dest FROM paquete "
                    + "WHERE id_envio IN (SELECT id_envio FROM envio "
                    + "ORDER BY id_envio DESC LIMIT 1)";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosPaquetes consulta = new DatosPaquetes();
                consulta.setTamanio_paq(resultado.getString(1));
                consulta.setPeso_paq(resultado.getDouble(2));
                consulta.setTipo_paq(resultado.getString(3));
                consulta.setValor_paq(resultado.getInt(4));
                consulta.setValor_imp(resultado.getInt(5));
                consulta.setValor_seguro(resultado.getInt(6));
                consulta.setId_dest(resultado.getInt(7));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public ArrayList<DatosPaquetes> datosEfectivo(){
        
        ArrayList<DatosPaquetes> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT num_paq, valor_paq, "
                    + "valor_imp, valor_seguro FROM paquete "
                    + "WHERE id_envio IN (SELECT id_envio FROM envio "
                    + "ORDER BY id_envio DESC LIMIT 1)";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosPaquetes consulta = new DatosPaquetes();
                consulta.setNum_paq(resultado.getInt(1));
                consulta.setValor_paq(resultado.getInt(2));
                consulta.setValor_imp(resultado.getInt(3));
                consulta.setValor_seguro(resultado.getInt(4));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
}
