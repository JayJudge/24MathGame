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
		
		String ruleText = "\t24����Ϸ����:\n\n"+
		"\t���˿����������ȡ���ſ��ظ�����\n"+
		"\t����A����1��J����11��Q����12��K����13\n"+
		"\t��������С����ʹ��'+','-','*,'/'�Լ�����\n"+
		"\t�����������㣬�������24�㣬���н⣬�����޽�\n"+
		"\n\n\n\t�������ṩ�����ı���ֻ����ʾ��Ϸ�Ľⷨ\n"+
		"\t�����ʼ��ť��ʼ��Ϸ�����������������\n"+
		"\t����𰸿�����ʾ����ǰ��Ŀ�Ĵ�\n"+
		"\t�����һ�����Ը�����Ŀ\n"+
		"\t��������˳���Ϸ�ͻ���"+
		"\t�鿴Դ����ɵ�½\n\t"+
		"https://github.com/jayjudge/24mathgame";

		Label rules = new Label(ruleText);
		root.getChildren().add(rules);
		Scene scene = new Scene(root,300,250);
	
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("��Ϸ����");
		stage.getIcons().add(new Image("src/img/icons/GameTitle.png"));
		stage.show();
	
	}

}
