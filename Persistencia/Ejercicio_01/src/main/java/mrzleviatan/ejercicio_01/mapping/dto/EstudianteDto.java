package mrzleviatan.ejercicio_01.mapping.dto;

/**
 * SE CREA EL DTO DEL OBJETO ESTUDIANTE.
 */
public record EstudianteDto(


        /**
         * SE PONEN TODAS LAS VARIABLES DEL OBJETO ESTUDIANTE DENTRO DE LA CLASE
                    ESTUDIANTE DTO.
         */
        String nombre,
        String apellido,
        String codigo,
        Integer nota1,
        Integer nota2,
        Integer nota3

) {  }
