package dataStructure.tree.binarySearchTree;

/**
 * 節點
 * @author oscar51011
 * @date 2022年10月10日
 */
public class Node {
	
	private Integer value;
	private Node left;
	private Node right;
	
	Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
