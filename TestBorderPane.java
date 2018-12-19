import java.util.LinkedList;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.Scene;

import javafx.collections.*;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;



public class TestBorderPane extends Application{
	@Override

	public void start(Stage stage){
	
		BorderPane bp = new BorderPane();
		//setTop/Bottom/LEFT/RIGHT/CENTER
		VBox right = addRight();
		VBox center = addCenter();
		VBox top = addTop();
		VBox left = addLeft();
		VBox bottom = addBottom();
		//
		BorderPane root = new BorderPane();
		root.setTop(top);
		root.setCenter(center);
		root.setRight(right);
		root.setLeft(left);
		root.setBottom(bottom);
		//

		Scene scene = new Scene(root,648,486);
		stage.setScene(scene);
		stage.setTitle("I Love you");
		stage.show();
	
	}
	public HBox addHbox(){
		HBox hbox = new HBox();
		Button bt = new Button("ABC");
		hbox.getChildren().add(bt);
		return hbox;
	}
	public VBox addTop(){
		
		VBox top = new VBox();
		MenuBar menuBar = new MenuBar();
		Label lb1 = new Label("I LOVE YOU");

		lb1.setContentDisplay(ContentDisplay.RIGHT);

		
		//
		Menu gameMenu = new Menu("Game");
		MenuItem startMenuItem = new MenuItem("Start");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem exitMenuItem = new MenuItem("Exit");
		exitMenuItem.setOnAction(actionEvent->Platform.exit());
		
		gameMenu.getItems().addAll(startMenuItem,saveMenuItem,new SeparatorMenuItem(),exitMenuItem);
		
		Menu helpMenu = new Menu("Help");
		MenuItem helpUsingMenu = new Menu("User's guide");
		MenuItem aboutUsMenu = new Menu("About us");
		
		helpMenu.getItems().addAll(helpUsingMenu,new SeparatorMenuItem(),aboutUsMenu);
		


		menuBar.getMenus().addAll(gameMenu,helpMenu);
		top.getChildren().addAll(menuBar,lb1);
		top.setPadding(new Insets(0,0,40,0));
		return top;
	}
	public VBox addCenter(){
		VBox center = new VBox();
		HBox up = new HBox();
		HBox down = new HBox();
		Image img1  = new Image("src/img/card/1-1.png");
		Image img2  = new Image("src/img/card/2-2.png");
		Image img3  = new Image("src/img/card/3-3.png");
		Image img4  = new Image("src/img/card/4-4.png");
		ImageView card1 = new ImageView(img1);
		ImageView card2 = new ImageView(img2);
		ImageView card3 = new ImageView(img3);
		ImageView card4 = new ImageView(img4);
		up.getChildren().addAll(card1,card2);
		down.getChildren().addAll(card3,card4);
		up.setSpacing(50);
		down.setSpacing(50);
		center.getChildren().addAll(up,down);
		center.setSpacing(40);
		center.setPadding(new Insets(0,50,0,80));
		return center;
	}
	public VBox addRight(){
		LinkedList<String> exs = new LinkedList<>();
		exs.add("(a+b)-(c*d)");
		exs.add("(a-c)*(d/b)");
		for(int i=0;i<22;i++){
			exs.add("asdfas");
		}
		VBox right = new VBox();
		Label title = new Label("SOLVE");
		ListView<String>  list = new ListView<>();
		ObservableList<String> items = FXCollections.observableArrayList();
		for(int i =0;i<exs.size();i++){
			items.add(exs.get(i));
		}
		list.setItems(items);
		list.setPrefWidth(100);
		list.setPrefHeight(200);
		title.setContentDisplay(ContentDisplay.CENTER);
		right.getChildren().addAll(title,list);
		right.setSpacing(10);
		right.setPadding(new Insets(0,20,0,10));
		return right;
	
	}
	public VBox addLeft(){
		VBox left = new VBox();
		Button startBt = new Button("Start");
		Button endBt   = new Button("End");
		Button changeBt = new Button("Change");
		Button showAnswerBt = new Button("Answer");
		Button checkBt = new Button("Check");
		startBt.setMaxWidth(Double.MAX_VALUE);
		endBt.setMaxWidth(Double.MAX_VALUE);
		changeBt.setMaxWidth(Double.MAX_VALUE);
		showAnswerBt.setMaxWidth(Double.MAX_VALUE);
		checkBt.setMaxWidth(Double.MAX_VALUE);

		startBt.setOnAction(e->{
			System.out.println("Game start");
		});


		endBt.setOnAction(e->{
			System.out.println("Mouse pressed");
		});

		left.setSpacing(20);
		left.setPadding(new Insets(0,20,10,20));
		left.getChildren().addAll(startBt,changeBt,showAnswerBt,checkBt,endBt);

		return left;
	}
	public VBox addBottom(){
		VBox bottom = new VBox();
		Label tips = new Label("Please enter your answer:"+
						"(example:(a+b)/(c-d))");
		TextField answerSheet = new TextField();
		answerSheet.setPrefWidth(100);
		bottom.getChildren().addAll(tips,answerSheet);
		bottom.setSpacing(15);
		bottom.setPadding(new Insets(0,200,40,100));

		return bottom;
	}
}
