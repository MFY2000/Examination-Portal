package Exam_System;

import Exam_System.db.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Dropdown implements Initializable {
    ObservableList<String> ChoiceList;
    public ComboBox combobox;
    @FXML
    AnchorPane pinbox = new AnchorPane();
    @FXML
    PasswordField pincode = new PasswordField();

    jdbcDao jdb = new jdbcDao();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> Feild = jdb.displayFeildList();
        ChoiceList = FXCollections.observableArrayList(Feild);
        combobox.setItems(ChoiceList);
        combobox.setValue("Feild");
    }

    public void EnterPin(ActionEvent event) {
        pinbox.setVisible(true);
    }

    public void checkingPin(ActionEvent event) {

        if (jdb.checkPin(pincode.getText(), (String) combobox.getValue())){
            System.out.println("Welcome ");
        }
    }
}
