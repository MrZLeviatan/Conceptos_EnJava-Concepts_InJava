package mrzleviatan.ejercicio_03.Model;

import java.time.LocalDate;

/**
 * SE CREA LA CLASE ClienteNatural LA CUAL HEREDA DE PERSONA SUS ATRIBUTOS.
 */

public class ClienteNatural extends Persona{


    /**
     * SE CREAN LOS ATRIBUTOS DE ESTA CLASE.
     */

    private String email;
    private LocalDate fechaNacimiento;


    /**
     * SE CREAN LOS CONSTRUCTORES TANTO VACIO COMO CON LOS ATRIBUTOS DE LA CLASE.
     */

    public ClienteNatural (){ }


    public ClienteNatural(String nombre, String apellido, String direccion, String telefono, int id, String email, LocalDate fechaNacimiento) {
        super(nombre, apellido, direccion, telefono, id);
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }


    /**
     * SE CREAN LOS GET Y SET DE LOS ATRIBUTOS.
     */
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}
