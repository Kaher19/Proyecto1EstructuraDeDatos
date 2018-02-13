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
 * @author Kirbey Garcia
 */
public class Quicksort {
    
    public void realizarQuicksort(int[] A, int izq, int der){
        
        int pivote=A[izq]; 
        int i=izq; 
        int j=der;
        int aux;
 
        while(i<j) {     
            
            while(A[i]<=pivote && i<j) i++; 
            
                while(A[j]>pivote) j--;  
              
                    if (i<j) {                                          
                        aux= A[i];                  
                        A[i]=A[j];
                         A[j]=aux;
                    }
                    
        }
        
        A[izq]=A[j];
        A[j]=pivote;
        
        if(izq<j-1){
            
            realizarQuicksort(A,izq,j-1); 
        }
        
        if(j+1 <der){
            
            realizarQuicksort(A,j+1,der); 

        }
        
    }    
    
    public ArrayList<DatosEmpleado> ordenarEmpleados(ArrayList<DatosEmpleado> nomina){
        ArrayList<DatosEmpleado> nominaArreglada = new ArrayList<DatosEmpleado>();
        
        int[] arreglo = new int[nomina.size()];
        int i = 0;
        
        for(DatosEmpleado nom : nomina){ 
                
            arreglo[i] = nom.getMonto();
            
            i++;
            
        }
          
        Quicksort quicksort = new Quicksort();
        quicksort.realizarQuicksort(arreglo, 0, arreglo.length - 1);
        
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
