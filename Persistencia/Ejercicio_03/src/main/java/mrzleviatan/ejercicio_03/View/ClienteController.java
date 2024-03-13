package mrzleviatan.ejercicio_03.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import mrzleviatan.ejercicio_03.Model.Persona;

import java.time.LocalDate;

public class ClienteController {

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnModificar;

    @FXML
    private DatePicker datePickerFechaNacimiento;

    @FXML
    private RadioButton rbPersonaJuridica;

    @FXML
    private RadioButton rbPersonaNatural;

    @FXML
    private TableColumn<Persona, String> tblApellido;

    @FXML
    private TableColumn<Persona,String> tblDireccion;

    @FXML
    private TableColumn<Persona,String> tblEmail;

    @FXML
    private TableColumn<Persona, LocalDate> tblFechaNacimiento;

    @FXML
    private TableColumn<Persona,Integer> tblIdentificacion;

    @FXML
    private TableColumn<Persona,String> tblNit;

    @FXML
    private TableColumn<Persona,String> tblNom;

    @FXML
    private TableColumn<Persona,String> tblTelefono;

    @FXML
    private ToggleGroup tipoCliente;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNit;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;



    @FXML
    void crearCliente(ActionEvent event) {

    }

    @FXML
    void eliminarCliente(ActionEvent event) {

    }

    @FXML
    void modificarCliente(ActionEvent event) {

    }

}
