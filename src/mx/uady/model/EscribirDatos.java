/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uady.model;

import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Kirbey
 */
public class EscribirDatos {
    /**Variables globales**/
    private String ficheroSalida = "C:\\Users\\Kirbey\\Desktop\\Registro de Transferencias.csv";
    private String outputFile = ficheroSalida;
    
    /*Metodos*/
    
    /**Metodo que comprueba si el documento .csv ya existe
     *@return exist
     */
    public boolean existDocument(){
        boolean exist = new File(outputFile).exists();
        return exist;
    }
    
    /**Metodo que crea el documento .csv
     * @param nombre*
     * @param cuenta
     * @param monto*/
    public void crearDocCSV(String nombre, double monto, String cuentaDestino, double fecha, float impuesto){
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        listaClientes.add(new Clientes (nombre, monto, cuentaDestino, fecha, "cuentaOrigen", impuesto));
        System.out.println("Nombre:" +nombre);
        System.out.println("Monto:" +monto);
        System.out.println("CuentaDestino:" +cuentaDestino);
        System.out.println("Fecha:" +fecha);
        System.out.println("CuentaOrigen: cuentaOrigen");
        System.out.println("Impuesto:" +impuesto);
        
        
        if(this.existDocument()){
            File ArchivoEmpleados = new File(outputFile);
            ArchivoEmpleados.delete();
        }        
         
        try {
 
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
             
            csvOutput.write("Nombre");
            csvOutput.write("Monto de transferencia");
            csvOutput.write("Cuenta de destino");
            csvOutput.write("Fecha de transferencia");
            csvOutput.write("Cuenta de origen");
            csvOutput.write("Impuesto");
            csvOutput.endRecord();
            
            for (Iterator<Clientes> it = listaClientes.iterator(); it.hasNext();) {
                Clientes transf = it.next();
                csvOutput.write(transf.getNombre());
                csvOutput.write("" +transf.getMonto());
                csvOutput.write(transf.getCuentaDestino());
                csvOutput.write("" +transf.getFecha());
                csvOutput.write(transf.getCuentaOrigen());
                csvOutput.write("" + transf.getImpuesto());
                csvOutput.endRecord();
            }
            
            csvOutput.close();
        } catch (IOException e) {
            System.out.println("Imposible crear registro");
        }
    }
}
