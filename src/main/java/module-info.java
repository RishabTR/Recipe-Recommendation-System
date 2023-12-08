module com.example.logininterface {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.executables to javafx.fxml;
    exports com.example.executables;
}