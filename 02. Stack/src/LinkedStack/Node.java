package LinkedStack;

public class Node {
	private int data;
	private Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public int getData() {
		return this.data;
	}
}
