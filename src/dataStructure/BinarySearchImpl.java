package dataStructure;

/**
 * 實作 二元搜尋
 * @author oscar51011
 * @date 2022年9月22日
 */
public class BinarySearchImpl {
	/**
	 * 使用 迴圈 實作二元搜尋( 如果不存在則回傳 -1 )
	 * 
	 * @param sortedArray 排序後的陣列
	 * @param target 目標物
	 * @return
	 */
	public static int dobinarySearchIterable(int[] sortedArray, int target) {
		
		int left = 0;
		int right = sortedArray.length-1;
		
		while(left<=right) {
			int mid = (left + right) / 2;
			if(target > sortedArray[mid])
				left = mid + 1;
			else if(target < sortedArray[mid])
				right = mid -1;
			else
				return mid;
		}
		
		return -1;
	}
	
	/**
	 * 使用 遞回 實作 二元搜尋( 如果不存在則回傳 -1 )
	 * 
	 * @param sortedArray 排序後的陣列
	 * @param target 目標物
	 * @param left 選取範圍最小index
	 * @param right 選取範圍最大index
	 * @return
	 */
	public static int dobinarySearchRecursive(int[] sortedArray, int target, int left, int right) {
		
		if(left <= right){
			int mid = (left + right) / 2;
			if(target > sortedArray[mid])
				return dobinarySearchRecursive(sortedArray, target, mid+1, right);
			else if(target < sortedArray[mid])
				return dobinarySearchRecursive(sortedArray, target, left, mid-1);
			else
				return mid;
		}
		
		return -1;
	}
}
