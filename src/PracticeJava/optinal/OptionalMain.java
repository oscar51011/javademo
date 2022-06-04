package PracticeJava.optinal;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * 練習 Optional 使用
 * @author oscar51011
 * @date 2022年6月4日
 *
 */
public class OptionalMain {

	public static void main(String[] args) {
		
		System.out.println("== data not found ( before java 8 ) ==");
		
		// java8以前 ( 如果 null 則不顯示值)
		String nullValueBeforeJava8 = getMapValue("four");
		if(nullValueBeforeJava8 != null)
			System.out.println("Before java8 value is null: " + nullValueBeforeJava8);
		
		String value = getMapValue("three");
		if(value != null)
			System.out.println("Before java8 value is not null: " + value);
		
		System.out.println("== data not found ( java 8 ) ==");
		
		/**
		 * java8以後 沒有值的情況
		 */
		Optional<String> nullValueJava8 = getMapValueByOptional("four");
		
		// get() 用法
		if(nullValueJava8.isPresent())
			System.out.println("java8 Optional get() is not null:" + nullValueJava8.get());
		else
			System.out.println("java8 Optional get() is null: " + "mapValueIsNull");
		
		// orElse() 用法
		System.out.println("java8 Optional orElse() is null: " + nullValueJava8.orElse("mapValueIsNull"));
		
		// orElseGet()方法 , 隨機產一個1-100的亂數，根據奇數偶數顯示不同的邏輯
		System.out.println(nullValueJava8.orElseGet(()->{
			Random rd = new Random();
			int random = rd.nextInt(100);
			if(random%2 == 0)
				return "java8 Optional orElseGet() null logic : even";
			else
				return "java8 Optional orElseGet() null logic :　odd";
		}));
			
		// orElseThrow()方法
		try {
			System.out.println(nullValueJava8.orElseThrow(()-> new Exception("custom Exception")));
		} catch (Exception e) {
			System.out.println("test catch exception:" + e.getMessage());
		}
		
		System.out.println("== data exist ( java 8 )==");
		
		/**
		 * java8以後 有值的情況
		 */
		Optional<String> valueJava8 = getMapValueByOptional("three");
		if(valueJava8.isPresent())
			System.out.println("java8 Optional get() is not null:" + valueJava8.get());
		else
			System.out.println("java8 Optional get() is null:" + "mapValueIsNull");
		
		// orElse() 用法
		System.out.println("java8 Optional orElse() is not null: " + valueJava8.orElse("mapValueIsNull"));
		
		// isPresent()用法
		valueJava8.ifPresent( parameter -> {
			System.out.println("java8 Optional ifPresent() is not null:" + parameter);
		});
	
	}
	
	/**
	 * 取得map的值，如果沒有判斷 null 的情況，則會有 NullPointerException
	 * @param key
	 * @return
	 */
	public static String getMapValue(String key) {
		Map<String, String> map = new HashMap<>();
		map.put("one", "one");
		map.put("two", "two");
		map.put("three", "three");
		String value = map.get(key);
		return value;
	}
	
	public static Optional<String> getMapValueByOptional(String key) {
		Map<String, String> map = new HashMap<>();
		map.put("one", "one");
		map.put("two", "two");
		map.put("three", "three");
		String value = map.get(key);
		// 方法1: 判斷null
		//return value == null ? Optional.empty() : Optional.of(value);
		// 方法2: 濃縮上述的方法 如果不為 null則回傳值
		return Optional.ofNullable(value);
	}
}