package Exam_System;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ResultTable extends Application {
    private String SNO;
    private String UserID;
    private String QuizName;
    private String Total;
    private String Correct;
    private String Time;

//    public ResultTable(String SNO, String UserID, String QuizName, String Total, String Correct, String Time){
//        this.setSNO(SNO);
//        this.setUserID(UserID);
//        this.setQuizName(QuizName);
//        this.setTotal(Total);
//        this.setCorrect(Correct);
//        this.setTime(Time);
//    }
//
//    public ResultTable(String laptop, String v, String i) {
//        this.setSNO(laptop);
//        this.setUserID(v);
//        this.setQuizName(i);
//    }

    public String getSNO() {
        return SNO;
    }

    public void setSNO(String SNO) {
        this.SNO = SNO;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getQuizName() {
        return QuizName;
    }

    public void setQuizName(String quizName) {
        QuizName = quizName;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getCorrect() {
        return Correct;
    }

    public void setCorrect(String correct) {
        Correct = correct;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public static void main(String[] args) throws Exception {launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXML/ResultVeiws.fxml"));
        Scene scene = new  Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}