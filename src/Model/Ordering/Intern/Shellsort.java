/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Ordering.Intern;

import Model.DatosEmpleado;
import java.util.ArrayList;

/**
 *
 * @author Kirbey Garcia
 */
public class Shellsort {
    
    public int[] realizarSherllsort(int[] entrada){
        int n = entrada.length;
        int salto = (int) Math.floor(n/2);
        
        int temp;
        while(salto > 0){
            
            for (int i = salto; i < n; i++) {
                
                int j = i;
                temp = entrada[i];
                while(j >= salto && entrada[j - salto] > temp){
                    entrada[j] = entrada[j - salto];
                    j = j - salto;
                }
                
                entrada[j] = temp;
            }
           
            salto = (int) Math.floor(salto/2);
            
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
          
        Shellsort shellsort = new Shellsort();
        shellsort.realizarSherllsort(arreglo);
        
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
