package stock;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ProductoSimple casco = new ProductoSimple("Casco", "Casco integral", 80000, 10);
        ProductoSimple guante = new ProductoSimple("Guantes", "Guantes de moto", 25000, 8);
        ProductoSimple chaleco = new ProductoSimple("Chaleco", "Chaleco reflectivo", 15000, 12);
        ProductoSimple piloto = new ProductoSimple("Piloto", "Piloto impermeable", 30000, 5);

        ArrayList<Producto> productosProteccion = new ArrayList<>();
        productosProteccion.add(casco);
        productosProteccion.add(guante);
        productosProteccion.add(chaleco);
        Producto comboProteccion = new Combo("Combo proteccion", "Casco, guantes y chaleco", productosProteccion);

        ArrayList<Producto> productosCompleto = new ArrayList<>();
        productosCompleto.add(comboProteccion);
        productosCompleto.add(piloto);
        productosCompleto.add(piloto);
        Producto comboCompleto = new Combo("Combo completo", "Combo proteccion mas dos pilotos", productosCompleto);

        // combo de combos: kitMoto contiene adentro a comboCompleto (que a su vez ya contiene a comboProteccion)
        ProductoSimple moto = new ProductoSimple("Moto", "Moto 150cc", 900000, 3);
        ArrayList<Producto> productosKit = new ArrayList<>();
        productosKit.add(comboCompleto);
        productosKit.add(moto);
        Producto kitMoto = new Combo("Kit moto", "Combo completo mas la moto", productosKit);

        Producto oferta = new Descuento(comboCompleto, 5000);
        oferta = new Descuento(oferta, 2500);
        Producto paquete = new Packing(oferta, "Caja premium", 3000);

        mostrar(comboProteccion);
        mostrar(comboCompleto);
        mostrar(kitMoto);
        mostrar(paquete);
    }

    private static void mostrar(Producto producto) {
        System.out.printf(
                "%s | Precio: $%.2f | Stock: %d | %s%n",
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getDescripcion()
        );
    }
}