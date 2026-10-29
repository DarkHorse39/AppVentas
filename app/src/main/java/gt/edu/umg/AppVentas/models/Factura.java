package gt.edu.umg.AppVentas.models;

import java.util.List;

public class Factura {
    private String numeroFactura;
    private String fecha;
    private String cliente;
    private String nit;
    private double total;
    private String origen;
    private List<DetalleFactura> detalles;

    // Constructor
    public Factura(String numeroFactura, String fecha, String cliente, String nit, double total, String origen, List<DetalleFactura> detalles) {
        this.numeroFactura = numeroFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.nit = nit;
        this.total = total;
        this.origen = origen;
        this.detalles = detalles;
    }

    // Getters y Setters (Necesarios para que Json los convierta)
    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getNit() { return nit; }
    public void setNit(String nit) { this.nit = nit; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public List<DetalleFactura> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleFactura> detalles) { this.detalles = detalles; }
}