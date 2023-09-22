# _Juego de la mochila_
Queremos meter elementos en una mochila con un peso maximo; Estos elementos tienen un peso y un beneficio.

## _Problematica Backtracking:_
Obtener la mejor combinacion que más beneficios nos dé y que no soprepase el 
peso de la mochila

![ImagenEjemplo](https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/JuegoMochila/src/main/resources/images/mochilaJuego.png?raw=true)

------

## _Tool_

- Java 17
- Maven
- IDE Intellij

# _Classes_

## _Class App_

Se crea la clase App donde se queman algunos datos para poder empezar el Backtracking, también se
crea la funcion para llenar la mochila con los datos ya quemados.

```java

public class App {

    public static void main(String[] args) {

        Elemento[] elementos = {

                new Elemento(1, 5),
                new Elemento(2, 20),
                new Elemento(4, 1),
                new Elemento(4, 3),
                new Elemento(10, 1),
        };

        Mochila base = new Mochila(elementos.length, 15);
        Mochila opt = new Mochila(elementos.length, 15);

        System.out.println("-- JUEGO DE LA MOCHILA --");
        llenarMochila(base, elementos, opt, false);
        System.out.println(opt);
    }

    public static void llenarMochila(Mochila base, Elemento[] elementos, Mochila opt, boolean lleno) {

        if (lleno) {
            if (base.getBeneficios() > opt.getBeneficios()) {
                Elemento[] elementosMochBase = base.getElementos();
                opt.clear(0);
                comprobrar(elementosMochBase, 0, opt);
            }
        }else{
            recorrer(base,elementos,opt,false,0);
        }
    }

    public static Mochila comprobrar(Elemento[] elementoMoch, int i, Mochila opt) {

        if (i == elementoMoch.length) {
            return opt;
        }
        if (elementoMoch[i] != null) {
            opt.anadirElemento(elementoMoch[i], 0);
            comprobrar(elementoMoch, i + 1, opt);
            return opt;
        } else {
            return comprobrar(elementoMoch, i + 1, opt);
        }
    }

    public static void recorrer(Mochila base, Elemento[] elementos, Mochila opt, boolean lleno, int i) {

        if (i != elementos.length) {
            if (!base.existeElemento(elementos[i], 0)) {
                if (base.getPesoMaximo() > base.getPeso() + elementos[i].getPeso()) {
                    base.anadirElemento(elementos[i], 0);
                    llenarMochila(base, elementos, opt, false);
                    base.eliminarElemento(elementos[i], 0);

                } else {
                    llenarMochila(base, elementos, opt, true);
                }
            }
            recorrer(base,elementos,opt,lleno,i+1);
        }
    }
}

```
## _Class Elemento:_

En esta clase generamos el objeto elemento con las propiedades de peso y presio, este mismo 
elemento seran los que se metan en la mochila

````Java

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
````

## _Class Mochila:_

Creamos la clase de objeto para la Mochila la cual tiene por propiedades su capacidad maxima de peso.
También se crea los diferentes arquetivos y metodos para completar el Backtracking de este ejercicio.


```java

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
```
