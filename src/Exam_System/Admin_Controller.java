package Exam_System;


import Exam_System.db.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class Admin_Controller{
    @FXML
    private Admin_Controller PopController;
    @FXML
    private AnchorPane rootgride;

    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;
    @FXML
    private AnchorPane ExamShowPane;
    @FXML
    public void login(ActionEvent event) throws SQLException, IOException {

        Window owner = submitButton.getScene().getWindow();
        // Parent pane1 = FXMLLoader.load(getClass().getResource("sample.fxml"));

        System.out.println(emailIdField.getText());
        System.out.println(passwordField.getText());

        if(emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String emailId = emailIdField.getText();
        String password = passwordField.getText();

        jdbcDao jdbcDao = new jdbcDao();
        boolean flag = jdbcDao.validate(emailId, password);

        if(!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        }else {
            infoBox("Login Successful!", null, "Failed");
            AnchorPane pane2 = FXMLLoader.load(getClass().getResource("FXML/admin_pannel.fxml"));
            rootgride.getChildren().setAll(pane2);
        }
    }
//    public void secondStage(){
//
//    }

    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void ADMIN_CALLER(ActionEvent actionEvent) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("FXML/login_form.fxml"));
        rootgride.getChildren().setAll(pane1);
    }

    public void CloseApp(ActionEvent actionEvent)throws Exception{
        Window owner = submitButton.getScene().getWindow();
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
        System.exit(1);
    }

    public void PopUpExxam(ActionEvent actionEvent) throws IOException {
          AnchorPane pane3 = FXMLLoader.load(getClass().getResource("FXML/Exam_Insertion.fxml"));
          ExamShowPane.getChildren().setAll(pane3);
    }


}


