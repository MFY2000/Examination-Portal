package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.util.ArrayList;

public class AlertWindow {

        public static void starter(int noOfQuestion){
//            ArrayList<String> Question = new ArrayList<String>(4);
//            Question.add("Q1: This is Question number one");
//            Question.add("Q2: This is Question number two");
//            Question.add("Q3: This is Question number three");

            for(int i=0;i<noOfQuestion;i++){
                display(i);
            }

        }

        public static String QuestionBanks(int number){

           return "";
        }

        public static void display( int noOfQuestion) {
            Stage window = new Stage();
            Label label;
            Button Next,Previous;


            window.initModality(Modality.WINDOW_MODAL);

            label = new Label();
            VBox layout = new VBox(300);
            HBox hbButtons = new HBox(300);

            GridPane grid = new GridPane();
            grid.setHgap(10);
            grid.setVgap(12);

                label.setText("Q"+noOfQuestion);
                Next = new Button("Next");
                Next.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        window.close();
                    }
                });
                Previous = new Button("Previous");

                hbButtons.getChildren().addAll(Next, Previous);
                grid.add(hbButtons, 0, 2, 2, 1);

                layout.getChildren().addAll(label, hbButtons);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.initStyle(StageStyle.UTILITY);
                window.setScene(scene);
                window.showAndWait();
        }

    }