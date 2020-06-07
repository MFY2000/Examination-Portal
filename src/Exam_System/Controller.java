package Exam_System;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane loginFrame;

    @FXML
    private AnchorPane ExamShowPane;

    @FXML
    private AnchorPane Plane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnchorPane pane1 = null;
        try {
            pane1 = FXMLLoader.load(getClass().getResource("FXML/login_form.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        loginFrame.getChildren().setAll(pane1);

    }

    public void loginSucc(){
        AnchorPane pane1 = null;
        try {
            pane1 = FXMLLoader.load(getClass().getResource("FXML/login_form.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        Plane.getChildren().setAll(pane1);
    }

    public void PopUpExxam(ActionEvent event) {

    }

    public void QuizDisplay(ActionEvent event) throws IOException {
        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("FXML/Dropdown.fxml"));
        ExamShowPane.getChildren().setAll(pane3);
    }

}
