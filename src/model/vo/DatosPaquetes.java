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
public class DatosPaquetes {
    
    public int num_paq;
    public int id_envio;
    public String tamanio_paq;
    public double peso_paq;
    public String tipo_paq;
    public int valor_paq;
    public int valor_imp;
    public int valor_seguro;
    public int id_cliente;
    public int id_dest;

    public DatosPaquetes(int num_paq, int id_envio, String tamanio_paq, double peso_paq, String tipo_paq, int valor_paq, int valor_imp, int valor_seguro, int id_cliente, int id_dest) {
        this.num_paq=num_paq;
        this.id_envio = id_envio;
        this.tamanio_paq = tamanio_paq;
        this.peso_paq = peso_paq;
        this.tipo_paq = tipo_paq;
        this.valor_paq = valor_paq;
        this.valor_imp = valor_imp;
        this.valor_seguro = valor_seguro;
        this.id_cliente = id_cliente;
        this.id_dest = id_dest;
    }

    public DatosPaquetes(String tamanio_paq, double peso_paq, String tipo_paq, int valor_paq, int valor_imp, int valor_seguro) {
        this.tamanio_paq = tamanio_paq;
        this.peso_paq = peso_paq;
        this.tipo_paq = tipo_paq;
        this.valor_paq = valor_paq;
        this.valor_imp = valor_imp;
        this.valor_seguro = valor_seguro;
    }

    public DatosPaquetes() {
    }

    public int getNum_paq() {
        return num_paq;
    }

    public void setNum_paq(int num_paq) {
        this.num_paq = num_paq;
    }
    
    

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public String getTamanio_paq() {
        return tamanio_paq;
    }

    public void setTamanio_paq(String tamanio_paq) {
        this.tamanio_paq = tamanio_paq;
    }

    public double getPeso_paq() {
        return peso_paq;
    }

    public void setPeso_paq(double peso_paq) {
        this.peso_paq = peso_paq;
    }

    public String getTipo_paq() {
        return tipo_paq;
    }

    public void setTipo_paq(String tipo_paq) {
        this.tipo_paq = tipo_paq;
    }

    public int getValor_paq() {
        return valor_paq;
    }

    public void setValor_paq(int valor_paq) {
        this.valor_paq = valor_paq;
    }

    public int getValor_imp() {
        return valor_imp;
    }

    public void setValor_imp(int valor_imp) {
        this.valor_imp = valor_imp;
    }

    public int getValor_seguro() {
        return valor_seguro;
    }

    public void setValor_seguro(int valor_seguro) {
        this.valor_seguro = valor_seguro;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_dest() {
        return id_dest;
    }

    public void setId_dest(int id_dest) {
        this.id_dest = id_dest;
    }
}
