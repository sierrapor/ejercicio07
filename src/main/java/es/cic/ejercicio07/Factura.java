package es.cic.ejercicio07;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String concepto;
    private double importe;
    
    public Factura() {
        super();
    }
    
    public Factura(String concepto, double importe) {
        super();
        this.concepto = concepto;
        this.importe = importe;
    }
    
    public Factura(Long id, String concepto, double importe) {
        super();
        this.id = id;
        this.concepto = concepto;
        this.importe = importe;
    }
    
    @Override
    public String toString() {
        return "Factura [id=" + id + ", concepto=" + concepto + ", importe=" + importe + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
