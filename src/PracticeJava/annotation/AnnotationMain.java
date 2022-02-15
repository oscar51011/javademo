package PracticeJava.annotation;

import java.lang.reflect.Method;

/**
 * 用來演示客製化 Annotation 的使用方式
 * 
 * @author oscar51011
 *
 */
public class AnnotationMain {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		AnnotationMain main = new AnnotationMain();
		main.test();
		
		System.out.println("======");
		
		main.testInherited();
		
	}

	/**
	 * 透過反射機制取得 Main Class 上面方法的 註解, 並顯示客製化的值
	 * 1. 超過一個值時，需要各自定義，且 value 可為複數(因為型態定義為 String[])
	 * 2. 只有value賦值時, 可以省略; annotation 參數可以有預設值
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	@CustomAnnotation(value = {"test", "test2"}, message = "one")
	//@CustomAnnotation("test")
	public void test() throws NoSuchMethodException, SecurityException {
		
		// 使用反射機制
		CustomAnnotation customAnnotation = AnnotationMain.class.getMethod("test").getAnnotation(CustomAnnotation.class);
		
		String[] values = customAnnotation.value();
		
		// 取得 value
		System.out.println("value:");
		for(String value: values) 
			System.out.println(value);
		
		// 取得 messsage
		System.out.println("message: " + customAnnotation.message());
	}

	/**
	 * @Inherited 元註解 只有在 class-level 繼承底下才可以使用
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public void testInherited() throws NoSuchMethodException, SecurityException {
		
		Class<Child> clazz = Child.class;
		// class level
		if(clazz.isAnnotationPresent(InheritedAnnotation.class)) {
			System.out.println(clazz.getAnnotation(InheritedAnnotation.class).value());
		}
		
		// method level ( 沒有反應 )
		Method testInheritedAnnotation = clazz.getMethod("testInheritedAnnotation", null);
		if(testInheritedAnnotation.isAnnotationPresent(InheritedAnnotation.class)){
			System.out.println(clazz.getAnnotation(InheritedAnnotation.class).value());
		}
		
	}
}
