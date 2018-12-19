import javafx.application.Application;

import javafx.scene.Scene;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;



public class Test extends Application{
	@Override
	public void start(Stage stage){
	
		//empty	
		Label label1 = new Label();
		//with text
		Label label2 = new Label("LOVE");
		//with image & text
		Image image1 = new Image(getClass().getResourceAsStream("src/img/01.jpg"));
		Label label3 = new Label("QBHN",new ImageView(image1));
/*		

		Pane pane1   = new Pane();
		pane1.getChildren().addAll(label2,label3);
		Stage newStage = new Stage();
		newStage.setScene(new Scene(pane1,500,600));
		newStage.show();
*/
		//setText(String str)
		label3.setText("LOVE  YOU");
		//setGraphic(Node Graphic)
		Image image2 = new Image(getClass().getResourceAsStream("src/img/03.jpg"));
		label3.setGraphic(new ImageView(image2));
		//setTextFill()
		//setFont(Font o)
		//setWrapText(boolean e)
		//setTextAlignment()
		//setGraohicTextGap()
		//setContentDisplay(Content a) LEFT\RIGHT\TOP\BOTTOM\CENTER
		label3.setContentDisplay(ContentDisplay.CENTER);


		Pane pane2   = new Pane();
		pane2.getChildren().addAll(label2,label3);
		Scene scene = new Scene(pane2,500,700);
	
		stage.setTitle("Test");
		stage.setScene(scene);
		stage.show();
	}

}
