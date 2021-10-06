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
public class DatosClientes {
   
   //Atributos
    private int id_cliente;
    private String num_cedula;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String telefono;
    private String id_sede;

    public DatosClientes() {
    }

    
    
    public DatosClientes(int id_cliente, String num_cedula, String nombre, String direccion, String ciudad, String telefono, String id_sede) {
        this.id_cliente=id_cliente;
        this.num_cedula = num_cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.id_sede = id_sede;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    

    public String getNum_cedula() {
        return num_cedula;
    }

    public void setNum_cedula(String num_cedula) {
        this.num_cedula = num_cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_sede() {
        return id_sede;
    }

    public void setId_sede(String id_sede) {
        this.id_sede = id_sede;
    }
    
    
    
    
    
  

    
    
    
    
    
}
