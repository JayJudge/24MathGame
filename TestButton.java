import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import javafx.event.*;

import javafx.stage.Stage;


public class TestButton extends Application{

	@Override
	public void start(Stage stage){
		Label lb1  = new Label("I LOVE YOU");
		//empty	
		Button bt1 = new Button();
		//with text
		Button bt2 = new Button("AC");
		//with text & image
		Image img1 = new Image("src/img/04.jpg");
		Button bt3 = new Button("LOVE",new ImageView(img1));
	
		//setText()
		//....
		//setOnAction(ActionEvent e)
		bt2.setOnAction((ActionEvent e)->{
			lb1.setText("YOU LOVE ME");
		});



		FlowPane pane1 = new FlowPane();
		pane1.getChildren().addAll(lb1,bt1,bt2,bt3);
		
		Scene scene = new Scene(pane1,50,200);
	
	
		stage.setScene(scene);
		stage.setTitle("Simple Button Example");
		stage.show();	
	
	}

}
