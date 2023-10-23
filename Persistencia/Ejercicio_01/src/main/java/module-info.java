module mrzleviatan.ejercicio_01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens mrzleviatan.ejercicio_01 to javafx.fxml;
    exports mrzleviatan.ejercicio_01;
    opens mrzleviatan.ejercicio_01.model to javafx.fxml;
    exports mrzleviatan.ejercicio_01.model;
    opens mrzleviatan.ejercicio_01.model.service to javafx.fxml;
    exports mrzleviatan.ejercicio_01.model.service;
    opens mrzleviatan.ejercicio_01.exceptions to javafx.fxml;
    exports mrzleviatan.ejercicio_01.exceptions;
    opens mrzleviatan.ejercicio_01.mapping.dto to javafx.fxml;
    exports mrzleviatan.ejercicio_01.mapping.dto;
    opens mrzleviatan.ejercicio_01.mapping.mappers to javafx.fxml;
    exports mrzleviatan.ejercicio_01.mapping.mappers;

}