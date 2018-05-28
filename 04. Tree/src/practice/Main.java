package practice;

import Tree.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(null);
		
		bst.add(5);
		bst.add(1);
		bst.add(2);
		bst.add(15);
		bst.add(7);
		bst.add(3);
		bst.add(4);
		bst.add(16);
		bst.add(17);
		bst.add(0);
		bst.add(14);
		bst.add(13);
		bst.add(6);
		bst.print();
		
		bst.delete(15);
		
		bst.print();
		
		bst.delete(5);
		bst.print();
	}
}
