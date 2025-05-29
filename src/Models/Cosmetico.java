package Models;

import java.util.Date;

public class Cosmetico extends Producto {
    private String lote;
    private Date fechaElaboracion;
    private Date fechaVencimiento;
    private String ingredientes;
    private String tipoProducto;

    public Cosmetico(String lote, Date fechaElaboracion, Date fechaVencimiento, String ingredientes, String tipoProducto,
                     String sku, String nombre, double costo, double precio, int cantidad, String descripcion, String marca) {
        super(sku, nombre, costo, precio, cantidad, descripcion, marca);
        this.lote = lote;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
        this.ingredientes = ingredientes;
        this.tipoProducto = tipoProducto;
    }

    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public Date getFechaElaboracion() { return fechaElaboracion; }
    public void setFechaElaboracion(Date fechaElaboracion) { this.fechaElaboracion = fechaElaboracion; }

    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getIngredientes() { return ingredientes; }
    public void setIngredientes(String ingredientes) { this.ingredientes = ingredientes; }

    public String getTipoProducto() { return tipoProducto; }
    public void setTipoProducto(String tipoProducto) { this.tipoProducto = tipoProducto; }
}
