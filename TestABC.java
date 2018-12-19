import java.util.LinkedList;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.Scene;

import javafx.collections.*;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;




public class TestABC extends Application{
	public void start(Stage stage){
		BorderPane root = new BorderPane();
		CardsViewGUI cardsView = new CardsViewGUI();
		VBox center = cardsView.getCardsView();
		//
		MenuBarGUI menuBar = new MenuBarGUI(root);
		VBox top = menuBar.getMenuBar();
		//
		AnswerListGUI answerList = new AnswerListGUI();
		VBox right = answerList.getAnswerView();
		//
		ButtonGUI buttons = new ButtonGUI(answerList,cardsView);
		VBox left = buttons.getButtonView();
		//
		//
		root.setRight(right);
		root.setLeft(left);
		root.setCenter(center);
		root.setTop(top);
		root.getStyleClass().add("root");
		//

		Scene scene = new Scene(root,570,400);
		scene.getStylesheets().add("style1.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("TwentyFourMathGame");
		stage.show();
	}
}
