package Exam_System;

// local files
import Exam_System.db.jdbcDao;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.Arrays;
//import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class LoginController{
//main plane
    @FXML public AnchorPane Main_plane;
    @FXML public Button Closebutton;
    @FXML public Button Closebutton2;

    @FXML public AnchorPane Quiz_plane;
    @FXML public Label QuestionNo;
    @FXML public Label QuizTimer;
    @FXML public Label question;
    @FXML public RadioButton B;
    @FXML public RadioButton D;
    @FXML public RadioButton A;
    @FXML public RadioButton C;
    @FXML public Button Submit;


    public AnchorPane Result_plane;
    public Label correctAnswer;
    public Label wrongAnswer;
    public Label TotalAnswer;
    public Label Percentage;


    public AnchorPane Details_plane;
    public Label QuizName;
    public Label QuizTime;
    public Label QuizNo;

    @FXML private AnchorPane Student_plane;

    @FXML public AnchorPane Course_plane;
    @FXML private ComboBox combobox;
    @FXML private AnchorPane pinbox;
    @FXML private PasswordField pincode;

    @FXML public AnchorPane ExamShowPane;
    @FXML private Label nameOFUser;

    @FXML private AnchorPane Login_plane;
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
    ArrayList<Character> Answer;


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
            Student_plane.setOpacity(100);
            Student_plane.setDisable(false);

//            AnchorPane Plane1 = FXMLLoader.load(getClass().getResource("FXML/Student_plane.fxml"));
//            Login_plane.getChildren().setAll((Collection<? extends Node>) null);
//            main_plane.getChildren().remove(Login_plane);
            Login_plane.setOpacity(0);
            Login_plane.setDisable(true);



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
        Login_plane.getChildren().setAll(pane1);
    }

    @FXML private void CloseApp(ActionEvent actionEvent)throws Exception{
        Window owner = submitButton.getScene().getWindow();
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please enter a password");
        System.exit(1);
    }

    public void PopUpExxam(ActionEvent event) {

    }

    public void QuizDisplay(ActionEvent event) throws IOException {
//        AnchorPane pane3 = FXMLLoader.load(getClass().getResource("FXML/Course_plane.fxml"));
//        ExamShowPane.getChildren().setAll(pane3);
        ExamShowPane.setOpacity(0);
        ExamShowPane.setDisable(true);

        Course_plane.setOpacity(100);
        Course_plane.setDisable(false);
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
            Student_plane.setDisable(true);
            Student_plane.setOpacity(0);
            Details_plane.setOpacity(100);
            Details_plane.setDisable(!true);
            //
            QuizDetailPlane();
        }
    }

    public void QuizDetailPlane(){
        QuizName.setText(jdb.getQuizSelete());
        QuizNo.setText(jdbcDao.getQuizNoofAttemt());
        QuizTime.setText(jdbcDao.getQuizTime());
        getQuestionList();
        Answer = new ArrayList<Character>(Integer.parseInt(jdbcDao.getQuizNoofAttemt()));
    }

    public void getQuestionList() {
        QuestionNumber = (new Randommy(jdbcDao.getTotalQuizQuestion(),jdbcDao.getQuizNoofAttemt())).getRandomArray();// direct create call and get the value
        for (int i = 0; i < QuestionNumber.size(); i++) {
            System.out.println(QuestionNumber.get(i));
        }
    }

    public void NextQuestion() throws InterruptedException {
        QuestionNo.setText(String.valueOf(QNO));
        int temp = Integer.parseInt(jdbcDao.getQuizNoofAttemt());
        if(QNO == temp-1){
            Submit.setText("Submit Quiz");
            Submit.setOnAction(event -> {
                try {
                    Submit_CheckAnswer(event);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
        }
        if (temp > QNO){
            QuestionAnswer = new ArrayList<String>();
            QuestionAnswer = jdb.getQuizDetails(QuestionNumber.get(QNO));
            RealAnswer.add(QuestionAnswer.get(5));
            setQuestion();
        }
    }

    public void setQuestion() {
        QuizNo.setText(" " +(QNO+1));
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

        Details_plane.setOpacity(0);
        Details_plane.setDisable(true);

        Quiz_plane.setDisable(false);
        Quiz_plane.setOpacity(100);
        getTime();
        NextQuestion();
    }

    public void SubmitNextQuestion() throws InterruptedException {
        QuestionAnswer.clear();
        Selected();
        QNO++;
        NextQuestion();
    }

    public void Submit_CheckAnswer(ActionEvent event) throws SQLException {
        Quiz_plane.setOpacity(0);
        Quiz_plane.setDisable(true);
        Result_plane.setOpacity(100);
        Result_plane.setDisable(!true);
        QuestionAnswer.clear();
        Selected();
        QNO++;

        check();
    }

    public void check() throws SQLException {
        int temp=0;
        for (int i = 0; i < RealAnswer.size(); i++) {
            if(RealAnswer.get(i).matches(String.valueOf(Answer.get(i)))){
                temp++;
            }
        }
        float temp2 = ((float) temp / (float) QNO);

        correctAnswer.setText(""+temp);
        wrongAnswer.setText(""+(QNO-temp));
        TotalAnswer.setText(""+QNO);
        Percentage.setText(""+(temp2*100));

        GetDate date = new GetDate();
        //
        jdb.insertRecord((""+temp) ,(""+(temp2*100)),date.get());
    }

    private Timeline timeline;
    private Integer horse,minute,timeSeconds;

    public void handleTime() {
        if (timeline != null) {
            timeline.stop();
        }

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);


        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event event) {
                                if (timeSeconds == 1){
                                    if(minute == 0){
                                        try {
                                            CloseApp();
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                        timeline.stop();
                                    }
                                    else{
                                        --minute;
                                        timeSeconds = 60;
                                    }
                                }
                                else
                                    --timeSeconds;


                                // update timerLabel
                                QuizTimer.setText(""+horse+" : "+minute+" : "+timeSeconds);

                            }
                        }));
        timeline.playFromStart();
    }

    public void getTime(){
        horse = 00;
        timeSeconds = 60;
        minute = Integer.parseInt(jdbcDao.getQuizTime());
        handleTime();
    }

    public void CloseApp() throws SQLException {
        int TotalAnswer = Integer.parseInt(jdbcDao.getQuizNoofAttemt());
        int left = TotalAnswer - QNO;
        for (int i = 0; i < left; i++) {
            RealAnswer.add(jdb.getOnlyAnswer(QuestionNumber.get(QNO)));
            Answer.add(' ');
        }
        check();
    }

    @FXML public void minimize(Event evt) {
        Stage stage = (Stage)((Button) evt.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML public void Forget(Event evt) throws Exception {
        MailSender mailSender = new MailSender();
        if (!(emailIdField.getText()).isEmpty()){
            infoBox("We are send send the mail to "+emailIdField.getText()+"@maju.edu.pk","We are send mail","Forget Passwords");
            mailSender.SendMail(emailIdField.getText()+"@maju.edu.pk");
            jdb.forgetPassword(emailIdField.getText(),MailSender.Random);
        }

    }



}
