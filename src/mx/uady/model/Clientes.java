
package mx.uady.model;


public class Clientes {
    
    private String nombreTitular;
    private String cuentaTitular;
    private int PIN;
    private String cuentaOrigen;
    private String titularOrigen;
    private double monto;
    private double fecha;

    //Constructor
    public Clientes(String nombreTitular, String numeroCuentaTitular, int numeroSeguridad, String numeroCuentaOrigen, String nombreTitularOrigen, double monto, double fechaTransferencia) {
        this.nombreTitular = nombreTitular;
        this.cuentaTitular = numeroCuentaTitular;
        this.PIN = numeroSeguridad;
        this.cuentaOrigen = numeroCuentaOrigen;
        this.titularOrigen = nombreTitularOrigen;
        this.monto = monto;
        this.fecha = fechaTransferencia;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getCuentaTitular() {
        return cuentaTitular;
    }

    public void setCuentaTitular(String cuentaTitular) {
        this.cuentaTitular = cuentaTitular;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getTitularOrigen() {
        return titularOrigen;
    }

    public void setTitularOrigen(String titularOrigen) {
        this.titularOrigen = titularOrigen;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getFecha() {
        return fecha;
    }

    public void setFecha(double fecha) {
        this.fecha = fecha;
    }
    
    
    
    
}
