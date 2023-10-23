module mrzleviatan.ejercicio_01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mrzleviatan.ejercicio_01 to javafx.fxml;
    exports mrzleviatan.ejercicio_01;
}