package Exam_System;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;


interface Login_plane {

      void login(ActionEvent event) throws SQLException, IOException,Exception;
      void ADMIN_CALLER(ActionEvent actionEvent) throws IOException, URISyntaxException;
      void CloseApp(ActionEvent actionEvent)throws Exception;
      void QuizDisplay(ActionEvent event) throws IOException;
      void feildEnter();
      void EnterPin(ActionEvent event);
      void checkingPin(ActionEvent event);
      void QuizDetailPlane();
      void getQuestionList();
      void NextQuestion() throws InterruptedException;
      void setQuestion();
      void Selected();
      void StartQuiz(ActionEvent event) throws InterruptedException, SQLException;
      void SubmitNextQuestion() throws InterruptedException;
      void Submit_CheckAnswer(ActionEvent event) throws SQLException;
      void check() throws SQLException;
}
