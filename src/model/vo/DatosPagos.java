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
public class DatosPagos {
    
    public int id_pago;
    public int id_envio;
    public String medio_pago;

    public DatosPagos() {
    }

    public DatosPagos(int id_pago, int id_envio, String medio_pago) {
        this.id_pago = id_pago;
        this.id_envio = id_envio;
        this.medio_pago = medio_pago;
    }
    
    public DatosPagos(int id_envio, String medio_pago) {
        this.id_envio = id_envio;
        this.medio_pago = medio_pago;
    }
    
    

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }
    
    
}
