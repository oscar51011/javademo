package dataStructure.tree.binarySearchTree;

/**
 * 定義 Binary Search Tree 介面
 * @author oscar51011
 * @date 2022年10月10日
 */
public interface BinarySearchTree {
	public boolean search(int item);
	public void add(int item);
	public void delete(int item);
	public void inorder();
	public void preorder();
	public void postorder();
	public void levelorder();
}
