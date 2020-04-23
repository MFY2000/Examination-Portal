package sample;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainView {

	ImageView imageV = new ImageView();
	Image main_icon = new Image("Group.png"); //Tech Quiz icon
	static int random_no; //random no variable;
   
   public void setMainView()
   {
	        Stage stage = new Stage();
			AnchorPane root = new AnchorPane();
			root.setId("anPane");
			Scene scene = new Scene(root,640,412);
			scene.getStylesheets().add(getClass().getResource("/CSS/Main.css").toExternalForm());
			
			
			imageV.setImage(main_icon);
			imageV.setFitWidth(249);
			imageV.setFitHeight(112);
			imageV.setLayoutX(192);
			imageV.setLayoutY(119);
			
			Label txt = new Label("Start Your Round");
                        txt.setStyle("-fx-text-fill:#fff; -fx-font-size:22; -fx-font-weight:bold;");
			txt.setLayoutX(245);
			txt.setLayoutY(260);
		   
		
			Button start = new Button("Start");
			start.setId("round1");
			start.setLayoutX(201);
			start.setLayoutY(305);
			start.setPrefWidth(249);
			start.setPrefHeight(50);
			
                        //add action on start and start game
			start.setOnAction(e -> {
//				new JavaQuizView();
				stage.hide();
				System.out.println("The Game is starting");
//				random_no = RandomNumbers.randomFunction();
				
			});			
			
			root.getChildren().addAll(imageV,txt,start);
			
			stage.setScene(scene);
			stage.show();
		
	}
	
	public static int getRandomNo()
	 {
		
		 return random_no; //return rand no 
		   
	 }
   
}
	


