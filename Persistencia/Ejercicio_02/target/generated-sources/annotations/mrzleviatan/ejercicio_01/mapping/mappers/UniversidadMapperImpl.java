package mrzleviatan.ejercicio_01.mapping.mappers;

import java.util.ArrayList;
import java.util.List;
import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import mrzleviatan.ejercicio_01.model.Estudiante;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-22T18:09:09-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
*/
public class UniversidadMapperImpl implements UniversidadMapper {

    @Override
    public EstudianteDto estudianteToEstudianteDto(Estudiante estudiante) {
        if ( estudiante == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String codigo = null;
        Integer nota1 = null;
        Integer nota2 = null;
        Integer nota3 = null;
        String modalidad = null;

        nombre = estudiante.getNombre();
        apellido = estudiante.getApellido();
        codigo = estudiante.getCodigo();
        nota1 = estudiante.getNota1();
        nota2 = estudiante.getNota2();
        nota3 = estudiante.getNota3();
        modalidad = estudiante.getModalidad();

        EstudianteDto estudianteDto = new EstudianteDto( nombre, apellido, codigo, nota1, nota2, nota3, modalidad );

        return estudianteDto;
    }

    @Override
    public Estudiante estudianteDtoToEstudiante(EstudianteDto estudianteDto) {
        if ( estudianteDto == null ) {
            return null;
        }

        Estudiante estudiante = new Estudiante();

        estudiante.setNombre( estudianteDto.nombre() );
        estudiante.setApellido( estudianteDto.apellido() );
        estudiante.setCodigo( estudianteDto.codigo() );
        estudiante.setNota1( estudianteDto.nota1() );
        estudiante.setNota2( estudianteDto.nota2() );
        estudiante.setNota3( estudianteDto.nota3() );
        estudiante.setModalidad( estudianteDto.modalidad() );

        return estudiante;
    }

    @Override
    public List<EstudianteDto> getEstudianteDto(List<Estudiante> listEstudiante) {
        if ( listEstudiante == null ) {
            return null;
        }

        List<EstudianteDto> list = new ArrayList<EstudianteDto>( listEstudiante.size() );
        for ( Estudiante estudiante : listEstudiante ) {
            list.add( estudianteToEstudianteDto( estudiante ) );
        }

        return list;
    }
}
