package mx.uady.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvWriter;


public class EscribirDatos {
    
    
    public static void main(String[] args) throws IOException {
       
        ArrayList<Clientes> listaTransferencias = new ArrayList<Clientes>();
        double fecha = System.currentTimeMillis();
        String ficherosalida = "C:\\Users\\Kirbey\\Desktop\\Registro de Transferencias.csv";
        
        listaTransferencias.add(new Clientes ("Luis","1200108200",123,"13001082","Moises",1000,fecha));
        listaTransferencias.add(new Clientes ("Pedro","1300108200",234,"14001082","Noe",2000,fecha));
        listaTransferencias.add(new Clientes ("Paola","1400108200",345,"15001082","Pepe",3000,fecha));
        
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
            csvOutput.write("Numero de seguridad");
            csvOutput.write("Numero de cuenta origen");
            csvOutput.write("Nombre de titular cuenta origen");
            csvOutput.write("Monto");
            csvOutput.write("Fecha de transferencia");
            csvOutput.endRecord();
 
            for(Clientes transf : listaTransferencias){
     
                csvOutput.write(transf.getNombreTitular());
                csvOutput.write(transf.getCuentaTitular());
                csvOutput.write("" + transf.getPIN());
                csvOutput.write(transf.getCuentaOrigen());
                csvOutput.write(transf.getTitularOrigen());
                csvOutput.write("" + transf.getMonto());
                csvOutput.write("" + transf.getFecha());
                csvOutput.endRecord();                   
        
            }
             
            csvOutput.close();
 
         
        
    }
        
        catch (IOException e) {
            System.out.println("Imposible crear registro");
        }
    
}
    
}