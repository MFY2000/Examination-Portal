package Exam_System;

// Java program to create a label
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Cheating{

    // launch the application
    public void start()
    {
        Stage s = new Stage();
        s.setTitle("Cheating");
        Label b = new Label("You are Cheating Your Quiz is close");
        StackPane r = new StackPane();
        r.getChildren().add(b);
        Scene sc = new Scene(r, 200, 200);
        s.setScene(sc);

        s.show();
    }
}