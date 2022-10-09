package dataStructure.recursiveProblem;

/**
 * 實作 河內塔
 * 
 * @author oscar51011
 * @date 2022年9月24日
 */
public class HanoiTowerMain {
	
	public static void main(String[] args) {
		HanoiTowerImpl.executeHanoiTowerRecursive(3, "A", "B", "C");
	}
}
