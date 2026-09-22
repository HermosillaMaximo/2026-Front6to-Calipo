package stock;

import java.util.ArrayList;
import java.util.HashMap;


public class Combo implements Producto {
    private String nombre;
    private String descripcion;
    private ArrayList<Producto> productos;

    public Combo(String nombre, String descripcion, ArrayList<Producto> productos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.productos = new ArrayList<>(productos);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        double precioCombo = 0;
        for (Producto producto : productos) {
            precioCombo += producto.getPrecio();
        }
        return precioCombo;
    }

    @Override
    public int getStock() {
        // recorremos los productos y guardamos cuantas veces se necesita cada uno para armar el combo
        HashMap<Producto, Integer> cantidadNecesaria = new HashMap<>();

        for (Producto producto : productos) {
            if (cantidadNecesaria.containsKey(producto)) {
                int cantidadActual = cantidadNecesaria.get(producto);
                cantidadNecesaria.put(producto, cantidadActual + 1);
            } else {
                cantidadNecesaria.put(producto, 1);
            }
        }

    
        ArrayList<Integer> combosPosiblesPorProducto = new ArrayList<>();
        for (Producto producto : cantidadNecesaria.keySet()) {
            int stockProducto = producto.getStock();
            if (stockProducto <= 0) {
                return 0;
            }
            int cantidadPorCombo = cantidadNecesaria.get(producto);
            int combosConEsteProducto = stockProducto / cantidadPorCombo;
            combosPosiblesPorProducto.add(combosConEsteProducto);
        }

        int minimo = combosPosiblesPorProducto.get(0);
        for (int cantidad : combosPosiblesPorProducto) {
            if (cantidad < minimo) {
                minimo = cantidad;
            }
        }
        return minimo;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}