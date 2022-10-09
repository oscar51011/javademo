package dataStructure.list.linkedlist;

/**
 * 實作 LinkedList 
 * @author oscar51011
 * @date 2022年10月4日
 * @param <E>
 */
public class LinkedListImpl<E> implements ILinkedList<E> {
	
	// List第一個元素
	private Node<E> head;
	// List大小
	private int size;
	
	// 初始化 LinkedList
	LinkedListImpl() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public boolean add(E item) {
			
		Node<E> newNode = new Node<E>(item, null);

		if(head == null) {
			head = newNode;
		} else {
			Node<E> lastNode = head;
			while(lastNode.getNext() !=null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);
		}
		size++;
		return true;
	}

	@Override
	public void add(int index, E item) {
		if(head == null) {
			head = new Node<E>(item, null);
		} else {
			// 如果是開頭則把現行head往後擺, 並把最新的值給 head
			if(index == 0) {
				Node<E> newNode = new Node<E>(item, head);
				head = newNode;
			} else {
				// 如果是 0 以外用迴圈跑到 index 處 再進行置換
				Node<E> currentNode = head;
				for(int i=0;i<index-1;i++) {
					currentNode = currentNode.getNext();
				}
				// 取得原本下一個元素
				Node<E> originalNextNode = currentNode.getNext();
				// 初始化須插入的元素
				Node<E> nextNode = new Node<E>(item, originalNextNode);
				// 現行節點去接插入元素
				currentNode.setNext(nextNode);
			}
		}
		size++;
	}

	@Override
	public boolean delete(E item) {
		
		// 欲刪除的前一個node
		Node<E> prevNode = head;
		// 欲刪除的node
		Node<E> currentNode = head;
		int count=0;
		while(currentNode.getNext() !=null) {
			if(item.equals( currentNode.getData() )) {
				// 如果刪除的點是 head
				if(count==0) {
					currentNode.setData(null);
					head = currentNode.getNext();
				} else if(currentNode.getNext() == null) {
				// 假設欲刪除的點是最後一個點
					currentNode.setData(null);
				} else {
				// 假設刪除的點非最後一個點，把欲刪除的前一個節點接到欲刪除後一個節點
					currentNode.setData(null);
					prevNode.setNext(currentNode.getNext());
				}
				size--;
				return true;
			}
			prevNode = currentNode;
			currentNode = currentNode.getNext();
			count++;
		}	
		return false;
	}

	@Override
	public E delete(int index) {
		if(head == null) throw new RuntimeException("List is Empty");
		if(index == size) throw new RuntimeException("index error");
		
		if(index == 0) {
			E deletedData = head.getData();
			head.setData(null); // 將data設為null
			head = head.getNext();
			size--;
			return deletedData;
		} else {
			Node<E> currentNode = head;
			// 找到欲刪除的node的前一筆資料
			for(int i=0; i<index-1;i++) {
				currentNode = currentNode.getNext();
			}
			// 取得欲刪除的node
			Node<E> deletedNode = currentNode.getNext();
			// 如果刪除的node 是最後一筆資料，則把data設成null
			if(deletedNode.getNext() == null) {
				deletedNode.setData(null);
			} else {
			// 如果刪除的node 並非最後一筆資料，則把data設成null之外，並把 nextData設成下個node
				deletedNode.setData(null);
				currentNode.setNext(deletedNode.getNext());
			}			
			size--;
			return deletedNode.getData();
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(E item) {

		for(Node<E> node = head; node!= null; node = node.getNext()) {
			if(item.equals(node.getData()))
				return true;
		}

		return false;
	}

	@Override
	public void listAll() {
		if(head!=null && head.getNext() == null)
			System.out.println(head.getData());
		else {		
			for(Node<E> node = head; node!=null ; node = node.getNext()) {
				System.out.println(node.getData());
			}			
		}
	}

}
