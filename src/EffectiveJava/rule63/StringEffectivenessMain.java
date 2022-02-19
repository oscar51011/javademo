package EffectiveJava.rule63;

/**
 * 驗證字串連接時, 應避免使用 String 相加的方式 而是使用對應的 StringBuilder API
 * 
 * @author oscar51011
 *
 */
public class StringEffectivenessMain {
	
	public static final int counter = 100000;
	public static final String connectString = "A";
	
	public static void main(String[] args) {
		
		// 使用加號連接字串
		long timeBeforePlus = System.currentTimeMillis();
		StringEffectivenessMain.connectStringUsePlus();
		long timeAfterPlus = System.currentTimeMillis();
		
		// 使用StringBuilder 連接字串
		long timeBeforeStringBuilder = System.currentTimeMillis();
		StringEffectivenessMain.connectStringUseStringBuilderAPI();
		long timeAfterStringBuilder = System.currentTimeMillis();
		
        System.out.println("使用加號連接字串所花費時間： " + (timeAfterPlus-timeBeforePlus) + "毫秒");
        System.out.println("使用StringBuilder API連接字串所花費時間： " + (timeAfterStringBuilder-timeBeforeStringBuilder) + "毫秒");
	}
	
	/**
	 * 使用字串相加的方式連接字串
	 * @return
	 */
	private static String connectStringUsePlus() {
		String result = "";
		for(int i=0; i<counter; i++)
			result += connectString;
		return result;
	}
	
	/**
	 * 使用StringBuilder API 連接字串
	 * @return
	 */
	private static String connectStringUseStringBuilderAPI() {
		StringBuilder result = new StringBuilder();
		for(int i=0; i<counter;i++)
			result.append(connectString);
		return result.toString();
	}
}
