package EffectiveJava.rule09;

/**
 * 實作 AutoCloseable ，使其可以使用 try-with-resources
 * 
 * @author oscar51011
 * @date 2022年5月28日
 */
public class DemoCloseableService implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("demo close exception");
		throw new Exception("test close exception");
	}

}
