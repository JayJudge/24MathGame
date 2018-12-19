import java.util.List;
import java.util.LinkedList;


public class CheckValue{
	private final double winValue = 24; 	//最终表达式的值与之比较
	private static double EPS = 1e-10;		//保险值
	private static String expression;
	private static int[] cardsValue;

	CheckValue(){
	
	}
	CheckValue(int[] cardsValue, String expression){
		this.cardsValue = cardsValue;
		this.expression = expression;
	}

	public double getEPS(){
		return EPS;
	}
	public int[] getCards(){
		return cardsValue;
	}

	public void setEPS(double EPS){
		this.EPS = EPS;
	}
	public void setValue(int[] cardsValue){
		this.cardsValue = cardsValue;
	}
	//为了保证表达式可以出现分数
	public static boolean equal(double a,double b){
		if(Math.abs(a-b)<=EPS){
			return true;
		}
		return false;
	}
	//返回操作数
	public static double getValue(char ch){
		switch(ch){
			case 'a':return cardsValue[0];
			case 'b':return cardsValue[1];
			case 'c':return cardsValue[2];
			case 'd':return cardsValue[3];
		}
		return ch;
	}
	//返回操作符对应的结果
	public double getResult(double a, double b,char op){
		switch(op){
			case '+':return a+b;
			case '-':return b-a;
			case '*':return a*b;
			default:return (double)b/a;
		}
	}

	public boolean check(){
		return check(this.expression);
	}

	public boolean check(String expression){
		final char[] mathOps = {'+','-','*','/'};
		//对后缀表达式的操作符和数分别放入两个链式栈
		LinkedList<Double> num = new LinkedList<>();
		LinkedList<Character> op = new LinkedList<>();
		
		for(int i=0;i<expression.length();i++){
			char temp = expression.charAt(i);
			double tempValue;
			//判断是操作符还是数
			if(!Node.in(temp,mathOps)){
				tempValue =getValue(temp);
				num.push(tempValue);
			}
			else{
				double num1 = num.pop();
				double num2 = num.pop();
				double res = getResult(num1,num2,temp);
				num.push(res);
			}
		}
		if(equal(num.pop(),winValue)){
			return true;
		}
		return false;
	}
	public static String exToValueEx(){
		return exToValueEx(expression);
	}
	//将抽象字母表达式转换成数值表达式
	public static String exToValueEx(String postExpression){
		char[] mathOps ={'+','-','*','/','(',')'};
		String valueEx = "";
		for(int i=0;i<postExpression.length();i++){
			char temp = postExpression.charAt(i);
			switch(temp){
				case 'a':{
					valueEx += cardsValue[0];
					break;
				}
				case 'b':{
					valueEx += cardsValue[1];
					break;
				}
				case 'c':{
					valueEx += cardsValue[2];
					break;
				}
				case 'd':{
					valueEx += cardsValue[3];
					break;
				}
				default:valueEx += temp;
			}
		}
		return valueEx;

	}
}

