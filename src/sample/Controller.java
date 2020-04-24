package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // login methods
    public TextField Username;
    public TextField Password;

    @FXML
    public void LoginButton(ActionEvent event){
//        Password.setText("****");
        Password.setVisible(false);
        System.out.println("hello"+Username.getText()+Password.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}