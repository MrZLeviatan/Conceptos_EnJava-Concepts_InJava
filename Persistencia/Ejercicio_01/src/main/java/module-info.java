module mrzleviatan.ejercicio_01 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.mapstruct;
    requires java.logging;
    requires java.desktop;


    opens mrzleviatan.ejercicio_01 to javafx.fxml;
    exports mrzleviatan.ejercicio_01;
    exports mrzleviatan.ejercicio_01.viewController;
    opens mrzleviatan.ejercicio_01.viewController to javafx.fxml;

    exports mrzleviatan.ejercicio_01.controller;
    exports mrzleviatan.ejercicio_01.mapping.dto;
    exports mrzleviatan.ejercicio_01.mapping.mappers;
    exports mrzleviatan.ejercicio_01.model;
    exports mrzleviatan.ejercicio_01.utils;
    opens mrzleviatan.ejercicio_01.controller to javafx.fxml;

}