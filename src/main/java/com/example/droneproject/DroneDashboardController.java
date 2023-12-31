package com.example.droneproject;

import farm.*;
import tello.ScanFarm;
import tello.VisitItem;
import tello.GoHome;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.scene.paint.Color;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DroneDashboardController implements Initializable {
    //create timeline for drone
    Timeline rotate = new Timeline();
    Timeline moveDiagonal = new Timeline();
    Timeline moveUp = new Timeline();
    Timeline rotateNext = new Timeline();
    Timeline rotateLast = new Timeline();
    Timeline moveLeft = new Timeline();

    SequentialTransition sequence = new SequentialTransition();
    public Object currentAction = "";
    public TreeItem<String> rootItem = new TreeItem<>();
    public TreeItem<String> testItem = new TreeItem<>();
    FarmItem newFarmItem = new FarmItem();
    FarmBuilding newFarmBuilding = new FarmBuilding();
    ArrayList <FarmObject> farmObjects = new ArrayList<>();

    //create drone image
    ImageView drone = new ImageView(new Image("/drone.png"));

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

    public Text addLabel(FarmObject obj) {
        Text label = new Text(obj.getName());
        label.setX(obj.getLocationX());
        label.setY(obj.getLocationY());
        mapview.getChildren().add(label);
        return label;
    }

    public void createItem(){

        Dialog<Boolean> newItemDialog = new Dialog();
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        TextField itemMarketValueField = new TextField();
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
                    Float.parseFloat(itemMarketValueField.getText()),
                    Float.parseFloat(itemXField.getText()),
                    Float.parseFloat(itemYField.getText()),
                    Float.parseFloat(itemLengthField.getText()),
                    Float.parseFloat(itemWidthField.getText()),
                    Float.parseFloat(itemHeightField.getText()),
                    new Rectangle(),
                    new Text()
            );

            Rectangle rect = drawPerimeter(values);
            values.setPerimeter(rect);
            values.setLabel(addLabel(values));

            newItem.set(values);
           newItemDialog.close();
        });
        Font font = Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 12);
        txt.setFont(font);
        Label nameLabel = new Label("Name");
        Label priceLabel = new Label("Price");
        Label marketValueLabel = new Label("Market Value");
        Label xLabel = new Label("X Coordinate");
        Label yLabel = new Label("Y Coordinate");
        Label lengthLabel = new Label("Length");
        Label widthLabel = new Label("Width");
        Label heightLabel = new Label("Height");

        GridPane fieldPane = new GridPane();
        fieldPane.add(txt,0,0);
        fieldPane.add(nameLabel, 0,1);
        fieldPane.add(priceLabel, 0,2);
        fieldPane.add(marketValueLabel, 0,3);
        fieldPane.add(xLabel, 0,4);
        fieldPane.add(yLabel, 0,5);
        fieldPane.add(lengthLabel, 0,6);
        fieldPane.add(widthLabel, 0,7);
        fieldPane.add(heightLabel, 0,8);
        fieldPane.add(itemNameField,1,1);
        fieldPane.add(itemPriceField,1,2);
        fieldPane.add(itemMarketValueField,1,3);
        fieldPane.add(itemXField,1,4);
        fieldPane.add(itemYField,1,5);
        fieldPane.add(itemLengthField,1,6);
        fieldPane.add(itemWidthField,1,7);
        fieldPane.add(itemHeightField,1,8);
        fieldPane.add(acceptButton, 0,10);
        pane.getChildren().add(fieldPane);
        newItemDialog.getDialogPane().setContent(pane);
        newItemDialog.showAndWait();
        newFarmItem = newItem.get();
    }

    public void createContainer(){
        Dialog<Boolean> newItemDialog = new Dialog();
        TextField itemNameField = new TextField();
        TextField itemPriceField = new TextField();
        TextField itemMarketValueField = new TextField();
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
                    Float.parseFloat(itemMarketValueField.getText()),
                    Float.parseFloat(itemXField.getText()),
                    Float.parseFloat(itemYField.getText()),
                    Float.parseFloat(itemLengthField.getText()),
                    Float.parseFloat(itemWidthField.getText()),
                    Float.parseFloat(itemHeightField.getText()),
                    new Rectangle(),
                    new Text()
            );
            Rectangle rect = drawPerimeter(values);
            values.setPerimeter(rect);
            values.setLabel(addLabel(values));

            newBuilding.set(values);
            newItemDialog.close();
        });
        Font font = Font.font("verdana", FontWeight.MEDIUM, FontPosture.REGULAR, 12);
        txt.setFont(font);
        Label nameLabel = new Label("Name");
        Label priceLabel = new Label("Price");
        Label marketValueLabel = new Label("Market Value");
        Label xLabel = new Label("X Coordinate");
        Label yLabel = new Label("Y Coordinate");
        Label lengthLabel = new Label("Length");
        Label widthLabel = new Label("Width");
        Label heightLabel = new Label("Height");

        GridPane fieldPane = new GridPane();
        fieldPane.add(txt,0,0);
        fieldPane.add(nameLabel, 0,1);
        fieldPane.add(priceLabel, 0,2);
        fieldPane.add(marketValueLabel, 0,3);
        fieldPane.add(xLabel, 0,4);
        fieldPane.add(yLabel, 0,5);
        fieldPane.add(lengthLabel, 0,6);
        fieldPane.add(widthLabel, 0,7);
        fieldPane.add(heightLabel, 0,8);
        fieldPane.add(itemNameField,1,1);
        fieldPane.add(itemPriceField,1,2);
        fieldPane.add(itemMarketValueField,1,3);
        fieldPane.add(itemXField,1,4);
        fieldPane.add(itemYField,1,5);
        fieldPane.add(itemLengthField,1,6);
        fieldPane.add(itemWidthField,1,7);
        fieldPane.add(itemHeightField,1,8);
        fieldPane.add(acceptButton, 0,10);
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
    public Button scanDroneButton;

    @FXML
    private Button visitDroneButton;

    @FXML
    public Pane root;

    @FXML
    private TreeView itemTree;

    @FXML
    private Label priceLabel;

    @FXML
    private Label marketValueLabel;

    @FXML
    public void handleMouseClicked(MouseEvent mouseEvent) {
        currentAction = itemOptions.getSelectionModel().getSelectedItem();
        if (currentAction == "Item Root Commands"){
        }
        if (currentAction == "Add Item"){
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            createItem();
            try {
                if (selection.getValue() instanceof FarmBuilding) {
                    ((FarmBuilding) selection.getValue()).addItem(newFarmItem);
                } else {
                    farmObjects.add(newFarmItem);
                }
            } catch(NullPointerException e){
                farmObjects.add(newFarmItem);
            }

        }

        if (currentAction == "Add Item Container"){
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            createContainer();
            try {
                if (selection.getValue() instanceof FarmBuilding) {
                    ((FarmBuilding) selection.getValue()).addItemContainer(newFarmBuilding);
                } else {
                    farmObjects.add(newFarmBuilding);
                }
            } catch (NullPointerException e){
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
                    FarmBuilding fb = (FarmBuilding) target;
                    mapview.getChildren().remove(fb.getLabel());
                    mapview.getChildren().remove(fb.getPerimeter());
                    return;
                }
                if (((FarmBuilding) obj).getItems().contains(target)){
                    ((FarmBuilding) obj).deleteItem((Item) target);
                    FarmItem fb = (FarmItem) target;
                    mapview.getChildren().remove(fb.getLabel());
                    mapview.getChildren().remove(fb.getPerimeter());
                    return;
                }
                if (((FarmBuilding) obj).getItemContainers() != null) {
                    findObjectAndDelete(((FarmBuilding) obj).getItemContainers(), target);
                }
            }
            if(obj.equals(target) && target instanceof FarmBuilding) {
                /* Delete children shapes */
                FarmBuilding fb = (FarmBuilding) obj;

                for (ItemContainer child: fb.getItemContainers()){
                    mapview.getChildren().remove(((FarmBuilding) child).getPerimeter());
                    mapview.getChildren().remove(((FarmBuilding) child).getLabel());
                }

                for (Item child: fb.getItems()){
                    mapview.getChildren().remove(((FarmItem) child).getPerimeter());
                    mapview.getChildren().remove(((FarmItem) child).getLabel());
                }
                mapview.getChildren().remove(((FarmBuilding) target).getPerimeter());
                mapview.getChildren().remove(((FarmBuilding) target).getLabel());
                farm_arr.remove(target);
                return;

            } else if(obj.equals(target) && target instanceof FarmItem){
                mapview.getChildren().remove(((FarmItem) target).getPerimeter());
                mapview.getChildren().remove(((FarmItem) target).getLabel());
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
        MenuItem marketValue = new MenuItem("Change Market Value");

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
                    mapview.getChildren().remove(((FarmItem) selection.getValue()).getLabel());

                    ((FarmItem) selection.getValue()).changeLength(Float.parseFloat(length.getText()));
                    ((FarmItem) selection.getValue()).changeWidth(Float.parseFloat(width.getText()));
                    ((FarmItem) selection.getValue()).changeHeight(Float.parseFloat(height.getText()));

                    Rectangle newRect = drawPerimeter((FarmItem) selection.getValue());
                    ((FarmItem) selection.getValue()).setPerimeter(newRect);
                    ((FarmItem) selection.getValue()).setLabel(addLabel((FarmItem) selection.getValue()));

                }
                if (selection.getValue() instanceof FarmBuilding) {

                    mapview.getChildren().remove(((FarmBuilding) selection.getValue()).getPerimeter());
                    mapview.getChildren().remove(((FarmBuilding) selection.getValue()).getLabel());


                    ((FarmBuilding) selection.getValue()).changeLength(Float.parseFloat(length.getText()));
                    ((FarmBuilding) selection.getValue()).changeWidth(Float.parseFloat(width.getText()));
                    ((FarmBuilding) selection.getValue()).changeHeight(Float.parseFloat(height.getText()));

                    Rectangle newRect = drawPerimeter((FarmBuilding) selection.getValue());
                    ((FarmBuilding) selection.getValue()).setPerimeter(newRect);
                    ((FarmBuilding) selection.getValue()).setLabel(addLabel((FarmBuilding) selection.getValue()));

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

        marketValue.setOnAction(event -> {
            TreeItem selection = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            TextInputDialog inputDialog = new TextInputDialog();
            if (selection.getValue() instanceof FarmItem) {
                inputDialog.setTitle("Edit");
                inputDialog.setHeaderText(null); // Remove the header text
                inputDialog.setContentText("New Market Value:");
                inputDialog.setGraphic(null); // Remove the icon
                String result = inputDialog.showAndWait().get();
                ((FarmItem) selection.getValue()).setMarketValue(Float.parseFloat(result));
            }
            if (selection.getValue() instanceof FarmBuilding) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Can't change a Building's market value!");
                alert.showAndWait();            }
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
                FarmItem select = (FarmItem) selection.getValue();
                select.changeName(result);
                mapview.getChildren().remove(select.getLabel());
                select.setLabel(addLabel(select));
            }
            if (selection.getValue() instanceof FarmBuilding) {
                FarmBuilding select = (FarmBuilding) selection.getValue();
                select.changeName(result);
                mapview.getChildren().remove(select.getLabel());
                select.setLabel(addLabel(select));
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
                    mapview.getChildren().remove(((FarmItem) selection.getValue()).getLabel());

                    ((FarmItem) selection.getValue()).changeLocationX(Float.parseFloat(x.getText()));
                    ((FarmItem) selection.getValue()).changeLocationY(Float.parseFloat(y.getText()));


                    Rectangle newRect = drawPerimeter((FarmItem) selection.getValue());
                    ((FarmItem) selection.getValue()).setPerimeter(newRect);
                    ((FarmItem) selection.getValue()).setLabel(addLabel((FarmItem) selection.getValue()));
                }
                if (selection.getValue() instanceof FarmBuilding) {

                    mapview.getChildren().remove(((FarmBuilding) selection.getValue()).getPerimeter());
                    mapview.getChildren().remove(((FarmBuilding) selection.getValue()).getLabel());

                    ((FarmBuilding) selection.getValue()).changeLocationX(Float.parseFloat(x.getText()));
                    ((FarmBuilding) selection.getValue()).changeLocationY(Float.parseFloat(y.getText()));

                    Rectangle newRect = drawPerimeter((FarmBuilding) selection.getValue());
                    ((FarmBuilding) selection.getValue()).setPerimeter(newRect);
                    ((FarmBuilding) selection.getValue()).setLabel(addLabel((FarmBuilding) selection.getValue()));
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

        contextMenu.getItems().addAll(rename, location, price, dimensions, delete, marketValue);
        itemTree.setContextMenu(contextMenu);
    }

    public void handleTreeClick(TreeItem i){
        MarketPriceCalculator calculator = new MarketPriceCalculator();
        FarmObject obj = (FarmObject) i.getValue();
        obj.accept(calculator);

        priceLabel.setText("Purchase Price: " + calculator.getPrice());
        marketValueLabel.setText("Market Value: " + calculator.getMarketValue());
    }
    public void configureTreeListener(TreeView t) {
        t.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue != null) {
                handleTreeClick((TreeItem) newValue);
            }
        });

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList optionList = new ArrayList<>();
        optionList.add("Add Item Container");
        optionList.add("Add Item");
        itemOptions.getItems().addAll(optionList.get(0), optionList.get(1));


        // Init item tree root
        rootItem.setValue("root");

        // Sets root for Item Tree
        itemTree.setRoot(rootItem);

        ImageView droneImage = new ImageView(new Image("/drone.png"));
        droneImage.setX(15);
        droneImage.setY(15);

        configureContextMenu();
        configureTreeListener(itemTree);
        FarmBuilding commandCenter = new FarmBuilding("Command Center", 2000, 0, 0, 0, 100, 100, 100, new Rectangle(), new Text());
        Rectangle rect = drawPerimeter(commandCenter);
        commandCenter.setLabel(addLabel(commandCenter));
        commandCenter.setPerimeter(rect);

        Drone drone = Drone.getInstance();
        drone.setName("Drone");
        drone.setPrice(2);
        drone.setX((float) droneImage.getX());
        drone.setY((float) droneImage.getY());
        drone.setLength((float) droneImage.getImage().getHeight());
        drone.setWidth((float) droneImage.getImage().getWidth());
        drone.setHeight(2);
        drone.setRectangle(new Rectangle());
        drone.setImage(droneImage);

        //Drone drone = new Drone("Drone",2,(float) droneImage.getX(),(float) droneImage.getY(),(float) droneImage.getImage().getHeight(),(float) droneImage.getImage().getWidth(),2, new Rectangle(), droneImage);
        commandCenter.addItem(drone);
        farmObjects.add(commandCenter);

        mapview.getChildren().addAll(drone.getImage());

        scanDroneButton.setOnAction(event -> {
            final Logger logger = Logger.getGlobal();
            final ConsoleHandler handler = new ConsoleHandler();
            logger.addHandler(handler);
            logger.setUseParentHandlers(false);
            logger.setLevel(Level.FINE);
            handler.setLevel(Level.FINE);

            logger.info("start");
            ScanFarm scan = new ScanFarm();
            scan.execute();
        });

        // Button Handlers
        scanImageButton.setOnAction(event -> {

            double sceneWidth = mapview.getWidth();
            double sceneHeight = mapview.getHeight();
            double droneWidth = drone.getImage().getLayoutBounds().getWidth();
            double droneHeight = drone.getImage().getLayoutBounds().getHeight();
            double y = sceneHeight - droneHeight - 15;
            double x = 72;

            SequentialTransition sequence = new SequentialTransition();
            Duration moveDuration = Duration.seconds(0.5);
            Duration endDuration = Duration.seconds(0.25);

            drone.getImage().setRotate(0);
            drone.getImage().setX(0);

            for(int i =0; i <= 5; i++) {
                if(i == 5){

                    KeyValue endDownKV_Y = new KeyValue(drone.getImage().translateYProperty(), y);
                    KeyFrame endDownKF = new KeyFrame(moveDuration, endDownKV_Y);

                    KeyValue rotateDroneUp = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() - 90);
                    KeyFrame turnUp = new KeyFrame(endDuration, rotateDroneUp);

                    KeyValue returnXHome = new KeyValue(drone.getImage().translateXProperty(), 15);
                    KeyValue returnYHome = new KeyValue(drone.getImage().translateYProperty(), 0);
                    KeyValue pointHome = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() + 45);
                    KeyValue resetTurn = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate());

                    KeyFrame resetRotation = new KeyFrame(endDuration, resetTurn);
                    KeyFrame returnCoords = new KeyFrame(moveDuration, pointHome, returnXHome, returnYHome);

                    Timeline moveDown = new Timeline(endDownKF);
                    Timeline rotateUp = new Timeline(turnUp);
                    Timeline returnHome = new Timeline(returnCoords);
                    Timeline reset = new Timeline(resetRotation);

                    sequence.getChildren().addAll(moveDown, rotateUp, returnHome, reset);
                    break;
                }
                KeyValue rotateDroneDown = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() + 90);
                KeyFrame turnDown = new KeyFrame(endDuration, rotateDroneDown);

                KeyValue endDownKV_Y = new KeyValue(drone.getImage().translateYProperty(), y);
                KeyFrame endDownKF = new KeyFrame(moveDuration, endDownKV_Y);

                KeyValue rotateDroneRight = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate());
                KeyFrame turnRight = new KeyFrame(endDuration, rotateDroneRight);

                KeyValue moveRightKV = new KeyValue(drone.getImage().translateXProperty(), x);
                KeyFrame moveRightKF = new KeyFrame(endDuration, moveRightKV);

                KeyValue rotateDroneUp = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() - 90);
                KeyFrame turnUp = new KeyFrame(endDuration, rotateDroneUp);

                KeyValue moveUpKV = new KeyValue(drone.getImage().translateYProperty(), 0);
                KeyFrame moveUpKF = new KeyFrame(moveDuration, moveUpKV);

                x = x + 72;

                KeyValue moveRightSecondKV = new KeyValue(drone.getImage().translateXProperty(), x);
                KeyFrame moveRightSecondKF = new KeyFrame(endDuration, moveRightSecondKV);

                Timeline rotateDown = new Timeline(turnDown);
                Timeline moveDown = new Timeline(endDownKF);
                Timeline rotateRight = new Timeline(turnRight);
                Timeline moveRight = new Timeline(moveRightKF);
                Timeline rotateUp = new Timeline(turnUp);
                Timeline moveUp = new Timeline(moveUpKF);
                Timeline rotateRightSecond = new Timeline(turnRight);
                Timeline moveRightSecond = new Timeline(moveRightSecondKF);
                Timeline rotateDownSecond = new Timeline(turnDown);

                sequence.getChildren().addAll(rotateDown,
                        moveDown,
                        rotateRight,
                        moveRight,
                        rotateUp,
                        moveUp,
                        rotateRightSecond,
                        moveRightSecond,
                        rotateDownSecond);
                x = x + 72;
            }
            sequence.play();
        });

        visitImageButton.setOnAction(event -> {
            double droneStartX = drone.getImage().getLayoutX();
            double droneStartY = drone.getImage().getLayoutY();

            TreeItem selectedItem = (TreeItem) itemTree.getSelectionModel().getSelectedItem();
            double x = 0;
            double y = 0;

            Duration moveDuration = Duration.seconds(0.5);
            Duration endDuration = Duration.seconds(0.25);

            if (selectedItem.getValue() instanceof FarmBuilding fb){
                x = ((fb.getLocationX() + (fb.getLocationX() + fb.getWidth()))/2) - 50;
                y = ((fb.getLocationY() + (fb.getLocationY() + fb.getHeight()))/2)- 50;
            }

            if (selectedItem.getValue() instanceof FarmItem fi){
                x = ((fi.getLocationX() + (fi.getLocationX() + fi.getWidth()))/2) - 50;
                y = ((fi.getLocationY() + (fi.getLocationY() + fi.getHeight()))/2)- 50;
            }

            VisitItem visit = new VisitItem();
            visit.execute(drone, x ,y);

            KeyValue moveXKV = new KeyValue(drone.getImage().translateXProperty(), x);
            KeyFrame moveXKF = new KeyFrame(moveDuration, moveXKV);

            KeyValue rotateYDown = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() + 90);
            KeyFrame rotateDown = new KeyFrame(endDuration, rotateYDown);

            KeyValue moveYKV = new KeyValue(drone.getImage().translateYProperty(), y);
            KeyFrame moveYKF = new KeyFrame(moveDuration, moveYKV);

            KeyValue rotateXRight = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate());
            KeyFrame rotateRight = new KeyFrame(endDuration, rotateXRight);

            Timeline moveX = new Timeline(moveXKF);
            Timeline turnDown = new Timeline(rotateDown);
            Timeline moveY = new Timeline(moveYKF);
            Timeline resetRotation = new Timeline(rotateRight);

            SequentialTransition sequence = new SequentialTransition(moveX,turnDown, moveY, resetRotation);

            sequence.setCycleCount(1);
            sequence.play();
        });

        homeButton.setOnAction(event -> {

            GoHome home = new GoHome();
            home.execute(drone);

            drone.getImage().setRotate(0);

            Duration moveDuration = Duration.seconds(1);
            Duration endDuration = Duration.seconds(0.5);

            KeyValue returnXHome = new KeyValue(drone.getImage().translateXProperty(), 0);
            KeyValue returnYHome = new KeyValue(drone.getImage().translateYProperty(), 0);
            KeyValue pointHome = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() - 135);
            KeyValue resetTurn = new KeyValue(drone.getImage().rotateProperty(), drone.getImage().getRotate() + 0);

            KeyFrame turnForHome = new KeyFrame(endDuration, pointHome);
            KeyFrame returnCoords = new KeyFrame(moveDuration, returnXHome, returnYHome);
            KeyFrame resetRotation = new KeyFrame(endDuration, resetTurn);

            Timeline prepareForHome = new Timeline(turnForHome);
            Timeline goHome = new Timeline(returnCoords, resetRotation);
            Timeline reset = new Timeline(resetRotation);

            SequentialTransition sequence = new SequentialTransition(prepareForHome,goHome, reset);
            sequence.play();
        });

        rootItem.getChildren().clear();
        for(FarmObject i: farmObjects){
            TreeItem node = buildTree(i);
            rootItem.getChildren().add(node);
        }
    }

}
