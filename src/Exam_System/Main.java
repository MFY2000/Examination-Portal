package Exam_System;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

        root.setOnMouseDragged(mouseEvent -> {
            double x = mouseEvent.getSceneX();
            double y = mouseEvent.getSceneY();

            System.out.println(x+""+y);
        });

        root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();

               if (bounds.getWidth() < x) {
                    System.out.println("hello");
                    primaryStage.close();
               }

            }
        );

        root.setOnMouseDragged(mouseEvent -> {
            if (bounds.getWidth() < x) {
                System.out.println("hello");
                primaryStage.close();
            }

            if (bounds.getWidth() > x){//do all the thing
                System.out.println("hello2");
                primaryStage.close();
            }
        });


        Scene scene = new  Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
