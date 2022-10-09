package dataStructure.recursiveProblem;

/**
 * 實作費伯納西數列
 * 
 * 規則:
 * 	Fn = 0 if n=0
 *  Fn = 1 if n=1
 *  Fn = fn-1 + fn-2 if n>2
 *  
 *  Ex: 
 *  
 * index: 0 | 1 | 2 | 3 | 4 | 5 | 6
 * value: 0 | 1 | 1 | 2 | 3 | 5 | 8 ...etc
 * 
 * 
 * @author oscar51011
 * @date 2022年9月23日
 */
public class FibonacciMain {

	public static void main(String[] args) {
		
		System.out.println("Iterable:");
		System.out.println("F0:" + FibonacciImpl.doFibonacciIterable(0) );
		System.out.println("F1:" + FibonacciImpl.doFibonacciIterable(1) );
		System.out.println("F6:" + FibonacciImpl.doFibonacciIterable(6) );
		System.out.println("F6(直覺寫法):" + FibonacciImpl.doFibonacciIterableFromIntuition(6) );
		
		System.out.println("======");
		
		System.out.println("Recursive:");
		System.out.println("F0:" + FibonacciImpl.doFibonacciRecursive(0) );
		System.out.println("F1:" + FibonacciImpl.doFibonacciRecursive(1) );
		System.out.println("F6:" + FibonacciImpl.doFibonacciRecursive(6) );
	}
}
