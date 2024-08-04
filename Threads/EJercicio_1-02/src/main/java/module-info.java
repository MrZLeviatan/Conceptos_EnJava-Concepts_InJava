module mrzleviatan.ejercicio_102 {
    requires javafx.controls;
    requires javafx.fxml;


    opens Ejercicio to javafx.fxml;
    exports Ejercicio;
}