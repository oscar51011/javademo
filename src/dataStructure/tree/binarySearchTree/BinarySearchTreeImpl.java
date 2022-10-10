package dataStructure.tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 實作 Binary Search Tree
 * @author oscar51011
 * @date 2022年10月10日
 */
public class BinarySearchTreeImpl implements BinarySearchTree {
	
	private Node root;
	
	/**
	 * 尋找節點
	 * @param item
	 * @return
	 */
	public boolean search(int item) {
		return find(root, item);
	}
	
	/**
	 * 尋找節點
	 * @param current
	 * @param item
	 * @return
	 */
	private boolean find(Node current, int item) {
		
		// 若此節點已經為空，代表無符合的資訊
		if(current == null)
			return false;
		
		// 如果找到符合的值，則回傳true
		if(current.getValue() == item)
			return true;
		
		// 如果值比較小就往左子樹找，反之則往右子樹找
		if(current.getValue() > item ) {
			return find(current.getLeft(), item);
		} else {
			return find(current.getRight(),item);
		}
	}
	
	/**
	 * 新增節點
	 * @param item
	 * @return
	 */
	public void add(int item) {
		root = addNode(root, item);
	}
	
	/**
	 * 使用遞迴去找尋要add的點
	 * @param root
	 * @param item
	 */
	private Node addNode(Node current, int item) {
		
		// 代表已經走訪到需要新增的點的位置
		if(current == null) {
			Node newNode = new Node(item);
			return newNode;
		}
		
		// 如果值比較小就往左子樹走，反之則往右子樹走
		if(current.getValue() > item) {
			current.setLeft(addNode(current.getLeft(), item));
		} else if ( current.getValue() < item ) {
			current.setRight(addNode(current.getRight(), item));
		} else {
			System.out.println( "item: " + item + "has alreadly existed.");
		}
		
		return current;
	}

	@Override
	public void delete(int item) {
		root = deleteNode(root, item);
	}
	
	/**
	 * 
	 * @return
	 */
	private Node deleteNode(Node current, int item) {
		
		// 如果找不到點，則回傳null
		if( current == null )
			return null;
		
		if ( current.getValue() > item ) {
			current.setLeft( deleteNode( current.getLeft(), item ) );
		} else if ( current.getValue() < item ) {
			current.setRight( deleteNode( current.getRight(), item ) );
		} else { // 如果找到點的處理方式
			
			// 把該點刪除
			current.setValue(null);
			
			// 如果點為 leaf node，讓其變成null
			if(current.getLeft() == null && current.getRight() == null )
				return null;
			
			// 如果只有一個 child，回傳該child的值
			if(current.getLeft() == null)
				return current.getRight();
			if(current.getRight() == null)
				return current.getLeft();
			
			// 如果兩個 child 都存在，則有兩種方式決定接下來的點
			// 1. inordderSuccessor 下一個(右子樹最小的點) 
			// 2. inorderPreSuccessor 找一個(左子樹最大的點)
			
			// 本案例採用 2 的方案，先找出左子樹最大的值賦予被刪除的點上，並用遞迴的方式把左子樹的點移除
			int biggestItemFromLeftNode = findBiggestItem(current.getLeft());
			current.setValue(biggestItemFromLeftNode);
			current.setLeft(deleteNode(current.getLeft(), biggestItemFromLeftNode));
		}

		return current;
	}
	
	/**
	 * 找到左子樹最大的值
	 * @param currentNode
	 * @return
	 */
	public int findBiggestItem(Node currentNode) {
		
		if(currentNode.getRight() == null )
			return currentNode.getValue();
		else
			return findBiggestItem( currentNode.getRight() );
	}
	
	@Override
	public void inorder() {
		inorderRecursive(root);
	}
	
	/**
	 * 採用 DFS 方式搜尋，inorder 規則是 LEFT -> ROOT -> RIGHT
	 * @param node
	 */
	private void inorderRecursive(Node node) {
		if(node != null) {
			inorderRecursive(node.getLeft());
			System.out.print(node.getValue() + " ");
			inorderRecursive(node.getRight());
		}
	}

	@Override
	public void preorder() {
		prerderRecursive(root);
	}
	
	/**
	 * 採用 DFS 方式搜尋，preorder 規則是 ROOT -> LEFT -> RIGHT
	 * @param node
	 */
	private void prerderRecursive(Node node) {
		if(node != null) {
			System.out.print(node.getValue() + " ");
			prerderRecursive(node.getLeft());
			prerderRecursive(node.getRight());
		}
	}

	@Override
	public void postorder() {
		postorderRecursive(root);		
	}
	
	/**
	 * 採用 DFS 方式搜尋，postorder 規則是 LEFT -> RIGHT -> ROOT
	 * @param node
	 */
	private void postorderRecursive(Node node) {
		if(node != null) {
			postorderRecursive(node.getLeft());
			postorderRecursive(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}

	/**
	 * 採用 BFS 方式搜尋，藉由實作 queue 方式
	 */
	@Override
	public void levelorder() {
		// 如果沒有 node 就不做事
		if(root == null) return;
		
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		
		// 只要 node 還有節點，就會持續走下去
		while(!nodes.isEmpty()) {
			// 造訪過就刪除
			Node currentNode = nodes.remove();
			System.out.print( currentNode.getValue() + " " );
			
			if(currentNode.getLeft() != null)
				nodes.add(currentNode.getLeft());
			
			if(currentNode.getRight() != null)
				nodes.add(currentNode.getRight());
			
			
		}
	}

}
