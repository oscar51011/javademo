package EffectiveJava.rule03;

/**
 * Effective java 3 - 使用 private constructor or enum type 來實現 singleton
 * @author oscar51011
 * @date 2022年5月22日
 *
 */
public class Main {
	public static void main(String[] args) {
		// 方法1: singleton with public final field
		PublicFieldSingleton publicFieldSingleton = PublicFieldSingleton.INSTANCE;
		publicFieldSingleton.demo();
		
		// 方法2: singleton with static factory
		StaticFactorySingleton staticFactorySingleton = StaticFactorySingleton.getInstance();
		staticFactorySingleton.demo();
		
		// 方法3: singleton lazy initialization
		StaticFoctorylazySingleton staticFoctorylazySingleton = StaticFoctorylazySingleton.getInstance();
		staticFoctorylazySingleton.demo();
		
		// 方法4: enum singleton
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		enumSingleton.demo();
	}
}
