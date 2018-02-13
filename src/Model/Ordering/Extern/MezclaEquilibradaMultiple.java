package Model.Ordering.Extern;

import Model.GeneradorArchivoTXTOE;
import Model.DatosEmpleado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Alvarez
 */
public class MezclaEquilibradaMultiple {

    public final String salto = System.lineSeparator();

    public void realizarMezclaEquilibrada(String F1, String F2, String F3, String F4) throws IOException {

        boolean band = true;

        particionInicial(F1, F3, F4);

        File archivo1 = new File(F1);
        File archivo2 = new File(F2);
        File archivo3 = new File(F3);
        File archivo4 = new File(F4);

        archivo2.createNewFile();
        archivo4.createNewFile();

        particionFusion(F3, F4, F1, F2);
        band = false;
        do {
            if (band) {


                particionFusion(F3, F4, F1, F2);
                band = false;
            } else {

                particionFusion(F1, F2, F3, F4);
                band = true;
            }
        } while (archivo2.length() > 0l || archivo4.length() > 0);


    }


    public void particionFusion(String Fs1, String Fs2, String Fs3, String Fs4) throws FileNotFoundException, FileNotFoundException, IOException {

        double r1 = 0;
        double r2 = 0;

        File archivo1 = new File(Fs1);
        File archivo2 = new File(Fs2);
        File archivo3 = new File(Fs3);
        File archivo4 = new File(Fs4);

        FileReader reader1 = new FileReader(archivo1);
        FileReader reader2 = new FileReader(archivo2);
        FileReader reader3 = new FileReader(archivo3);
        FileReader reader4 = new FileReader(archivo4);

        Scanner F1 = new Scanner(reader1);
        Scanner F2 = new Scanner(reader2);

        FileWriter F3 = new FileWriter(archivo3);
        FileWriter F4 = new FileWriter(archivo4);

        boolean ban1 = true;
        boolean ban2 = true;
        boolean ban3 = true;
        Double aux = Double.MIN_VALUE;

        while ( (F1.hasNextDouble() || !ban1) &&  (F2.hasNextDouble() || !ban2 ) ) {

            if (ban1) {
                if (F1.hasNextDouble()) {
                     r1 = F1.nextDouble();
                      ban1 = false;
                }
            }

            if (ban2) {
                if (F2.hasNextDouble()) {
                    r2 = F2.nextDouble();
                    ban2 = false;
                }
            }


            if (r1 <= r2) {
                if (r1 >= aux) {

                    if (ban3) {
                        F3.write(r1 +salto);
                    }else {
                        F4.write(r1 + salto);
                    }
                    ban1 = true;
                    aux = r1;

                } else {

                    if (ban3) {
                        F3.write(r2 + salto);
                        ban3 = false;
                    } else {
                        F4.write(r2 + salto);
                        ban3 = true;
                    }

                    ban2 = true;
                    aux = Double.MIN_VALUE;
                }
            } else {

                if (r2 >= aux) {

                    if (ban3) {
                        F3.write(r2 + salto);
                    } else {
                        F4.write(r2 + salto);
                    }

                    ban2 = true;
                    aux = r2;

                } else {

                    if (ban3) {
                        F3.write(r1 + salto);
                        ban3 = false;
                    } else {
                        F4.write(r1 + salto);
                        ban3 = true;
                    }

                    ban1 = true;
                    aux = Double.MIN_VALUE;
                }

            }

        }

        if (ban1 == false) {

            if (ban3) {
                F3.write(r1 + salto);

                while (F1.hasNextDouble()) {
                    r1 = F1.nextDouble();
                    F3.write(r1 + salto);
                }

            } else {
                F4.write(r1 + salto);


                while (F1.hasNextDouble()) {
                    r1 = F1.nextDouble();
                    F4.write(r1 + salto);
                }
            }
        }

        if (ban2 == false) {

            if (ban3) {
                F3.write(r2 + salto);

                while (F2.hasNextDouble()) {
                    r2 = F2.nextDouble();
                    F3.write(r2 + salto);
                }

            } else {
                F4.write(r2 + salto);


                while (F2.hasNextDouble()) {
                    r2 = F2.nextDouble();
                    F4.write(r2 + salto);
                }
            }

        }


        F3.flush();
        F4.flush();

        F3.close();
        F4.close();
        F1.close();
        F2.close();

    }

    public void particionInicial(String F1, String F3, String F4) throws FileNotFoundException, IOException {
        double aux = 0;
        double r = 0;
        boolean band = false;

        File archivo1 = new File(F1);
        File archivo3 = new File(F3);
        File archivo4 = new File(F4);

        FileReader reader1 = new FileReader(archivo1);
        Scanner scanner1 = new Scanner(reader1);

        FileWriter writer3 = new FileWriter(archivo3);
        FileWriter writer4 = new FileWriter(archivo4);

        if (scanner1.hasNextDouble()) {
            r = scanner1.nextDouble();
            writer3.write(r + System.lineSeparator());
            band = true;
            aux = r;
        }

        while (scanner1.hasNextDouble()) {
            r = scanner1.nextDouble();

            if (r >= aux) {

                aux = r;
                if (band == true) {
                    writer3.write(r + salto);
                }else{
                    writer4.write(r + salto);
                }

            }else{

                aux = r;
                if (band == true) {
                    writer4.write(r + salto);
                    band = false;
                } else {
                    writer3.write(r + salto);
                    band = true;
                }

            }
        }

        scanner1.close();
        writer3.close();
        writer4.close();

    }

    public ArrayList<DatosEmpleado> ordenarEmpleados(ArrayList<DatosEmpleado> nomina) throws IOException{
        GeneradorArchivoTXTOE archivo = new GeneradorArchivoTXTOE();
        
        ArrayList<DatosEmpleado> nominaArreglada = new ArrayList<DatosEmpleado>();
        
        Double[] arreglo = new Double[nomina.size()];
        int i = 0;
        
        archivo.crearTXT("F1.txt", nomina);
        
        MezclaEquilibradaMultiple mn = new MezclaEquilibradaMultiple();

        String F1 = "F1.txt";
        String F2 = "F2.txt";
        String F3 = "F3.txt";
        String F4 = "F4.txt";

        mn.realizarMezclaEquilibrada(F1, F2, F3, F4);
        
        String datosTxt = archivo.leerTxt(F1);
        
        if(datosTxt.equals("")){
            datosTxt = archivo.leerTxt(F3);
        }
        
        arreglo = archivo.guardarTxtEnArregloEM(datosTxt, nomina);
        
        for (i = 0; i < arreglo.length; i++) {
        
            for(DatosEmpleado nom : nomina){ 

                if(arreglo[i] != null){
                    if(arreglo[i] == nom.getImpuesto().doubleValue()){
                        nominaArreglada.add(nom);
                    }
                } else {
                    System.out.println("Hay un valor nulo, no se puede completar la operación");
                }
                
            }
            
        }
        
        return nominaArreglada;
        
    }

}
