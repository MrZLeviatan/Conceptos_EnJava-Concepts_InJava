package mrzleviatan.ejercicio_01.controller;

import mrzleviatan.ejercicio_01.controller.service.IModelFactoryService;
import mrzleviatan.ejercicio_01.exceptions.EstudianteException;
import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import mrzleviatan.ejercicio_01.mapping.mappers.UniversidadMapper;
import mrzleviatan.ejercicio_01.model.Estudiante;
import mrzleviatan.ejercicio_01.model.Universidad;
import mrzleviatan.ejercicio_01.utils.Persistencia;

import java.io.IOException;
import java.util.List;


/**
 * SE CREA EL MODEL FACTORY CONTROLLER IMPLEMENTANDO EL IMODEL, EN SI ES LA MADRE DE TODO ESTO.
 */
public class ModelFactoryController implements IModelFactoryService {


    /**
     * SE CREA UNA UNIVERSIDAD DEL OBJETO E IGUALMENTE SE CREA UN MAPPER.
     */
    Universidad universidad;
    UniversidadMapper mapper = UniversidadMapper.INSTANCE;


    /**
     * SE CREA EL GET DE LA UNIVERSIDAD.
     */
    public Universidad getUniversidad () { return universidad; }


    /**
     * SE CREA LA CLASE SINGLE QUE SERVIRA COMO UNA INTANCE.
     */
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }


    /**
     * SE CREA EL GET DE LA INTANCE DEL SINGLE.
     */

    public static ModelFactoryController getInstance(){

        return SingletonHolder.eINSTANCE;
    }


    /**
     * SE CREA EL CONSTRUCTOR DONDE SE GUARDARA, CREARA Y SE VERIFICARA LOS DATOS.
     * @serialData DE IGUAL FORMA SE HACE EL REGISTRO DE ACCIONES.
     */
    public ModelFactoryController(){

        System.out.println("Singleton, !!Manifiestate!! ");


    //   -- CARGAR LOS DATOS DE LOS ARCHIVOS --

            cargarDatosDesdeArchivos();

    //   -- SALVA LOS DATOS EN UN TXT

            salvarDatos();

    //   -- GUARDAR Y CARGAR EL RECURSO SERIALIZABLE BINARIO --

            //cargarResourceBinario();
            guardarResourseBinario();

    //   -- GUARDAR Y CARGAR EL RECURSO SERIALIZABLE XML --

            //cargarResourceXML();
            guardarResourseXML();

    //   -- GUARDAR Y CARGAR EL RESPALDO DEL XML --

            //cargarRespaldoXML();
            guardarRespaldoXML();

    //   -- SIEMPRE SE DEBE VERIFICAR SI LA RAIZ DEL RECURSO ES NULL --

        if (universidad == null){
            cargarRespaldoXML();
            guardarRespaldoXML();
        }

        registrarAccionesSistema("Inicio De Sesion",1,"Ah Iniciado Sesion");
    }


    private void cargarDatosPrueba (){

        universidad = new Universidad();

        try {
            Persistencia.cargarDatosArchivos(universidad);
        }catch (IOException e){

            throw new RuntimeException(e);
        }

    }


    /**
     * SE SALVAN LOS DATOS EN LOS DIFERENTES ARCHIVOS. ESTE ES DIOS ENSERIO.
     */
    private void salvarDatos(){

        try {

            Persistencia.guardarEstudiante(universidad.getEstudiantesList());
         //   guardarResourseXML();
            // guardarResourseBinario();


        }catch (IOException e){

            throw new RuntimeException(e);
        }

    }



    /**
     * SE CREA LA CLASE DE REGISTRAR ACCIONES DEL SISTEMA PUES PARA REGISTRAR.
     */
    public void registrarAccionesSistema (String mensaje, int nivel, String accion) {

        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }


    /**
     * SE CREA LA CLASE PARA CARGAR LOS DATOS DE LOS ARCHIVOS LLAMADA DESDE utils.
     */
    private void cargarDatosDesdeArchivos(){

        universidad = new Universidad();

        try {
            Persistencia.cargarDatosArchivos(universidad);

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    /**
     * SE CREA TODOS LOS METODOS PARA CARGAR CADA SERIALIZACION DE LA PERSISTENCIA.
     */
    private void cargarResourseBinario() { universidad = Persistencia.cargarRecursosUniversidadBinario(); }
    private void cargarResourseXML () { universidad = Persistencia.cargarRecursosUniversidadXML(); }
    private void cargarRespaldoXML (){ universidad = Persistencia.cargarRespaldoXML(); }



    /**
     * SE CREA TODOS LOS METODOS PARA GUARDAR CADA SERIALIZACION DE LA PERSISTENCIA.
     */
    private void guardarResourseBinario() { Persistencia.guardarRecursosUniversidadBinario(universidad);}
    private void guardarResourseXML (){ Persistencia.guardarRecursosUniversidadXML(universidad);}
    private void guardarRespaldoXML () { Persistencia.copiaSeguridadXML(universidad);}


    /**
     * SE CREA EL METODO PARA OBTENER AL ESTUDIANTE DE LA LISTA
     */
    @Override
    public List<EstudianteDto> obtenerEstudiante() {

        return mapper.getEstudianteDto(universidad.getEstudiantesList());
    }


    /**
     * SE CREA LA CLASE PARA AGREGAR A LOS ESTUDIANTES A LA UNIVERSIDAD.
     */
    @Override
    public boolean agregarEstudiante(EstudianteDto estudianteDto) {

        try {
            if(!universidad.VerificarEstudianteExistente(estudianteDto.codigo())){
                Estudiante estudiante= mapper.estudianteDtoToEstudiante(estudianteDto);
                getUniversidad().agregarEstudiante(estudiante);
                salvarDatos();
            }
            return true;

        }catch (EstudianteException e){
            e.getMessage();
            return false;
        }

    }


    /**
     * SE CREA EL METODO PARA ELIMINAR AL ESTUDIANTE DE LA UNIVERSIDAD.
     */
    @Override
    public boolean eliminarEstudiante(String codigo) {
        boolean flagExiste = false;

        try {
            flagExiste = getUniversidad().eliminarEstudiante(codigo);
            salvarDatos();

        }catch (EstudianteException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }


    /**
     * SE CREA EL METODO PARA ACTUALIZAR AL ESTUDIANTE DE LA UNIVERSIDAD.
     */
    @Override
    public boolean actualizarEstudiante(String codigoActual, EstudianteDto estudianteDto) {
        try {

            Estudiante estudiante = mapper.estudianteDtoToEstudiante(estudianteDto);
            getUniversidad().actualizarEstudiante(codigoActual,estudiante);
            salvarDatos();
            return true;
        }catch (EstudianteException e){
            e.printStackTrace();
            return false;
        }
    }
}
