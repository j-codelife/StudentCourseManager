module edu.farmingdale.csc311 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.farmingdale.csc311 to javafx.fxml;
    exports edu.farmingdale.csc311;
}
