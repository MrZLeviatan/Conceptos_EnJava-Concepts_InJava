package mrzleviatan.ejercicio_03.Model;

/**
 * SE CREA LA CLASE ProductoRefigerado QUE HEREDA DE PRODUCTO.
 */
public class ProductoRefigerado extends Producto{


    /**
     * SE CREAN LOS ATRIBUTOS DE LA CLASE.
     */


    private int codigoAprobacion;
    private Double temperaturaRecomendada;


    /**
     * SE CREAN LOS CONSTRUCTORES DE LA CLASE, TANTO VACIOS COMO CON SUS PARAMETROS.
     */
    public ProductoRefigerado(){ }


    public ProductoRefigerado(String nombre, int codigo, String descripcion, Double valorMonetario, int cantidad, int codigoAprobacion, Double temperaturaRecomendada) {
        super(nombre, codigo, descripcion, valorMonetario, cantidad);
        this.codigoAprobacion = codigoAprobacion;
        this.temperaturaRecomendada = temperaturaRecomendada;
    }

    public int getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(int codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public Double getTemperaturaRecomendada() {
        return temperaturaRecomendada;
    }

    public void setTemperaturaRecomendada(Double temperaturaRecomendada) {
        this.temperaturaRecomendada = temperaturaRecomendada;
    }
}
