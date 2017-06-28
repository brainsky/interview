package static_constructor_learn;
import static java.lang.System.out;
/**
 * 栈的实现，这里我的经验是栈中主要记录了当前节点的以前节点的信息，记住这个。
 * @author Administrator
 *
 */
public class StackImpl {
	public Node head;
	public Node current;
	//入栈
	public void push(int data){
		//这一部分，如果头部为空，创建新节点为头部，并把当前节点指向头部。
		//第二个是重点，入栈的关键是把当前节点赋值以及它的前驱节点赋值就行。
		if(head == null){
			head = new Node(data);
			current = head;
		}else{
			Node node = new Node(data);
			node.pre = current;
			current = node;
		}
		
	}
	//出栈，出栈是一个逆过程，把当前节点取出来，它的前节点指定为当前节点。
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
