module com.example.w22comp1008lhw3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.w22comp1008lhw3 to javafx.fxml;
    exports com.example.w22comp1008lhw3;
}