package com.example.droneproject;

import farm.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class DroneDashboardController implements Initializable {

    public Object currentAction = "";
    public TreeItem<String> rootItem = new TreeItem<>();
    public FarmItem newFarmItem = new FarmItem();

    public FarmItem completeForms(Text prompt, TextField field, Dialog dialog){
        AtomicReference<String> newItemName = new AtomicReference<>("");
        AtomicReference<Float> newItemPrice = new AtomicReference(0);
        AtomicReference<Float> newItemX = new AtomicReference(0);
        AtomicReference<Float> newItemY = new AtomicReference(0);
        AtomicReference<Float> newItemLength = new AtomicReference(0);
        AtomicReference<Float> newItemWidth = new AtomicReference(0);
        AtomicReference<Float> newItemHeight = new AtomicReference(0);


        newItemName.set(field.getText());
        field.clear();
        prompt.setText("Enter Price Value");
        newItemPrice.set(Float.parseFloat(field.getText().isEmpty() ? "0" : field.getText()));
        field.clear();
        prompt.setText("Enter X Value");
        newItemX.set(Float.parseFloat(field.getText().isEmpty() ? "0" : field.getText()));
        field.clear();
        prompt.setText("Enter Y Value");
        newItemY.set(Float.parseFloat(field.getText().isEmpty() ? "0" : field.getText()));
        field.clear();
        prompt.setText("Enter Length Value");
        newItemLength.set(Float.parseFloat(field.getText().isEmpty() ? "0" : field.getText()));
        field.clear();
        prompt.setText("Enter Width Value");
        newItemWidth.set(Float.parseFloat(field.getText().isEmpty() ? "0" : field.getText()));
        field.clear();
        prompt.setText("Enter Height Value");
        newItemHeight.set(Float.parseFloat(field.getText().isEmpty() ? "0" : field.getText()));
        FarmItem newItem = new FarmItem(
                newItemName.get(),
                newItemPrice.get(),
                newItemX.get(),
                newItemY.get(),
                newItemLength.get(),
                newItemWidth.get(),
                newItemHeight.get());
        return newItem;

    }
    public void createItem(){

        Dialog<Boolean> newItemDialog = new Dialog();
        TextField itemNameField = new TextField();
        Button acceptButton = new Button("OK");
        newItemDialog.setResult(true);
        Text txt = new Text("Enter Item Name");
        VBox pane = new VBox(10);
        AtomicReference<FarmItem> newItem = new <FarmItem>AtomicReference();

        newItemDialog.setTitle("New Item");

        acceptButton.setOnAction(e -> {
           newItem.set(completeForms(txt, itemNameField, newItemDialog));
           newItemDialog.close();
        });
        Font font = Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 12);
        txt.setFont(font);

        pane.getChildren().addAll(txt, itemNameField, acceptButton);
        newItemDialog.getDialogPane().setContent(pane);
        newItemDialog.show();
        newFarmItem = newItem.get();
    }
    @FXML
    private ListView itemOptions = new ListView<>();

    @FXML
    private Button visitImageButton;

    @FXML
    private SplitPane controlPanel;

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

    @FXML
    public void handleMouseClicked(MouseEvent mouseEvent) {
        currentAction = itemOptions.getSelectionModel().getSelectedItem();
        if (currentAction == "Item Root Commands"){
            System.out.println("Check 1");
        }
        if (currentAction == "Add Item Container"){
            createItem();
            itemOptions.getItems().add(newFarmItem);

        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FarmItem item = new FarmItem("Cow", 250, 10, 10, 10, 10, 10);
        FarmBuilding room = new FarmBuilding("CowContainer", 2000, 10, 10, 10, 10, 10);
        room.addItem(item);
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
