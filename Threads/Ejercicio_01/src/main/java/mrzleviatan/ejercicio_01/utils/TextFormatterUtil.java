package mrzleviatan.ejercicio_01.utils;

import javafx.scene.control.TextFormatter;

public class TextFormatterUtil {

    public static TextFormatter.Change integerFormat(TextFormatter.Change change){
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }

}
