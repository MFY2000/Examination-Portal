package Exam_System;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class StudentPlane {

    @FXML
    private AnchorPane ExamShowPane;

    public void PopUpExxam(ActionEvent event) {

    }

    public void QuizDisplay(ActionEvent event) throws IOException {
            AnchorPane pane3 = FXMLLoader.load(getClass().getResource("FXML/Dropdown.fxml"));
            ExamShowPane.getChildren().setAll(pane3);
        }

    }