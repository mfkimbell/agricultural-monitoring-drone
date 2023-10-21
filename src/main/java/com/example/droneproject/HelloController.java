package com.example.droneproject;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Label metric1;
    @FXML
    private Label metric2;
    @FXML
    private Label metric3;
    @FXML
    private Label metric4;
    @FXML
    private ListView<String> myListView = new ListView<>();
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to the Drone Application!");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = myListView.getItems();
        String[] food = {"pizza", "sushi","ramen"};
        items.addAll(food);
    }
}