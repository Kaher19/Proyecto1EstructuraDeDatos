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
    private EscribirDatos escribirDatos = new EscribirDatos();
    private double fecha = System.currentTimeMillis();
    //Funcion que 
    public void generateReport(String nombre, int monto, String cuenta, int elementosTabla){
        float impuesto = (float) (monto*0.16);
        escribirDatos.crearDocCSV(nombre, monto, cuenta, fecha, impuesto, elementosTabla);
    }
    
    public String[][] addElementToTable(String[][]table, String[] newElementToAdd){
        String[][]updatedTable = new String[table.length][newElementToAdd.length];
        for (int columna = 0; columna < newElementToAdd.length; columna++) {
            table[0][columna] = newElementToAdd[columna];
        }
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < newElementToAdd.length; column++) {
                updatedTable[row][column] = table[row][column];
            }
        }
        for (int columna = 0; columna < newElementToAdd.length; columna++) {
            updatedTable[updatedTable.length-1][columna] = newElementToAdd[columna];
        }
        return updatedTable;
    }
    
    //Función que generará la cabecera de la tabla
    public String [] getHeader(){
        String[] header = {"Nombre", "Monto", "Cuenta"};
        return header;
    }
    
    
}
