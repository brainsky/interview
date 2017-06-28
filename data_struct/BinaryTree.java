package static_constructor_learn;

public class BinaryTree {
	private Node rootNode;
	private int size = 0;
	//递归搜索二叉树
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
	//先序遍历
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
	//中序遍历
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
	//后序遍历
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
	
	//最小值
	public Node min(){
		Node tempNode = rootNode;
		while(tempNode.left != null){
			tempNode = tempNode.left;
		}
		return tempNode;
	}
	//最大值
	public Node max(){
		Node tempNode = rootNode;
		while(tempNode.right != null){
			tempNode = tempNode.right;
		}
		return tempNode;
	}
	//得到大小
	public int size(){
		return size;
	}
	
	public void tree_insert(BinaryTree tree, Node in){
		Node temp = null;
		Node parent = tree.rootNode;
		//该while实现遍历左右子树功能，直到parent的左或右子树变为空，代表到了左或右的尽头,这时可插入新的Node,且Node的父节点为parent。
		//插入的关键在于遍历到树的左右子树尽头，再与该尽头值比较，插入值即可。
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
		size++;//计算容量
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


//节点类，节点记录左节点、右节点、父节点。
class Node {
	Node left;
	Node right;
	Node parent;
	int data;
	public Node(int data){
		this.data = data;
	}
}