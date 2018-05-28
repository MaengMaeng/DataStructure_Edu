package Tree;

public class Node<T extends Comparable<?>> {
	public int data;
	public Node<T> left;
	public Node<T> right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node(int data, Node<T> left, Node<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
