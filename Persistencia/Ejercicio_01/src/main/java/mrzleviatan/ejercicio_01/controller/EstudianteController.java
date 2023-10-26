package mrzleviatan.ejercicio_01.controller;

import mrzleviatan.ejercicio_01.controller.ModelFactoryController;
import mrzleviatan.ejercicio_01.controller.service.IEstudianteControllerService;
import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import java.util.List;

/**
 * SE CREA EL CONTROLADOR DEL ESTUDIANTE IMPLEMENTANDO EL IESTUDIANTE.
 */
public class EstudianteController implements IEstudianteControllerService {

    /**
     * SE CREA UN OBJETO DE LA CLASE MODELFACTORY.
     */
    ModelFactoryController modelFactoryController;


    /**
     * SE CREA EL CONSTRUCTOR DEL ESTUDIANTECONTROLLER.
     */
    public EstudianteController(){

        modelFactoryController = ModelFactoryController.getInstance();
    }


    /**
     * SE CREA EL METODO PARA OBTENER AL ESTUDIANTE.
     */
    @Override
    public List<EstudianteDto> obtenerEstudiante() {
        return modelFactoryController.obtenerEstudiante();
    }


    /**
     * SE CREA EL METODO PARA AGREGAR AL ESTUDIANTE.
     */
    @Override
    public boolean agregarEstudiante(EstudianteDto estudianteDto) {
        return modelFactoryController.agregarEstudiante(estudianteDto);
    }

    /**
     * SE CREA EL METODO PARA ELIMINAR AL ESTUDIANTE.
     */
    @Override
    public boolean eliminarEstudiante(String codigo) {
        return modelFactoryController.eliminarEstudiante(codigo);
    }


    /**
     * SE CREA EL METODO PARA ACTUALIZAR AL ESTUDIANTE.
     */
    @Override
    public boolean actualizarEstudiante(String codigoActual, EstudianteDto estudianteDto) {
        return modelFactoryController.actualizarEstudiante(codigoActual,estudianteDto);
    }


    /**
     * SE CREA EL METODO PARA REGISTRAR LAS ACCIONES DEL ESTUDIANTE.
     */
    @Override
    public void registrarAcciones(String mensaje, int nivel, String accion) {
        modelFactoryController.registrarAccionesSistema(mensaje,nivel,accion);
    }
}
