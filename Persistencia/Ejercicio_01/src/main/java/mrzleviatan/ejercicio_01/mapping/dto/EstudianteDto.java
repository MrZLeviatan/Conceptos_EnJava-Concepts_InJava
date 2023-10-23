package mrzleviatan.ejercicio_01.mapping.dto;

import java.util.List;

public record EstudianteDto(

        String codigo,
        String nombre,
        String apellido,
        List<NotasDto>notasDtos

) {
}
