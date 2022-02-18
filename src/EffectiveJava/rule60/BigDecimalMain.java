package EffectiveJava.rule60;

import java.math.BigDecimal;

/**
 * 需要精確答案時, 避免使用 float & double.
 * 測試 使用 float & double 計算精密資料的後果
 * 
 * @author oscar51011
 *
 */
public class BigDecimalMain {

	public static void main(String[] args) {
		
		// 使用小數點相減時, 並不會得到精確的答案 0.61 而是0.6100000000000000001
		System.out.println(1.03-0.42);
		
		// 如果需要精確的答案 請使用 BigDecimal:
		// 使用 兩種方法將 primitive 參數轉換成 bigDecimal
		// 1. new BigDecimal(String value)
		// 2. valueOf()
		BigDecimal minuend = new BigDecimal(Double.toString(1.03));
		BigDecimal subtractionSubtraction = BigDecimal.valueOf(0.42);
		System.out.println(minuend.subtract(subtractionSubtraction));
		
		// 使用 new BigDecimal(double) 得到的值是不精確的 ( 因為傳入的 double 本身也只是一個近似值 )
		BigDecimal unsafeValue = new BigDecimal(1.02F);
		System.out.println("使用new BigDecimal(double)是不精確的: " + unsafeValue);
	}
	
}
