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
		//关于后缀表达式转换
		//遍历表达式，遇到的字母放与到输出栈(output)中
		//遇到操作符放到待定栈(stakc)中
		//如果遇到右括号")",将待定栈弹出，放入输出栈，直到遇到左括号"("
		//注意:左括号不弹出
		//其他操作符，弹出直到遇到更低优先级操作符时，停止弹出
		//遍历结束，输出待定栈内所有未弹出字符到输出栈
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
					//去除'('
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
