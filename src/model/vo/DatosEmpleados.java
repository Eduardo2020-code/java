/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author usuario
 */
public class DatosEmpleados {
   
   //Atributos
    private int id_empleado;
    private String usuario;
    private String contrasenia;
    private String nombre;
    private String num_cedula;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String cargo;
    private String id_sede;
    
    private String usuarioNuevo;
    private String contraseniaNueva;
    private String nombreNuevo;
    private String telefonoNuevo;

    public DatosEmpleados(){
        
    }
    
    public DatosEmpleados(String usuario, String contrasenia, String nombre,
            String num_cedula, String telefono, String direccion, String ciudad,
            String cargo, String id_sede){
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.nombre=nombre;
        this.num_cedula=num_cedula;
        this.telefono=telefono;
        this.direccion=direccion;
        this.ciudad=ciudad;
        this.cargo=cargo;
        this.id_sede=id_sede;
    }
    
    /**
     *
     * @param usuarioNuevo
     * @param usuario
     * @param contrasenia
     */
    public DatosEmpleados(String usuarioNuevo, String usuario, String contrasenia){
        this.usuarioNuevo=usuarioNuevo;
        this.usuario=usuario;
        this.contrasenia=contrasenia;
    }
   
    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_cedula() {
        return num_cedula;
    }

    public void setNum_cedula(String num_cedula) {
        this.num_cedula = num_cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getId_sede() {
        return id_sede;
    }

    public void setId_sede(String id_sede) {
        this.id_sede = id_sede;
    }

    public String getUsuarioNuevo() {
        return usuarioNuevo;
    }

    public void setUsuarioNuevo(String usuarioNuevo) {
        this.usuarioNuevo = usuarioNuevo;
    }

    public String getContraseniaNueva() {
        return contraseniaNueva;
    }

    public void setContraseniaNueva(String contraseniaNueva) {
        this.contraseniaNueva = contraseniaNueva;
    }

    public String getNombreNuevo() {
        return nombreNuevo;
    }

    public void setNombreNuevo(String nombreNuevo) {
        this.nombreNuevo = nombreNuevo;
    }

    public String getTelefonoNuevo() {
        return telefonoNuevo;
    }

    public void setTelefonoNuevo(String telefonoNuevo) {
        this.telefonoNuevo = telefonoNuevo;
    }

    
    
    
    
    
}
