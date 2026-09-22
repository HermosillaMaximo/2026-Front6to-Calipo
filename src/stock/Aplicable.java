package stock;

public abstract class Aplicable implements Producto {
    protected Producto producto;

    protected Aplicable(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String getNombre() {
        return producto.getNombre();
    }

    @Override
    public String getDescripcion() {
        return producto.getDescripcion();
    }

    @Override
    public int getStock() {
        return producto.getStock();
    }
}
