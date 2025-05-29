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
            System.out.println("\n=== MENU INVENTARIO ===");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto por SKU");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Mostrar totales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt(); scanner.nextLine();

            switch (opcion) {
                case 1 -> crearProducto();
                case 2 -> sistema.ListProducto();
                case 3 -> buscarProducto();
                case 4 -> actualizarProducto();
                case 5 -> eliminarProducto();
                case 6 -> mostrarTotales();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void crearProducto() {
        System.out.println("Ingrese el tipo de producto (1 - Electronico, 2 - Cosmetico): ");
        int tipo = scanner.nextInt(); scanner.nextLine();
        if (tipo == 1) {
            crearElectronico();
        } else if (tipo == 2) {
            crearCosmetico();
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    private static void crearElectronico() {
        System.out.print("SKU: "); String sku = scanner.nextLine();
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Costo: "); double costo = scanner.nextDouble();
        System.out.print("Precio de venta: "); double precio = scanner.nextDouble(); scanner.nextLine();
        System.out.print("Descripcion: "); String descripcion = scanner.nextLine();
        System.out.print("Cantidad: "); int cantidad = scanner.nextInt(); scanner.nextLine();
        System.out.print("Marca: "); String marca = scanner.nextLine();
        System.out.print("Voltaje: "); double voltaje = scanner.nextDouble();
        System.out.print("Garantia (meses): "); int garantia = scanner.nextInt(); scanner.nextLine();

        sistema.createProducto(sku, nombre, costo, precio, descripcion, cantidad, marca, voltaje, garantia);
        System.out.println("Producto electronico creado.");
    }

    private static void crearCosmetico() {
        try {
            System.out.print("SKU: "); String sku = scanner.nextLine();
            System.out.print("Nombre: "); String nombre = scanner.nextLine();
            System.out.print("Costo: "); double costo = scanner.nextDouble();
            System.out.print("Precio de venta: "); double precio = scanner.nextDouble(); scanner.nextLine();
            System.out.print("Descripci\u00f3n: "); String descripcion = scanner.nextLine();
            System.out.print("Cantidad: "); int cantidad = scanner.nextInt(); scanner.nextLine();
            System.out.print("Marca: "); String marca = scanner.nextLine();
            System.out.print("Lote: "); String lote = scanner.nextLine();
            System.out.print("Fecha de elaboraci\u00f3n (yyyy-MM-dd): "); Date fechaElab = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            System.out.print("Fecha de vencimiento (yyyy-MM-dd): "); Date fechaVenc = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
            System.out.print("Ingredientes: "); String ingredientes = scanner.nextLine();
            System.out.print("Tipo de producto: "); String tipo = scanner.nextLine();

            sistema.createProducto(sku, nombre, costo, precio, descripcion, cantidad, marca, lote, fechaElab, fechaVenc, ingredientes, tipo);
            System.out.println("Producto cosm\u00e9tico creado.");
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
        sistema.readProducto(sku);

        System.out.println("Seleccione el campo a actualizar:");
        System.out.println("1. Nombre\n2. Costo\n3. Precio\n4. Cantidad");
        System.out.print("Opci\u00f3n: ");
        int opcion = scanner.nextInt(); scanner.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.print("Nuevo nombre: ");
                String nombre = scanner.nextLine();
                sistema.updateProducto(sku, nombre, -1, -1, -1);
            }
            case 2 -> {
                System.out.print("Nuevo costo: ");
                double costo = scanner.nextDouble();
                sistema.updateProducto(sku, null, costo, -1, -1);
            }
            case 3 -> {
                System.out.print("Nuevo precio: ");
                double precio = scanner.nextDouble();
                sistema.updateProducto(sku, null, -1, precio, -1);
            }
            case 4 -> {
                System.out.print("Nueva cantidad: ");
                int cantidad = scanner.nextInt();
                sistema.updateProducto(sku, null, -1, -1, cantidad);
            }
            default -> System.out.println("Opci\u00f3n inv\u00e1lida.");
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
