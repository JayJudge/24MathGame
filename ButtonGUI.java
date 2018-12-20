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
		
		buttons[0] = new Button("开始");
		buttons[1] = new Button("换一换");
		buttons[2] = new Button("答案");
		buttons[3] = new Button("结束");
		for(int i=0;i<buttonNum;i++){
			buttons[i].setMaxWidth(Double.MAX_VALUE);
		}
		//开始游戏
		Tooltip tip0 = new Tooltip();
		tip0.setText("点击后开始游戏，\n请不要重复点击，\n若想初始化游戏，\n请点击菜单栏的开局选项");
		buttons[0].setTooltip(tip0);
		buttons[0].setOnAction(e->{
			if(started==false){
				started = true;
				answerList.setAnswer("仔细动一动脑经");
				CardsGenerator cards = new CardsGenerator();
				cardsColor = cards.randomCardsColor();
				cardsValue = cards.randomCards();
				cardsView.setCardsView(cardsValue,cardsColor);
			}
			else{
				AlertBlock.display("游戏已经开始\n请不要重复点击");
			}
		});
		//换一换
		Tooltip tip1 = new Tooltip();
		tip1.setText("点击后替换题目");
		buttons[1].setTooltip(tip1);
		buttons[1].setOnAction(e->{
			if(started==true){
				answerList.setAnswer("仔细动一动脑经");
				CardsGenerator cards = new CardsGenerator();
				cardsColor = cards.randomCardsColor();
				cardsValue = cards.randomCards();
				cardsView.setCardsView(cardsValue,cardsColor);
			}
			else{
				AlertBlock.display("游戏还未开始\n请点击开始按钮");			
				System.out.println("Game Not started");
			}
		});
		//显示答案
		Tooltip tip2 = new Tooltip();
		tip2.setText("点击后显示答案");
		buttons[2].setTooltip(tip2);
		buttons[2].setOnAction(e->{
			if(started==false){
				AlertBlock.display("游戏还未开始\n请点击开始按钮");
			}
			else{
				answerList.setAnswer(cardsValue);
			}
		});
	//结束，退出
	
		Tooltip tip3 = new Tooltip();
		tip3.setText("点击后退出游戏");
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
