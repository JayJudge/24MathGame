import java.util.List;
import java.util.LinkedList;


public class CheckValue{
	private final double winValue = 24; 	//���ձ��ʽ��ֵ��֮�Ƚ�
	private static double EPS = 1e-10;		//����ֵ
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
	//Ϊ�˱�֤���ʽ���Գ��ַ���
	public static boolean equal(double a,double b){
		if(Math.abs(a-b)<=EPS){
			return true;
		}
		return false;
	}
	//���ز�����
	public static double getValue(char ch){
		switch(ch){
			case 'a':return cardsValue[0];
			case 'b':return cardsValue[1];
			case 'c':return cardsValue[2];
			case 'd':return cardsValue[3];
		}
		return ch;
	}
	//���ز�������Ӧ�Ľ��
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
		//�Ժ�׺���ʽ�Ĳ����������ֱ����������ʽջ
		LinkedList<Double> num = new LinkedList<>();
		LinkedList<Character> op = new LinkedList<>();
		
		for(int i=0;i<expression.length();i++){
			char temp = expression.charAt(i);
			double tempValue;
			//�ж��ǲ�����������
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
	//��������ĸ���ʽת������ֵ���ʽ
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

