package mrzleviatan.ejercicio_03.Model;

/**
 * SE CREA LA CLASE ClienteJuridico QUE HEREDA LOS ATRIBUTOS DE LA CLASE PERSONA.
 */

public class ClienteJuridico extends Persona{


    /**
     * SE CREAN LOS ATRIBUTOS DE LA CLASE
     */

    private String nit;


    /**
     * SE CREAN LOS CONSTRUCTORES DE LA CLASE TANTO VACIOS COMO CON LOS ATRIBUTOS.
     */

    public ClienteJuridico (){ }


    public ClienteJuridico(String nombre, String apellido, String direccion, String telefono, int id, String nit) {
        super(nombre, apellido, direccion, telefono, id);
        this.nit = nit;
    }


    /**
     * SE CREAN LOS GET Y SET DE LOS ATRIBUTOS.
     * @return
     */

    public String getNit() { return nit; }

    public void setNit(String nit) { this.nit = nit; }
}
