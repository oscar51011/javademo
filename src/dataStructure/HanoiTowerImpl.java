package dataStructure;

/**
 * 使用 遞迴 實作 河內塔
 * 
 * @author oscar51011
 * @date 2022年9月24日
 */
public class HanoiTowerImpl {

	/**
	 * 假設有 A B C 3個木樁，A有3個碟子，由小到大
	 * 1. 每次只能移動一個盤子，且只能從最上面移動
	 * 2. 盤子可移動到任一木樁
	 * 3. 木樁必須由小到大擺放
	 * 
	 * A ->(1) -> C
	 * A ->(2) -> B => A移動(N-1)層到B (中間經過C)
	 * C ->(1) -> B
	 * A ->(3) -> C => A移動最底層(N)到C
	 * B ->(1) -> A
	 * B ->(2) -> C => B移動(N-1)層到C (中間經過A)
	 * A ->(1) -> C
	 * 
	 * @param size
	 */
	public static void executeHanoiTowerRecursive(int size, String a, String b, String c) {
		if(size ==1) {
			System.out.println("從" + a + "移動到" + c);
		} else {
			executeHanoiTowerRecursive(size-1,a, c, b);
			executeHanoiTowerRecursive(1,a, b, c);
			executeHanoiTowerRecursive(size-1,b, a, c);
		}
	}
}
