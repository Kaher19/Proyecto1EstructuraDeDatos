/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Ordering.Intern;

import Model.DatosEmpleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kirbey garcia
 */
public class Burbuja {
    
    public int[] realizarBurbuja(int[] entrada){

        int temp;
        for (int i = 0; i < entrada.length; i++) {
            
            for (int j = 1; j < (entrada.length - i); j++) {
                if(entrada[j - 1] >= entrada[j]){
                    temp = entrada[j - 1];
                    entrada[j - 1] = entrada[j];
                    entrada[j] = temp;
                }

            }
          
        }
        
        return entrada;
    }
    
    public ArrayList<DatosEmpleado> ordenarEmpleados(ArrayList<DatosEmpleado> nomina){
        ArrayList<DatosEmpleado> nominaArreglada = new ArrayList<DatosEmpleado>();
        
        int[] arreglo = new int[nomina.size()];
        int i = 0;
        
        for(DatosEmpleado nom : nomina){ 
                
            arreglo[i] = nom.getMonto();
            
            i++;
            
        }
          
        Burbuja burbuja = new Burbuja();
        burbuja.realizarBurbuja(arreglo);
        
        for (i = 0; i < arreglo.length; i++) {
        
            for(DatosEmpleado nom : nomina){ 

                if(arreglo[i] == nom.getMonto()){
                    nominaArreglada.add(nom);
                }
                
            }
            
        }
        
        return nominaArreglada;
    }
    
}
