import java.util.LinkedList;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.Scene;

import javafx.collections.*;

import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;

public class CardsViewGUI{
	
	private static VBox cardsView;
	private static HBox up;
	private static HBox down;
	private static Image[] cards;
	private static ImageView[] cardsImageView;
	private static int[] cardsValue ={41,14,14,41};
	private static int[] cardsColor ={5,5,5,5};

	CardsViewGUI(){
		this(cardsValue,cardsColor);
	}

	CardsViewGUI(int[] cardsValue, int[] cardsColor){
		this.cardsValue = cardsValue;
		this.cardsColor = cardsColor;
			
		cardsView = new VBox();
		up = new HBox();
		down = new HBox();
//		
		cards = new Image[cardsValue.length];
		cardsImageView = new ImageView[cardsValue.length];
		//随机抽取四张牌
		for(int i=0;i<cardsValue.length;i++){
			String imagePath = "src/img/card/" + cardsColor[i]
				   	+ "-" + cardsValue[i] + ".png";
			cards[i] = new Image(imagePath);
			cardsImageView[i] = new ImageView(cards[i]);	
		}
//
		up.getChildren().addAll(cardsImageView[0],cardsImageView[1]);
		down.getChildren().addAll(cardsImageView[2],cardsImageView[3]);
		up.setSpacing(50);
		down.setSpacing(50);
		cardsView.getChildren().addAll(up,down);
		cardsView.setSpacing(50);
	}
	public static int[] getCardsValue(){
		return cardsValue;
	}
	public static void setCardsView(int[] cardsValue, int[] cardsColor){
		
		for(int i=0;i<cardsValue.length;i++){
			String imagePath = "src/img/card/" + cardsColor[i]
				   	+ "-" + cardsValue[i] + ".png";
			cards[i] = new Image(imagePath);
			cardsImageView[i] = new ImageView(cards[i]);	
		}
//
		up.getChildren().setAll(cardsImageView[0],cardsImageView[1]);
		down.getChildren().setAll(cardsImageView[2],cardsImageView[3]);
		cardsView.getChildren().setAll(up,down);
	}

	public static VBox getCardsView(){
		return cardsView;
	}
}
