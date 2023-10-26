package com.example.droneproject;

import farm.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class DroneDashboardController implements Initializable {

    public Object currentAction = "";
    public TreeItem<String> rootItem = new TreeItem<>();
    FarmItem newFarmItem = new FarmItem();

    ArrayList <FarmObject> farmObjects = new ArrayList<>();

    public void createItem(){

        Dialog<Boolean> newItemDialog = new Dialog();
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        TextField itemXField = new TextField();
        TextField itemYField = new TextField();
        TextField itemLengthField = new TextField();
        TextField itemWidthField = new TextField();
        TextField itemHeightField = new TextField();

        Button acceptButton = new Button("OK");
        newItemDialog.setResult(true);
        Text txt = new Text("Enter Item Values");
        VBox pane = new VBox(10);
        AtomicReference<FarmItem> newItem = new <FarmItem>AtomicReference();

        newItemDialog.setTitle("New Item");

        acceptButton.setOnAction(e -> {
            FarmItem values = new FarmItem(
                    itemNameField.getText(),
                    Float.parseFloat(itemPriceField.getText()),
                    Float.parseFloat(itemXField.getText()),
                    Float.parseFloat(itemYField.getText()),
                    Float.parseFloat(itemLengthField.getText()),
                    Float.parseFloat(itemWidthField.getText()),
                    Float.parseFloat(itemHeightField.getText())
            );
            newItem.set(values);


           newItemDialog.close();
        });
        Font font = Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 12);
        txt.setFont(font);
        Label nameLabel = new Label("Name");
        Label priceLabel = new Label("Price");
        Label xLabel = new Label("X Coordinate");
        Label yLabel = new Label("Y Coordinate");
        Label lengthLabel = new Label("Length");
        Label widthLabel = new Label("Width");
        Label heightLabel = new Label("Height");

        GridPane fieldPane = new GridPane();
        fieldPane.add(txt,0,0);
        fieldPane.add(nameLabel, 0,1);
        fieldPane.add(priceLabel, 0,2);
        fieldPane.add(xLabel, 0,3);
        fieldPane.add(yLabel, 0,4);
        fieldPane.add(lengthLabel, 0,5);
        fieldPane.add(widthLabel, 0,6);
        fieldPane.add(heightLabel, 0,7);
        fieldPane.add(itemNameField,1,1);
        fieldPane.add(itemPriceField,1,2);
        fieldPane.add(itemXField,1,3);
        fieldPane.add(itemYField,1,4);
        fieldPane.add(itemLengthField,1,5);
        fieldPane.add(itemWidthField,1,6);
        fieldPane.add(itemHeightField,1,7);
        fieldPane.add(acceptButton, 0,9);
        pane.getChildren().add(fieldPane);
        newItemDialog.getDialogPane().setContent(pane);
        newItemDialog.showAndWait();
        newFarmItem = newItem.get();
    }

    public void createContainer(){

        Dialog<Boolean> newItemDialog = new Dialog();
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        TextField itemXField = new TextField();
        TextField itemYField = new TextField();
        TextField itemLengthField = new TextField();
        TextField itemWidthField = new TextField();
        TextField itemHeightField = new TextField();

        Button acceptButton = new Button("OK");
        newItemDialog.setResult(true);
        Text txt = new Text("Enter Item Values");
        VBox pane = new VBox(10);
        AtomicReference<FarmItem> newItem = new <FarmItem>AtomicReference();

        newItemDialog.setTitle("New Item");

        acceptButton.setOnAction(e -> {
            FarmItem values = new FarmItem(
                    itemNameField.getText(),
                    Float.parseFloat(itemPriceField.getText()),
                    Float.parseFloat(itemXField.getText()),
                    Float.parseFloat(itemYField.getText()),
                    Float.parseFloat(itemLengthField.getText()),
                    Float.parseFloat(itemWidthField.getText()),
                    Float.parseFloat(itemHeightField.getText())
            );
            newItem.set(values);


            newItemDialog.close();
        });
        Font font = Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 12);
        txt.setFont(font);
        Label nameLabel = new Label("Name");
        Label priceLabel = new Label("Price");
        Label xLabel = new Label("X Coordinate");
        Label yLabel = new Label("Y Coordinate");
        Label lengthLabel = new Label("Length");
        Label widthLabel = new Label("Width");
        Label heightLabel = new Label("Height");

        GridPane fieldPane = new GridPane();
        fieldPane.add(txt,0,0);
        fieldPane.add(nameLabel, 0,1);
        fieldPane.add(priceLabel, 0,2);
        fieldPane.add(xLabel, 0,3);
        fieldPane.add(yLabel, 0,4);
        fieldPane.add(lengthLabel, 0,5);
        fieldPane.add(widthLabel, 0,6);
        fieldPane.add(heightLabel, 0,7);
        fieldPane.add(itemNameField,1,1);
        fieldPane.add(itemPriceField,1,2);
        fieldPane.add(itemXField,1,3);
        fieldPane.add(itemYField,1,4);
        fieldPane.add(itemLengthField,1,5);
        fieldPane.add(itemWidthField,1,6);
        fieldPane.add(itemHeightField,1,7);
        fieldPane.add(acceptButton, 0,9);
        pane.getChildren().add(fieldPane);
        newItemDialog.getDialogPane().setContent(pane);
        newItemDialog.showAndWait();
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
            farmObjects.add(newFarmItem);

        }
        for(FarmObject i: farmObjects){
            TreeItem node = buildTree(i);
            rootItem.getChildren().add(node);
        }

    }
    public TreeItem buildTree(FarmObject object){
        TreeItem node = new TreeItem<>();
        node.setValue(object);
        if(object instanceof FarmBuilding){
            for(ItemContainer ic: ((FarmBuilding) object).getItemContainers()){
                node.getChildren().add(buildTree(ic));
            }
            for(Item i: ((FarmBuilding) object).getItems()){
                TreeItem child = new TreeItem();
                child.setValue(i);
                node.getChildren().add(child);
            }
        }
        return node;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FarmBuilding room = new FarmBuilding("CowContainer", 2000, 10, 10, 10, 10, 10);
        room.addItem(new FarmItem("test",2,2,2,2,2,2));
        farmObjects.add(room);
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


        // Sets root for Item Tree
        itemTree.setRoot(rootItem);




    }

}
