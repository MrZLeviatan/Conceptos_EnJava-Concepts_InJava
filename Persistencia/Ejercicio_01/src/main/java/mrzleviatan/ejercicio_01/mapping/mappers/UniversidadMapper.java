package mrzleviatan.ejercicio_01.mapping.mappers;


import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import mrzleviatan.ejercicio_01.model.Estudiante;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * SE CREA LA INTERFACE DE LA UNIVERSIDAD.
 * @serial SE IMPLEMENTA LA LIBRERÍA MAPPER EN EL "pom" Y EN EL MODULO.
 */
@Mapper
public interface UniversidadMapper {


    /**
     * SE CREA LA INTANCE DEL MAPPER.
     */
    UniversidadMapper INSTANCE = Mappers.getMapper(UniversidadMapper.class);


    /**
     * SE CREA EL METODO PARA PASAR DE DTO A OBJETO Y VICEVERSA.
     */
    @Named("estudianteToEstudianteDto")
    EstudianteDto estudianteToEstudianteDto(Estudiante estudiante);
    Estudiante estudianteDtoToEstudiante (EstudianteDto estudianteDto);
    @IterableMapping(qualifiedByName = "estudianteToEstudianteDto")
    List<EstudianteDto> getEstudianteDto(List<Estudiante> listEstudiante);




}
