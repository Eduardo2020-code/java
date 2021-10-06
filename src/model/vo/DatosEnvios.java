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
public class DatosEnvios {
    
    public int id_envio;
    public int valor_envio;

    public DatosEnvios() {
    }
    
    public DatosEnvios(int id_envio, int valor_envio) {
        this.id_envio = id_envio;
        this.valor_envio = valor_envio;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public int getValor_envio() {
        return valor_envio;
    }

    public void setValor_envio(int valor_envio) {
        this.valor_envio = valor_envio;
    }
    
    
}
