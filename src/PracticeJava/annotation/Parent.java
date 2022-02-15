package PracticeJava.annotation;

/**
 * 測試 annotation @Inherited 的用法
 * @author oscar51011
 *
 */
@InheritedAnnotation("Inherited-class-level")
public class Parent {

	@InheritedAnnotation("Inherited-method-level")
	public void testInheritedAnnotation() {
		System.out.println("parent");
	};
	
	@CustomAnnotation("parent")
	public void testSimpleAnnotation() {
		System.out.println("parent");
	}
}
