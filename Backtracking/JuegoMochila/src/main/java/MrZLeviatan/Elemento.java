package MrZLeviatan;


/**
 * ELEMENTO PARA INGRESAR A LA MOCHILA.
 */
public class Elemento {


    /**
     * CARACTERÍSTICAS DEL OBJETO ELEMENTO.
     */
    private int peso;
    private int precio;


    /**
     * CONSTRUCTOR DE LA CLASE.
     * @param peso
     * @param precio
     */
    public Elemento(int peso, int precio) {
        this.peso = peso;
        this.precio = precio;
    }


    /**
     * MÉTODOS GET Y SET DE LA CLASE.
     */
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    /**
     * CREAMOS EL MÉTODO EQUALS PARA COMPARAR CADA OBJETO. IGUALMENTE PODEMOS COMPARAR SI ES EQUIVALENTE A OTRO.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;
        final Elemento other = (Elemento) obj;
        if (this.peso != other.peso || this.precio != other.precio){
            return false;
        }
        return true;
    }


    /**
     * CREAMOS EL MÉTODO ToString PARA RETORNAR UNA REPRESENTACIÓN DE CADENA DEL OBJETO EN FORMA DE DECLARACIÓN DE FUNCIÓN.
     */
    @Override
    public String toString() {
        return "Elemento { "+"peso: "+peso+ ","+" precio: "+precio+ " }";
    }
}



