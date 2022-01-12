module app.gui_hmi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.paho.client.mqttv3;


    opens app.gui_hmi to javafx.fxml;
    exports app.gui_hmi;
}