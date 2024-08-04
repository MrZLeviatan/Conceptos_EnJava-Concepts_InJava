package mrzleviatan.ejercicio_04.Model;

import mrzleviatan.ejercicio_04.Model.Enum.Genero;

import java.io.Serializable;

public abstract class  Persona implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * Caracteristicas generales de la Persona (padre).
     */
    private String nombre,apellido,correoElectornico,telefono;

    private int edad,codigo;

    private Genero genero;

    /**
     * Constructor de la clase.
     * @param nombre
     * @param apellido
     * @param correoElectornico
     * @param telefono
     * @param edad
     * @param codigo
     * @param genero
     */
    public Persona(String nombre, String apellido, String correoElectornico, String telefono, int edad, int codigo, Genero genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectornico = correoElectornico;
        this.telefono = telefono;
        this.edad = edad;
        this.codigo = codigo;
        this.genero = genero;
    }

    /**
     * Constructor vacio para el mapper.
     */
    public Persona(){}


    /**
     * Getter y setter
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectornico() {
        return correoElectornico;
    }

    public void setCorreoElectornico(String correoElectornico) {
        this.correoElectornico = correoElectornico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}


