package dataStructure.recursiveProblem;

/**
 * 實作費伯納西數列
 * 
 * @author oscar51011
 * @date 2022年9月23日
 */
public class FibonacciImpl {

	/**
	 * 使用迴圈實作 實作費伯納西數列
	 * 
	 * @param n
	 * @return
	 */
	public static int doFibonacciIterable(int n) {
		// 0,1 皆回傳1
		if(n<=1)
			return n;
		
		// 初始化兩個fib的值 F2 = F1+F0 , F3 = F2+F1 故每次都要置換fibLow & FibHigh
		int fibLow = 0; // F0
		int fibHigh = 1; // F1
		int temp;
		//temp fibLow fibHigh
		// F0 +  F1  =  F2
		//  0    1      1
		// F1 +  F2  =  F3
		//  1    1      2
		// F2 +  F3  =  F4
		//  1    2      3
		// F3 +  F4  =  F5
		//  2    3      5
		// F4 +  F5  =  F6
		//  3    5      8
		
		for(int i=2;i<=n;i++) {
			temp = fibLow;
			fibLow = fibHigh;
			fibHigh = temp + fibLow;
		}
			
		return fibHigh;
	}
	
	/**
	 * 使用迴圈實作 實作費伯納西數列(比較直覺想到的作法)
	 * 
	 * @param n
	 * @return
	 */
	public static int doFibonacciIterableFromIntuition(int n) {
		// 0,1 皆回傳1
		if(n<=1)
			return n;
		
		// 初始化兩個fib的值 F2 = F1+F0 , F3 = F2+F1 故每次都要置換fibLow & FibHigh
		int fibLow = 0; // F0
		int fibHigh = 1; // F1
		int answer = 0; // 結果
		//fibLow fibHigh answer
		// F0 +  F1  =  F2
		//  0    1      1
		// F1 +  F2  =  F3
		//  1    1      2
		// F2 +  F3  =  F4
		//  1    2      3
		// F3 +  F4  =  F5
		//  2    3      5
		// F4 +  F5  =  F6
		//  3    5      8
		
		for(int i=2;i<=n;i++) {
			answer = fibLow + fibHigh;
			if(i==n)break;
			fibLow = fibHigh;
			fibHigh = answer;
		}
		
		return answer;
	}
	
	/**
	 * 使用遞迴實作 實作費伯納西數列
	 * 
	 * @param n
	 * @return
	 */
	public static int doFibonacciRecursive(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else
			return doFibonacciRecursive(n-1) + doFibonacciRecursive(n-2);

	}
}
