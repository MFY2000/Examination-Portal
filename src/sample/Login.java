package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;


public class Login {
    public void check() throws Exception{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root, 804, 476));
        stage.show();
    }
    public static void display() {
        launch();
    }


}
