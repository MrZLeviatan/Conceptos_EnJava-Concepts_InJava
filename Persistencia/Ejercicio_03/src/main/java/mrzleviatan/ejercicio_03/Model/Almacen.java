package mrzleviatan.ejercicio_03.Model;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Almacen {


    private ArrayList<Persona> listaClientes;
    private ArrayList<Producto> listaProductos;

    public Almacen() {

        listaClientes = new ArrayList<>();
        listaProductos = new ArrayList<>();

    }

    public ArrayList<Persona> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }


    public Persona buscarPersona(int identificacion) throws Exception {
        try {
            return listaClientes.stream().filter(cliente -> cliente.getId()==identificacion).findFirst().get();
        }catch (Exception e){
            Alert mensaje = new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error. Persona no encontrada");
            mensaje.show();
            throw new Exception(e);
        }
    }

    public Producto buscarProducto (int id) throws Exception {
        try {
            return listaProductos.stream().filter(producto -> producto.getCodigo()==id).findFirst().get();
        }catch (Exception e){
            Alert mensaje = new Alert(Alert.AlertType.WARNING);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Error. Producto no encontrada");
            mensaje.show();
            throw new Exception(e);
        }


    }


    public void eliminarCliente (Persona persona){
        listaClientes.remove(persona.getId());
    }

    public void eliminarProducto (Producto producto){
        listaProductos.remove(producto.getCodigo());
    }



    public void agregarCliente (Persona cliente){
        listaClientes.add(cliente);
    }

    public void agregarProducto (Producto producto){
        listaProductos.add(producto);
    }


}





