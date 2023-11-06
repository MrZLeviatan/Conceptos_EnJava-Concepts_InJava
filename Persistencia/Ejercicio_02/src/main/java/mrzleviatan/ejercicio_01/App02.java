package mrzleviatan.ejercicio_01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App02 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App02.class.getResource("Universidad.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(" Ejercicio 2 _ Persistencia ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}