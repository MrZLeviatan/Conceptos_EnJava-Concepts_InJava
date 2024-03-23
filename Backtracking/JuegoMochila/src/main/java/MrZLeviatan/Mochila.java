package MrZLeviatan;

/**
 * CLASE DE LA MOCHILA
 */
public class Mochila {


    /**
     * CARACTERÍSTICAS DE LA MOCHILA.
      <br>
        *  elementos es una lista de la clase objeto "Elementos".
     */
    private Elemento [] elementos;
    private int peso, beneficios, pesoMáximo;


    /**
     * CONSTRUCTOR DE LA CLASE.
     * @param numElementos
     * @param pesoMáximo
     */
    public Mochila(int numElementos, int pesoMáximo) {
        this.elementos = new Elemento[numElementos];
        this.peso = 0;
        this.beneficios = 0;
        this.pesoMáximo = pesoMáximo;
    }


    /**
     * MÉTODOS GET Y SET DE LA CLASE.
     */
    public Elemento[] getElementos() {
        return elementos;
    }

    public void setElementos(Elemento[] elementos) {
        this.elementos = elementos;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(int beneficios) {
        this.beneficios = beneficios;
    }

    public int getPesoMáximo() {
        return pesoMáximo;
    }

    public void setPesoMáximo(int pesoMáximo) {
        this.pesoMáximo = pesoMáximo;
    }



    /**
     * MÉTODOS PARA AGREGAR OBJETOS DE TIPO "ELEMENTO" A LA MOCHILA.
     */
    public void agregarElemento(Elemento e, int i) {

        if (i != elementos.length) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e;
                this.beneficios += e.getPrecio();
                this.peso += e.getPeso();
            }else {
                agregarElemento(e,i+1);
            }
        }
    }


    /**
     * MÉTODOS PARA FORMATEAR LOS DATOS DE LA MOCHILA.
     */
    public void clear (int i){
        this.peso=0;
        this.beneficios=0;
        if (i != elementos.length){
            this.elementos[i] = null;
            clear(i+1);
        }
    }



    /**
     * MÉTODOS PARA ELIMINAR OBJETOS DE TIPO "ELEMENTO".
     */

    public void eliminarElemento (Elemento e, int i){

        if (i != elementos.length){
            if (this.elementos[i].equals(e)){
                this.elementos[i] = null;
                this.peso-=e.getPeso();
                this.beneficios-=e.getPrecio();

            }else{
                eliminarElemento(e,i+1);
            }
        }
    }



    /**
     * MÉTODOS PARA SABER SI EXISTE EL ELEMENTO EN LA MOCHILA.
     */

    public boolean existeElemento (Elemento e, int i){

        boolean pert = false;
        if (i == elementos.length){
            return pert;
        }
        if (this.elementos[i] != null && this.elementos[i].equals(e)){
            pert = true;
            return pert;
        }else{
            return existeElemento(e,i+1);
        }

    }


    /**
     * MÉTODOS PARA AGRUPAR EL ELEMENTO EN UN TIPO STRING.
     */
    public String palabra (String cod, int i) {

        if (i == this.elementos.length) {
            return cod;
        }
        if (this.elementos[i] != null) {
            cod += elementos[i] + "\n";
        }
        return palabra(cod, i+1);
    }


    /**
     * CREAMOS EL MÉTODO ToString PARA RETORNAR UNA REPRESENTACIÓN DE CADENA DEL OBJETO EN FORMA DE DECLARACIÓN DE FUNCIÓN.
     */
    @Override
    public String toString() {
        String cod = "";
        cod = palabra(cod,0);
        cod += "Peso = " + getPeso() + "\n";
        cod += "Beneficios = " + getBeneficios() + "\n";
        return cod;
    }
}




