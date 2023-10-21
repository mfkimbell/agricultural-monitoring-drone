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
        FarmItem item = new FarmItem("Cow", 250, 10, 10, 10, 10, 10);
        FarmBuilding room = new FarmBuilding("CowContainer", 2000, 10, 10, 10, 10, 10);
        room.addItem(item);
        System.out.println(room.getItems());

        Item cow = room.getItemFromContainer("Cow", 10, 10);
        System.out.println(cow.getName() + " "  + cow.getLocationX() + " " + cow.getLocationY());
    }
}