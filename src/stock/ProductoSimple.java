package stock;

public class ProductoSimple implements Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    public ProductoSimple(String nombre, String descripcion, double precio, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
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
        return precio;
    }

    @Override
    public int getStock() {
        return stock;
    }

    public void ingresarStock(int cantidad) {
        validarCantidad(cantidad);
        stock += cantidad;
    }

    public void retirarStock(int cantidad) {
        validarCantidad(cantidad);
        if (cantidad > stock) {
            throw new IllegalArgumentException("No hay stock suficiente de " + nombre);
        }
        stock -= cantidad;
    }

    private void validarCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }
    }
}