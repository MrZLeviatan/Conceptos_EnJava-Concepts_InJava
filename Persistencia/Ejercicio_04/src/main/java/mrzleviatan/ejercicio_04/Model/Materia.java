package mrzleviatan.ejercicio_04.Model;

import mrzleviatan.ejercicio_04.Model.Enum.TipoMateria;

import java.io.Serializable;

public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    private int codigo, intencidadHoraria;
    private String nombre;
    private TipoMateria tipoMateria;


    public Materia(int codigo, int intencidadHoraria, String nombre, TipoMateria tipoMateria) {
        this.codigo = codigo;
        this.intencidadHoraria = intencidadHoraria;
        this.nombre = nombre;
        this.tipoMateria = tipoMateria;
    }

    public Materia(){}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIntencidadHoraria() {
        return intencidadHoraria;
    }

    public void setIntencidadHoraria(int intencidadHoraria) {
        this.intencidadHoraria = intencidadHoraria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoMateria getTipoMateria() {
        return tipoMateria;
    }

    public void setTipoMateria(TipoMateria tipoMateria) {
        this.tipoMateria = tipoMateria;
    }
}
