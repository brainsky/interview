package static_constructor_learn;

public class BinaryTree {
	private Node rootNode;
	private int size = 0;
	//�ݹ�����������
	public Node search(int val){	
		return search(rootNode, val);	
	}
	private Node search(Node root, int val){
		if(root == null || val == root.data)
			return root;
		if( val < root.data)
			return search(root.left, val);
		else
			return search(root.right, val);
	}
	//�������
	public void preInorderTreeWalk(){
		preOrderTreeWalk(rootNode);
	}
	private void preOrderTreeWalk(Node root){
		Node temp = root;
		if(temp != null){
			System.out.print(temp.data+" ");
			preOrderTreeWalk(root.left);
			preOrderTreeWalk(root.right);
		}
	}
	//�������
	public void midInorderTreeWalk(){
		midOrderTreeWalk(rootNode);
	}
	private void midOrderTreeWalk(Node root){
		Node temp = root;
		if(temp != null){
			midOrderTreeWalk(root.left);
			System.out.print(temp.data+" ");
			midOrderTreeWalk(root.right);
		}
	}
	//�������
	public void folInorderTreeWalk(){
		folOrderTreeWalk(rootNode);
	}
	private void folOrderTreeWalk(Node root){
		Node temp = root;
		if(temp != null){
			folOrderTreeWalk(root.left);
			folOrderTreeWalk(root.right);
			System.out.print(temp.data+" ");
		}
	}
	
	//��Сֵ
	public Node min(){
		Node tempNode = rootNode;
		while(tempNode.left != null){
			tempNode = tempNode.left;
		}
		return tempNode;
	}
	//���ֵ
	public Node max(){
		Node tempNode = rootNode;
		while(tempNode.right != null){
			tempNode = tempNode.right;
		}
		return tempNode;
	}
	//�õ���С
	public int size(){
		return size;
	}
	
	public void tree_insert(BinaryTree tree, Node in){
		Node temp = null;
		Node parent = tree.rootNode;
		//��whileʵ�ֱ��������������ܣ�ֱ��parent�������������Ϊ�գ�����������ҵľ�ͷ,��ʱ�ɲ����µ�Node,��Node�ĸ��ڵ�Ϊparent��
		//����Ĺؼ����ڱ�������������������ͷ������þ�ͷֵ�Ƚϣ�����ֵ���ɡ�
		while(parent != null){
			temp = parent;
			if(in.data < parent.data){
				parent = parent.left;
			}else{
				parent = parent.right;
			}
		}
		in.parent = temp;
		if (temp == null){
			tree.rootNode = in;
		}else if(in.data < temp.data){
			temp.left = in;
		}else{
			temp.right = in;
		}
		size++;//��������
	}
	public static void main(String[] args) {
		int data[] = {10,20,100,60,50,40,2,8,9,111,296,555};
		BinaryTree tree = new BinaryTree();
		for(int i : data){
			tree.tree_insert(tree, new Node(i));
		}
		tree.folInorderTreeWalk();
		System.out.println();
		tree.midInorderTreeWalk();
		System.out.println();
		tree.preInorderTreeWalk();
		System.out.println();
		System.out.println(tree.size());
	}

}


//�ڵ��࣬�ڵ��¼��ڵ㡢�ҽڵ㡢���ڵ㡣
class Node {
	Node left;
	Node right;
	Node parent;
	int data;
	public Node(int data){
		this.data = data;
	}
}