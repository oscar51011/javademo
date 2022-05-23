package EffectiveJava.rule03;

/**
 * private constructor + static factory 實現 singleton
 * @author oscar51011
 * @date 2022年5月22日
 *
 */
public class StaticFactorySingleton {

	private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();
	
	private StaticFactorySingleton() {
	}
	
	public static StaticFactorySingleton getInstance() {
		return INSTANCE;
	}
	
	public void demo() {
		System.out.println("StaticFactorySingleton demo.");
	}
}
