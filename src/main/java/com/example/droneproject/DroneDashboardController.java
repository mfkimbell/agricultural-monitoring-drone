package com.example.droneproject;

import farm.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import javafx.scene.paint.Color;

public class DroneDashboardController implements Initializable {
    public Object currentAction = "";
    public TreeItem<String> rootItem = new TreeItem<>();
    public TreeItem<String> testItem = new TreeItem<>();
    FarmItem newFarmItem = new FarmItem();
    FarmBuilding newFarmBuilding = new FarmBuilding();

    ArrayList <FarmObject> farmObjects = new ArrayList<>();

    public Rectangle drawPerimeter(FarmItem values) {
        Rectangle myRectangle = new Rectangle(values.getWidth(), values.getHeight());
        myRectangle.setFill(null);
        myRectangle.setStroke(Color.BLACK);
        myRectangle.setStrokeWidth(2.0);
        myRectangle.setTranslateX(values.getLocationX());
        myRectangle.setTranslateY(values.getLocationY());
        mapview.getChildren().add(myRectangle);
        return myRectangle;
    }

    public Rectangle drawPerimeter(FarmBuilding values) {
        Rectangle myRectangle = new Rectangle(values.getWidth(), values.getHeight());
        myRectangle.setFill(null);
        myRectangle.setStroke(Color.BLACK);
        myRectangle.setStrokeWidth(2.0);
        myRectangle.setTranslateX(values.getLocationX());
        myRectangle.setTranslateY(values.getLocationY());
        mapview.getChildren().add(myRectangle);
        return myRectangle;
    }

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
                    Float.parseFloat(itemHeightField.getText()),
                    new Rectangle()
            );

            Rectangle rect = drawPerimeter(values);
            values.setPerimeter(rect);
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
        Text txt = new Text("Enter Building Values");
        VBox pane = new VBox(10);
        AtomicReference<FarmBuilding> newBuilding = new <FarmBuilding>AtomicReference();

        newItemDialog.setTitle("New Building");

        acceptButton.setOnAction(e -> {
            FarmBuilding values = new FarmBuilding(
                    itemNameField.getText(),
                    Float.parseFloat(itemPriceField.getText()),
                    Float.parseFloat(itemXField.getText()),
                    Float.parseFloat(itemYField.getText()),
                    Float.parseFloat(itemLengthField.getText()),
                    Float.parseFloat(itemWidthField.getText()),
                    Float.parseFloat(itemHeightField.getText()),
                    new Rectangle()
            );
            Rectangle rect = drawPerimeter(values);
            values.setPerimeter(rect);
            newBuilding.set(values);
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
        newFarmBuilding = newBuilding.get();
    }
    @FXML
    private ListView itemOptions = new ListView<>();

    @FXML
    public Pane mapview;

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
        if (currentAction == "Add Item"){
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            createItem();
            if (selection.getValue() instanceof FarmBuilding) {
                ((FarmBuilding) selection.getValue()).addItem(newFarmItem);
            } else {
                farmObjects.add(newFarmItem);
            }
        }

        if (currentAction == "Add Item Container"){
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            createContainer();
            if (selection.getValue() instanceof FarmBuilding) {
                ((FarmBuilding) selection.getValue()).addItemContainer(newFarmBuilding);
            } else {
                farmObjects.add(newFarmBuilding);
            }
        }
        rootItem.getChildren().clear();
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

    public void findObjectAndDelete(ArrayList farm_arr, FarmObject target){
        for(Object obj: farm_arr) {
            if(obj instanceof FarmBuilding) {
                if (((FarmBuilding) obj).getItemContainers().contains(target)){
                    ((FarmBuilding) obj).deleteItemContainer((ItemContainer) target);
                    return;
                }
                if (((FarmBuilding) obj).getItems().contains(target)){
                    ((FarmBuilding) obj).deleteItem((Item) target);
                    return;
                }
                if (((FarmBuilding) obj).getItemContainers() != null) {
                    findObjectAndDelete(((FarmBuilding) obj).getItemContainers(), target);
                }
            }
            if(obj.equals(target)) {
                farm_arr.remove(target);
                return;
            }
        }
    }
    public void configureContextMenu() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem rename = new MenuItem("Rename");
        MenuItem location = new MenuItem("Change Location");
        MenuItem price = new MenuItem("Change Price");
        MenuItem dimensions = new MenuItem("Change Dimensions");
        MenuItem delete = new MenuItem("Delete");

        delete.setOnAction(event -> {
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            findObjectAndDelete(farmObjects, (FarmObject) selection.getValue());
            rootItem.getChildren().clear();
            for(FarmObject i: farmObjects){
                TreeItem node = buildTree(i);
                rootItem.getChildren().add(node);
            }
        });

        dimensions.setOnAction(event -> {
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            Dialog<Boolean> newItemDialog = new Dialog();
            TextField length = new TextField();
            TextField width = new TextField();
            TextField height = new TextField();
            Label L = new Label("L: ");
            Label W = new Label("W: ");
            Label H = new Label("H: ");

            Button acceptButton = new Button("Change");

            acceptButton.setOnAction(e -> {
                if (selection.getValue() instanceof FarmItem) {

                    mapview.getChildren().remove(((FarmItem) selection.getValue()).getPerimeter());

                    ((FarmItem) selection.getValue()).changeLength(Float.parseFloat(length.getText()));
                    ((FarmItem) selection.getValue()).changeWidth(Float.parseFloat(width.getText()));
                    ((FarmItem) selection.getValue()).changeHeight(Float.parseFloat(height.getText()));

                    Rectangle newRect = drawPerimeter((FarmItem) selection.getValue());
                    ((FarmItem) selection.getValue()).setPerimeter(newRect);

                }
                if (selection.getValue() instanceof FarmBuilding) {

                    mapview.getChildren().remove(((FarmBuilding) selection.getValue()).getPerimeter());


                    ((FarmBuilding) selection.getValue()).changeLength(Float.parseFloat(length.getText()));
                    ((FarmBuilding) selection.getValue()).changeWidth(Float.parseFloat(width.getText()));
                    ((FarmBuilding) selection.getValue()).changeHeight(Float.parseFloat(height.getText()));

                    Rectangle newRect = drawPerimeter((FarmBuilding) selection.getValue());
                    ((FarmBuilding) selection.getValue()).setPerimeter(newRect);

                    System.out.println(((FarmBuilding) selection.getValue()).getLength());
                    System.out.println(((FarmBuilding) selection.getValue()).getWidth());
                    System.out.println(((FarmBuilding) selection.getValue()).getHeight());
                }
                newItemDialog.close();
            });

            newItemDialog.setResult(true);
            VBox pane = new VBox(10);

            GridPane fieldPane = new GridPane();
            fieldPane.add(L, 0,0);
            fieldPane.add(length, 1,0);
            fieldPane.add(W, 2,0);
            fieldPane.add(width, 3,0);
            fieldPane.add(H, 4,0);
            fieldPane.add(height, 5,0);
            fieldPane.add(acceptButton, 6, 0);

            pane.getChildren().add(fieldPane);
            newItemDialog.getDialogPane().setContent(pane);
            newItemDialog.showAndWait();

            itemTree.refresh();
        });
        price.setOnAction(event -> {
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setTitle("Edit");
            inputDialog.setHeaderText(null); // Remove the header text
            inputDialog.setContentText("New Price:");
            inputDialog.setGraphic(null); // Remove the icon
            String result = inputDialog.showAndWait().get();
            if (selection.getValue() instanceof FarmItem) {
                ((FarmItem) selection.getValue()).changePrice(Float.parseFloat(result));
            }
            if (selection.getValue() instanceof FarmBuilding) {
                ((FarmBuilding) selection.getValue()).changePrice(Float.parseFloat(result));
            }
            itemTree.refresh();
        });

        rename.setOnAction(event -> {
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            TextInputDialog inputDialog = new TextInputDialog();
            inputDialog.setTitle("Edit");
            inputDialog.setHeaderText(null); // Remove the header text
            inputDialog.setContentText("New Name:");
            inputDialog.setGraphic(null); // Remove the icon
            String result = inputDialog.showAndWait().get();
            if (selection.getValue() instanceof FarmItem) {
                ((FarmItem) selection.getValue()).changeName(result);
            }
            if (selection.getValue() instanceof FarmBuilding) {
                ((FarmBuilding) selection.getValue()).changeName(result);
            }
            itemTree.refresh();
        });

        location.setOnAction(event -> {
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            Dialog<Boolean> newItemDialog = new Dialog();
            TextField x = new TextField();
            TextField y = new TextField();
            Label X = new Label("X: ");
            Label Y = new Label("Y: ");

            Button acceptButton = new Button("Change");

            acceptButton.setOnAction(e -> {
                if (selection.getValue() instanceof FarmItem) {

                    mapview.getChildren().remove(((FarmItem) selection.getValue()).getPerimeter());

                    ((FarmItem) selection.getValue()).changeLocationX(Float.parseFloat(x.getText()));
                    ((FarmItem) selection.getValue()).changeLocationY(Float.parseFloat(y.getText()));


                    Rectangle newRect = drawPerimeter((FarmItem) selection.getValue());
                    ((FarmItem) selection.getValue()).setPerimeter(newRect);
                }
                if (selection.getValue() instanceof FarmBuilding) {

                    mapview.getChildren().remove(((FarmBuilding) selection.getValue()).getPerimeter());

                    ((FarmBuilding) selection.getValue()).changeLocationX(Float.parseFloat(x.getText()));
                    ((FarmBuilding) selection.getValue()).changeLocationY(Float.parseFloat(y.getText()));
                    System.out.println(((FarmBuilding) selection.getValue()).getLocationX());
                    System.out.println(((FarmBuilding) selection.getValue()).getLocationY());

                    Rectangle newRect = drawPerimeter((FarmBuilding) selection.getValue());
                    ((FarmBuilding) selection.getValue()).setPerimeter(newRect);
                }
                newItemDialog.close();
            });

            newItemDialog.setResult(true);
            VBox pane = new VBox(10);

            GridPane fieldPane = new GridPane();
            fieldPane.add(X, 0,0);
            fieldPane.add(Y, 2,0);
            fieldPane.add(x, 1, 0);
            fieldPane.add(y, 3, 0);
            fieldPane.add(acceptButton, 4, 0);

            pane.getChildren().add(fieldPane);
            newItemDialog.getDialogPane().setContent(pane);
            newItemDialog.showAndWait();

            itemTree.refresh();
        });

        contextMenu.getItems().addAll(rename, location, price, dimensions, delete);
        itemTree.setContextMenu(contextMenu);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configureContextMenu();
        FarmBuilding room = new FarmBuilding("CowContainer", 2000, 10, 10, 10, 10, 10, new Rectangle());
        room.addItem(new FarmItem("test",2,2,2,2,2,2, new Rectangle()));
        farmObjects.add(room);
        ArrayList optionList = new ArrayList<>();
        optionList.add("Item Root Commands");
        optionList.add("Add Item Container");
        optionList.add("Add Item");
        itemOptions.getItems().addAll(optionList.get(0), optionList.get(1), optionList.get(2));

        // Button Handlers
        visitImageButton.setOnAction(event -> System.out.println(itemOptions.getSelectionModel().getSelectedItem()));
        homeButton.setOnAction(event -> System.out.println());
        scanImageButton.setOnAction(event -> System.out.println());
        scanDroneButton.setOnAction(event -> System.out.println());
        visitDroneButton.setOnAction(event -> System.out.println());

        // Init item tree root
        rootItem.setValue("root");

        // Sets root for Item Tree
        itemTree.setRoot(rootItem);
    }

}
