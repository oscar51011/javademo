package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * test VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath={自定義}
 * TODO: 下載 Eclipse Memory Analyzer 研究
 * @author oscar51011
 * @date 2022年8月4日
 */
public class HeapOom {

	static class OomObject{
		
	}
	
	public static void main(String[] args) {
		System.out.println("start");
		List<OomObject> list = new ArrayList<>();
		while(true) {
			list.add(new OomObject());
		}
	}
}
