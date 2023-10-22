package com.example.droneproject;

import farm.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DroneDashboardController implements Initializable {

    @FXML
    private Label metric1;

    @FXML
    private Label metric2;

    @FXML
    private Label metric3;

    @FXML
    private Label metric4;

    @FXML
    private ListView itemOptions = new ListView<>();

    @FXML
    private Button visitImageButton;


    @FXML
    private Button homeButton;

    @FXML
    private Button scanImageButton;

    @FXML
    private Button scanDroneButton;

    @FXML
    private Button visitDroneButton;

    @FXML
    public Pane root;

    @FXML
    private TreeView itemTree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FarmItem item = new FarmItem("Cow", 250, 10, 10, 10, 10, 10);
        FarmBuilding room = new FarmBuilding("CowContainer", 2000, 10, 10, 10, 10, 10);
        room.addItem(item);
        System.out.println(room.getItems());
        ArrayList optionList = new ArrayList<>();
        optionList.add("Item Root Commands");
        optionList.add("Add Item Container");
        itemOptions.getItems().addAll(optionList.get(0), optionList.get(1));




        // Button Handlers
        visitImageButton.setOnAction(event -> System.out.println(itemOptions.getSelectionModel().getSelectedItem()));
        homeButton.setOnAction(event -> System.out.println());
        scanImageButton.setOnAction(event -> System.out.println());
        scanDroneButton.setOnAction(event -> System.out.println());
        visitDroneButton.setOnAction(event -> System.out.println());

        // Init item tree root
        TreeItem<String> rootItem = new TreeItem<>();
        rootItem.setValue("root");

        // Gets each item in the Farm Building instance
        for(Item i: room.getItems()){
            TreeItem node = new TreeItem<>();
            node.setValue(i);
            rootItem.getChildren().add(node);
        }

        // Sets root for Item Tree
        itemTree.setRoot(rootItem);


    }
}
