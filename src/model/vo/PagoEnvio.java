/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.vo;

/**
 *
 * @author Windows 10
 */
public class PagoEnvio  {
     private String Nopaquete;
    private int id_envio;
    private int tamano;
    private int peso;
    private String tipo;
    private int valor;
    private double impuesto;
    private int seguro;
    private String cliente;
    private String destino;
     
    
    public PagoEnvio( String Nopaquete, int id_envio, int tamano, int peso, 
            String tipo, int valor, double impuesto, int seguro, String Cliente,
            String destino){
        
        this.Nopaquete=Nopaquete;
        this.id_envio=id_envio;
        this.tamano=tamano;
        this.peso=peso;
        this.tipo=tipo;
        this.valor=valor;
        this.impuesto=impuesto;
        this.seguro=seguro;
        this.cliente=cliente;
        this.destino=destino;       
    }

    public PagoEnvio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getNopaquete() {
        return Nopaquete;
    }

    public void setNopaquete(String Nopaquete) {
        this.Nopaquete = Nopaquete;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public int getSeguro() {
        return seguro;
    }

    public void setSeguro(int seguro) {
        this.seguro = seguro;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
}
