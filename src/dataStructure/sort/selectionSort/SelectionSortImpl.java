package dataStructure.sort.selectionSort;

/**
 * 實作 Selection Sort
 * 時間複雜度 : O(n^2)
 * 
 * 
 * @author oscar51011
 * @date 2022年9月24日
 */
public class SelectionSortImpl {

	/**
	 * Selection Sort 排序法
	 * 從外層的起始 預設為最小值，遍歷剩餘的 array，找出最小值並置換
	 * 當整個外層迴圈走完，就從小到大排序完了
	 * 
	 * @param array
	 */
	public static void sortBySelectionSort(int []array) {
		
		for(int i=0; i <= array.length-1;i++) {
			int min = i; // 預設起始最小
			for(int j=i+1; j <= array.length -1; j++) {
				if( array[j] < array[min] )
					swap(array, j, min);
			}
		}
		
	}
	
	/**
	 * 把兩者交換
	 * @param array 處理的陣列
	 * @param i 第i個元素
	 * @param j 第j的元素
	 */
	private static void swap(int []array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
