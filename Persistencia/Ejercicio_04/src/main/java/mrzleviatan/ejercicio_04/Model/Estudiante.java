package mrzleviatan.ejercicio_04.Model;

import mrzleviatan.ejercicio_04.Model.Enum.Genero;

import java.io.Serializable;

// Serializable para la Persistencia.
public class Estudiante extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    public Estudiante(String nombre, String apellido, String correoElectornico, String telefono, int edad, int codigo, Genero genero) {
        super(nombre, apellido, correoElectornico, telefono, edad, codigo, genero);
    }

    public Estudiante() {
    }
}
