import java.util.List;
import java.util.LinkedList;

public class InfixToPostfix{

	private static String expression;

	InfixToPostfix(String expresssion){
		this.expression = expression;
	}

	public static void step(LinkedList<Character> output, LinkedList<Character> stack, char a, char b){
		while(stack.size()!=0&&(stack.peek()==a||stack.peek()==b)){
			output.push(stack.pop());
		}
	}
	public static void step(LinkedList<Character> output, LinkedList<Character> stack){
		while(stack.size()!=0&&stack.peek()!='('){
			output.push(stack.pop());
		}
	}

	public static String infixToPostfix(){
		String newExpression = expression;
		infixToPostfix(newExpression);
		return newExpression;
	}
	public static String infixToPostfix(String expression){
		String newExpression = "";
		//���ں�׺���ʽת��
		//�������ʽ����������ĸ���뵽���ջ(output)��
		//�����������ŵ�����ջ(stakc)��
		//�������������")",������ջ�������������ջ��ֱ������������"("
		//ע��:�����Ų�����
		//����������������ֱ�������������ȼ�������ʱ��ֹͣ����
		//�����������������ջ������δ�����ַ������ջ
		LinkedList<Character> output = new LinkedList<>();
		LinkedList<Character> stack = new LinkedList<>();
		for(int i=0;i<expression.length();i++){
			char temp = expression.charAt(i);
			switch(temp){
				case '(':{
					stack.push(temp);
					break;
				}
				case ')':{
					//ȥ��'('
					step(output, stack);
					stack.pop();
					break;
				}
				case '/':{
					step(output, stack,'/','*');
					stack.push(temp);
					break;
				}
				case '*':{
					step(output, stack,'/','*');
					stack.push(temp);
					break;
				}
				case '-':{
					step(output,stack);
					stack.push(temp);
					break;
				}
				case '+':{
					step(output, stack);
					stack.push(temp);
					break;
				}
				default:{
					output.push(temp);
				}
			}
		}
		while(stack.size()!=0){
			output.push(stack.pop());
		}
		while(output.size()!=0){
			newExpression = output.pop() + newExpression;
		}
		return newExpression;
	}
}
