package Exam_System;

// local files
import Exam_System.db.jdbcDao;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
    public Button Admin_button;


    @FXML
    private AnchorPane Plane;
    @FXML
    private AnchorPane loginFrame;
    @FXML
    private LoginController PopController;
    @FXML
    private AnchorPane rootgride;
    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    public void login(ActionEvent event)  throws SQLException, IOException,Exception {

        Window owner = submitButton.getScene().getWindow();

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

        jdbcDao jdb = new jdbcDao();
        boolean flag = jdb.validate(emailId, password);

        if(!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        }else {
            infoBox("Login Successful!", null, "Failed");
            AnchorPane Plane1 = FXMLLoader.load(getClass().getResource("FXML/Student_plane.fxml"));
            Plane.getChildren().setAll(Plane1);
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("FXML/Admin.fxml"));
        rootgride.getChildren().setAll(pane1);
    }

    public void CloseApp(ActionEvent actionEvent)throws Exception{
        Window owner = submitButton.getScene().getWindow();
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
        System.exit(1);
    }

}
