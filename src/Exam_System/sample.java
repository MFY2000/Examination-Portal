/*
package Exam_System;
//
//
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class sample extends Application {
//
//    // private class constant and some variables
//    private static final Integer STARTTIME = 60;
//    private Timeline timeline;
//    private Label timerLabel = new Label();
//    private Integer timeSeconds = STARTTIME;
//    private Integer horse = 0,minute = 1;
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//
//        // Setup the Stage and the Scene (the scene graph)
//        primaryStage.setTitle("FX Timer");
//        Group root = new Group();
//        Scene scene = new Scene(root, 300, 250);
//
//        // Configure the Label
//        timerLabel.setText(timeSeconds.toString());
//        timerLabel.setTextFill(Color.RED);
//        timerLabel.setStyle("-fx-font-size: 4em;");
//
//        // Create and configure the Button
//        Button button = new Button();
//        button.setText("Start Timer");
//        button.setOnAction(new EventHandler() {
//
//            public void handle(Event event) {
//                if (timeline != null) {
//                    timeline.stop();
//                }
//
//                timeline = new Timeline();
//                timeline.setCycleCount(Timeline.INDEFINITE);
//
//
//                timeline.getKeyFrames().add(
//                        new KeyFrame(Duration.seconds(1),
//                                new EventHandler() {
//                                    @Override
//                                    public void handle(Event event) {
//                                        if (timeSeconds == 1){
//                                            if(minute == 0){
//                                                //CloseApp();
//                                                timeline.stop();
//                                            }
//                                            else{
//                                                --minute;
//                                                timeSeconds = 60;
//                                            }
//                                        }
//                                        else
//                                            --timeSeconds;
//
//
//                                        // update timerLabel
//                                        timerLabel.setText(""+horse+" : "+minute+" : "+timeSeconds);
//
//                                    }
//                                }));
//                timeline.playFromStart();
//            }
//        });
//
//        // Create and configure VBox
//        // gap between components is 20
//        VBox vb = new VBox(20);
//        // center the components within VBox
//        vb.setAlignment(Pos.CENTER);
//        // Make it as wide as the application frame (scene)
//        vb.setPrefWidth(scene.getWidth());
//        // Move the VBox down a bit
//        vb.setLayoutY(30);
//        // Add the button and timerLabel to the VBox
//        vb.getChildren().addAll(button, timerLabel);
//        // Add the VBox to the root component
//        root.getChildren().add(vb);
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//}
//

import java.util.ArrayList;

class Candidate {
    private String Name;
    private int NoOFVote;

    public Candidate(String name, {
        setName(name);
        NoOFVote = 0;
    }

    public int getNoOFVote() {
        return NoOFVote;
    }

    public void setNoOFVote() {
        NoOFVote++;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String toString(){
        return ("Name of the Candidate is: "+getName()+"\nNumber of Vote: "+getNoOFVote());
    }

}

class VotingMachine{
    private ArrayList<Candidate> listOf;

    public VotingMachine(){
        listOf = new ArrayList<Candidate>();
    }

    public void addCandidate(String Candidatename) throws Exception {
        boolean match = false;
        for (int i = 0; i < listOf.size(); i++) {
            match = Candidatename.equals(listOf.get(i).getName()) ? false : true;
        }
        try{// IF cascasvrvssdvvds
            listOf.add(new Candidate(Candidatename));
        }
        catch (Exception e){
            throw e;
        }

    }

    public void castVote(String Candidatename){
        boolean match = false;
        for (int i = 0; i < listOf.size(); i++) {
            if (Candidatename.equals(listOf.get(i).getName())){
                listOf.get(i).setNoOFVote();
            }
        }
    }
}

class Test{
    public void
}

class Quiz4{
    public static void main(String[] args) {

    }
}
*/
