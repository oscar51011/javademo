package PracticeJava.lambda;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 測試 Java8 Function 用法
 * 引入一個參數，並針對該參數進行運算並回傳其結果
 * 
 * @author oscar51011
 *
 */
public class FuncationMain {

	public static void main(String[] args) {
		
		// 轉換 字串長度
		Function<String, Integer> function = new Function<String, Integer>(){
			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		
		Stream<String> stream = Stream.of("one", "two", "three");
		stream.map(function).forEach(System.out::println);
		
		System.out.println("***************");
		
		// 使用 lambda 的寫法
		Stream<String> stream2 = Stream.of("one", "two", "three");
		stream2.map(t-> t.length()).forEach(System.out::println);		
	}
}
