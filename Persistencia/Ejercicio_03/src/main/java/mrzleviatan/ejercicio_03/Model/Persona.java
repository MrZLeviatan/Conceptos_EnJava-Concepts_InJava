package mrzleviatan.ejercicio_03.Model;


/**
 * SE CREA LA CLASE PERSONA
 * @serial SUS ATRIBUTOS POSTERIORMENTE SERAN HEREDADOS EN OTRAS CLASES.
 */
public class Persona {


    /**
     * SE CREAN LOS ATRIBUTOS DE LA CLASE.
     */


    private String nombre,apellido,direccion,telefono;
    private int id;


    /**
     * SE IMPLEMENTAN LOS DOS CONTRUCTORES DE LA CLASE, UNO VACIO Y UNO COS LOS ATRIBUTOS ANTES MENCIONADOS.
     */
    public Persona(){ }


    public Persona(String nombre, String apellido, String direccion, String telefono, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id = id;
    }




    /**
     * SE CREAN LOS GET Y SET DE LOS ATRIBUTOS DE LA CLASE.
     */

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}
