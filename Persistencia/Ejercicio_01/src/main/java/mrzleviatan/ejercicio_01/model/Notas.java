package mrzleviatan.ejercicio_01.model;

/**
 * SE CREA LA CLASE NOTAS PARA LLEVARLAS AL ESTUDIANTE
 */

public class Notas {

    /**
     * SE CREAN 3 VARIABLES INTEGER DE NOTAS,
     */

    private Integer Nota1,Nota2,Nota3;


    /**
     * SE CREA EL CONSTRUCTOR VACIO
     */
    public Notas() {

    }


    /**
     * SE CREA LOS GET Y SET DE LAS NOTAS
     */

    public Integer getNota1() { return Nota1; }

    public void setNota1(Integer nota1) { Nota1 = nota1; }

    public Integer getNota2() { return Nota2; }

    public void setNota2(Integer nota2) { Nota2 = nota2; }

    public Integer getNota3() { return Nota3; }

    public void setNota3(Integer nota3) { Nota3 = nota3; }
}
