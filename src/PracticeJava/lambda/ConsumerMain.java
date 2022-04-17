package PracticeJava.lambda;

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 測試 java8 Consumer 用法
 * 引入一個參數，對該參數做處理(並不會有回傳值)
 * 
 * @author oscar51011
 *
 */
public class ConsumerMain {
	
	public static void main(String[] args) {
		
		Consumer<String> comsumer = new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		Stream<String> stream = Stream.of("one", "two", "three");
		stream.forEach(comsumer);
		
		System.out.println("***************");
		
		// 使用 lambda 的寫法
		Stream<String> stream2 = Stream.of("one", "two", "three");
		stream2.forEach( t -> System.out.println(t));		
	}
}
