package dataStructure.list.linkedlist;

public class LinkedListMain {
	
	public static void main(String[] args) {
		
		// 實作 LinkedList
		ILinkedList<String> list = new LinkedListImpl<>();
		System.out.println("初始化 size:"+ list.size());
		
		list.add("one");
		list.add("two");
		list.add("three");
		
		list.add(1,"special");
		
		// list.delete(2);
		
		list.delete("one");
		
		list.listAll();
		
	}
}
