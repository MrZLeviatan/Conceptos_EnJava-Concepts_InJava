module mrzleviatan.ejercicio_tcp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mrzleviatan.ejercicio_tcp to javafx.fxml;
    exports mrzleviatan.ejercicio_tcp;
}