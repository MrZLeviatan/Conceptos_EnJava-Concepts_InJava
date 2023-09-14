package MrZLeviatan;

import java.util.ArrayList;

public class App12_2 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println(" --EJERCICIO 12/2.0-- ");


        ArrayList listaPrimos = new ArrayList();
        ArrayList listaPerfectos = new ArrayList();
        Persona m [][] = {

                {new Persona(5,"nicolas"),new Persona(7,"camilo"),new Persona(1,"juan")},
                {new Persona(6, "juana"),new Persona(45,"scoot"),new Persona(13,"veggeta"),new Persona(89,"goku")},
                {new Persona(2,"alistar"),new Persona(28,"Ahri"),new Persona(496,"Azir"),new Persona(8128,"aurelio")},
                {new Persona(11,"annie"),new Persona(4,"heimer"),new Persona(8,"jesus"),new Persona(89,"marco")},
                {new Persona(31,"star"),new Persona(37,"ibai"),new Persona(43,"alejo"),new Persona(10,"tesla")}
        };

        System.out.println("""
                        
                                                         Recorrer lA Matriz de forma retrocediendo en filas y avanzando en columnas:
                        """);
        recorrerMatrizRetrocediendoInicio(m,m.length-1,0,listaPrimos,listaPerfectos);
        System.out.println("\n \nARRAYLIST DE EDAD PRIM0: " + listaPrimos);
        System.out.println("ARRAYLIST DE EDAD PERFECTA: " + listaPerfectos);

    }

    public static void recorrerMatrizRetrocediendoInicio ( Persona [][]m,int i, int j, ArrayList listaPrimos, ArrayList listaPerfectos){

        System.out.print(m[i][j]);
        Persona actual = m[i][j];
        int edad = actual.getEdad();

        if (i!= 0 || j != m[i].length-1){

            if (j == m[i].length-1){

                if (esPrimo(edad,edad-1) == true)
                    listaPrimos.add(actual);

                if (sumarDivisores(edad,1) == edad)
                    listaPerfectos.add(actual);

                i--;
                j = 0;
                System.out.println(" ");

            }else{
                if (esPrimo(edad,edad-1) == true)
                    listaPrimos.add(actual);

                if (sumarDivisores(edad,1) == edad)
                    listaPerfectos.add(actual);
                j++;
                System.out.print(" ");

            }
            recorrerMatrizRetrocediendoInicio(m,i,j,listaPrimos,listaPerfectos);
        }
    }

    public static boolean esPrimo ( int numero, int c) {

        if (numero == 1 || c == 1) {
            return true;

        } else {
            if (numero % c == 0) {
                return false;
            } else {
                return esPrimo(numero, c - 1);
            }
        }
    }

    public static int sumarDivisores (int numero, int c){

        int res;
        if (c > (numero/2)){
            res = 0;
        }else{
            int aux = 0;
            if (numero% c == 0){
                aux = c;
            }
            res = aux+sumarDivisores(numero,c+1);
        }
        return res;
    }
}