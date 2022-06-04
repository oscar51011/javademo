package PracticeJava.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 1. 使用 Charset library 的 defaultCharset 查看作業系統預設的編碼形式
 * 
 * 2. 使用 String 的 getBytes(charsetName) 把 字串 用定義的編碼格式
 *    把它 轉成 byte 陣列 ( encoding )
 *    
 * 3. 使用 new String(bytes[] , charsetName) 把 byte陣列 用定義的編碼格式
 *    把其 轉回 字串格式 ( decoding )
 * 
 * @author oscar51011
 * @date 2022年6月4日
 */
public class StringEncodingMain {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String city = "臺北市";
		System.out.println("deafult:" + Charset.defaultCharset());
		
		// 使用 UTF-8 互轉
		byte[] byteArrayUTF8 = city.getBytes();
		System.out.println( new String(byteArrayUTF8, "UTF-8"));
		
		// 使用 MS950 互轉
		byte[] byteArrayMS950 = city.getBytes("MS950");
		System.out.println( new String(byteArrayMS950, "MS950"));
		
	}
}
