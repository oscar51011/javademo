package dataStructure.recursiveProblem;

/**
 * 實作 數列排序
 * @author oscar51011
 * @date 2022年9月22日
 */
public class PermutationImpl {

	/**
	 * 使用遞迴實作 數列排序
	 * @param numberArray
	 */
	public static void printPermutation(String []numberArray, int startIndex, int endIndex) {
		
		if(startIndex==endIndex) {
			for(int i= 0; i<= numberArray.length-1;i++)
				System.out.print(numberArray[i]+" ");
			System.out.println();
		}
		
		for(int i=startIndex; i<=endIndex; i++) {
			swap(numberArray, i, startIndex);
			printPermutation(numberArray, startIndex+1, endIndex);
			swap(numberArray, startIndex, i);
		}
		
	}
	
	public static void swap(String[] numberArray, int a, int b) {
		String temp = numberArray[a];
		numberArray[a] = numberArray[b];
		numberArray[b] = temp;
	}
}
