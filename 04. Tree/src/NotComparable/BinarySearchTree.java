package NotComparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree{
	public Node root;
	
	public BinarySearchTree(Node root) {
		this.root = root;
	}
	
	public void insert(int data) {
		Node addNode = new Node(data);
		
		if(this.root == null) {
			this.root = addNode;
		}
		else {
			Node temp = this.root;
			Node previous = this.root;
			
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
			Node temp = this.root;
			Node previous = null;
			
			while(temp.data != data) {
				previous = temp;
				if(temp.data > data) {
					temp = temp.left;
				}
				else {
					temp = temp.right;
				}
			}
			
			if(temp.left == null && temp.right == null) {
				System.out.println("자식이 없을 때");
				if(previous == null) {
					this.root = null;
					return true;
				}
				
				if(previous.left.data == temp.data) {
					previous.left = null;
				}
				else {
					previous.right = null;
				}
			}
			else if((temp.left == null && temp.right != null) || (temp.left != null && temp.right == null)) {
				System.out.println("자식이 하나 일 때");
				if(temp.right == null) {
					if(previous != null) {
						if(previous.left.data == temp.data) {
							previous.left = temp.left;
						}
						else {
							previous.right = temp.left;
						}
					}
					else {
						this.root = temp.left;
					}
				}
				else {
					if(previous != null) {
						if(previous.left.data == temp.data) {
							previous.left = temp.right;
						}
						else {
							previous.right = temp.right;
						}
					}
					else {
						this.root = temp.right;
					}
				}
			}
			else{
				System.out.println("자식이 둘 일 때");
				Node successor = temp.right;
				Node successor_prev = temp;
				
				while(successor.left != null) {
					successor_prev = successor;
					successor = successor.left;
				}
				
				if(successor == temp.right) {
					temp.data = successor.data;
					temp.right = successor.right;
				}
				else{
					System.out.println(temp.data + ", " + successor.data + ", " + successor_prev.data);
					successor_prev.left = successor.right;
					temp.data = successor.data;
				}
			}
		}
		
		return false;
	}
	
	public boolean search(int data) {
		Node temp = this.root;
		
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

    public static <T extends Comparable<?>> void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
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

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<Node> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}