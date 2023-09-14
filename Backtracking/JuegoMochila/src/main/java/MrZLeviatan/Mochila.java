package MrZLeviatan;

public class Mochila {


    private Elemento [] elementos;
    private int peso, beneficios, pesoMaximo;

    public Mochila(int numElementos, int pesoMaximo) {
        this.elementos = new Elemento[numElementos];
        this.peso = 0;
        this.beneficios = 0;
        this.pesoMaximo = pesoMaximo;
    }

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

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }


    public void anadirElemento (Elemento e, int i) {

        if (i != elementos.length) {
            if (this.elementos[i] == null) {
                this.elementos[i] = e;
                this.beneficios += e.getPrecio();
                this.peso += e.getPeso();
            }else {
                anadirElemento(e,i+1);
            }
        }
    }

    public void clear (int i){
        this.peso=0;
        this.beneficios=0;
        if (i != elementos.length){
            this.elementos[i] = null;
            clear(i+1);
        }
    }

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

    public String palabra (String cod, int i) {

        if (i == this.elementos.length) {
            return cod;
        }
        if (this.elementos[i] != null) {
            cod += elementos[i] + "\n";
        }
        return palabra(cod, i+1);
    }

    @Override
    public String toString() {
        String cod = "";
        cod = palabra(cod,0);
        cod += "Peso = " + getPeso() + "\n";
        cod += "Beneficios = " + getBeneficios() + "\n";
        return cod;
    }
}




