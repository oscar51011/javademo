package dataStructure;

/**
 * 實作 Binary Search
 * 1. 使用前提為 資料已經排序過 & 存在 array中
 * 
 * @author oscar51011
 * @date 2022年9月21日
 */
public class BinarySearchMain {

	
	public static void main(String[] args) {
	
		int []sortedArray = new int[] {1, 4, 5, 7, 9, 10, 12, 15};
				
		int targetNumber = 9;
		int targetLocationFromIteration = BinarySearchImpl.dobinarySearchIterable(sortedArray, targetNumber);
		if(targetLocationFromIteration < 0)
			System.out.println( targetNumber + " 不存在." );
		else
			System.out.println( targetNumber + " 所在: " + targetLocationFromIteration );
		
		int targetLocationFromRecursive = BinarySearchImpl.dobinarySearchRecursive(sortedArray, targetNumber, 0, sortedArray.length-1);
		if(targetLocationFromRecursive < 0)
			System.out.println( targetNumber + " 不存在." );
		else
			System.out.println( targetNumber + " 所在: " + targetLocationFromRecursive );
	}
}
