package dataStructure;

/**
 * 實作 Stack
 * 1. isEmpty()
 * 2. top() <-> peek()
 * 3. push(i)
 * 4. pop()
 * 5. isFull()
 * 
 * @author oscar51011
 * @date 2022年9月25日
 */
public class StackMain {
	
	public static void main(String[] args) {			
		// 測試泛型
		demoStackIntegerTypeCase();
		demoStackStringTypeCase();
	}

	/**
	 * demo Integer 類別 Stack 操作
	 */
	private static void demoStackIntegerTypeCase() {
		MyStack<Integer> myStack = new MyStack<>(3);
		System.out.println("===Integer Case===");
		System.out.println("case1: 初始化,預期為空:" + myStack.isEmpty());
		
		try {
			myStack.pop();
		} catch (Exception e) {
			System.out.println("case2: 預期為空的情況，pop會報錯");
		}
		
		try {
			myStack.top();
		} catch (Exception e) {
			System.out.println("case3: 預期為空的情況，top取值會報錯");
		}
		
		myStack.push(1);
		myStack.push(2);
		
		System.out.println("case4: push兩次, 印出值(預期為2): " + myStack.top());
		System.out.println("case5: pop值(預期為2): " + myStack.pop());

		myStack.push(3);
		myStack.push(4);
		
		System.out.println("case6: 總共push 4次, pop 1次, 印出值(預期為4): " + myStack.top());
		System.out.println("case7: 總共push 4次, pop 1次(size為3, 預期已滿): " + myStack.isFull());
		
		try {
			myStack.push(5);
		} catch (Exception e) {
			System.out.println("case8: 預期已滿再Push 5會報錯");
		}
	}
	
	/**
	 * demo String 類別 Stack 操作
	 */
	private static void demoStackStringTypeCase(){
		MyStack<String> myStackString = new MyStack<>(2);
		System.out.println("===String Case===");
		myStackString.push("test");
		myStackString.push("test2");
		System.out.println("case1: push 2次，印出值(預期印出 test2)" + myStackString.top());
		System.out.println("case1: pop 1次(預期pop出 test2)" + myStackString.pop());
	}
}
