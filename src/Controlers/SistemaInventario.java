package Controlers;

import Models.Cosmetico;
import Models.Electronico;
import Models.Producto;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class SistemaInventario {

    List<Producto> productos = new ArrayList<>();
    double costoTotal = 0;
    int cantidadTotal = 0;

    // CREAR PRODUCTOS
    public void createProducto(String sku, String nombre, double costo, double precio, String descripcion, int cantidad, String marca, double voltaje, int garantia) {
        Electronico e = new Electronico(voltaje, garantia, "Electrodoméstico", sku, nombre, costo, precio, cantidad, descripcion, marca);
        productos.add(e);
        costoTotal += e.getCosto() * e.getCantidad();
        cantidadTotal += e.getCantidad();
    }

    public void createProducto(String sku, String nombre, double costo, double precio, String descripcion, int cantidad, String marca,
                               String lote, Date fechaElaboracion, Date fechaVencimiento, String ingredientes, String tipoProducto) {
        Cosmetico c = new Cosmetico(lote, fechaElaboracion, fechaVencimiento, ingredientes, tipoProducto,
                sku, nombre, costo, precio, cantidad, descripcion, marca);
        productos.add(c);
        costoTotal += c.getCosto() * c.getCantidad();
        cantidadTotal += c.getCantidad();
    }

    // LEER PRODUCTO POR SKU
    public void readProducto(String sku) {
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                System.out.println("SKU: " + p.getSku());
                System.out.println("Nombre: " + p.getNombre());
                System.out.println("Descripción: " + p.getDescripcion());
                System.out.println("Cantidad: " + p.getCantidad());
                System.out.println("Marca: " + p.getMarca());
                System.out.println("Precio: " + p.getPrecio());
                System.out.println("Costo: " + p.getCosto());

                if (p instanceof Electronico) {
                    Electronico e = (Electronico) p;
                    System.out.println("Voltaje: " + e.getVoltaje() + " V");
                    System.out.println("Garantía: " + e.getGarantia() + " meses");
                } else if (p instanceof Cosmetico) {
                    Cosmetico c = (Cosmetico) p;
                    System.out.println("Lote: " + c.getLote());
                    System.out.println("Elaboración: " + c.getFechaElaboracion());
                    System.out.println("Vencimiento: " + c.getFechaVencimiento());
                    System.out.println("Ingredientes: " + c.getIngredientes());
                    System.out.println("Tipo: " + c.getTipoProducto());
                }

                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // ACTUALIZAR PRODUCTO
    public boolean updateProducto(String sku, String nuevoNombre, double nuevoCosto, double nuevoPrecio, int nuevaCantidad) {
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                costoTotal -= p.getCosto() * p.getCantidad();
                cantidadTotal -= p.getCantidad();

                p.setNombre(nuevoNombre);
                p.setCosto(nuevoCosto);
                p.setPrecio(nuevoPrecio);
                p.setCantidad(nuevaCantidad);

                costoTotal += nuevoCosto * nuevaCantidad;
                cantidadTotal += nuevaCantidad;

                return true;
            }
        }
        return false;
    }

    // ELIMINAR PRODUCTO
    public boolean deleteProducto(String sku) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getSku().equalsIgnoreCase(sku)) {
                costoTotal -= p.getCosto() * p.getCantidad();
                cantidadTotal -= p.getCantidad();
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    // LISTAR PRODUCTOS
    public void ListProducto() {
        int i = 0;
        System.out.printf("n\t\tCategoria\t\tNombre\t\tCantidad\t\tValor Unitario\n");
        for (Producto producto : productos) {
            String cat = (producto instanceof Electronico) ? "Electronico" :
                    (producto instanceof Cosmetico) ? "Cosmetico" : "Desconocido";
            System.out.printf("%d\t\t%s\t\t%s\t\t%d\t\t%.2f\n", i, cat, producto.getNombre(), producto.getCantidad(), producto.getCosto());
            i++;
        }
    }

    // GETTERS
    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
}
