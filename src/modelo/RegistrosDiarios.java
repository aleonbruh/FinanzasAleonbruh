
package modelo;

import java.util.Date;

public class RegistrosDiarios {
    
    private int id;
    private Date fecha;
    private double saldoFisico;
    private double saldoDigital;
    private double saldoTotal;
    
    public RegistrosDiarios(){
        this.id = 0;
        this.fecha = new Date(0);
        this.saldoFisico = 0;
        this.saldoDigital = 0;
        this.saldoTotal = 0;
    }

    public RegistrosDiarios(int id, Date fecha, double saldoFisico, double saldoDigital, double saldoTotal) {
        this.id = id;
        this.fecha = fecha;
        this.saldoFisico = saldoFisico;
        this.saldoDigital = saldoDigital;
        this.saldoTotal = saldoTotal;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getSaldoFisico() {
        return saldoFisico;
    }
    public void setSaldoFisico(double saldoFisico) {
        this.saldoFisico = saldoFisico;
    }

    public double getSaldoDigital() {
        return saldoDigital;
    }
    public void setSaldoDigital(double saldoDigital) {
        this.saldoDigital = saldoDigital;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }
    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
    
    
    
}
