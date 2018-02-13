/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Ordering.Intern.Burbuja;
import Model.Ordering.Intern.Quicksort;
import Model.Ordering.Intern.Shellsort;
import Model.Ordering.Intern.Mergesort;
import Model.Ordering.Intern.Insercion;
import Model.Ordering.Extern.MezclaDirecta;
import Model.DatosEmpleado;
import Controller.Controller;
import View.MainView;
import View.AddEmployedView;
import Model.Ordering.Extern.MezclaEquilibradaMultiple;
import java.math.BigDecimal;

/**
 *
 * @author Hector Burgos
 */
public class Main {
    
    public static void main(String[] args) {
        BigDecimal bDecimal = new BigDecimal(0);        
        
        MainView mView = new MainView();
        AddEmployedView aeView = new AddEmployedView();
        DatosEmpleado dEmpleado = new DatosEmpleado("Default", 10, "ca13001777", 2321, "ca09001987", bDecimal);
        Burbuja burbuja = new Burbuja();
        Insercion insercion = new Insercion();
        Mergesort mergesort = new Mergesort();
        Quicksort quicksort = new Quicksort();
        Shellsort shellsort = new Shellsort();
        MezclaDirecta mezclaDirecta = new MezclaDirecta();
        MezclaEquilibradaMultiple mezclaEquilibradaMultiple = new MezclaEquilibradaMultiple();
        
        Controller controller = new Controller(mView, aeView, dEmpleado, burbuja, insercion, mergesort, quicksort, shellsort, mezclaDirecta, mezclaEquilibradaMultiple);
        controller.iniciar();
        mView.setVisible(true);
        aeView.setVisible(false);
        
    }
    
}
