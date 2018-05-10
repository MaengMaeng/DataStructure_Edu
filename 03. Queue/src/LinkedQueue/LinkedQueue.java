package LinkedQueue;

public class LinkedQueue {
	int size;
	Node front;
	Node rear;
	
	public LinkedQueue() {
		this.size = 0;
		this.front = null;
		this.rear = null;
	}
	
	public void offer(int element) {
		Node node = new Node(element);
		
		if(this.front == null) {
			this.front = this.rear = node;
		}
		else {
			this.rear.next = node;
			this.rear = node;
		}
		this.size++;
	}
	
	public Node poll() {
		if(this.front != null) {
			Node temp = this.front;
			if(this.size == 1) {
				this.front = this.rear = null;
			}
			else {
				this.front = this.front.next;				
			}
			return temp;
		}
		else {
			return null;
		}
	}
	
	public Node peek() {
		return this.front;
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		Node temp = this.front;
		String result = "";
		result = " >> " + temp.getData() + " ";
		while((temp = temp.getNext()) != null) {
			result += temp.getData() + " ";
		}
		return result + "\n";
	}
}
