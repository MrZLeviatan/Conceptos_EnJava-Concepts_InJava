package mrzleviatan.ejercicio_01;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {

    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;


    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TableView<Usuario> table;

    @FXML
    private TableColumn<Usuario, Genero> colGender;

    @FXML
    private TableColumn<Usuario,String> colLName;

    @FXML
    private TableColumn<Usuario, String> colPhone;

    @FXML
    private TableColumn<Usuario,String> colfName;

    @FXML
    private TableColumn<Usuario,String> colid;


    @FXML
    private TextField tlLastName1;

    @FXML
    private TextField tlName1;

    @FXML
    private TextField tlPhone1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public ObservableList<Usuario> getUsuario(){
        ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

        String query = "select * from users";
        con = DBConnexion.getCon();
        try {
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()){
                Usuario us = new Usuario();
                us.setId(rs.getInt("id"));
                us.setFirstName(rs.getString("FirstName"));
                us.setLastName(rs.getString("LastName"));
                us.setPhone(rs.getString("Phone"));
                us.setGender(Genero.valueOf(rs.getString("Gender")));
                usuarios.add(us);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }



    public void showUsers(){
        ObservableList<Usuario> list = getUsuario();
        table.setItems(list);
        colid.setCellFactory(new PropertyValueFactory<Usuario,String>("id"));
        colfName.setCellFactory(new PropertyValueFactory<Usuario,String>("firstName"));



    }

    @FXML
    void clearUser(ActionEvent event) {

    }

    @FXML
    void creatUser(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void updateUser(ActionEvent event) {

    }


}
