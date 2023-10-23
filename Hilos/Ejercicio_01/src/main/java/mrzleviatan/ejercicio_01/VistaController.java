package mrzleviatan.ejercicio_01;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import mrzleviatan.ejercicio_01.utils.TextFormatterUtil;


public class VistaController {

    ManejadorHilo manejadorHilo;


    @FXML
    private TextField txtNumero;



    @FXML
    private void initialize(){

        manejadorHilo=new ManejadorHilo();
        txtNumero.setTextFormatter(new TextFormatter<>(TextFormatterUtil :: integerFormat));
    }


    @FXML
    void eventoContar(ActionEvent event) throws InterruptedException {

        for (int contar=0; contar<=50; contar++){
            Thread.sleep(500);
            System.out.println("El recuento es: "+contar);
        }
    }

    @FXML
    void eventoImprimir(ActionEvent event) {

        System.out.println("Hola");
    }

    @FXML
    void eventoStarServicio1(ActionEvent event) {
        manejadorHilo.starHiloServicio1();

    }

    @FXML
    void eventoStarServicio2(ActionEvent event) {
        manejadorHilo.starHiloServicio2();

    }

    @FXML
    void eventoStarServicio3(ActionEvent event) {
        manejadorHilo.starHiloServicio3();
    }

    @FXML
    void eventoStopServicio1(ActionEvent event) {
        manejadorHilo.detenerHiloServicio1();
    }

    @FXML
    void eventoStopServicio2(ActionEvent event) {
        manejadorHilo.detenerHiloServicio2();

    }

    @FXML
    void eventoStopServicio3(ActionEvent event) {
        manejadorHilo.detenerHiloServicio3();
    }

    public void eventoStarServicio4(ActionEvent actionEvent) {

        Integer num = Integer.valueOf(txtNumero.getText());
        manejadorHilo.starHiloServicio4(num);


    }

    public void eventoStopServicio4(ActionEvent actionEvent) {

        manejadorHilo.deteneHiloServicio4();
    }

    public void eventoStarServicio5(ActionEvent actionEvent) {

        manejadorHilo.starHiloServicio5();
    }

    public void eventoStopServicio5(ActionEvent actionEvent) {
        manejadorHilo.detenerServicio5();
    }
}

