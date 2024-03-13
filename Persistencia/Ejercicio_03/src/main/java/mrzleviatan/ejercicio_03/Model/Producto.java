package mrzleviatan.ejercicio_03.Model;


/**
 * SE CREA LA CLASE PRODUCTO QUE FUNCIONARA POSTERIOMENTE COMO HEREDITARIO.
 */
public class Producto {


    /**
     * SE CREAN LOS ATRIBUTOS DE LA CLASE
     */

    private String nombre,descripcion;
    private Double valorMonetario;
    private int cantidad, codigo;


    /**
     * SE CREAN LOS CONSTRUCTORES DE LA CLASE, TANTO VACIOS COMO CON LOS ATRIBUTOS.
     */

    public Producto(){ }

    public Producto(String nombre, int codigo, String descripcion, Double valorMonetario, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valorMonetario = valorMonetario;
        this.cantidad = cantidad;
    }


    /**
     * SE CREAN LOS GET Y SET DE LOS ATRIBUTOS.
     */
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getValorMonetario() { return valorMonetario; }

    public void setValorMonetario(Double valorMonetario) { this.valorMonetario = valorMonetario; }

    public int getCantidad() { return cantidad; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
