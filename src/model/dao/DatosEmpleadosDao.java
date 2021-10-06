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
import util.JDBCUtilities;

/**
 *
 * @author usuario
 */
public class DatosEmpleadosDao {
    
    public ArrayList<DatosEmpleados> listaEmpleados(){
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, nombre, num_cedula, "
                + "telefono, direccion, ciudad, cargo, id_sede"
                + " FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setNombre(resultado.getString(2));
                consulta.setNum_cedula(resultado.getString(3));
                consulta.setTelefono(resultado.getString(4));
                consulta.setDireccion(resultado.getString(5));
                consulta.setCiudad(resultado.getString(6));
                consulta.setCargo(resultado.getString(7));
                consulta.setId_sede(Integer.toString(resultado.getInt(8)));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public ArrayList<DatosEmpleados> datosRegistroEmpleados(){
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, num_cedula FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setNum_cedula(resultado.getString(2));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public ArrayList<DatosEmpleados> datosLogin(){
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia, cargo FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                consulta.setCargo(resultado.getString(3));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    public DatosEmpleados registrarEmpleado(DatosEmpleados nuevoEmpleado) throws SQLException{
        DatosEmpleados empleadoRegistrado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "INSERT INTO empleado(usuario, contrasenia, "
                    + "nombre, num_cedula, telefono, direccion, "
                    + "ciudad, cargo, id_sede) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, nuevoEmpleado.getUsuario());
            statement.setString(2, nuevoEmpleado.getContrasenia());
            statement.setString(3, nuevoEmpleado.getNombre());
            statement.setString(4, nuevoEmpleado.getNum_cedula());
            statement.setString(5, nuevoEmpleado.getTelefono());
            statement.setString(6, nuevoEmpleado.getDireccion());
            statement.setString(7, nuevoEmpleado.getCiudad());
            statement.setString(8, nuevoEmpleado.getCargo());
            statement.setInt(9, (int) Integer.parseInt((String)nuevoEmpleado.getId_sede()));
            

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoRegistrado = nuevoEmpleado;

        }catch(SQLException e){
            System.err.println("Error registrando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return empleadoRegistrado; 
    }
    
    public DatosEmpleados eliminarEmpleado(DatosEmpleados eliminaEmpleado) throws SQLException{
        DatosEmpleados empleadoEliminado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET estado=false "
                    + "WHERE usuario=?";
            

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, eliminaEmpleado.getUsuario());
            

            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoEliminado = eliminaEmpleado;

        }catch(SQLException e){
            System.err.println("Error eliminando empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }

        //Retornar la instancia del material o el nulo para validaciones posteriores
        return empleadoEliminado; 
    }
    
    public ArrayList<DatosEmpleados> datosModificacionUsuario() throws SQLException{
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia FROM empleado";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                
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
    
    public int existeUsuario(String usuarioExiste) throws SQLException{
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "SELECT count(id_empleado) FROM empleado "
                    + "WHERE usuario=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, usuarioExiste);
            
            
            //Realizar la actualización: Crear material
            ResultSet resultado = statement.executeQuery();

            if(resultado.next()){
                return resultado.getInt(1);
            }
            return 1;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
            return 1;
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
    }
    
    public DatosEmpleados actualizarUsuario(DatosEmpleados usuarioActualizar) throws SQLException{
        DatosEmpleados usuarioActualizado = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET usuario=? "
                    + "WHERE usuario=? AND contrasenia=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, usuarioActualizar.getUsuarioNuevo());
            statement.setString(2, usuarioActualizar.getUsuario());
            statement.setString(3, usuarioActualizar.getContrasenia());
            
            
            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            usuarioActualizado = usuarioActualizar;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return usuarioActualizado;
    }
    
    public ArrayList<DatosEmpleados> datosModificacionContrasenia() throws SQLException{
        return datosModificacionUsuario();
    }
    
    public DatosEmpleados actualizarContrasenia(DatosEmpleados contraseniaActualizar) throws SQLException{
        DatosEmpleados contraseniaActualizada = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET contrasenia=? "
                    + "WHERE usuario=? AND contrasenia=?";

            PreparedStatement statement = conexion.prepareStatement(consulta);

            statement.setString(1, contraseniaActualizar.getContraseniaNueva());
            statement.setString(2, contraseniaActualizar.getUsuario());
            statement.setString(3, contraseniaActualizar.getContrasenia());
            
            
            //Realizar la actualización: Crear material
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            contraseniaActualizada = contraseniaActualizar;

        }catch(SQLException e){
            System.err.println("Error modificando datos de empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return contraseniaActualizada;
    }
    
    /**
     * Enlista los atributos de la base de datos pero solo los necesarios para hacer la actualizacion de nombre de empleado
     * @return ArrayList de tipo objeto DatosNombre
     */
    public ArrayList<DatosEmpleados> datosModificacionNombre(){
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia, nombre"
                + " FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                consulta.setNombre(resultado.getString(3));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    /**
     * Actualiza el nombre del empleado en la base de datos
     * @param nombreEmpleado de tipo DatosNombre
     * @return DatosNombre objeto de este tipo
     * @throws SQLException 
     */
    public DatosEmpleados actualizarNombre(DatosEmpleados nombreEmpleado) throws SQLException{
        DatosEmpleados empleadoNombre = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET nombre=? "
                    + "WHERE usuario=? and contrasenia=?";
            

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setString(1, nombreEmpleado.getNombreNuevo());
            statement.setString(2, nombreEmpleado.getUsuario());
            statement.setString(3, nombreEmpleado.getContrasenia());
 
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoNombre = nombreEmpleado;

        }catch(SQLException e){
            System.err.println("Error actualizando nombre empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return empleadoNombre; 
    }
    
    /**
     * Enlista los atributos de la base de datos pero solo los necesarios para hacer la actualizacion de telefono de empleado
     * @return ArrayList de tipo objeto DatosTelefono
     */
    public ArrayList<DatosEmpleados> datosModificacionTelefono(){
        
        ArrayList<DatosEmpleados> respuesta = new ArrayList<>();
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();
            
            String query = "SELECT usuario, contrasenia, telefono"
                + " FROM empleado"
                    + " WHERE estado=true";
            
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            
            while(resultado.next()){
                DatosEmpleados consulta = new DatosEmpleados();
                consulta.setUsuario(resultado.getString(1));
                consulta.setContrasenia(resultado.getString(2));
                consulta.setTelefono(resultado.getString(3));
                
                respuesta.add(consulta);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error en la consulta " + e);
        }
        return respuesta;
    }
    
    /**
     * Actualiza el Telefono del empleado en la base de datos
     * @param telefonoEmpleado de tipo DatosNombre
     * @return DatosNombre objeto de este tipo
     * @throws SQLException 
     */
    public DatosEmpleados actualizarTelefono(DatosEmpleados telefonoEmpleado) throws SQLException{
        DatosEmpleados empleadoTelefono = null;
        Connection conexion = null;
        JDBCUtilities conex = new JDBCUtilities();
        
        try{
            conexion= conex.getConnection();

            String consulta = "UPDATE empleado SET telefono=? "
                    + "WHERE usuario=? and contrasenia=?";
            

            PreparedStatement statement = conexion.prepareStatement(consulta);
            
            statement.setString(1, telefonoEmpleado.getTelefonoNuevo());
            statement.setString(2, telefonoEmpleado.getUsuario());
            statement.setString(3, telefonoEmpleado.getContrasenia());
 
            statement.executeUpdate();

            //Cerrar interacciones con BD            
            statement.close();

            //Si el proceso fue exitoso cambiar el estado
            empleadoTelefono = telefonoEmpleado;

        }catch(SQLException e){
            System.err.println("Error actualizando nombre empleado! "+e);
        }finally{
            //Cierre del controlador
            if(conexion != null){
                conexion.close();
            }
        }
        return empleadoTelefono; 
    }
}
