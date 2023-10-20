package com.example.droneproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import farm.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}

class OldMcDonald extends FarmObject {
    // An example implementation of the farm package
    @Override
    public void changeName() {

    }

    @Override
    public void changePrice() {

    }

    @Override
    public void changeLocationX() {

    }

    @Override
    public void changeLocationY() {

    }

    @Override
    public void changeLength() {

    }

    @Override
    public void changeHeight() {

    }
}