package MrZLeviatan;

import java.util.ArrayList;

public class App10_2 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 10/2.0-- ");

        ArrayList listaPalabras = new ArrayList();

        String[][] m = {

                {"vacio", "carro", "bAul", "perro"},
                {"colombia", "casa", "moto", "caza"},
                {"llanta", "reir", "archivo", "silla","abuela"},
                {"cocina", "ola", "aver", "freir"}
        };

        System.out.println("");
        recorrerMatriz(m, 0, 0, listaPalabras);
        System.out.println("\n \nARRAYLIST DE PALABRAS CON VOCALES SEGUIDAS: " + listaPalabras);
        System.out.println("""
                              
                              } MATRIZ TRANSPUESTA {                 
                """);
        listaPalabras.clear();
        recorrerMatrizTranspuesta(m,0,0,listaPalabras);
        System.out.println("\n \nARRAYLIST DE PALABRAS CON VOCALES SEGUIDAS TRANSPUESTA: " + listaPalabras);


    }

    public static boolean verificar(int i, String palabra) {

        boolean ver = false;
        if (i == palabra.length() - 1) {
            return ver;
        }
        if (esVocal(palabra.charAt(i))) {
            if (esVocal(palabra.charAt(i + 1))) {
                ver = true;
                return ver;
            } else {
                return verificar(i + 1, palabra);
            }
        }
        return verificar(i + 1, palabra);
    }

    public static boolean esVocal(char palabra) {
        return palabra == 'a' || palabra == 'e' || palabra == 'i' || palabra == 'o' || palabra == 'u'
                || palabra == 'A' || palabra == 'E' || palabra == 'I' || palabra == 'O' || palabra == 'U';
    }


    public static void recorrerMatriz(String[][] m, int i, int j, ArrayList listaPalabras) {

        String palabra = m[i][j];
        System.out.print(m[i][j]);

        if (i != m.length - 1 || j != m[i].length - 1) {

            if (j == m[i].length - 1) {

                if (verificar(0,palabra) == true)
                    listaPalabras.add(palabra);
                i++;
                j = 0;
                System.out.println(" || ");
            } else {

                if (verificar(0,palabra) == true)
                    listaPalabras.add(palabra);
                j++;
                System.out.print(" || ");
            }
            recorrerMatriz(m, i, j,listaPalabras);
        }
    }

    public static void recorrerMatrizTranspuesta(String[][] m, int i, int j, ArrayList listaPalabras) {

        String nombre = m[i][j];
        System.out.print(m[i][j]);

        if (i != m.length - 1 || j != m[i].length - 1) {

            if (i == m.length - 1) {

                if (verificar(0,nombre) == true)
                    listaPalabras.add(nombre);
                System.out.print("\n");
                recorrerMatrizTranspuesta(m, 0, j + 1, listaPalabras);

            } else {
                if (verificar(0,nombre) == true)
                    listaPalabras.add(nombre);
                i++;
                System.out.print(" || ");
                recorrerMatrizTranspuesta(m, i, j,listaPalabras);
            }
        }
    }
}

