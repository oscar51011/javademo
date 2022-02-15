package PracticeJava.annotation;

/**
 * 測試 annotation @Inherited 的用法
 * @author oscar51011
 *
 */
public class Child extends Parent {

	@Override
	public void testInheritedAnnotation() {
		System.out.println("child");
	}

	@Override
	public void testSimpleAnnotation() {
		System.out.println("child");
	}

	
}
