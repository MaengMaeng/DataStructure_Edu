package LinkedStack;

public class _Main {
	public static void main(String[] args) {
		LinkedStack ls = new LinkedStack();
		
		ls.push(1);
		ls.push(2);
		ls.push(3);
		ls.push(5);
		ls.print();
		
		System.out.println(ls.pop().getData());
		
		
	}
}
