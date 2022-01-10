package app.gui_hmi;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void Up(ActionEvent e) {
        System.out.println("Up pressed");
    }
    public void Down(ActionEvent e) {

        System.out.println("Down pressed");
    }

    public void switchToElevator(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Elevator.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAdmin(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



/*    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }*/
}