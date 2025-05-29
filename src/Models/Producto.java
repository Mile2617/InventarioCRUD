package Models;

public class Producto {
    private String sku;
    private String nombre;
    private double costo;
    private double precio;
    private int cantidad;
    private String descripcion;
    private String marca;

    public Producto(String sku, String nombre, double costo, double precio, int cantidad, String descripcion, String marca) {
        this.sku = sku;
        this.nombre = nombre;
        this.costo = costo;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public Producto() {
    }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
}
