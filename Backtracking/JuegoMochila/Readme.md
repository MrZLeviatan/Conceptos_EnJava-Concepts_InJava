<h1 align="center"> Juego De La Mochila / Backpack Game</h1> 

El problema de la mochila es un problema clásico de optimización en el que se busca maximizar el valor total de los objetos que se pueden colocar en una mochila con capacidad limitada. Cada objeto tiene un peso y un valor, y el objetivo es determinar la combinación de objetos que maximiza el valor total sin exceder la capacidad de la mochila.

> The backpack problem is a classic optimization problem in which we seek to maximize the total value of the objects that can be placed in a backpack with limited capacity. Each item has a weight and value, and the goal is to determine the combination of items that maximizes the total value without exceeding the capacity of the backpack.



<p align="center">
  <img src="https://i.postimg.cc/dDMtSGNZ/mochila-Juego.png" />
</p>


---

## _Tools:_


- <H3> Backend:</H3>

    - [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ](https://www.oracle.com/co/java/technologies/downloads/#java21)


- <H3>  IDEs/ Editors: </H3>

    - [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/es-es/idea/) [![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)



___
<H1 align="center"> 

_Classes_

</H1>

## _Class App_

Se crea el ejecutable "App" donde iran los objetos 'Elementos' quemados para poder realizar el BackTracking con las funciones necesarias.
> The "App" executable is created where the burned 'Elements' objects will go to be able to perform BackTracking with the necessary functions.

<br>

> [!IMPORTANT]
> Se denota el uso y conocimiento previo de [Java Orientado A Objetos](/Objects).
> > The use and prior knowledge of [Object-Oriented Java](/Objects) is denoted.

<br>

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

Creamos la clase Elemento, la cual será nuestro objeto con las propiedades de peso y precio. Estos mismos objetos serán ingresados a la mochila.
> We create the Element class, which will be our object with the weight and price properties. These same objects will be placed in the backpack.

<br>

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

Se crea la clase Mochila con sus propiedades y lista de 'Elementos' los cuales se compararan para buscar el beneficio óptimo sin pasar el pesoMáximo.
> The Backpack class is created with its properties and list of 'Elements' which will be compared to find the optimal benefit without exceeding the Maximum weight.

<br>

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
