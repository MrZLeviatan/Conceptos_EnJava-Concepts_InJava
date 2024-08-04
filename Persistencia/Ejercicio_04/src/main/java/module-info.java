module mrzleviatan.ejercicio_04 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens mrzleviatan.ejercicio_04 to javafx.fxml;
    exports mrzleviatan.ejercicio_04;
}