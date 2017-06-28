package static_constructor_learn;
import static java.lang.System.out;
/**
 * ������ʽʵ��
 * @author Administrator
 *
 */
public class StackImpl {
	public Node head;
	public Node current;
	//��ջ
	public void push(int data){
		//�ж��Ƿ�Ϊ��
		if(head == null){
			head = new Node(data);
			current = head;
		}else{
			Node node = new Node(data);
			node.pre = current;
			current = node;
		}
		
	}
	//��ջ
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
		//��¼����
		int data;
		//��¼��ǰ�ڵ��ǰ���ڵ�
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
