module mrzleviatan.ejercicio_udp {
    requires javafx.controls;
    requires javafx.fxml;


    opens mrzleviatan.ejercicio_udp to javafx.fxml;
    exports mrzleviatan.ejercicio_udp;
}