package PracticeJava.lambda;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 測試 Java8 Supplier 用法
 * 不引入參數，回傳值
 * @author oscar51011
 *
 */
public class SupplierMain {
	
	public static void main(String[] args) {
		
		// 每次引用時，回傳邏輯行為
		Supplier<String> supplier = new Supplier<String>() {

			@Override
			public String get() {
				return "test";
			}
		};
		
		// Stream 的 generate 可以產生無限次的 Supplier 行為操作
		Stream.generate(supplier).limit(3).forEach(System.out::println);
		
		System.out.println("***************");
		
		// 使用 lambda 的寫法
		Stream.generate(()-> new String("test")).limit(3).forEach(System.out::println);
	}
}
