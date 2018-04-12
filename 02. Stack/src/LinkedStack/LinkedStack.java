package LinkedStack;

public class LinkedStack {
	int size;
	Node top;
	
	public LinkedStack() {
		this.size = 0;
		this.top = null;
	}
	
	public void push(int element) {
		Node node = new Node(element);
		
		if(this.top == null) {
			this.top = node;
		}
		else {
			node.setNext(this.top);
			this.top = node;
		}
		this.size++;
	}
	
	public Node pop() {
		if(this.size > 0) {
			Node node = this.top;
			this.top = this.top.getNext();
			this.size--;
			
			return node;
		}
		else {
			return null;
		}
	}
	
	public Node peek() {
		return this.top;
	}
	
	public int size() {
		return this.size;
	}
	
	public void print() {
		Node temp = this.top;
		System.out.print(" >> " + temp.getData() + " ");
		while((temp = temp.getNext()) != null) {
			System.out.print(temp.getData() + " ");
		}
		System.out.println();
	}
}
