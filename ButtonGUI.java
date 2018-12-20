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



public class ButtonGUI{
	private static boolean started;
	private static VBox buttonView;
	private static Button[] buttons;
	private static int buttonNum;
	private static int[] cardsValue;
	private static int[] cardsColor;
	ButtonGUI(){
		this(new AnswerListGUI(), new CardsViewGUI(), 4);
	}
	ButtonGUI(AnswerListGUI answerList, CardsViewGUI cardsView){
		this(answerList,cardsView,4);
	}
	ButtonGUI(AnswerListGUI answerList, CardsViewGUI cardsView, int buttonNum){
		buttonView = new VBox();
		this.buttonNum = buttonNum;
		buttons = new Button[buttonNum];
		started = false;
		
		buttons[0] = new Button("��ʼ");
		buttons[1] = new Button("��һ��");
		buttons[2] = new Button("��");
		buttons[3] = new Button("����");
		for(int i=0;i<buttonNum;i++){
			buttons[i].setMaxWidth(Double.MAX_VALUE);
		}
		//��ʼ��Ϸ
		Tooltip tip0 = new Tooltip();
		tip0.setText("�����ʼ��Ϸ��\n�벻Ҫ�ظ������\n�����ʼ����Ϸ��\n�����˵����Ŀ���ѡ��");
		buttons[0].setTooltip(tip0);
		buttons[0].setOnAction(e->{
			if(started==false){
				started = true;
				answerList.setAnswer("��ϸ��һ���Ծ�");
				CardsGenerator cards = new CardsGenerator();
				cardsColor = cards.randomCardsColor();
				cardsValue = cards.randomCards();
				cardsView.setCardsView(cardsValue,cardsColor);
			}
			else{
				AlertBlock.display("��Ϸ�Ѿ���ʼ\n�벻Ҫ�ظ����");
			}
		});
		//��һ��
		Tooltip tip1 = new Tooltip();
		tip1.setText("������滻��Ŀ");
		buttons[1].setTooltip(tip1);
		buttons[1].setOnAction(e->{
			if(started==true){
				answerList.setAnswer("��ϸ��һ���Ծ�");
				CardsGenerator cards = new CardsGenerator();
				cardsColor = cards.randomCardsColor();
				cardsValue = cards.randomCards();
				cardsView.setCardsView(cardsValue,cardsColor);
			}
			else{
				AlertBlock.display("��Ϸ��δ��ʼ\n������ʼ��ť");			
				System.out.println("Game Not started");
			}
		});
		//��ʾ��
		Tooltip tip2 = new Tooltip();
		tip2.setText("�������ʾ��");
		buttons[2].setTooltip(tip2);
		buttons[2].setOnAction(e->{
			if(started==false){
				AlertBlock.display("��Ϸ��δ��ʼ\n������ʼ��ť");
			}
			else{
				answerList.setAnswer(cardsValue);
			}
		});
	//�������˳�
	
		Tooltip tip3 = new Tooltip();
		tip3.setText("������˳���Ϸ");
		buttons[3].setTooltip(tip3);
		buttons[3].setOnAction(e->Platform.exit());

		//
		buttonView.getChildren().addAll(buttons[0], buttons[1], buttons[2], buttons[3]);
		buttonView.setSpacing(35);
		buttonView.setPadding(new Insets(0,60,0,30));
	}
	
	public static VBox getButtonView(){
		return buttonView;
	}
}
