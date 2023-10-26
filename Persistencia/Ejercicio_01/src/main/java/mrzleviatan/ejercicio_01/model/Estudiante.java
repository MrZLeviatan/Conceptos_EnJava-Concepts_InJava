package mrzleviatan.ejercicio_01.model;

import java.io.Serializable;


/**
 * SE CREA EL OBJETO ESTUDIANTE IMPLEMENTANDO LA SERIALIZABLE.
 */
public class Estudiante implements Serializable {


    /**
     * SE CREAN LOS VALORES DEL OBJETO ESTUDIANTE
     * @param serialVersionUID sirve para la persistencia.
     */

    private static final long serialVersionUID = 1L;

    private String nombre;

    private String apellido;

    private String codigo;

    private Integer nota1,nota2,nota3;


    /**
     * SE CREA EL CONSTRUCTOR DEL OBJETO VACIO.
     */
    public Estudiante (){  }


    /**
     * SE CREA LOS GET Y SET DE LAS VARIABLES DEL OBJETOS
     *
     */

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }



    /**
     * SE CREAN LOS GET Y SET DE CADA NOTA DEL ESTUDIANTE
     */

    public Integer getNota1() { return nota1; }

    public void setNota1(Integer nota1) { this.nota1 = nota1; }

    public Integer getNota2() { return nota2; }

    public void setNota2(Integer nota2) { this.nota2 = nota2; }

    public Integer getNota3() { return nota3; }

    public void setNota3(Integer nota3) { this.nota3 = nota3; }
}
