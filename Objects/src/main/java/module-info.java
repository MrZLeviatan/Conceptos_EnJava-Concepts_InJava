module mrzleviatan.objects {
    requires javafx.controls;
    requires javafx.fxml;


    opens mrzleviatan.objects to javafx.fxml;
    exports mrzleviatan.objects;
}