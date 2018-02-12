/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.controller;

import mx.uady.model.EscribirDatos;

/**
 *
 * @author A13001777
 */
public class Controller {
    
    //Funcion que 
    public void addNewClient(String nombre, String cuenta, double monto){
        EscribirDatos escribirDatos = new EscribirDatos();
        escribirDatos.CrearDocCSV(nombre, cuenta, monto);
    }
    
    //Función que generará la cabecera de la tabla
    public String [] getHeader(){
        String[] header = {"Nombre", "Monto", "Cuenta"};
        return header;
    }
    
    
}
