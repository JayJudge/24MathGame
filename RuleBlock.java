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


public class RuleBlock{

	public static void display(){
		Stage stage = new Stage();
		VBox root = new VBox();
		
		String ruleText = "\t24点游戏规则:\n\n"+
		"\t从扑克牌中随机抽取四张可重复的牌\n"+
		"\t其中A代表1，J代表11，Q代表12，K代表13\n"+
		"\t不包括大小王，使用'+','-','*,'/'以及括号\n"+
		"\t进行四则运算，若能算出24点，则有解，否则无解\n"+
		"\n\n\n\t本程序不提供输入文本框，只能显示游戏的解法\n"+
		"\t点击开始按钮开始游戏，将随机给出四张牌\n"+
		"\t点击答案可以显示出当前题目的答案\n"+
		"\t点击换一换可以更换题目\n"+
		"\t点击结束退出游戏客户端"+
		"\t查看源代码可登陆\n\t"+
		"https://github.com/jayjudge/24mathgame";

		Label rules = new Label(ruleText);
		root.getChildren().add(rules);
		Scene scene = new Scene(root,300,250);
	
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("游戏规则");
		stage.getIcons().add(new Image("src/img/icons/GameTitle.png"));
		stage.show();
	
	}

}
