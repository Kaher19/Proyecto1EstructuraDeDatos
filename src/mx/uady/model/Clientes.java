/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.model;

/**
 *
 * @author Kirbey
 */
public class Clientes {
    private String nombre;
    private double monto;
    private String cuentaDestino;
    private double fecha;
    private String cuentaOrigen;
    private float impuesto;

    //Constructor
    public Clientes(String nombre, double monto, String cuentaDestino, double fecha, String cuentaOrigen, float impuesto) {
        this.nombre = nombre;
        this.monto = monto;
        this.cuentaDestino = cuentaDestino;
        this.fecha = fecha;
        this.cuentaOrigen = cuentaOrigen;
        this.impuesto = impuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreTitular) {
        this.nombre = nombreTitular;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public double getMonto() {
        return monto;
    }
    
    public float getImpuesto(){
        return impuesto;
    }
    
    public String getCuentaDestino(){
        return cuentaDestino;
    }
    
    public double getFecha(){
        return fecha;
    }
    
    public void setFecha(double fecha){
        this.fecha = fecha;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
