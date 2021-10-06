/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author Juan Diego
 */
public class DatosTarjetas {
    
    public int num_tarjeta;
    public String fecha_vencimiento;
    public int cod_seguridad;
    public String nombre_titular;
    public String cedula_titular;

    public DatosTarjetas() {
    }

    public DatosTarjetas(int num_tarjeta, String fecha_vencimiento, int cod_seguridad, String nombre_titular, String cedula_titular) {
        this.num_tarjeta = num_tarjeta;
        this.fecha_vencimiento = fecha_vencimiento;
        this.cod_seguridad = cod_seguridad;
        this.nombre_titular = nombre_titular;
        this.cedula_titular = cedula_titular;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getCod_seguridad() {
        return cod_seguridad;
    }

    public void setCod_seguridad(int cod_seguridad) {
        this.cod_seguridad = cod_seguridad;
    }

    public String getNombre_titular() {
        return nombre_titular;
    }

    public void setNombre_titular(String nombre_titular) {
        this.nombre_titular = nombre_titular;
    }

    public String getCedula_titular() {
        return cedula_titular;
    }

    public void setCedula_titular(String cedula_titular) {
        this.cedula_titular = cedula_titular;
    }
    
    
    
}
