package dataStructure.queue.circularQueue;


/**
 * Demo Circular Queue
 * 1.isEmpty()
 * 2.front()
 * 3.rear()
 * 4.push()
 * 5.pop()
 * 
 * @author oscar51011
 * @date 2022年9月26日
 */
public class CircularQueueMain {

	public static void main(String[] args) {
		// 測試泛型
		demoQueueIntegerTypeCase();
		demoQueueStringTypeCase();
	}

	private static void demoQueueIntegerTypeCase() {
		System.out.println("===Integer Demo===");
		MyQueue<Integer> myQueue = new MyQueue<>(4);
		System.out.println("case1: 初始化後，預期為空:" + myQueue.isEmpty());
		
		try {
			myQueue.front();
		} catch (Exception e) {
			System.out.println("case2: 預期為空的情況，front會報錯");
		}
		
		try {
			myQueue.rear();
		} catch (Exception e) {
			System.out.println("case3: 預期為空的情況，rear會報錯");
		}
		
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		System.out.println("case4: push 1, 2, 3後，查看front，預期為1:" + myQueue.front());
		System.out.println("case5: push 1, 2, 3後，查看rear，預期為3:" + myQueue.rear());
		
		myQueue.pop();
		System.out.println("case6: pop 值後，查看front，預期為2:" + myQueue.front());
	}
	
	private static void demoQueueStringTypeCase() {
		System.out.println("===String Demo===");
		MyQueue<String> myQueue = new MyQueue<>(3);
		
		myQueue.push("test");
		myQueue.push("test2");
		
		System.out.println("case1: push test, test2後，查看front，預期為test:" + myQueue.front());
		System.out.println("case2: push test, test2後，查看rear，預期為test2:" + myQueue.rear());
		
		myQueue.pop();
		System.out.println("case3: pop 值後，查看front，預期為test2:" + myQueue.front());
	}
}
