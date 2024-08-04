package mrzleviatan.ejercicio_04.Model;

import mrzleviatan.ejercicio_04.Model.Enum.Genero;
import mrzleviatan.ejercicio_04.Model.Enum.TipoProgramas;

import java.io.Serializable;
import java.util.ArrayList;


public class Docente extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private TipoProgramas tipoProgramas;
    private String profesion;
    private Materia materiaAsignada;
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();


    public Docente(String nombre, String apellido, String correoElectornico, String telefono, int edad, int codigo, Genero genero, TipoProgramas tipoProgramas, String profesion, Materia materiaAsignada) {
        super(nombre, apellido, correoElectornico, telefono, edad, codigo, genero);
        this.tipoProgramas = tipoProgramas;
        this.profesion = profesion;
        this.materiaAsignada = materiaAsignada;
    }

    public Docente() {
    }


    public TipoProgramas getTipoProgramas() {
        return tipoProgramas;
    }

    public void setTipoProgramas(TipoProgramas tipoProgramas) {
        this.tipoProgramas = tipoProgramas;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }


}
