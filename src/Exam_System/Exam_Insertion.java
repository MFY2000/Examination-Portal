package Exam_System;


import java.sql.SQLException;
import java.util.Optional;

import Exam_System.db.jdbcDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class Exam_Insertion {

    public TextField Question;
    @FXML
    public TextField option1;
    @FXML
    public TextField option2;
    @FXML
    public TextField option3;
    @FXML
    public TextField option4;
    @FXML
    public TextField answer;
    @FXML
    private Button submitButton;
    @FXML
    public void register(ActionEvent event) throws SQLException{

        Window owner = submitButton.getScene().getWindow();

        System.out.println(Question.getText());
        System.out.println(option1.getText());
        System.out.println(option2.getText());
        System.out.println(option3.getText());
        System.out.println(option4.getText());
        System.out.println(answer.getText());
        if(Question.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your Question");
            return;
        }

        if(option1.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Option 1");
            return;
        }
        if(option2.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Option 2");
            return;
        }
        if(option3.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Option 3");
            return;
        }

        if(option4.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Option 4");
            return;
        }
        if(answer.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter Your Answer");
            return;
        }


        String question = Question.getText();
        String Option_1= option1.getText();
        String Option_2 = option2.getText();
        String Option_3 = option3.getText();
        String Option_4= option4.getText();
        String Answer = answer.getText();

        jdbcDao jdbcDao = new jdbcDao();
        jdbcDao.insertRecord(question,Option_1,Option_2,Option_3,Option_4,Answer);

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!", "Question Inserted");
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}

