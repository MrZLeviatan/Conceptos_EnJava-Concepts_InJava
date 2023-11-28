# _BackTracking_

El BackTracking en java es un enfoque de programación utilizado para encontrar soluciones a
problemas que implican la exploracion sistematica de multiples opciones. Este enfoque se
caracteriza por probar una serie de elecciones y, en caso de que una eleccion no conduza a
una solucion válida, retrocede (hacer "backtrack") para probar una alternativa diferente.


<p align="center">
<picture>
  <source media="(prefers-color-scheme: dark)"  srcset="https://github.com/MrZLeviatan/Conceptos_EnJava/assets/117557162/5ecc1d8c-36ce-4e5c-8a29-62b5bb1d3b19">
  <source media="(prefers-color-scheme: light)" srcset="https://github.com/MrZLeviatan/Conceptos_EnJava/assets/117557162/9311f983-480f-4684-90b9-0cf212f1eda3">
  <img alt="Shows an illustrated sun in light mode and a moon with stars in dark mode." src="https://user-images.githubusercontent.com/25423296/163456779-a8556205-d0a5-45e2-ac17-42d089e3c3f8.png">
</picture>
</p>

___

#### _A continuacion se demostrarán distintos ejemplos usando la tecnica "BackTracking" en distintos ejercicios y juegos orientados en la programación de Java:_


# _Juegos Comunes:_

## [_Juego De La Mochila_](./JuegoMochila)
El juego de la mochila se basa en obtener la mejor combinacion de elementos que más beneficios nos dé y que no sobrepase el
peso de una mochila. Se denota la creacion de clases y metodos recursivos.

## [_Juego De Los Laberintos_](./Laberinto)
Queremos hallar la solucion oh posibles soluciones de un laberinto hecho por matrices utilizando los metodos recursivos y de Backtracking.

## [_Campo De Guerra_](./CampoDeGuerra)
Recorrer un campo de guerra hecho por matriz, donde se encontrara aliados y enemigos de diferentes tipos; La idea es contar cada aliado encontrado y eliminar a los enemigos para subir un contador.

___
# _Problematicas BackTracking:_

## [_Recorrido Carcel_](./Carcel)
Recorrer una carcel hecha por matriz donde se encontraran presos; La idea es contar los presos y saber cuantos faltan dentro de la carcel.

## [_Parqueadero_](./Parqueadero)
Desarrolle una aplicación que permita parquear los 2 carros en los respectivos espacios reservados Una vez realice el parqueo de un carro en R1 o R2 colocar en dicha posición el carro //

Tener en cuenta que si R1 y R2 tiene algún carro suyo parqueado ya no será un punto disponible. Al seguir con el siguiente carro limpiar la ruta previa que realizó para parquear el carro El inicio del parqueo de los carros inicia donde dice Entrada Tener presente que no se puede salir del parqueadero
