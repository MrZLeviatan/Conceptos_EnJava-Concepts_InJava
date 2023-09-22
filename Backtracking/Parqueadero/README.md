# _Parqueadero_

Implementar un algoritmo usando backtracking que permita solucionar el siguiente problema
En un parqueadero usted tiene dos lugares disponibles(R1 y R2). En cada lugar usted quiere parquear un carro, es decir tiene 2 carros para parquear. Una vez realice el parqueo de un carro se dispone a parquear el siguiente carro. Un parqueadero se puede representar en forma de matriz parqueadero[i][j], tener en cuenta:
- R significar que es un espacio reservado

- <img align='legt' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/ImagenDis.png?raw=true" width="40"> L significa que es un espacio libre para discapacitados. parqueadero[i][j]= “discapacitado”

- <img align='legt' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/imagenCar.png?raw=true" width="40"> C significa que es un espacio ocupado por un carro. parqueadero[i][j]= “carro”
- parqueadero[i][j]= " ", significa que es un pasillo
- Se tienen 2 carros a parquear
- Solo se puede estacionar en algunos de los 2 puntos reservados R1 o R2
- Cada carro va en un espacio R1 o R2
- Dejar una marca “+” en la posición[i][j] por donde va pasando el carro (solo por pasillos).

<img align='center' src="https://github.com/MrZLeviatan/Conceptos_EnJava/blob/main/Backtracking/Parqueadero/src/main/resources/images/ImagenParq.png?raw=true" >


## _Problematica:_
Desarrolle una aplicación que permita parquear los 2 carros en los respectivos espacios reservados
Una vez realice el parqueo de un carro en R1 o R2 colocar en dicha posición el carro //


Tener en cuenta que si R1 y R2 tiene algún carro suyo parqueado ya no será un punto disponible.
Al seguir con el siguiente carro limpiar la ruta previa que realizó para parquear el carro
El inicio del parqueo de los carros inicia donde dice Entrada
Tener presente que no se puede salir del parqueadero

------

## _Tool_

- Java 17
- Maven
- IDE Intellij

# _Classes_

## _Class AppParqueadero_
```java

public class AppParqueadero {

    public static String[][] parqueadero = {

            {"L", " ", "L", "C", "R1", "L", " "},
            {"L", " ", "L", "C", " ", "L", " "},
            {" ", " ", " ", "C", " ", " ", " "},
            {"C", " ", " ", "C", "I", "I", " "},      
            {"C", " ", " ", " ", " ", "L", " "},      
            {"C", " ", "C", " ", " ", "L", " "},      
            {"C", " ", "C", " ", "C", "C", " "},      
            {" ", " ", "C", " ", " ", " ", " "},      
            {"C", " ", "C", " ", "C", " ", "C"},
            {"C", " ", "R", " ", "C", " ", "R"},
            {" ", " ", "R", " ", "C", "C", "R"},
            {" ", " ", "R", " ", " ", " ", "R2"},
            
    };

    public static void main(String[] args) {
        System.out.println("""
                       
                        -- PARQUEADERO LA CHINGADA  --    
                """);
        AppParqueadero m = new AppParqueadero();
        m.resuelve(11, 0);
        imprimir(0, 0);
        System.out.println("FIN DEL PROGRAMA");
    }

    public void resuelve(int x, int y) {
        movimiento(x, y);
        parqueadero[x][y] = "S";

    }

    private boolean esPasoValido(int x, int y) {

        if (x >= 0 && x <= parqueadero.length - 1 && y >= 0 && y <= parqueadero[x].length - 1) { //PARA QUE NO SE DESBORDE DE LA MATRIZ
            return true;
        } else {
            return false;
        }
    }

    public boolean movimiento(int x, int y) {
        if (!esPasoValido(x, y)) {   
            return false;
        }

        if (parqueadero[x][y].equals("R1")) {
            parqueadero[x][y] = "//";
            imprimir(0, 0);
            System.out.println(" --- SE PARQUEO EL PRIMER CARRO ---");
            System.out.println("");
            return true;
        }

        if (parqueadero[x][y].equals("R2")) {
            parqueadero[x][y] = "//";
            imprimir(0, 0);
            System.out.println(" --- SE PARQUEO EL SEGUNDO CARRO ---");
            System.out.println("");
            return true;
        }

        if (parqueadero[x][y].equals("L") || parqueadero[x][y].equals("C") || parqueadero[x][y].equals("R")
                || parqueadero[x][y].equals("I")) {
            return false;
        }
        if (parqueadero[x][y].equals("/") || parqueadero[x][y].equals("+")) {
            return false;
        }

        parqueadero[x][y] = "+";   

        boolean result;

        result = movimiento(x, y + 1); 
        result = movimiento(x + 1, y); 
        result = movimiento(x - 1, y);
        result = movimiento(x, y - 1); 

        parqueadero[x][y] = " ";  
        return false;

    }

    public static void imprimir(int i, int j) {  

        if (parqueadero.length - 1 == ) {
            if (parqueadero[0].length - 1 == j) {
                System.out.println(parqueadero[i][j] + "\n");
            } else {
                System.out.print(parqueadero[i][j] + " ");
                imprimir(i, j + 1);
            }
        } else {
            if (parqueadero[0].length - 1 == j) {
                System.out.println(parqueadero[i][j] + " ");
                imprimir(i + 1, 0);
            } else {
                System.out.print(parqueadero[i][j] + " ");
                imprimir(i, j + 1);
            }
        }

    }
}
```
