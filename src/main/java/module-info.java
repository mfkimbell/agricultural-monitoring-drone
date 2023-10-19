module dronedashboard {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens dronedashboard to javafx.fxml;
    exports dronedashboard;
}