package Clases;

import java.util.Date;

public class Boleta {

    private String codigoBoleta;

    private Date fecha;

    public Boleta() {
    }

    // Getters
    public String getCodigoBoleta() {
        return codigoBoleta;
    }

    public Date getFecha() {
        return fecha;
    }

    // Setters
    public void setDni(String codigoBoleta) {
        this.codigoBoleta = codigoBoleta;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
