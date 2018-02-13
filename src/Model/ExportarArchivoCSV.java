/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Alvarez
 */

/**Clase que se encarga de la gestion de archivos .csv
**/
public class ExportarArchivoCSV {
    
    /**Funcion generarArchivo genera el documento .csv 
     * @param nomina
     **/
    public void generarArchivo(List<DatosEmpleado> nomina){
        String ficheroSalida = "Nomina.csv";
        String outputFile = ficheroSalida;
        
        try {
            
            if(new File(outputFile).exists() == false){

                File archivo = new File(ficheroSalida);
                FileWriter writer = new FileWriter(archivo, true);
                FileReader reader = new FileReader(archivo);
                CsvWriter csvSalida = new CsvWriter(writer, ',');
                CsvReader csvEntrada = new CsvReader(reader);
                
                csvSalida.write("Nombre");
                csvSalida.write("Monto de transferencia");
                csvSalida.write("Cuenta de destino");
                csvSalida.write("Fecha de transferencia");
                csvSalida.write("Cuenta de origen");
                csvSalida.write("Impuesto");
                csvSalida.endRecord(); 
                
                for(DatosEmpleado nom : nomina){ 
                    
                    csvSalida.write(nom.getNombre());
                    csvSalida.write(Integer.toString(nom.getMonto()));
                    csvSalida.write(nom.getCuentaDestino());
                    csvSalida.write(Long.toString(nom.getFechaTransferencia()));
                    csvSalida.write(nom.getCuentaOrigen());
                    csvSalida.write(nom.getImpuesto().toString());
                    csvSalida.endRecord();
                    
                }
                
                csvEntrada.close();
                csvSalida.close();
            
            } else {    

                for(DatosEmpleado nom : nomina){ 
                    
                    File archivo = new File(ficheroSalida);
                    FileWriter writer = new FileWriter(archivo, true);
                    FileReader reader = new FileReader(archivo);
                    CsvWriter csvSalida = new CsvWriter(writer, ',');
                    CsvReader csvEntrada = new CsvReader(reader);
                
                    csvSalida.write(nom.getNombre());
                    csvSalida.write(Integer.toString(nom.getMonto()));
                    csvSalida.write(nom.getCuentaDestino());
                    csvSalida.write(Long.toString(nom.getFechaTransferencia()));
                    csvSalida.write(nom.getCuentaOrigen());
                    csvSalida.write(nom.getImpuesto().toString());
                    csvSalida.endRecord();
                    
                    csvEntrada.close();
                    csvSalida.close();

                }
            }
            
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
        }
        
    }
    
}
