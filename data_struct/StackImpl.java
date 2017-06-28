package static_constructor_learn;
import static java.lang.System.out;
/**
 * 栈的实现，这里我的经验是栈中主要是赋值当前节点和它前驱节点的信息，记住这个。
 * 你也可以记住这个，算法导论中的伪代码，非常简单，实现就自行发挥。
 * STACK-EMPTY(S)//S为一个容器，书中为数组，且它有一个属性top。
 *	if S.top == 0
 *		return TRUE
 *	else return FALSE
 * 入栈,思想就2行，会非常惊讶吧
 * PUSH(S, x)
 *	S.top = S.top + 1
 *	S[S.top] = x
 * 出栈,只是弹出栈顶元素，所以return S[S.top],但是栈顶指针要指向栈顶下的一个元素，所以有S.top = S.top -1
 * 
 * POP(S)
 *  	if STACK-EMPTY(S)
 *		error "underflow"
 *	else S.top = S.top -1
 *		return S[S.top + 1]
 * 其实我非常佩服《算法导论》这本书，也推荐读者去读一读，它的思想是非常非常简洁。我原来看到树就头疼，更不要说自己实现一颗树了，
 * 但是这本书里的思想真的非常简单，像我这种基础不扎实的都能实现，何况你呢？而且算法是内功，其实当你用到框架处理各种事务后会发现
 * 真正能提高自己的是算法，程序里不变的是这个，框架会变，语言会变。而且我预言有3-5年工作经验后，应该体验得更深，项目经验很有局限，
 * 下个项目未必能用到，这就说明我们不能靠项目经验去创造。只能解决过去出现过的问题，而用算法是可以创造新的东西的，这是两者最大的区别。
 * 最后，能创造才会无可限量，别人和你自己都无法估计你的未来，要不然，基本上20岁就干着60岁的工作。你会愿意吗？
 * @author LKD
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
		return top == null;
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
