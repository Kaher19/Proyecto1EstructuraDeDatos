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
    private String nombreTitular;
    private String cuentaTitular;
    private double monto;

    //Constructor
    public Clientes(String nombreTitular, String cuentaTitular, double monto) {
        this.nombreTitular = nombreTitular;
        this.cuentaTitular = cuentaTitular;
        this.monto = monto;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCuentaTitular() {
        return cuentaTitular;
    }

    public void setCuentaTitular(String cuentaTitular) {
        this.cuentaTitular = cuentaTitular;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
