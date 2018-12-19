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
	private static Label title = new Label("���");
	private static ListView<String> list;
	private static ObservableList<String> items;
	
	
	AnswerListGUI(){
		answerListView = new VBox();
		//�𰸱���CSS
		title.getStyleClass().add("answer-title");

		//��������
		list = new ListView<>();
		items = FXCollections.observableArrayList();
		//������ʼ��
		items.add("���Ʋ�����Ϸ");
		items.add("�ܾ�������Ϸ");
		items.add("ע�����ұ���");
		items.add("�����ϵ���ƭ");
		items.add("�ʶ���Ϸ����");
		items.add("������Ϸ����");
		items.add("������ʱ��");
		items.add("���ܽ�������");
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
