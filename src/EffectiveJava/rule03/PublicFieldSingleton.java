package EffectiveJava.rule03;

/**
 * private constructor + public static final field 實現 singleton
 * @author oscar51011
 * @date 2022年5月22日
 *
 */
public class PublicFieldSingleton {

	public static final PublicFieldSingleton INSTANCE = new PublicFieldSingleton();
	
	public void demo() {
		System.out.println("PublicFieldSingleton demo.");
	}
}
