package EffectiveJava.rule52;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 按照書中範例演示 為何使用 overload 需要謹慎 
 * 
 * @author oscar51011
 *
 */
public class CollectionClassifier {

	public static String classify(Set<?> set) {
		return "Set";
	}
	
	public static String classify(List<?> list) {
		return "List";
	}
	
	public static String classify(Collection<?> collection) {
		return "Unknown collection";
	}
	
	
}
