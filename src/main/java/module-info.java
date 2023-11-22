module com.example.droneproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires Jamepad;
    requires opencv;
    requires java.logging;
    requires java.desktop;

    opens com.example.droneproject to javafx.fxml;
    exports com.example.droneproject;
}