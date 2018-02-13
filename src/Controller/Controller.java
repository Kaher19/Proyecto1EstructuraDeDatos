/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ordering.Intern.Burbuja;
import Model.Ordering.Intern.Quicksort;
import Model.Ordering.Intern.Shellsort;
import Model.Ordering.Intern.Mergesort;
import Model.Ordering.Intern.Insercion;
import Model.Ordering.Extern.MezclaDirecta;
import Model.DatosEmpleado;
import Model.ExportarArchivoCSV;
import Exceptions.*;
import View.MainView;
import View.AddEmployedView;
import Model.Ordering.Extern.MezclaEquilibradaMultiple;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector
 */
public final class Controller implements ActionListener{
    
    private final MainView mainWindow;
    private final AddEmployedView addEmpWindow;
    private final DatosEmpleado regEmpleados;
    private Burbuja burbuja;
    private Insercion insercion;
    private Mergesort mergesort;
    private Quicksort quicksort;
    private Shellsort shellsort;
    private MezclaDirecta mezclaDirecta;
    private MezclaEquilibradaMultiple mezclaEquilibradaMultiple;
    
    
    public Controller (MainView vMain, AddEmployedView vRegistro, 
            DatosEmpleado dEmpleado, Burbuja burbuja, Insercion insercion, Mergesort mergesort, Quicksort quicksort, Shellsort shellsort, MezclaDirecta mezclaDirecta, MezclaEquilibradaMultiple mezclaEquilibradaMultiple){
        ItemListener s = null;
        
        this.mainWindow = vMain;
        this.addEmpWindow = vRegistro;
        this.regEmpleados = dEmpleado;
        this.burbuja = burbuja;
        this.insercion = insercion;
        this.mergesort = mergesort;
        this.quicksort = quicksort;
        this.shellsort = shellsort;
        this.mezclaDirecta = mezclaDirecta;
        this.mezclaEquilibradaMultiple = mezclaEquilibradaMultiple;
        
        
        //Botones, solo se agrega el listener para saber si se presiona  o no
        this.mainWindow.JBGenerateReport.addActionListener(this);
        this.mainWindow.JBNewEmployed.addActionListener(this);
        
        this.addEmpWindow.JBCancel.addActionListener(this);
        this.addEmpWindow.JBAcept.addActionListener(this);
        
        //Combo box, se necesita validar cual tipo de ordenamiento esta está seleccionado
        this.mainWindow.JCBSort.addItemListener(s);
        
        configuraTabla(vMain.JTEmployees);
        
    }
    
    /**Inicializa los datos para las dos vistas**/
    public void iniciar(){
        mainWindow.setTitle("Generador de nóminas");
        addEmpWindow.setTitle("Agregar nuevo empleado");
        mainWindow.setLocationRelativeTo(null);
        addEmpWindow.setLocationRelativeTo(null);
    }
    
    /**Metodo para configurar el contenido de la tabla principal
     * @param tabla Tabla que será configurada**/
    public void configuraTabla(JTable tabla){
        Vector<String> titulos = new Vector<String>();
        Vector<Vector<Object>> datos = new Vector<Vector<Object>>();
        
        titulos.add("Nombre");
        titulos.add("Monto");
        titulos.add("Cuenta");
        
        for(int i=0; i < regEmpleados.listaEmpleados.size(); i++){
            Vector<Object> row = new Vector<Object>();
            
            row.add(regEmpleados.listaEmpleados.get(i).getNombre());
            row.add(regEmpleados.listaEmpleados.get(i).getMonto());
            row.add(regEmpleados.listaEmpleados.get(i).getCuentaDestino());
            
            datos.add(row);       
            
        }
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        
        tabla.setModel(modelo);                 
        
    }
    
    /**Override de la funcion actionPerformed
     * @param e evento**/
    @Override
    public void actionPerformed(ActionEvent e){
        String s = (String) mainWindow.JCBSort.getSelectedItem();
        
        //Botones para la vista "MainView"
        if(mainWindow.listenJBNewEmployed() == e.getSource()){ //Listener del boton "+Agregar empleado"       
            addEmpWindow.setVisible(true);
            addEmpWindow.setLocationRelativeTo(mainWindow);
        }
        
        if(mainWindow.listenJBGenerateReport() == e.getSource()){ //Listener del boton "Generar reporte"
            if(mainWindow.JTEmployees.getModel().getRowCount() > 0){
            
                switch(s){

                case "Insercion":
                    long tiempoInicial = System.currentTimeMillis();

                    ExportarArchivoCSV exportar = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> insercionO = new ArrayList<DatosEmpleado>();

                    insercionO = insercion.ordenarEmpleados(regEmpleados.listaEmpleados);
                    exportar.generarArchivo(insercionO);

                    long tiempoFinal = System.currentTimeMillis();                
                    long tiempoTotal = (tiempoFinal - tiempoInicial);

                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal / 1000 + " segundos");

                    break;

                case "Burbuja":
                    long tiempoInicial2 = System.currentTimeMillis();

                    ExportarArchivoCSV exportar2 = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> burbujaO = new ArrayList<DatosEmpleado>();

                    burbujaO = burbuja.ordenarEmpleados(regEmpleados.listaEmpleados);
                    exportar2.generarArchivo(burbujaO);

                    long tiempoFinal2 = System.currentTimeMillis();                
                    long tiempoTotal2 = tiempoFinal2 - tiempoInicial2;
                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal2 / 1000 + " segundos");

                    break;

                case "Mergesort":
                    long tiempoInicial3 = System.currentTimeMillis();

                    ExportarArchivoCSV exportar3 = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> mergesorter = new ArrayList<DatosEmpleado>();

                    mergesorter = mergesort.ordenarEmpleados(regEmpleados.listaEmpleados);
                    exportar3.generarArchivo(mergesorter);

                    long tiempoFinal3 = System.currentTimeMillis();                
                    long tiempoTotal3 = tiempoFinal3 - tiempoInicial3;
                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal3 / 1000 + " segundos");

                    break;

                case "Quicksort":                
                    long tiempoInicial4 = System.currentTimeMillis();

                    ExportarArchivoCSV exportar4 = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> quicksorter = new ArrayList<DatosEmpleado>();

                    quicksorter = quicksort.ordenarEmpleados(regEmpleados.listaEmpleados);
                    exportar4.generarArchivo(quicksorter);

                    long tiempoFinal4 = System.currentTimeMillis();                
                    long tiempoTotal4 = tiempoFinal4 - tiempoInicial4;
                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal4 / 1000 + " segundos");

                    break;

                case "Shellsort":                
                    long tiempoInicial5 = System.currentTimeMillis();

                    ExportarArchivoCSV exportar5 = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> shellsorter = new ArrayList<DatosEmpleado>();

                    shellsorter = shellsort.ordenarEmpleados(regEmpleados.listaEmpleados);
                    exportar5.generarArchivo(regEmpleados.listaEmpleados);

                    long tiempoFinal5 = System.currentTimeMillis();                
                    long tiempoTotal5 = tiempoFinal5 - tiempoInicial5;
                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal5 / 1000 + " segundos");

                    exportar5.generarArchivo(shellsorter);
                    break;

                case "Mezcla directa":
                    long tiempoInicial6 = System.currentTimeMillis();

                    ExportarArchivoCSV exportar6 = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> mezclarDirecta = new ArrayList<DatosEmpleado>();

                {
                    try {
                        mezclarDirecta = mezclaDirecta.ordenarEmpleados(regEmpleados.listaEmpleados);
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    exportar6.generarArchivo(mezclarDirecta);

                    long tiempoFinal6 = System.currentTimeMillis();                
                    long tiempoTotal6 = tiempoFinal6 - tiempoInicial6;
                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal6 / 1000 + " segundos");                

                    exportar6.generarArchivo(mezclarDirecta);               
                    break;


                case "Mezcla equilibrada multiple":
                    long tiempoInicial7 = System.currentTimeMillis();

                    ExportarArchivoCSV exportar7 = new ExportarArchivoCSV();
                    ArrayList<DatosEmpleado> mezclaEM = new ArrayList<DatosEmpleado>();

                {
                    try {
                        mezclaEM = mezclaEquilibradaMultiple.ordenarEmpleados(regEmpleados.listaEmpleados);
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                    exportar7.generarArchivo(mezclaEM);

                    long tiempoFinal7 = System.currentTimeMillis();                
                    long tiempoTotal7 = tiempoFinal7 - tiempoInicial7;
                    mainWindow.JLResults.setText("La operación tardó: " + tiempoTotal7 / 1000 + " segundos");

                    break;                                

            }
        } else {
               JOptionPane.showMessageDialog(null, "La tabla esta vacia, no se puede generar el reporte"); 
            }
            
    }
        
        //Listener de botones para AddEmployedView
        if(addEmpWindow.listenJBSave() == e.getSource()){ //Listener del boton "Aceptar"
            
            try{
                
                String nombre = addEmpWindow.JTFName.getText();            
                if(nombre.isEmpty()){
                    throw new EmptyException("");
                } else if (nombre.length() > 50){
                    throw new NameSizeException("");
                }

                int monto = Integer.parseInt(addEmpWindow.JTFAmmount.getText());
                if(addEmpWindow.JTFAmmount.getText().equals("")){
                    throw new EmptyException("");
                } else if(monto < 10){
                    throw new LessThanTenException("");
                }

                String cuentaD = addEmpWindow.JTFAccount.getText();            
                if(cuentaD.length() != 10){
                    throw new AccountSizeException("");
                } else if(addEmpWindow.JTFAccount.getText().equals("")){
                    throw new EmptyException("");
                }            

                long fechaTrans = System.currentTimeMillis();

                String cuentaOrigen = "1200108200";
                if(cuentaOrigen.length() != 10){
                    throw new AccountSizeException("");
                }

                BigDecimal impuesto = new BigDecimal(monto * .16);
                impuesto.setScale(2, RoundingMode.UP);


                DatosEmpleado reg = new DatosEmpleado(nombre, monto, cuentaD, fechaTrans, cuentaOrigen, impuesto);

                regEmpleados.listaEmpleados.add(reg);            

                configuraTabla(mainWindow.JTEmployees);

                JOptionPane.showMessageDialog(null,"Guardado satisfactoriamente");
                addEmpWindow.setVisible(false);
                addEmpWindow.JTFName.setText("");
                addEmpWindow.JTFAmmount.setText("");
                addEmpWindow.JTFAccount.setText("");
            }
            
            catch(InputMismatchException e1){
                JOptionPane.showMessageDialog(null, "Escribió caracteres no validos");
            }            
            catch(NumberFormatException e2){
                JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros en el campo \"Monto\"");                
            }             
            catch (EmptyException e3) {
                JOptionPane.showMessageDialog(null,"No puede tener campos vacíos");                
            } 
            catch (LessThanTenException e4) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un monto mayor a $10");
            }
            catch (AccountSizeException e5) {
                JOptionPane.showMessageDialog(null, "La cuenta debe constar de 10 digitos");
            }
            catch (NameSizeException e6) {
                JOptionPane.showMessageDialog(null, "El nombre no puede exceder 50 dígitos");
            }
            
        }
        
        if(addEmpWindow.listenJBExit() == e.getSource()){ //Listener del boton "Salir"
            addEmpWindow.dispose();
            mainWindow.setVisible(true);
        }
        
    }
    
}