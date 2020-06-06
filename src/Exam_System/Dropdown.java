package Exam_System;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Dropdown implements Initializable {
    ObservableList<String> ChoiceList;
    public ComboBox combobox;
    @FXML
    AnchorPane pinbox = new AnchorPane();
    @FXML
    PasswordField pincode = new PasswordField();

    private Connection con;
    private Statement sc;
    private ResultSet res;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        databaseChoicelist();
        combobox.setItems(ChoiceList);
        combobox.setValue("Feild");
    }

    private void databaseChoicelist(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/database_choicelist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            sc = con.createStatement();
            showdata();
        }
        catch (Exception e){
            System.out.println("Error : "+e);
        }
        System.out.println("123");
    }

    private void showdata(){
        List<String> Feild = new ArrayList<String>();

        try {
            String query = "select * from subjectlist";
            res = sc.executeQuery(query);

            while (res.next()){
                Feild.add(res.getString("Field"));
            }}
        catch (Exception e){
            System.out.println("Error : "+e);
        }
        ChoiceList = FXCollections.observableArrayList(Feild);
    }

    public void EnterPin(ActionEvent event){
      pinbox.setVisible(true);
    }

    public void checkingPin(ActionEvent event){

            String query = "SELECT * FROM `subjectlist` WHERE `Field` LIKE "+'"'+combobox.getValue()+'"'+" ";
        try {
            res = sc.executeQuery(query);
            res.next();
            String pin = res.getString("Pincode");

            if (pin.equals(pincode.getText())){
                System.out.println("Welcome");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }





}
