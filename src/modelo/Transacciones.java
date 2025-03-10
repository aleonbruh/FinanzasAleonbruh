
package modelo;

public class Transacciones {
    
    private int id;
    private int registroId;
    private String tipo;
    private String fuente;
    private double monto;
    private String descripcion;

    //Constructor
    public Transacciones(int id, int registroId, String tipo, String fuente, double monto, String descripcion) {
        this.id = id;
        this.registroId = registroId;
        this.tipo = tipo;
        this.fuente = fuente;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getRegistroId() {
        return registroId;
    }
    public void setRegistroId(int registroId) {
        this.registroId = registroId;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFuente() {
        return fuente;
    }
    public void setFuente(String fuente) {
        this.fuente = fuente;
    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     
}
