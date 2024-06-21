module com.example.assignment001 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment001 to javafx.fxml;
    exports com.example.assignment001;
}