package com.example.droneproject;

import farm.FarmBuilding;
import farm.FarmItem;
import farm.Item;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class DroneDashboardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DroneDashboardApplication.class.getResource("dashboard-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 900);
        ImageView drone = new ImageView(new Image("/drone.png"));
        stage.setTitle("Drone Dashboard");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}