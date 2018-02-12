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
    /**Metodo
     * @param nombre*
     * @param cuenta
     * @param monto*/
    public void CrearDocCSV(String nombre, String cuenta, double monto){
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        String ficherosalida = "C:\\Users\\Kirbey\\Desktop\\Registro de Transferencias.csv";
        
        listaClientes.add(new Clientes (nombre, cuenta, monto));
        
        String outputFile = ficherosalida;
        boolean Existe = new File(outputFile).exists();
         
        if(Existe){
            File ArchivoEmpleados = new File(outputFile);
            ArchivoEmpleados.delete();
        }        
         
        try {
 
            CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
             
            csvOutput.write("Nombre de titular");
            csvOutput.write("Numero de cuenta del titular");
            csvOutput.write("Monto");
            csvOutput.endRecord();
            
            for (Iterator<Clientes> it = listaClientes.iterator(); it.hasNext();) {
                Clientes transf = it.next();
                csvOutput.write(transf.getNombreTitular());
                csvOutput.write(transf.getCuentaTitular());
                csvOutput.write("" + transf.getMonto());
                csvOutput.endRecord();
            }
            
            csvOutput.close();
        } catch (IOException e) {
            System.out.println("Imposible crear registro");
        }
    }
}
