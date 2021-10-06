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
public class DatosCreditos {
    
    public int id_credito;
    public int num_tarjeta;
    public int cuotas;
    public int valor_pagar;

    public DatosCreditos() {
    }

    public DatosCreditos(int id_credito, int num_tarjeta, int cuotas, int valor_pagar) {
        this.id_credito = id_credito;
        this.num_tarjeta = num_tarjeta;
        this.cuotas = cuotas;
        this.valor_pagar = valor_pagar;
    }

    public int getId_credito() {
        return id_credito;
    }

    public void setId_credito(int id_credito) {
        this.id_credito = id_credito;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getValor_pagar() {
        return valor_pagar;
    }

    public void setValor_pagar(int valor_pagar) {
        this.valor_pagar = valor_pagar;
    }
    
    
}
