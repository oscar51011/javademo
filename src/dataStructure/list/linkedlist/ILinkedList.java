package dataStructure.list.linkedlist;

/**
 * 定義 LinkedList 規格
 * @author oscar51011
 * @date 2022年10月4日
 */
public interface ILinkedList<E> {
	// 新增元素在尾端
	public boolean add(E item);
	// 從第index的地方插入一個值
	public void add(int index, E item);
	// 刪除資料(如果有資料即刪除，如果沒有資料則無改變並回傳false)
	public boolean delete(E item);
	// 刪除第index的值(並回傳刪除的值
	public E delete(int index);
	// 取得list大小
	public int size();
	// 是否包含某元素
	public boolean contains(E item);
	// 歷遍
	public void listAll();
}
