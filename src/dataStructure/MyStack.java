package dataStructure;

/**
 * 實作Stack
 * 
 * @author oscar51011
 * @date 2022年9月26日
 */
public class MyStack<E> {

	private Object[] stack;
	
	// 現在 stack 的 index
	private int pointer;
	
	// stack 初始化的大小
	private int capacity;

	MyStack(int capacity) {
		stack = new Object[capacity];
		this.capacity = capacity;
		pointer = -1; 
	}
	
	/**
	 * 取得最上面的元素
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E top() {
		if(isEmpty()) throw new RuntimeException("Stack is empty.");
		return (E) stack[pointer];
	}
	
	/**
	 * 檢查是否為空
	 * @return
	 */
	public boolean isEmpty() {
		if( pointer == -1) 
			return true;
		else
			return false;
	}
	
	/**
	 * 檢查是否已滿，如果指針指到陣列最大值，代表已經滿了
	 * @return
	 */
	public boolean isFull() {
		if( pointer == capacity-1 )
			return true;
		else
			return false;
	}
	
	/**
	 * 取出元素
	 */
	public E pop()
	{
		if(isEmpty()) throw new RuntimeException("Stack is empty.");
		// 拿出最上面的值
		E result = top();
		// 把當前值null並退回指針
		stack[pointer--] = null;
		return result;
	}
	
	/**
	 * 放入元素
	 * @param item
	 * @return
	 */
	public E push(E item) {
		if(isFull()) throw new RuntimeException("Stack is full.");
		// 移動指針並放入值
		stack[++pointer]=item;
		return item;
	}
	
}
