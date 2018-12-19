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

import java.util.List;
import java.util.LinkedList;


public class AnswerListGUI{
	private static VBox answerListView;
	private static Label title = new Label("解答");
	private static ListView<String> list;
	private static ObservableList<String> items;
	
	
	AnswerListGUI(){
		answerListView = new VBox();
		//答案标题CSS
		title.getStyleClass().add("answer-title");

		//答案区声明
		list = new ListView<>();
		items = FXCollections.observableArrayList();
		//答案区初始化
		items.add("抵制不良游戏");
		items.add("拒绝盗版游戏");
		items.add("注意自我保护");
		items.add("谨防上当受骗");
		items.add("适度游戏益脑");
		items.add("沉迷游戏伤身");
		items.add("合理安排时间");
		items.add("享受健康生活");
		//
		list.setItems(items);
		list.setPrefWidth(150);
		list.setPrefHeight(200);
		
		title.setContentDisplay(ContentDisplay.CENTER);
		answerListView.getChildren().addAll(title,list);
	
		answerListView.setSpacing(20);
		answerListView.setPadding(new Insets(0,10,0,30));
}
	
	public static void setAnswer(String ans){
		items.clear();
		items.add(ans);
	}

	public static void setAnswer(int[] cardsValue){
			LinkedList<String> copy = AnswerGenerator.getAnswer(cardsValue);
			items.clear();
			for(int i=0;i<copy.size();i++){
				items.add(copy.get(i));
			}
	}

	public VBox getAnswerView(){
		return answerListView;
	}

}
