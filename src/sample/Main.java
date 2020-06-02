package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

        private double x,y;
        @Override

        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("Dropdown.fxml"));
            primaryStage.initStyle(StageStyle.UNDECORATED);

            root.setOnMousePressed(mouseEvent -> {
                        x = mouseEvent.getSceneX();
                        y = mouseEvent.getSceneY();
                    }
            );
            root.setOnMouseDragged(mouseEvent -> {
                primaryStage.setX(mouseEvent.getSceneX() - x);
                primaryStage.setY(mouseEvent.getSceneY() - y);
            });

            Scene scene = new  Scene(root);
            scene.getStylesheets().add(Main.class.getResource("Combobox.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
 }
