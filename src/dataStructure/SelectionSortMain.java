package dataStructure;

import java.util.Arrays;

/**
 * 實作 Selection Sort
 * 
 * input : [5, 9, 2, 8, 6]
 * output: [2, 5, 6, 8, 9]
 * 
 * @author oscar51011
 * @date 2022年9月24日
 */
public class SelectionSortMain {

	public static void main(String[] args) {
		
		int []input = new int[] {5, 9, 2, 8, 6};
	
		SelectionSortImpl.sortBySelectionSort(input);
		
		int []answer = new int[] {2, 5, 6, 8, 9};
		
		if( Arrays.equals(input, answer) ) 
			System.out.println("正確");
		else
			System.out.println("錯誤");
	}
}
