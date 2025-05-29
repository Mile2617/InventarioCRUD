package Views;

import Controlers.SistemaInventario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static SistemaInventario sistema = new SistemaInventario();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n=== MENÚ INVENTARIO ===");
            System.out.println("1. Crear producto electrónico");
            System.out.println("2. Crear producto cosmético");
            System.out.println("3. Mostrar productos");
            System.out.println("4. Buscar producto por SKU");
            System.out.println("5. Actualizar producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Mostrar totales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1 -> crearElectronico();
                case 2 -> crearCosmetico();
                case 3 -> sistema.ListProducto();
                case 4 -> buscarProducto();
                case 5 -> actualizarProducto();
                case 6 -> eliminarProducto();
                case 7 -> mostrarTotales();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void crearElectronico() {
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Costo: ");
        double costo = scanner.nextDouble();
        System.out.print("Precio de venta: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // limpiar
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Voltaje: ");
        double voltaje = scanner.nextDouble();
        System.out.print("Garantía (meses): ");
        int garantia = scanner.nextInt();
        scanner.nextLine();

        sistema.createProducto(sku, nombre, costo, precio, descripcion, cantidad, marca, voltaje, garantia);
        System.out.println("Producto electrónico creado.");
    }

    private static void crearCosmetico() {
        try {
            System.out.print("SKU: ");
            String sku = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Costo: ");
            double costo = scanner.nextDouble();
            System.out.print("Precio de venta: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            System.out.print("Lote: ");
            String lote = scanner.nextLine();
            System.out.print("Fecha de elaboración (yyyy-MM-dd): ");
            Date fechaElab = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            System.out.print("Fecha de vencimiento (yyyy-MM-dd): ");
            Date fechaVenc = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            System.out.print("Ingredientes: ");
            String ingredientes = scanner.nextLine();
            System.out.print("Tipo de producto: ");
            String tipo = scanner.nextLine();

            sistema.createProducto(sku, nombre, costo, precio, descripcion, cantidad, marca, lote, fechaElab, fechaVenc, ingredientes, tipo);
            System.out.println("Producto cosmético creado.");
        } catch (Exception e) {
            System.out.println("Error en formato de fecha. Intente de nuevo.");
        }
    }

    private static void buscarProducto() {
        System.out.print("Ingrese el SKU del producto: ");
        String sku = scanner.nextLine();
        sistema.readProducto(sku);
    }

    private static void actualizarProducto() {
        System.out.print("Ingrese el SKU del producto a actualizar: ");
        String sku = scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo costo: ");
        double costo = scanner.nextDouble();
        System.out.print("Nuevo precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Nueva cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        if (sistema.updateProducto(sku, nombre, costo, precio, cantidad)) {
            System.out.println("Producto actualizado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el SKU del producto a eliminar: ");
        String sku = scanner.nextLine();
        if (sistema.deleteProducto(sku)) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarTotales() {
        System.out.println("Cantidad total de productos: " + sistema.getCantidadTotal());
        System.out.printf("Costo total del inventario: $%.2f\n", sistema.getCostoTotal());
    }
}