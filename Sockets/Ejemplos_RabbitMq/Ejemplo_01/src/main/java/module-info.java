module mrzleviatan.ejemplo_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.rabbitmq.client;

    opens mrzleviatan.ejemplo_01 to javafx.fxml;
    exports mrzleviatan.ejemplo_01;
}