package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        window = primaryStage;
        window.setTitle("Examination management system");
        window.setWidth(600);

        Label label = new Label();
        label.setText("Examination management system");
        label.setStyle("-fx-font: 24 arial;");
        button = new Button("Start Exam");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
                AlertWindow.starter(20);
            }
        });

        VBox layout = new VBox(600);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

}