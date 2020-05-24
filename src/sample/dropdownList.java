package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class dropdownList  extends Application {


// Java Program to create a combo Box and add items to it


    // Launch the application
    public void start(Stage stage) {
        stage.setTitle("creating combo box ");
        TilePane r = new TilePane();

        Label description_label = new Label("This is a combo box example ");
        String week_days[] = { "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday" };
        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(week_days));

        Label selected = new Label("default item selected");
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        selected.setText(combo_box.getValue() + " selected");
                    }
                };

        combo_box.setOnAction(event);
        TilePane tile_pane = new TilePane(combo_box, selected);
        Scene scene = new Scene(tile_pane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        // Launch the application
        launch(args);
    }
}
