package mrzleviatan.ejercicio_04.Model;

import mrzleviatan.ejercicio_04.Model.Service.IUniversidadService;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable, IUniversidadService {

    private static final long serialVersionUID = 1L;


    private ArrayList<Docente> listaDocentes = new ArrayList<>();
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
    private ArrayList<Materia> listaMaterias = new ArrayList<>();



    public void addDocente (Docente docente){
        listaDocentes.add(docente);
    }

    public void removeDocente (Docente docente){
        listaDocentes.remove(docente);
    }

    public Docente buscarDocente(int codigo){
        for (Docente docente: listaDocentes){
            if (docente.getCodigo()==codigo){
                return docente;
            }
        }
        return null;
    }


    public void actualizarDocente(Docente docenteActualizado, int codigo){
        for (int i = 0; i < listaDocentes.size(); i++) {
            if (listaDocentes.get(i).getCodigo() == codigo) {
                listaDocentes.set(i, docenteActualizado);
                break;
            }
        }
    }

}
