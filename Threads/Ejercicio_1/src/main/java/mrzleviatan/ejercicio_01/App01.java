package mrzleviatan.ejercicio_01;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App01 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("VistaPrincipal.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Ejemplo 01");
        stage.getIcons().add(new Image(App01.class.getResourceAsStream("/Images/Logo.jpg")));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}