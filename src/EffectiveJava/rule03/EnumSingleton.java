package EffectiveJava.rule03;

/**
 * enum singleton
 * @author oscar51011
 * @date 2022年5月22日
 */
public enum EnumSingleton {

	INSTANCE;
	
	public void demo() {
		System.out.println("EnumSingleton demo.");
	}
}
