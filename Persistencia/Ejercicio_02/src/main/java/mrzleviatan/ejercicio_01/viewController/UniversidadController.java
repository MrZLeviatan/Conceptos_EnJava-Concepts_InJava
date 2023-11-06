package mrzleviatan.ejercicio_01.viewController;



import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import mrzleviatan.ejercicio_01.controller.EstudianteController;
import mrzleviatan.ejercicio_01.mapping.dto.EstudianteDto;
import mrzleviatan.ejercicio_01.utils.PropertiesUtils;
import mrzleviatan.ejercicio_01.utils.TextFormatterUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class UniversidadController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<EstudianteDto> tablaEstudiantes;

    @FXML
    private TableColumn<EstudianteDto, String> tcNombre;


    @FXML
    private TableColumn<EstudianteDto, String> tcApellido;

    @FXML
    private TableColumn<EstudianteDto, String> tcCodigo;

    @FXML
    private TableColumn<EstudianteDto, String> tcModalidad;

    @FXML
    private TableColumn<EstudianteDto, String> tcNota1;

    @FXML
    private TableColumn<EstudianteDto, String> tcNota2;

    @FXML
    private TableColumn<EstudianteDto, String> tNota3;


    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNota1;

    @FXML
    private TextField txtNota2;

    @FXML
    private TextField txtNota3;

    @FXML
    private ComboBox comboModalidad;


    EstudianteController estudianteController;
    ObservableList<EstudianteDto> listEstudianteDto = FXCollections.observableArrayList();
    EstudianteDto estudianteSeleccionado;

    @FXML
    void initialize() throws IOException {

        estudianteController = new EstudianteController();
        intiView();
        txtNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtCedula.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        txtNota1.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        txtNota2.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        txtNota3.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));


        comboModalidad.getItems().addAll(PropertiesUtils.gerProperty("Modalidad").split(","));

    }


    private void intiView() {

        initDataBinding();
        obtenerEstudiante();
        tablaEstudiantes.getItems().clear();
        tablaEstudiantes.setItems(listEstudianteDto);
        listenerSelection();
    }


    private void initDataBinding() {

        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
        tcNota1.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().nota1())));
        tcNota2.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().nota2())));
        tNota3.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().nota3())));
        tcModalidad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().modalidad())));
    }

    private void obtenerEstudiante() {
        listEstudianteDto.addAll(estudianteController.obtenerEstudiante());
    }


    private void listenerSelection() {

        tablaEstudiantes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {

            estudianteSeleccionado = newSelection;
            mostrarInformacionEstudiante(estudianteSeleccionado);


        });

    }


    private void mostrarInformacionEstudiante(EstudianteDto estudianteDto) {

        if (estudianteSeleccionado != null) {

            txtNombre.setText(estudianteSeleccionado.nombre());
            txtApellido.setText(estudianteSeleccionado.apellido());
            txtCedula.setText(estudianteSeleccionado.codigo());
            txtNota1.setText(String.valueOf(estudianteSeleccionado.nota1()));
            txtNota2.setText(String.valueOf(estudianteSeleccionado.nota2()));
            txtNota3.setText(String.valueOf(estudianteSeleccionado.nota3()));


        }


    }


    @FXML
    void actualizarEstudianteAction(ActionEvent event) {

            actualizarEstudiante();
    }

    @FXML
    void agregarEstudianteAction(ActionEvent event) {

        crearEstudiante();
    }

    @FXML
    void eliminarEstudianteAction(ActionEvent event) {

        eliminarEstudiante();
    }

    @FXML
    void nuevoEstudianteAction(ActionEvent event) {

        txtNombre.setText("Ingrese el nombre");
        txtApellido.setText("Ingrese el apellido");
        txtCedula.setText("Ingrese la cedula");
        txtNota1.setText("Ingrese la nota 1");
        txtNota2.setText("Ingrese la nota 2");
        txtNota3.setText("Ingrese la nota 3");


    }





    private EstudianteDto contruirEstudianteDto() {


        return new EstudianteDto(

                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                Integer.valueOf(txtNota1.getText()),
                Integer.valueOf(txtNota2.getText()),
                Integer.valueOf(txtNota3.getText()),
                (String) comboModalidad.getValue()


        );
    }

    private void crearEstudiante() {

        EstudianteDto estudianteDto = contruirEstudianteDto();

        if (datosValidor(estudianteDto)){
            if (estudianteController.agregarEstudiante(estudianteDto)){
                listEstudianteDto.add(estudianteDto);
                mostrarMensaje("Notificacion","Estudiante Creado", "EL Estudiante se ha creado con exito", Alert.AlertType.INFORMATION);
                limpiarCampos();
                registrarAcciones("Estudiante agregado", 1, "Se ah agregado un estudiante");

            }else {
                mostrarMensaje("Noticicacion", "Estudiante no creado","El estudiante no se ah creado con exito", Alert.AlertType.ERROR);
            }
        }else {
            mostrarMensaje("Noticiacion", "Estudiante no creado", "Los datos ingresados no son validos", Alert.AlertType.ERROR);

        }
    }


    private void eliminarEstudiante(){

        boolean estudianteEliminado = false;
        if (estudianteSeleccionado != null){
            if (mostrarMensajeConfirmacion("Esta Seguro de Eliminar al empleado")){
                estudianteEliminado = estudianteController.eliminarEstudiante(estudianteSeleccionado.codigo());

                if (estudianteEliminado == true) {

                    listEstudianteDto.remove(estudianteSeleccionado);
                    estudianteSeleccionado = null;
                    tablaEstudiantes.getSelectionModel().clearSelection();
                    limpiarCampos();
                    mostrarMensaje("Notificacion", "Estudiante eliminado", "EL estudiante se ah eliminado con exito", Alert.AlertType.INFORMATION);
                    registrarAcciones("Estudiante eliminado", 2, "Se ah eliminado un estudiante");

                }else {
                    mostrarMensaje("Notificacion", "Estudiante no eliminado", "EL estudiante no se pudo eliminar", Alert.AlertType.ERROR);
                }
            }
        }else {
            mostrarMensaje("Notificacion", "Estudiante no seleccionado", "Seleccione un estudiante de la lista mi perro", Alert.AlertType.WARNING);
        }
    }


    private void actualizarEstudiante(){

        boolean estudianteActualizado = false;

        String codigoActual = estudianteSeleccionado.codigo();

        EstudianteDto estudianteDto = contruirEstudianteDto();

        if (estudianteSeleccionado != null){

            if (datosValidor(estudianteSeleccionado)){

                estudianteActualizado = estudianteController.actualizarEstudiante(codigoActual, estudianteDto);
                if (estudianteActualizado){

                    listEstudianteDto.remove(estudianteSeleccionado);
                    listEstudianteDto.add(estudianteDto);
                    tablaEstudiantes.refresh();
                    mostrarMensaje("Notificacion", "Estudiante Actualizado", "El estudiante se ah actualizado", Alert.AlertType.INFORMATION);
                    registrarAcciones("Estudiante moficidado" , 3, "Se ah modificado un estudiante");
                    limpiarCampos();
                }else {
                    mostrarMensaje("Notificacion", "Estudiante No Actualizado", "El estudiante no se ah actualizado", Alert.AlertType.WARNING);
                }

            }else {

                mostrarMensaje("Notificacion", "Estudiante No Actualizado", "Datos ingresados son invalidos", Alert.AlertType.ERROR);
            }
        }
    }



    private boolean datosValidor(EstudianteDto estudianteDto) {

        String mensaje = "";

        if (estudianteDto.nombre() == null || estudianteDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n";

        if (estudianteDto.apellido() == null || estudianteDto.apellido().equals(""))
            mensaje += "El apellido es invalido \n";

        if (estudianteDto.codigo() == null || estudianteDto.codigo().equals(""))
            mensaje += "El codigo es invalido \n";

        if (estudianteDto.nota1() == null || estudianteDto.nota1().equals(""))
            mensaje += "La nota 1 es invalida \n";

        if (estudianteDto.nota2() == null || estudianteDto.nota2().equals(""))
            mensaje += "La nota 3 es invalida \n";

        if (estudianteDto.nota3() == null || estudianteDto.nota3().equals(""))
            mensaje += "La nota 3 es invalida \n";

        if (mensaje.equals("")) {

            return true;

        } else {
            mostrarMensaje("Notificacion","Datos Invalidos",mensaje, Alert.AlertType.ERROR);
            return false;
        }
    }


    private void registrarAcciones (String mensaje, int nivel, String accion){
        estudianteController.registrarAcciones(mensaje,nivel,accion);
    }


    private void limpiarCampos(){

        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtNota1.setText("");
        txtNota2.setText("");
        txtNota3.setText("");
    }


    private void mostrarMensaje (String titulo, String header, String contenido, Alert.AlertType alertType){

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();

    }

    private boolean mostrarMensajeConfirmacion (String mensaje){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("CONFIRMACION");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK){
            return true;
        }else{
            return false;
        }
    }

}