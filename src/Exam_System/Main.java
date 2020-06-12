package Exam_System;


import Exam_System.db.jdbcDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.security.Key;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    // main fxml through all the file are connected
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXML/MainStage.fxml"));// by-defualt method of javafx

        primaryStage.initStyle(StageStyle.UNDECORATED);
//for getting the screen size
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());//
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight()+100);//

        KeyCombination keyCombinationWin1 = new KeyCodeCombination(KeyCode.TAB, KeyCombination.ALT_ANY);
        KeyCombination keyCombinationWin2 = new KeyCodeCombination(KeyCode.WINDOWS, KeyCombination.ALT_ANY);

        root.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            if (keyCombinationWin1.match(event) || keyCombinationWin2.match(event) ||  event.getCode() == KeyCode.WINDOWS || event.getCode() == KeyCode.ALT ) {
                if(jdbcDao.getQuizStart()){
                    System.out.println("Your are doing cheating");
                    primaryStage.close();
//                      Cheating cheat = new Cheating();
//                      cheat
                      }
                else {
                    //w0000ing
                }
                // object of cheating
            }
        });

//        root.setOnKeyPressed(keyEvent -> {
//            if (keyEvent.getCode() == KeyCode.CONTROL){
//                System.out.println("hello");
//                primaryStage.close();
//            }
//        });
//
//        root.setOnMousePressed(mouseEvent -> {
//                x = mouseEvent.getSceneX();
//                y = mouseEvent.getSceneY();
//
//               if (bounds.getWidth() < x) {
//                    System.out.println("hello");
//                    primaryStage.close();
//               }
//
//            }
//        );
//
//        root.setOnMouseDragged(mouseEvent -> {
//            if (bounds.getWidth() < x) {
//                System.out.println("hello");
//                primaryStage.close();
//            }
//
//            if (bounds.getWidth() > x){//do all the thing
//                System.out.println("hello2");
//                primaryStage.close();
//            }
//        });


        Scene scene = new  Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {launch(args); }
}
