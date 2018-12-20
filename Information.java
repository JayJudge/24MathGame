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


public class Information{
	
	public static void display(){
		Stage stage = new Stage();
		VBox root = new VBox();
		HBox icon = new HBox();
		Image sign = new Image("src/img/icons/Sign.png");	
		ImageView signView = new ImageView(sign);
		Separator line = new Separator();
		
		Image bigGameTitle = new Image("src/img/icons/GameTitleBig.png");
		ImageView bigGameView  = new ImageView(bigGameTitle);
	

		Label message = new Label("\n\n\n\t24点游戏:\n\n"+
		"\t版本:v0.0.1.\n\n\n"+
		"\t\tby JayJudge");
		icon.getChildren().addAll(bigGameView,message);	


		root.getChildren().addAll(signView,line,icon);
		Scene scene = new Scene(root,400,300);
		
		stage.setScene(scene);

		stage.setResizable(false);
	 	stage.setTitle("关于24点");
		stage.getIcons().add(new Image("src/img/icons/GameTitle.png"));
		stage.show();
	}
}
