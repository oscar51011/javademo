package EffectiveJava.rule03;

/**
 * 因使用直接new的方式, 如果都沒有用到, 成本很高, 因此調整 lazy loading 的方式, 需要用才產實例
 * @author oscar51011
 * @date 2022年5月22日
 */

public class StaticFoctorylazySingleton {
	
	private static StaticFoctorylazySingleton INSTANCE;
	
	public static StaticFoctorylazySingleton getInstance() {
		if(null == INSTANCE ) {
			INSTANCE = new StaticFoctorylazySingleton();
		}
		return INSTANCE;
	}
	
	public void demo() {
		System.out.println("StaticFoctorylazySingleton demo.");
	}
}
