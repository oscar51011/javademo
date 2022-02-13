package EffectiveJava.rule52;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Case1:
 * 下述方法在 編譯時期(由宣告該變數的型別決定)皆為 Collection, 因此都會走到 classify(Collection<?> collection)的方法
 * HashSet 為 Collection 的子類別，其 overload 在編譯時期已經根據型別決定需要執行的方法
 * 
 * Case2:
 * List 的 remove 方法也是 overload，根據傳入不同的參數類型 primitive or Object 來決定操作行為
 * 
 * ※ Overload 是編譯時期決定要使用哪個方法
 * ※ 書中建議: 永遠不要產出兩個相同參數數目的 overload 方法
 * ※ 對此不同的傳入類型的議題, 可以使用 不同的 method name 明確定義其行為 example : classifySet(Set<?> s)
 * 
 * @author oscar51011
 *
 */
public class Main {
	
	public static void main(String[] args) {		
		
		// Case 1:測試 overload ( 編譯時期多態 )
		Collection<?>[] collections = {
			new HashSet<String>(),
			new ArrayList<String>(),
			new HashMap<String, String>().values()
		};
		for(Collection<?> collection: collections){
			System.out.println( CollectionClassifier.classify(collection) );
		}
		
		// 測試 override ( 執行時期多態 )
		List<Wine> wines = List.of(new Wine(), new SparklingWine(), new Champagne());
		for(Wine wine: wines) {
			System.out.println(wine.name());
		}
		
		// Case 2:Set & List remove
		/**
		 * List 有兩個 remove(Object o) , remove(int index) 為一個 overload 方法
		 * 根據放入的參數為 int or Integer 時，會有不同的結果
		 * 
		 */
		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();
		
		for(int i= -3;i<3;i++) {
			set.add(i);
			list.add(i);
		}
		for(int i= 0;i<3;i++) {
			set.remove(i);
			list.remove((Integer)i);
		}
		
		System.out.println(set);
		System.out.println(list);
		
		
		
		
	}
	
}
