package temp;

public class LinkedList {
	private Node head;
	private int size;
	
	public LinkedList(){
		this.head = null;
		this.size = 0;
	}
	
	public void add(int data) {
		Node add = new Node(data);
		add.setNext(this.head);
		this.head = add;
		this.size++;
	}

	public boolean delete(int index) {
		if(index >= this.size) {
			return false;
		}
		else {
			if(index == 0) {
				this.head = this.head.getNext();
				this.size--;
				return true;
			}
			else if(index == this.size-1) {
				Node temp = this.head;
				
				for(int i = 0; i < this.size-2; i++) {
					temp = temp.getNext();
				}
				System.out.println(temp.getData());
				temp.setNext(null);
				this.size--;
				return false;
			}
			else{
				Node temp = this.head;
				
				for(int i = 0; i < index-1; i++) {
					temp = temp.getNext();
				}
				System.out.println(temp.getData());
				temp.setNext(temp.getNext().getNext());
				this.size--;
				return false;
			}			
		}
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void print() {
		Node temp = this.head;
		System.out.print(" >> " + temp.getData() + " ");
		while((temp = temp.getNext()) != null) {
			System.out.print(temp.getData() + " ");
		}
		System.out.println();
	}
}
