package gt.edu.umg.AppVentas.models;

public class DetalleFactura {
    private String producto;
    private int cantidad;
    private double precio;
    private String descripcion;
    private double subtotal;
    private int idProducto;

    public DetalleFactura(String producto, int cantidad, double precio, String descripcion, double subtotal, int idProducto) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.idProducto = idProducto;
    }

    // Getters y Setters
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
}