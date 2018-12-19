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





public class MenuBarGUI{
	private static VBox menuBar;
	private static MenuBar topMenu;
	private static Label message;
	private static String messageValue;
	MenuBarGUI(BorderPane root){
		this(root,"��Ϸ���");
	}

	MenuBarGUI(BorderPane root, String messageValue){
		this.messageValue = messageValue;
		message = new Label(messageValue);
		message.setMaxWidth(Double.MAX_VALUE);
		message.setAlignment(Pos.CENTER);
		message.getStyleClass().add("message");
		topMenu = new MenuBar();
		menuBar = new VBox();
		Menu gameMenu = new Menu("��Ϸ");
		MenuItem newGameMenuItem = new MenuItem("����");
		MenuItem exitMenuItem = new MenuItem("�˳�");
		
		newGameMenuItem.setOnAction(e->{
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
		});
		exitMenuItem.setOnAction(e->Platform.exit());
		gameMenu.getItems().addAll(newGameMenuItem,new SeparatorMenuItem(),exitMenuItem);
		//
		Menu helpMenu = new Menu("����");
		MenuItem helpUsingMenuItem = new MenuItem("ʹ�ð���");
		MenuItem aboutUsMenuItem = new MenuItem("����24��");
		helpMenu.getItems().addAll(helpUsingMenuItem,aboutUsMenuItem);
	
		topMenu.getMenus().addAll(gameMenu,helpMenu);

		menuBar.getChildren().addAll(topMenu,message);
		menuBar.setSpacing(20);
		menuBar.setPadding(new Insets(0,0,40,0));
	}
	
	public String getMessageValue(){
		return messageValue;
	}
	public void setMessageValue(String messageValue){
		this.messageValue = messageValue;
	}

//
	public static VBox getMenuBar(){
		return menuBar;
	}
}
