# _Threads_

Los Threads en java son subprocesos de ejecución independientes que permiten que un programa
realice multiples tareas simultáneamente. Los "Threads" son pequeñas unidades de procesamiento
que comparten recursos y se ejecutan de manera concurrente en el mismo programa. Java
proporciona una API de hilos que permiten crear, controlar y coordinar multiples hilos en una
aplicacion.


<p align="center">
<picture>
  <source media="(prefers-color-scheme: dark)"  srcset="https://github.com/MrZLeviatan/Conceptos_EnJava/assets/117557162/3c0d6abf-a489-4283-b590-813bf047049a">
  <source media="(prefers-color-scheme: light)" srcset="https://github.com/MrZLeviatan/Conceptos_EnJava/assets/117557162/fd7dd7fa-23d9-4f6e-9858-a4ebb2141966">
  <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://user-images.githubusercontent.com/25423296/163456779-a8556205-d0a5-45e2-ac17-42d089e3c3f8.png">
</picture>
</p>


___

#### _A continuacion se demostrarán distintos ejemplos usando la API "Threads" en distintos ejercicios orientados en la programación de Java:_

# _Ejercicios Basicos:_

## [_Ejercicio 2_](Ejercicio_2)  
En este ejercicio se pide la creacion de 3 hilos con funcionalidades distintas:

- Hilo 1: Se crea un arreglo e imprime sus valores. Tiempo de espera en cada iteracion(1 Segundo).
- Hilo 2: Se genera un entero aleatorio y se multiplica por el mismo 10 veces. Tiempo de espera
    en cada iteracion(1.5 segundos).
- Hilo 3: Imprimie el nombre del mismo hilo 15 veces. Tiempo de espera en cada iteracion (500 ms).

___

# _Ejercicios Utilizando La Libreria Fx:_

## [_Ejercicio 1_](./Ejercicio_01)
Demostrar en una interfaz creada por la libreria Fx varios botones con diferentes funcionalidades:

- En el BotonFx "Main01" imprime un conteo de 1-50 sin poder ser interrumpido.
- En el BotonFx "Main02" imprime un hola sin poder ser interrumpido.
- Hilo 1: Se implementan dos BotonesFx. En el BotonFx "Star" imprime el nombre del Hilo y
    un conteo. En el BotonFx "Stop" se detienen el proceso.
- Hilo 2: Se implementan dos BotonesFx. En el BotonFx "Star" imprime el nombre del Hilo. En
    el BotonFx "Stop" se detiene el proceso.
- Hilo 3: Se implementan dos BotonesFx. En el BotonFx "Star" imprime el nombre del Hilo con un
    conteo. En el BotonFx "Stop" se detiene el proceso.
- Hilo 4: Se pide un número por TextField y se implementan dos BotonesFx. En el BotonFx "Star"
    imprime la tabla de multiplicacion. En el BotonFx "Stop" se detiene el proceso.
- Hilo 5: Se pide un número por TextField y se implementandos BotonesFx. En el BotonFx "Star"
    imprime el doble del mismo sucesivamente. En el BotonFx "Stop" se detiene el proceso.

