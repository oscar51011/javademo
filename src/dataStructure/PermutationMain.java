package dataStructure;

/**
 * 實作 數列排列
 * Ex: 列出 a,b,c 的所有排序種類
 * 
 * 序列以第一個為基準，跟後面依序置換
 * 
 * 1-1互換     固定1(a) -> 2-2互換(b)
 * a [b,c] -> a, b [c]
 *  
 *            固定1(a) -> 2-3互換(b, c)
 *         -> a, c [b]
 *         
 * 1-2互換     固定1(b) -> 2-2互換(a)
 * b [a,c] -> b, a [c]
 * 
 *            固定1(b) -> 2-3互換(a, c)        
 *         -> b, c [a]
 *         
 * 1-3互換     固定1(c) -> 2-2互換(b)    
 * c [b,a] -> c, b [a]
 * 
 *            固定1(c) -> 2-3互換(a, b)
 *         -> c. a [b]
 * 
 * 換到只有最後一個參數時，把整個序列印出，即可得到結果        
 *         
 * @author oscar51011
 * @date 2022年9月22日
 */
public class PermutationMain {

	public static void main(String[] args) {
		
		String[] numberArray = new String[] {"a", "b", "c"};
		// b, c, d做排序
		PermutationImpl.printPermutation(numberArray, 0, numberArray.length-1);
		
	}
}
