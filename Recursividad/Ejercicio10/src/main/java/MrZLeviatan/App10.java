package MrZLeviatan;

import java.util.ArrayList;

public class App10 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 10-- ");

        ArrayList listaPalabras = new ArrayList();

        String[][] m = {

                {"vacio", "carro", "bAul", "perro"},
                {"colombia", "casa", "moto", "caza", "aereolina"},
                {"llanta", "reir", "archivo","silla","abuela"},
                {"cocina", "ola", "aver", "freir"}
        };

        System.out.println("");
        recorrerMatriz(m, 0, 0, listaPalabras);

        System.out.println("""
                
                """);
        System.out.println("ARRAYLIST DE PALABRAS CON VOCALES SEGUIDAS: " + listaPalabras);

    }

    public static boolean verificar(int i, String palabra) {

        boolean ver = false;
        if (i == palabra.length()-1) {
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
        return verificar(i+1,palabra);
    }

    public static boolean esVocal (char palabra){
        return palabra == 'a' || palabra =='e'|| palabra == 'i'|| palabra == 'o'|| palabra == 'u'
                || palabra == 'A' || palabra == 'E' || palabra == 'I' || palabra == 'O' || palabra == 'U';
    }


    public static void recorrerMatriz(String[][] matriz, int i, int j, ArrayList listaPalabras) {

        String palabra = matriz[i][j];

        if(matriz.length-1!=i) {
            if (matriz[i].length - 1 == j) {

                if (verificar(0,palabra) == true)
                    listaPalabras.add(palabra);
                System.out.print(matriz[i][j]);
                System.out.print("\n");
                recorrerMatriz(matriz, i + 1, 0, listaPalabras);

            } else {

                if (verificar(0, palabra) == true)
                    listaPalabras.add(palabra);
                System.out.print(matriz[i][j]);
                System.out.print(" || ");
                recorrerMatriz(matriz, i, j + 1, listaPalabras);
            }

        } else {

            if(matriz[i].length-1==j){
                if (verificar(0, palabra) == true)
                    listaPalabras.add(palabra);
                System.out.print(matriz[i][j]);

            } else {

                System.out.print(matriz[i][j]);
                System.out.print(" || ");
                recorrerMatriz(matriz,i,j+1,listaPalabras);
            }

        }
    }

}

