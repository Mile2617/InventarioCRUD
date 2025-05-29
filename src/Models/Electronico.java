package Models;

public class Electronico extends Producto {
    private double voltaje;
    private int garantia;
    private String tipo;

    public Electronico(double voltaje, int garantia, String tipo, String sku, String nombre, double costo, double precio,
                       int cantidad, String descripcion, String marca) {
        super(sku, nombre, costo, precio, cantidad, descripcion, marca);
        this.voltaje = voltaje;
        this.garantia = garantia;
        this.tipo = tipo;
    }

    public double getVoltaje() { return voltaje; }
    public void setVoltaje(double voltaje) { this.voltaje = voltaje; }

    public int getGarantia() { return garantia; }
    public void setGarantia(int garantia) { this.garantia = garantia; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
