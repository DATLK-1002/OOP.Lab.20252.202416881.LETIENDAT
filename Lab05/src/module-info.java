module Lab05 {
    requires javafx.controls;
    requires javafx.fxml;
    
    opens hust.soict.elitech.gui to javafx.fxml;
    opens hust.soict.elitech.aims.gui to javafx.fxml;
}
