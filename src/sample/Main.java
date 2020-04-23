package sample;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	
		
	@Override
	public void start(Stage primaryStage) throws IOException {
		Login mainV = new Login();
		mainV.display(); //call MainView
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
