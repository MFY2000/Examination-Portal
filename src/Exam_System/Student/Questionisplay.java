package Exam_System.Student;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Questionisplay implements Initializable {
    public AnchorPane root2;
    public Label question;
    public Label QuestionNo;
    public Label timer;
    public RadioButton B;
    public RadioButton D;
    public RadioButton A;
    public RadioButton C;
    public ToggleGroup choice;
    private static int minute = 45;
    int Second = 0;
    final static int temp = minute * 60 *60;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        QuestionNo.setText("1");
        question.setText("What did this program may do");
//        timer.setText(""+minute+":"+Second);

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(temp),ae -> doSomething(ae)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void doSomething(ActionEvent ae) {
        System.out.println(""+minute+":"+--Second);
        timer.setText(""+minute+":"+--Second);
    }

    public void NextQuestion(ActionEvent e){

    }

}
