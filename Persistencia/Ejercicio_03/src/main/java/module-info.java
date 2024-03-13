module mrzleviatan.ejercicio_03 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mrzleviatan.ejercicio_03 to javafx.fxml;
    exports mrzleviatan.ejercicio_03;
    exports mrzleviatan.ejercicio_03.View;
    opens mrzleviatan.ejercicio_03.View to javafx.fxml;
}