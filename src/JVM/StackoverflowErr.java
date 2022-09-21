package JVM;

/**
 * test JVM stackOverflow error Args: -Xss128k
 * @author oscar51011
 * @date 2022年8月5日
 */
public class StackoverflowErr {

	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		StackoverflowErr oom = new StackoverflowErr();
		try {
			oom.stackLeak();
		} catch(Throwable e) {
			System.out.println("stack length:" + oom.stackLength);
			throw e;
		}
	}
}
