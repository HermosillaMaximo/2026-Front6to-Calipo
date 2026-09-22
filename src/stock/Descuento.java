package stock;

public class Descuento extends Aplicable {
    private float descuento;

    public Descuento(Producto producto, float descuento) {
        super(producto);
        this.descuento = descuento;
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion() + " - descuento fijo $" + descuento;
    }

    @Override
    public double getPrecio() {
        double precio = producto.getPrecio() - descuento;
        return precio;
    }
}
