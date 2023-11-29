package mrzleviatan.ejercicio_01;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Observable;
import java.util.Observer;

public class Frm2 implements Observer {

    @FXML
    private Button botonEnviar;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtField;


    public Frm2 (){

        Servidor s = new Servidor(6000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();

    }

    @FXML
    void enviarAction(ActionEvent event) {

        String mensaje = "2: " + this.txtField.getText() + "\n";

        this.txtArea.appendText(mensaje);

        Cliente c = new Cliente(5000,mensaje);
        Thread t = new Thread(c);
        txtField.clear();
        t.start();


    }


    @Override
    public void update(Observable o, Object arg) {

        this.txtArea.appendText((String) arg);

    }
}