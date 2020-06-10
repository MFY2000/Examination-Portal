package Exam_System;

// local files
import Exam_System.db.jdbcDao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

public class LoginController {
//main plane
    @FXML public AnchorPane main_plane;


    public AnchorPane QuizPlane;
    public Label QuestionNo;
    public Label timer;
    public Label question;
    public RadioButton B;
    public RadioButton D;
    public RadioButton A;
    public RadioButton C;
    @FXML public Button Submit;


    public AnchorPane QuizDetials;
    public Label QuizName;
    public Label QuizTime;
    public Label QuizNo;

    @FXML private AnchorPane Plane;
    @FXML
    public AnchorPane dropdown;
    @FXML private ComboBox combobox;
    @FXML private AnchorPane pinbox;
    @FXML private PasswordField pincode;

    @FXML
    public AnchorPane ExamShowPane;
    @FXML private Label nameOFUser;

    @FXML private AnchorPane rootgride;
    @FXML private TextField emailIdField;
    @FXML private PasswordField passwordField;
    @FXML public Button submitButton;

    // Local varaible
    private ObservableList<String> ChoiceList;

    private ArrayList<Integer> QuestionNumber;
    private ArrayList<String> QuestionAnswer;
    private ArrayList<String> RealAnswer = new ArrayList<String>();
    private int QNO = 0;
    ToggleGroup tgGroup;

    private jdbcDao jdb = new jdbcDao();

    @FXML private void login(ActionEvent event)  throws SQLException, IOException,Exception {

        Window owner = submitButton.getScene().getWindow();

        if(emailIdField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if(passwordField.getText().isEmpty()) {
            showAlert(AlertType.ERROR, owner, "Form Error!",
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
            Plane.setOpacity(100);
            Plane.setDisable(false);

            AnchorPane Plane1 = FXMLLoader.load(getClass().getResource("FXML/Student_plane.fxml"));
//            rootgride.getChildren().setAll((Collection<? extends Node>) null);
//            main_plane.getChildren().remove(rootgride);
            rootgride.setOpacity(0);
            rootgride.setDisable(true);



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

    @FXML private void ADMIN_CALLER(ActionEvent actionEvent) throws IOException {
        AnchorPane pane1 = FXMLLoader.load(getClass().getResource("FXML/Admin.fxml"));
        rootgride.getChildren().setAll(pane1);
    }

    @FXML private void CloseApp(ActionEvent actionEvent)throws Exception{
        Window owner = submitButton.getScene().getWindow();
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
        System.exit(1);
    }

    public void PopUpExxam(ActionEvent event) {

    }

    public void QuizDisplay(ActionEvent event) throws IOException {
//        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("FXML/Dropdown.fxml"));
//        ExamShowPane.getChildren().setAll(pane3);
        ExamShowPane.setOpacity(0);
        ExamShowPane.setDisable(true);

        dropdown.setOpacity(100);
        dropdown.setDisable(false);
        feildEnter();
    }

    public void feildEnter(){
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
            // to change the the plane
            Plane.setDisable(true);
            Plane.setOpacity(0);
            QuizDetials.setOpacity(100);
            QuizDetials.setDisable(!true);
            //
            QuizDetailPlane();
        }
    }

    public void QuizDetailPlane(){
        QuizName.setText(jdb.getQuizSelete());
        QuizNo.setText(jdbcDao.getQuizNoofAttemt());
        QuizTime.setText(jdbcDao.getQuizTime());
        getQuestionList();
    }

    public void getQuestionList() {
        QuestionNumber = (new Randommy(jdbcDao.getTotalQuizQuestion(),jdbcDao.getQuizNoofAttemt())).getRandomArray();// direct create call and get the value
        for (int i = 0; i < QuestionNumber.size(); i++) {
            System.out.println(QuestionNumber.get(i));
        }
    }

    public void NextQuestion() throws InterruptedException {
        System.out.println("Starting the Quiz");
        int temp = Integer.parseInt(jdbcDao.getQuizNoofAttemt());
        if(QNO == temp-1){
            Submit.setText("Submit Quiz");
            Submit.setOnAction(event -> Submit_CheckAnswer(event));
        }
        if (temp > QNO){
            QuestionAnswer = new ArrayList<String>();
            QuestionAnswer = jdb.getQuizDetails(QuestionNumber.get(QNO));
            RealAnswer.add(QuestionAnswer.get(5));
            setQuestion();
        }
        else {

        }
    }

    public void setQuestion() {
        QuizNo.setText(" " +QNO);
        question.setText("Q ."+QuestionAnswer.get(0));
        A.setText("A) "+QuestionAnswer.get(1));
        B.setText("B) "+QuestionAnswer.get(2));
        C.setText("C) "+QuestionAnswer.get(3));
        D.setText("D) "+QuestionAnswer.get(4));

        A.getText().substring(4);
        B.getText().substring(4);
        C.getText().substring(4);
        D.getText().substring(4);

        A.setSelected(false);
        B.setSelected(false);
        C.setSelected(false);
        D.setSelected(false);

    }

    ArrayList<Character> Answer = new ArrayList<Character>();

    public void Selected(){
        char selete = ' ';

            if(A.isSelected())
                selete = 'A';

            else if(B.isSelected())
                selete = 'B';


            else if(C.isSelected())
                selete = 'C';

            else if(D.isSelected()) {
                selete = 'D';
            }
            Answer.add((QNO),selete);
        System.out.println(selete);
    }

    public void StartQuiz(ActionEvent event) throws InterruptedException {
        tgGroup = new ToggleGroup();
        A.setToggleGroup(tgGroup);
        B.setToggleGroup(tgGroup);
        C.setToggleGroup(tgGroup);
        D.setToggleGroup(tgGroup);

        QuizDetials.setOpacity(0);
        QuizDetials.setDisable(true);

        QuizPlane.setDisable(false);
        QuizPlane.setOpacity(100);

        NextQuestion();
    }

    public void SubmitNextQuestion() throws InterruptedException {
        QuestionAnswer.clear();
        Selected();
        QNO++;
        NextQuestion();
    }

    public void Submit_CheckAnswer(ActionEvent event){
        
    }

}
