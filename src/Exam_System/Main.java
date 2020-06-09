package Exam_System;

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
    private double x,y;
    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane root = FXMLLoader.load(getClass().getResource("FXML/MainStage.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight()+100);

        KeyCombination keyCombinationWin1 = new KeyCodeCombination(KeyCode.TAB, KeyCombination.ALT_ANY);
        KeyCombination keyCombinationWin2 = new KeyCodeCombination(KeyCode.WINDOWS, KeyCombination.ALT_ANY);
//        KeyCombination keyCombinationWin3 = new KeyCodeCombination(KeyCode.TAB, KeyCombination.ALT_DOWN);

        root.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            if (keyCombinationWin1.match(event) || keyCombinationWin2.match(event)) {
                System.out.println("hello");
                    primaryStage.close();
            }
        });


//        root.setOnKeyPressed(keyEvent -> {
//            System.out.println(keyEvent.getCode() == KeyCode.CONTROL);
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


    public static void main(String[] args) {
        launch(args);
    }
}
