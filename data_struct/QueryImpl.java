package static_constructor_learn;
import static java.lang.System.out;
public class QueryImpl {
	private Node head;
	private Node current;
	//入队
	public void add(int data){
		if(head == null){
			head = new Node(data);
			current = head;
		}else{
			current.next = new Node(data);
			current = current.next;
		}
	}
	//出队
	public Node pop(){
		if(current == null){
			throw new RuntimeException("队列为空");
		}
		Node node = head;
		head = head.next;
		return node; 
	}
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	public static void main(String args[]){
		QueryImpl query = new QueryImpl();
		query.add(1);
		query.add(2);
		query.add(3);
		out.println(query.pop().data);
		out.println(query.pop().data);
		out.println(query.pop().data);
	}
}

