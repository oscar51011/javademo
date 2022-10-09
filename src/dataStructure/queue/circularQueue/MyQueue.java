package dataStructure.queue.circularQueue;

/**
 * 實作 Circular Queue (預留一個空間來判斷空 or 滿)
 * 
 * @author oscar51011
 * @date 2022年9月26日
 */
public class MyQueue<E> {
	
	private Object queue[];

	// 容量
	private int capacity;
	
	// 前端指針
	private int front;
	
	// 末端指針
	private int rear;
	
	
	/**
	 * 初始化 queue 指針都指向同一個地方0
	 * @param capacity
	 */
	MyQueue(int capacity) {
		queue = new Object[capacity];
		this.capacity = capacity;
		front = 0;
		rear = 0;
	}

	/**
	 * 檢查queue是否為空，如果指針指向同一個地方，代表queue是空的
	 * @return
	 */
	public boolean isEmpty() {
		return front == rear;
	}
		
	/**
	 * 取出最前端的值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E front() {
		if(this.isEmpty()) throw new RuntimeException("Queue is empty");
		return (E) queue[(front+1)%capacity];
	}
	
	/**
	 * 取出最末端的值
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E rear() {
		if(this.isEmpty()) throw new RuntimeException("Queue is empty");
		return (E) queue[rear];
	}
	
	/**
	 * 將值加在最末端
	 * @return
	 */
	public E push(E item) {
		
		// 檢查前方是否還有格子可以存放
		if((rear+1)%capacity == front) throw new RuntimeException("Queue is full");
		
		rear = (rear+1)%capacity;
		queue[rear] = item;
		
		return item;
	}
	
	/**
	 * 將值從最前端取出
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E pop() {
		
		if(this.isEmpty()) throw new RuntimeException("Queue is empty");
		front = (front+1)%capacity;	
		E result = (E) queue[front];
		//把值取出並設為空
		queue[front] = null;
		
		return result;
	}
	
	
}
