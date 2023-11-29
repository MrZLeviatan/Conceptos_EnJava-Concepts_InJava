module mrzleviatan.ejercicio_102 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens mrzleviatan.ejercicio_102 to javafx.fxml;
    exports mrzleviatan.ejercicio_102;
}