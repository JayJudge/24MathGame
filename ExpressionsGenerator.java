import java.util.List;
import java.util.LinkedList;

public class ExpressionsGenerator{

	private static LinkedList<Node> trees;
	private static LinkedList<String> expressions;



	ExpressionsGenerator(){
		trees = new LinkedList<Node>();
		expressions = new LinkedList<String>();
		//��ʼɭ��
		trees.add(new Node("a",0));
		trees.add(new Node("b",1));
		trees.add(new Node("c",2));
		trees.add(new Node("d",3));
	}
	public LinkedList<Node> getTrees(){
		return this.trees;
	}
	public LinkedList<String> getExpressions(){
		return this.expressions;
	}
	public static void dfs(){
		dfs(trees,1);	
	}
	public static void dfs(LinkedList<Node> tree, int minj){
		LinkedList<Node> roots = new LinkedList<>();
		LinkedList<Node> newTree  = new LinkedList<>();
		//�ݹ�����������������
		if(tree.size()==1){
			//�������ñ��ʽ
			expressions.add(tree.getFirst().get());
			return;
		}
		int len = tree.size();
		for(int j=minj;j<len;j++){
			for(int i=0;i<j;i++){
				//���Ͻ���
				Node.buildTree(roots,tree.get(i),tree.get(j));
				for(int k=0;k<roots.size();k++){
					Node node = roots.get(k);
					node.setId(tree.getLast().getId()+1);

					for(int h=0;h<len;h++){
						//�Ѿ�ѡȡ����С��������ѡȡ
						if(h!=i&&h!=j){
							newTree.add(tree.get(h));
						}
					}
					newTree.add(node);
	
					//�ݹ��������
					dfs(newTree,j-1);
					//�������
					newTree.clear();
				}
				roots.clear();
			}
		}
	}
}
