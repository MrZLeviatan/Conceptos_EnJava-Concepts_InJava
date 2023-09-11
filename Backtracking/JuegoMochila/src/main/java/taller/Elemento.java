package taller;

public class Elemento {

    private int peso;
    private int precio;

    public Elemento(int peso, int precio) {
        this.peso = peso;
        this.precio = precio;
    }

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

    // Equal es para comparar oh saber si un objeto es equivalente a otro

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

    @Override
    public String toString() {
        return "Elemento { "+"peso: "+peso+ ","+" precio: "+precio+ " }";
    }
}



