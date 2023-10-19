module com.example.dronedashboard {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.dronedashboard to javafx.fxml;
    exports com.example.dronedashboard;
}