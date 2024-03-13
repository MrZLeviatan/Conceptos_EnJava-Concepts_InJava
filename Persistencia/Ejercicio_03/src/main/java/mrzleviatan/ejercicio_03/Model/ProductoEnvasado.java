package mrzleviatan.ejercicio_03.Model;

import java.time.LocalDate;

/**
 * SE CREA LA CLASE ProductoEnvasado QUE HEREDA DE PRODUCTO.
 */
public class ProductoEnvasado extends Producto{


    /**
     * SE CREAN LOS ATRIBUTOS DE LA CLASE
     */

    private LocalDate fechaEnvasado;
    private Double pesoEnvase;
    private TipoPais tipoPais;


    /**
     * SE CREAN LOS CONSTRUCTORES DE LA CLASE TANTO VACIOS COMO CON LOS ATRIBUTOS.
     */
    public ProductoEnvasado(){ }


    public ProductoEnvasado(String nombre,  int codigo, String descripcion, Double valorMonetario, int cantidad, LocalDate fechaEnvasado, Double pesoEnvase, TipoPais tipoPais) {
        super(nombre, codigo, descripcion, valorMonetario, cantidad);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.tipoPais = tipoPais;
    }


    /**
     * SE CREAN LOS GET Y SET DE LOS ATRIBUTOS.
     */

    public LocalDate getFechaEnvasado() { return fechaEnvasado; }

    public void setFechaEnvasado(LocalDate fechaEnvasado) { this.fechaEnvasado = fechaEnvasado; }

    public Double getPesoEnvase() { return pesoEnvase; }

    public void setPesoEnvase(Double pesoEnvase) { this.pesoEnvase = pesoEnvase; }

    public TipoPais getPaisOrigen() { return tipoPais; }

    public void setPaisOrigen(TipoPais tipoPais) { this.tipoPais = tipoPais ; }
}
