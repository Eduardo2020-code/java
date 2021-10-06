
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.vo.DatosClientes;
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosClientesDao {
    
    public ArrayList<DatosClientes> listaClientes(){
        
        ArrayList<DatosClientes> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT cedula_cliente, nombre_cliente, "
                + "direccion_cliente, ciudad_cliente, telefono_cliente, id_sede"
                + " FROM cliente";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosClientes consulta = new DatosClientes();
                consulta.setNum_cedula(resultado.getString(1));
                consulta.setNombre(resultado.getString(2));
                consulta.setDireccion(resultado.getString(3));
                consulta.setCiudad(resultado.getString(4));
                consulta.setTelefono(resultado.getString(5));
                consulta.setId_sede(Integer.toString(resultado.getInt(6)));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
//Con esto se hace validacion al momento de registrar de si ese cliente ya esta registrado en la base de datos
    public ArrayList<DatosClientes> datosRegistroClientes(){
        
        ArrayList<DatosClientes> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT cedula_cliente FROM cliente";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosClientes consulta = new DatosClientes();
                consulta.setNum_cedula(resultado.getString(1));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public ArrayList<DatosClientes> datosRegistroPaquetes(){
        
        ArrayList<DatosClientes> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT id_cliente, cedula_cliente FROM cliente";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosClientes consulta = new DatosClientes();
                consulta.setId_cliente(Integer.parseInt(resultado.getString(1)));
                consulta.setNum_cedula(resultado.getString(2));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public ArrayList<DatosClientes> datosConsultaPaquetes(){
        return datosRegistroPaquetes();
    }
    
    
    public DatosClientes registrarCliente(DatosClientes nuevoCliente) throws SQLException{
        DatosClientes clienteRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO cliente(cedula_cliente, nombre_cliente,"
                    + "direccion_cliente, ciudad_cliente, telefono_cliente, id_sede , "
                    + "VALUES(?,?,?,?,?,?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setString(1, nuevoCliente.getNum_cedula());
            statement.setString(2, nuevoCliente.getNombre());
            statement.setString(3, nuevoCliente.getDireccion());
            statement.setString(4, nuevoCliente.getCiudad());
            statement.setString(5, nuevoCliente.getTelefono());
            statement.setInt(6, (int) Integer.parseInt((String)nuevoCliente.getId_sede()));

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            clienteRegistrado = nuevoCliente;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return clienteRegistrado; 
    }
}
