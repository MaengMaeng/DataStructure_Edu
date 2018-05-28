package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree <T extends Comparable<?>>{
	public Node<T> root;
	
	public BinarySearchTree(Node<T> root) {
		this.root = root;
	}
	
	public void add(int data) {
		Node<T> addNode = new Node<T>(data);
		
		if(this.root == null) {
			this.root = addNode;
		}
		else {
			Node<T> temp = this.root;
			Node<T> previous = this.root;
			
			while(temp != null) {
				previous = temp;
				if(temp.data > data) {
					temp = temp.left;
				}
				else if(temp.data < data){
					temp = temp.right;
				}
				else {
					System.out.println("이미 데이터가 존재 합니다.");
					return;
				}
			}
			
			if(previous.data > data) {
				previous.left = addNode;
			}
			else {
				previous.right = addNode;
			}
		}
	}
	
	public boolean delete(int data) {
		if(this.search(data)) {
			Node<T> temp = this.root;
			Node<T> previous = this.root;
			
			while(temp.data != data) {
				if(temp.data > data) {
					temp = temp.left;
				}
				else {
					temp = temp.right;
				}
			}
			
			if(temp.left == null && temp.right == null) {
				if(previous.left.data == temp.data) {
					previous.left = null;
				}
				else {
					previous.right = null;
				}
			}
			else if((temp.left == null && temp.right != null) || (temp.left != null && temp.right == null)) {
				if(temp.right == null) {
					if(previous.left.data == temp.data) {
						previous.left = temp.left;
					}
					else {
						previous.right = temp.left;
					}
				}
				else {
					if(previous.left.data == temp.data) {
						previous.left = temp.right;
					}
					else {
						previous.right = temp.right;
					}
				}
			}
			else{
				Node<T> successor = temp.right;
				Node<T> successor_prev = temp;
				
				while(successor.left != null) {
					successor_prev = successor;
					successor = successor.left;
				}
				
				if(successor_prev == temp) {
					successor.left = temp.left;
					previous.right = successor;
				}
				else {
					temp.data = successor.data;
					successor_prev.left = successor.right;
				}
			}
		}
		
		return false;
	}
	
	public boolean search(int data) {
		Node<T> temp = this.root;
		
		while(temp != null) {
			if(temp.data == data) {
				return true;
			}
			else if(temp.data > data){
				temp = temp.left;
			}
			else {
				temp = temp.right;
			}
		}
		
		return false;
	}
	
	public void print() {
		BTreePrinter.printNode(this.root);
	}
}

class BTreePrinter {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<Node<T>>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}