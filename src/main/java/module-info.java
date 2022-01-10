module app.gui_hmi {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.gui_hmi to javafx.fxml;
    exports app.gui_hmi;
}