package JVM;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * test JVM constant pool OOM Args: -XX:PermSize=6M -XX:MaxPermSize=6M
 * ※ 因 JDK8後就移除了 PermSize參數，且JDK7時把永久區的常量池 移到了 java Heap 當中，因此就不會出現 常量池滿的錯誤
 * @author oscar51011
 * @date 2022年8月6日
 */
public class ConstantPoolOom {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		short i=0;	
		// intern() 是將字串加入 常量池中
		while(true) set.add(String.valueOf(i++).intern());
	}
}
