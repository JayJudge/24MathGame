import java.util.List;
import java.util.LinkedList;

public class Node{
	private static final String[] op1 = {"+","-"};
	private static final String[] op2 = {"*","/"};
	private final String[] op3 = {"/"};
	private final String[] op4 = {"*","-"};
	private static final String[] mathOps = {"+","/","*","-"};

	private String ch;
	private int id;			//����������
	private int polar;		//��������
	private Node leftChild;
	private Node rightChild;

	Node(){

	}
	Node(String ch, int id){
		this(ch,id,0,null,null);	
	}
	Node(String ch){
		this(ch,0,0,null,null);
	}
	Node(String ch, Node left, Node right){
		this(ch,0,0,left,right);
	}
	Node(String ch, int polar, Node left, Node right){
		this(ch,0,polar,left,right);
	}
	Node(String ch, int id, int polar, Node left, Node right){
		this.ch = ch;
		this.id = id;
		this.polar = polar;
		this.leftChild = left;
		this.rightChild = right;
	}

 	String getCh(){
		return this.ch;
	}
	int getId(){
		return this.id;
	}
	Node getRightChild(){
		return this.rightChild;
	}
	Node getLeftChild(){
		return this.rightChild;
	}

	void setCh(String ch){
		this.ch = ch;
	}
	void setId(int id){
		this.id =id;
	}

	static boolean in(char ch, char[] list){
		for(int i=0;i<list.length;i++){
			if(list[i]==ch){
				return true;
			}
		}
		return false;
	}
	static boolean in(String ch, String[] list){
		for(int i=0;i<list.length;i++){
			if(list[i].equals(ch)){
				return true;
			}
		}
		return false;
	}
	static boolean in(String ch, String[] list1, String[] list2){
		return in(ch,list1)||in(ch,list2);
	}


	public String get(){
		//���س���
		if(!in(this.ch, op1, op2))
			return this.ch;

		//�������ұ��ʽ
		String leftEx = this.leftChild.get();
		String rightEx = this.rightChild.get();
		
		//������
		if(in(this.ch, op2)&&in(this.leftChild.ch, op1))
			leftEx = "(" + leftEx + ")";
	
		if((in(this.ch, op3)&&in(this.rightChild.ch,mathOps))
			||(in(this.ch, op4)&&in(this.rightChild.ch,op1)))
			rightEx = "(" + rightEx +")";	

		//�����ܱ��ʽ
		return leftEx + this.ch + rightEx;
	}

	static void buildTree(LinkedList<Node> roots, Node left, Node right){
		
		//�ӷ�:���Һ��Ӳ����Ǽ��ţ������Ӳ����ǼӺ�
		//���Һ����ǼӺţ������Ӻ��Һ��ӵ��������㵥����
		int newPolar;
		if((!in(left.ch,op1))&&(!right.ch.equals("-"))
		&&((!right.ch.equals("+"))||left.id<right.leftChild.id)){
			if(left.polar==0&&right.polar==0)			//�޼��� + �޼��� = �޼���	
				newPolar=0;								//�м��� + �޼��� = ������
			else if(left.polar==0||right.polar==0)		//�м��� + �м��� = ����������
				newPolar=1;
			else
				newPolar=right.polar;	
			roots.add(new Node("+",newPolar,left,right));					
		}	
		//����:�������Ӷ������Ǽ���
		if((!left.ch.equals("-"))&&(!right.ch.equals("-"))){
			if(left.polar==0&&right.polar==0){			//�޼��� - �޼���
				roots.add(new Node("-",1,left,right)); 	//������
				roots.add(new Node("-",-1,right,left)); //������
			}
			else{
				if(left.polar==0)
					roots.add(new Node("-",-1,right,left)); //�м��� - �޼��� = ������
				if(right.polar==0)							
					roots.add(new Node("-",-1,left,right));
			}
		}
		//�˷�
		if((!in(left.ch,op2))&&(!right.ch.equals("/"))
		&&((!right.ch.equals("*"))||left.id<right.leftChild.id)){
			if(left.polar==0||right.polar==0){			//�޼��� * �޼��� = �޼��� �м��� * �޼��� = �м��Եļ���
				newPolar = left.polar+right.polar;	
				roots.add(new Node("*",newPolar,left,right));			
			}
			else if(left.polar>0){
				newPolar = left.polar+right.polar;		//������ * �м��� = �������ļ���
				roots.add(new Node("*",newPolar,left,right));
			}
		}
		//����
		if((!left.ch.equals("/"))&&(!right.ch.equals("/"))){
			if(left.polar==0||right.polar==0){			//�޼��� * �޼��� = �޼��� �м��� * �޼��� = �м����ߵļ���
				newPolar = left.polar+right.polar;
				roots.add(new Node("/",newPolar,left,right));
				roots.add(new Node("/",newPolar,right,left));
			}
			else{
				if(left.polar>0){						//������ / �м��� = �������ļ���
					newPolar = right.polar;
					roots.add(new Node("/",newPolar,left,right));
				}
				if(right.polar>0){
					newPolar = left.polar;
					roots.add(new Node("/",newPolar,right,left));
				}
			}	
		}
	}
}
