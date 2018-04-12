package LinkedList;

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
		if(index >= this.size) { // index가 사이즈보다 크거나 같으면 실패이므로 false 반환
			return false;
		}
		else {
			if(index == 0) { // 가장 처음을 삭제할 때
				Node temp = this.head;
				this.head = this.head.getNext();
				this.size--;
				System.out.println("!" + index +"번째 원소 삭제 : " + temp.getData());
				return true;
			}
			else{	// 그 외 나머지
				Node temp = this.head;
				
				for(int i = 0; i < index-1; i++) {
					temp = temp.getNext();
				}
				System.out.println("!" + index +"번째 원소 삭제 : " + temp.getNext().getData());
				temp.setNext(temp.getNext().getNext());
				this.size--;
				return true;
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
