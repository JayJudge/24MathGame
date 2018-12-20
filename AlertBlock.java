import java.util.LinkedList;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.Scene;

import javafx.collections.*;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class AlertBlock{
	AlertBlock(){
	
	}
	public static void display(){
		display("�벻Ҫ�ظ����!");
	}
	public static void display(String message){
		Stage stage = new Stage();
		VBox root = new VBox();

		Label alertMessage = new Label(message);
			
		alertMessage.setMaxWidth(Double.MAX_VALUE);
		Button okButton = new Button("ȷ��");
		okButton.setAlignment(Pos.CENTER);
		okButton.setOnAction(e->stage.close());
		
		
		root.getChildren().addAll(alertMessage,okButton);
		root.getStyleClass().add("root");

		Scene scene = new Scene(root,160,100);
		scene.getStylesheets().add("css/alert_style.css");
	
		stage.setTitle("ע��");
		stage.getIcons().add(new Image("src/img/icons/Alert.png"));
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
}
