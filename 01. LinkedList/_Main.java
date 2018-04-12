package temp;

public class _Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		LinkedList a = new LinkedList();
		
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.print();
		
		a.delete(2);
		
		a.print();
		
		a.delete(0);
		a.print();
		
		a.delete(a.getSize()-1);
		a.print();
		
		System.out.println(a.getSize());
	}

}
