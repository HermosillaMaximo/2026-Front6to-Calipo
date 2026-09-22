package stock;

public class Packing extends Aplicable {
    private String tipo;
    private double costo;

    public Packing(Producto producto, String tipo, double costo) {
        super(producto);
        this.costo = costo;
    }

    @Override
    public double getPrecio() {
        return producto.getPrecio() + costo;
    }
}
