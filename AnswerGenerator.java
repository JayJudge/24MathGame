import java.util.List;
import java.util.LinkedList;


public class AnswerGenerator{

	public static LinkedList<String> getAnswer(){
	
		//调用卡牌生成模块，随机生成四个数字
		CardsGenerator cards = new CardsGenerator();
		int[] cardsValue =  cards.randomCards();
		LinkedList<String> answer= getAnswer(cardsValue);
		return answer;
	}

	
	public static LinkedList<String> getAnswer(int[] cardsValue){
		LinkedList<String> answer = new LinkedList<>();
		LinkedList<String> finalAnswer = new LinkedList<>();
		
	
		
		//调用表达式生成器模块，给出所有表达式
		ExpressionsGenerator exG = new ExpressionsGenerator();
		exG.dfs();
		LinkedList<String> exs = exG.getExpressions();
	
		//对所有表达式检验
		for(int i=0;i<exs.size();i++){
			String ex = exs.get(i);
			String newEx = InfixToPostfix.infixToPostfix(ex);
		
			//调用检验模块，检验z
			CheckValue valueChecker = new CheckValue(cardsValue, newEx);
			if(valueChecker.check() == true)
				answer.add(valueChecker.exToValueEx(ex));
		}

		if(answer.size()==0){
			finalAnswer.add("这道题没有解答");
			return finalAnswer;
		}
		else{
			//最终去重
			for(int i=0;i<answer.size();i++){
				if(finalAnswer.contains(answer.get(i)))
					continue;
				else
					finalAnswer.add(answer.get(i));
			}
		}
		return finalAnswer;
	}
}
