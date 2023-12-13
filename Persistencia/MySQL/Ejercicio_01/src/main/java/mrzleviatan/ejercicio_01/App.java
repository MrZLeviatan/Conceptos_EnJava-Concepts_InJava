package mrzleviatan.ejercicio_01;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/Fxml/Usuario.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("MySQL Ejercicio 01");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args){
        launch();
    }

}
