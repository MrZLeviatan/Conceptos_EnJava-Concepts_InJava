# _Ejercicio 02_

En este ejercicio se pide la creacion de 3 hilos con funcionalidades distintas:

- Hilo 1: Se crea un arreglo e imprime sus valores. Tiempo de espera en cada iteracion(1 Segundo).
- Hilo 2: Se genera un entero aleatorio y se multiplica por el mismo 10 veces. Tiempo de espera
  en cada iteracion(1.5 segundos).
- Hilo 3: Imprimie el nombre del mismo hilo 15 veces. Tiempo de espera en cada iteracion (500 ms).

## _Tool_

- Java 17
- Maven
- IDE Intellij

___

# _Class_

- ### _App02_

Inicia la aplicacion con la ejecución de algún Hilo.

```java

public class App02 {

    public static void main(String[] args){

        HiloServicio01 hiloServicio01 = new HiloServicio01("Hilo 1");
        HiloServicio02 hiloServicio02 = new HiloServicio02("Hilo 2");
        HiloServicio03 hiloServicio03 = new HiloServicio03("Hilo 3");


        hiloServicio01.start();
        // hiloServicio02.start();
        // hiloServicio03.start();

    }
}
```

- ### _Hilo Servicio 01_

Se crea las condiciones para poder ejecutar el servicio del Hilo 1

```java

public class HiloServicio01 extends Thread {



    String[] nombres = {"esto", "es", "un", "mensaje", "de", "un", "array"};



    HiloServicio01(String nombre) {

        super(nombre);
    }


    public void run() {

        System.out.println(" // "+getName() + " Ah Iniciado // \n");

        try {

            for (int i = 0; i < nombres.length; i++) {
                System.out.print(nombres[i] + " ");
                Thread.sleep(1000);
            }

            System.out.println("\n //"+ getName() + " Ah Finalizado //");

        } catch (Exception e) { }

    }
}
```

- ### _Hilo Servicio 02_

Se crea las condiciones para poder ejecutar el servicio del Hilo 2

```java

public class HiloServicio02 extends Thread {

    int numero = (int) (Math.random()*10+1);


    HiloServicio02(String nombre){

        super(nombre);
    }


    public void run(){

        System.out.println(" // "+getName() + " Ah iniciado // \n");

        try{

            for (int i = 1; i < 10; i++) {

                int contador = (int) Math.pow(numero,i);
                System.out.println("El numero es: "+ numero + " y la sumatoria va por: " + contador);
                Thread.sleep(1500);

            }

            System.out.println( "\n // "+getName() + " Ah Finalizado // ");

        }catch (Exception ex){}
    }

}
```

- ### _Hilo Servicio 03_

Se crea las condiciones para poder ejecutar el servicio del Hilo 3

```java

public class HiloServicio03 extends Thread{


    HiloServicio03(String nombre){

        super(nombre);
    }

    public void run(){

        System.out.println(" // "+getName() + " Ah iniciado // \n");

        try {

            for (int i = 0; i < 15; i++) {
                System.out.println(getName() + " Contando ");
                Thread.sleep(500);
            }

            System.out.println(" // " + getName()+ " Ah Finalizado //");

        }catch (Exception e){}
    }
}
```

