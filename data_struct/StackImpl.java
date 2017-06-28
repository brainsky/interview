package static_constructor_learn;
import static java.lang.System.out;
/**
 * 数组形式实现
 * @author Administrator
 *
 */
public class StackImpl {
	public Node head;
	public Node current;
	//入栈
	public void push(int data){
		//判断是否为空
		if(head == null){
			head = new Node(data);
			current = head;
		}else{
			Node node = new Node(data);
			node.pre = current;
			current = node;
		}
		
	}
	//出栈
	public Node pop(){
		if(current == null){
			return null;
		}
		Node node = current;
		current = current.pre;
		return node;
	}
	public boolean isEmpty(){
		return current == null;
	}
	class Node{
		//记录数据
		int data;
		//记录当前节点的前驱节点
		Node pre;
		Node(int data){
			this.data = data;
		}
	}
	public static void main(String args[]){
		StackImpl stack = new StackImpl();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		out.println(stack.pop().data);
		out.println(stack.isEmpty());
		out.println(stack.pop().data);
		out.println(stack.pop().data);
		
	}
	
}
