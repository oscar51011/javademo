package dataStructure.tree.binarySearchTree;

/**
 * Demo BST Tree
 * 
 * @author oscar51011
 * @date 2022年10月10日
 */
public class BinarySearchTreeMain {
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTreeImpl();
		
		bst.add(30);
		bst.add(25);
		bst.add(40);
		bst.add(28);
		bst.add(35);
		bst.add(50);
		bst.add(15);
		bst.add(10);
		
		System.out.println("\n === node trvaersal ===");
		// traversal BST
		System.out.println("inorder:");
		bst.inorder();
		System.out.println("\npreorder:");
		bst.preorder();
		System.out.println("\npostorder:");
		bst.postorder();
		System.out.println("\nlevelorder:");
		bst.levelorder();
	
		System.out.println("\n === practive delete node ===");
		
		// delete leaf node issue
		bst.delete(35);
		System.out.println("after deleted 35, inorder:");
		bst.inorder();
		System.out.println();
		
		// delete one child issue
		bst.delete(10);
		System.out.println("after deleted 35 and 15, inorder:");
		bst.inorder();
		System.out.println();
		
		// delete two child issue
		bst.delete(28);
		System.out.println("after deleted 35 and 15 and 28, inorder:");
		bst.inorder();
		
	}
}
