package PracticeJava.lambda;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 測試 Java8 Predicate 用法
 * 引入一個參數，然後回傳 boolean值
 * @author oscar51011
 *
 */
public class PredicateMain {
	
	public static void main(String[] args) {
	
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.length()>3;
			}
		};
		
		// 只有滿足長度超過3的才有辦法被過濾
		Stream<String> stream = Stream.of("one", "two", "three");
		stream.filter(predicate).forEach(System.out::println);
		
		System.out.println("***************");
		
		// 使用 lambda 的寫法
		Stream<String> stream2 = Stream.of("one", "two", "three");
		stream2.filter(t -> t.length()>3).forEach(System.out::println);
	}
}
