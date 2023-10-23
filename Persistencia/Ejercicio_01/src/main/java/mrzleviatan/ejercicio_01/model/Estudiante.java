package mrzleviatan.ejercicio_01.model;

import java.util.ArrayList;
import java.util.List;


/**
 *  SE CREA LA CLASE ESTUDIANTE QUE SERA NUESTRO SUJETO EN EL PROYECTO
 */
public class Estudiante {

    /**
     * SE CREA LOS VALORES REPRESENTATIVOS DEL ESTUDIANTE.
     * @serialField se crean las notasList para asignar minimo 3 notas.
     */
    private String codigo;
    private String nombre;
    private String apellido;

    private List<Notas> notasList = new ArrayList<>();


    /**
     * SE CREA EL CONSTRUCTOS DE ESTUDIANTE VACIO.
     */
    public Estudiante(){

    }

    /**
     * SE CREA LOS GET Y SET DE LAS VARIABLES
     */

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public List<Notas> getNotasList() { return notasList; }

    public void setNotasList(List<Notas> notasList) { this.notasList = notasList; }


    public void addNotas(Notas notas){

        if(notasList.size()<= 3){

            notasList.add(notas);
        }

    }

}
