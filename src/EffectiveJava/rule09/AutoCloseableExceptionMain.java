package EffectiveJava.rule09;

public class AutoCloseableExceptionMain {

	public static void main(String[] args) {
		try {
			AutoCloseableExceptionMain.test();
		} catch (Exception e) {
			 System.out.println("Logic Exception message:" + e);
			 
			Throwable[] throwables = e.getSuppressed();
			for(Throwable t : throwables) {
				System.out.println("Suppressed Exception message:" + t);
			}
		}
	}
	
	public static void test() throws Exception {
		try(DemoCloseableService s = new DemoCloseableService()){
			System.out.println("do service");
			throw new Exception("logic exception");
		}
	}
}
