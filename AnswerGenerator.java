import java.util.List;
import java.util.LinkedList;


public class AnswerGenerator{

	public static LinkedList<String> getAnswer(){
	
		//���ÿ�������ģ�飬��������ĸ�����
		CardsGenerator cards = new CardsGenerator();
		int[] cardsValue =  cards.randomCards();
		LinkedList<String> answer= getAnswer(cardsValue);
		return answer;
	}

	
	public static LinkedList<String> getAnswer(int[] cardsValue){
		LinkedList<String> answer = new LinkedList<>();
		LinkedList<String> finalAnswer = new LinkedList<>();
		
	
		
		//���ñ��ʽ������ģ�飬�������б��ʽ
		ExpressionsGenerator exG = new ExpressionsGenerator();
		exG.dfs();
		LinkedList<String> exs = exG.getExpressions();
	
		//�����б��ʽ����
		for(int i=0;i<exs.size();i++){
			String ex = exs.get(i);
			String newEx = InfixToPostfix.infixToPostfix(ex);
		
			//���ü���ģ�飬����z
			CheckValue valueChecker = new CheckValue(cardsValue, newEx);
			if(valueChecker.check() == true)
				answer.add(valueChecker.exToValueEx(ex));
		}

		if(answer.size()==0){
			finalAnswer.add("�����û�н��");
			return finalAnswer;
		}
		else{
			//����ȥ��
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
