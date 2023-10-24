package mrzleviatan.ejercicio_01;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App01 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("VistaPrincipal.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Ejemplo 01");
     //   stage.getIcons().add(new Image(App01.class.getResourceAsStream("C:\\Users\\MrZ Leviatan\\Documents\\Programacion\\Parcial\\Pre-Parcial2\\Ejercicio_01\\src\\main\\resources\\Images\\Logo.jpg")));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}