# _Ejercicio 8_

En este ejercicio se demuestra las diferentes maneras de recorrer una matriz con 
los metodos recursivos.


## _Problematica_
Recorrer una matriz de forma recursiva.

## _Tool_
- Java 17
- Maven
- IDE Intellij

___________

# _Class_

-----

## _Por Filas:_

### - Recorrer la matriz por Filas:

### _Ejemplo:_

    [ 1 2 3 / 4 5 6 / 7 8 9 ]
### _MainApp_

```java 

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Filas:  ");
        recorrerMatriz(m, 0, 0);
    }

    public static void recorrerMatriz(int[][] m, int i, int j) {

        System.out.print(m[i][j]);

        if (i != m.length - 1 || j != m[i].length - 1) {

            if (j == m[i].length - 1) {
                i++;
                j = 0;
                System.out.println(" ");
            } else {
                j++;
                System.out.print(" ");
            }
            recorrerMatriz(m, i, j);
        }
    }
}
```
### - Recorrer la matriz por Filas empezando desde el final de la fila:

### _Ejemplo:_

    [ 3 2 1 // 6 5 4 // 9 8 7 ]

### _MainApp_

```java

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Filas empezando al final: ");
        recorrerMatrizUltimo(m,0,m[0].length-1);
    }
    public static void recorrerMatrizUltimo(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i != m.length-1 || j != 0){

            if (j==0){
                i++;
                j=m[0].length-1;
                System.out.println(" ");
            }else{
                j--;
                System.out.print(" ");
            }
            recorrerMatrizUltimo(m,i,j);
        }
    }
}
```
### -Recorrer la matriz por Filas de forma inversa:

### _Ejemplo:_

    [ 9 8 7 // 6 5 4 // 3 2 1 ]

### _MainApp_

````java 

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Filas inversa: ");
        recorrerMatrizRetrocediendoFinal(m,m.length-1,m[0].length-1);
    }

    public static void recorrerMatrizRetrocediendoFinal(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i != 0 || j != 0){

            if(j == 0){
                i--;
                j = m[0].length-1;
                System.out.println(" ");
                recorrerMatrizRetrocediendoFinal(m,i,j);
            }else{
                j--;
                System.out.print(" ");
                recorrerMatrizRetrocediendoFinal(m,i,j);
            }
        }
    }
}
````
### -Recorrer la matriz por Filas de forma inversa desde el inicio de las filas:

### _Ejemplo:_

    [ 7 8 9 // 4 5 6 // 1 2 3 ]

### _MainApp_

````java

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Filas inversa empezando al inicio: ");
        recorrerMatrizRetrocediendoInicio(m,m.length-1,0);
    }

      public static void recorrerMatrizRetrocediendoInicio ( int [][]m,int i, int j){
        System.out.print(m[i][j]);

        if (i!= 0 || j != m[0].length-1){

            if (j == m[0].length-1){
                i--;
                j = 0;
                System.out.println(" ");

            }else{
                j++;
                System.out.print(" ");

            }
            recorrerMatrizRetrocediendoInicio(m,i,j);
        }
    }
}
````

-------

## _Por Columnas:_

### -Recorrer la matriz por columnas:

### _Ejemplo:_

    [ 1 4 7 // 2 5 8 // 3 6 9 ]

### _MainApp_

````java

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

       System.out.println("");
       System.out.println("Recorrerla por Columnas: ");
       recorrerMatrizAnormal(m,0,0);
    }

    public static void recorrerMatrizAnormal(int [][]m, int i, int j){

        System.out.print(m[i][j]);

        if (i!=m.length-1 || j!=m[i].length-1){

            if (i == m.length-1){
                i=0;
                System.out.println(" ");
                recorrerMatrizAnormal(m,i,j+1);
            }else{
                i++;
                System.out.print(" ");
                recorrerMatrizAnormal(m,i,j);
            }
        }
    }
}
````

### -Recorrer la matriz por columnas empezando desde el final:

### _Ejemplo:_

    [ 7 4 1 // 8 5 2 // 9 6 3 ]

### _MainApp_

````java

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Columnas empezando al final: ");
        recorrerMatrizAnormalUltimo(m,m.length-1,0);
    }

  public static void recorrerMatrizAnormalUltimo (int [][]m,int i, int j){

        System.out.print(m[i][j]);

        if( i != 0 || j != m[0].length-1){

            if(i == 0){
                i= m.length-1;
                j++;
                System.out.println(" ");

            }else{
                i--;
                System.out.print(" ");

            }
            recorrerMatrizAnormalUltimo(m,i,j);
        }
    }
}
````

### - Recorrer la matriz por columnas inversamente la matriz:

### _Ejemplo:_

    [ 9 6 3 // 8 5 2 // 7 4 1 ]

### _MainApp_

````java

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Columnas inversa: ");
        recorrerMatrizAnormalRetrocediendoFinal(m,m.length-1,m[0].length-1);
    }
    
     public static void recorrerMatrizAnormalRetrocediendoFinal (int [][]m,int i, int j){
        System.out.print(m[i][j]);

        if ( i != 0 || j !=0){

            if (i==0) {
                i = m.length - 1;
                j--;
                System.out.println(" ");
            }else{
                i--;
                System.out.print(" ");
            }
            recorrerMatrizAnormalRetrocediendoFinal(m,i,j);
        }
    }
}
````

### -Recorrer la matriz por columnas inversamente empezando desde el inicio la matriz:

### _Ejemplo:_

    [ 3 6 9 // 2 5 8 // 1 4 7]

### _MainApp_

````java

public class App08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 8-- ");

        int[][] m = {


                //Columnas

                {1, 2, 3},
                {4, 5, 6},       //Filas
                {7, 8, 9}
        };

        System.out.println("");
        System.out.println("Recorrerla por Columnas inversa empezando al inicio: ");
        recorrerMatrizAnormalRetrocediendoInicio(m,0,m[0].length-1);
    }

    public static void recorrerMatrizAnormalRetrocediendoInicio (int [][]m,int i, int j){
        System.out.print(m[i][j]);

        if (i != m.length-1 || j != 0){

            if(i==m.length-1){
                i=0;
                j--;
                System.out.println(" ");
                recorrerMatrizAnormalRetrocediendoInicio(m,i,j);
            }else {
                i++;
                System.out.print(" ");
                recorrerMatrizAnormalRetrocediendoInicio(m,i,j);
            }
        }
    }
}
````

