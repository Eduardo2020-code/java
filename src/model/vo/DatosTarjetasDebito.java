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
public class DatosTarjetasDebito {
    
    int num_tarjeta;
    int saldo;

    public DatosTarjetasDebito() {
    }

    public DatosTarjetasDebito(int num_tarjeta, int saldo) {
        this.num_tarjeta = num_tarjeta;
        this.saldo = saldo;
    }

    public int getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(int num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}
