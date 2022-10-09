package dataStructure.list.linkedlist;
/**
 * LinkedList 節點資訊
 * @author oscar51011
 * @date 2022年10月4日
 */
public class Node<E> {
	
	private E data;
	private Node<E> next;
	
	Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}
	
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
