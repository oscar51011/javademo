package DesignPattern.statePattern.candyMechine.before;

import DesignPattern.statePattern.candyMechine.GumBallMechine;
import DesignPattern.statePattern.candyMechine.GumBallStatusEnum;

/**
 * 演示未使用 State Pattern 的範例
 * 
 * @author oscar51011
 *
 */
public class DemoMain {

	public static void main(String[] args) {
		
		// 初始化機器含3顆糖果
		GumBallMechine mechine = new GumBallMechine(3);
		GumBallService service = new GumBallService();
		
		System.out.println("Case 1: 正常購買");
		// 購買第一顆糖果  ( 應出現 沒有錢的狀態 - 因為已經購買成功 )
		service.insertQuarter(mechine);	// 投入金幣
		service.turnCrank(mechine); // 轉動曲柄		
		showMechineInfo(mechine);
		
		System.out.println("Case 2: 投錢退錢");
		// 投入金錢 然後馬上退錢 ( 應出現 沒有錢的狀態 )
		service.insertQuarter(mechine);
		service.ejectQuarter(mechine);
		service.turnCrank(mechine);
		showMechineInfo(mechine);

		System.out.println("Case 3: 購買完後，無法按下退錢");
		// 投入金錢，因付款完成，金額扣除，因此無法退錢
		service.insertQuarter(mechine);
		service.turnCrank(mechine);
		service.ejectQuarter(mechine);
		showMechineInfo(mechine);
		
		System.out.println("Case 4: 重複投錢，無法投入金錢");
		// 投入金錢，重複投錢後，會無法投入
		service.insertQuarter(mechine);
		service.insertQuarter(mechine);
		showMechineInfo(mechine);
		
		System.out.println("Case 5: 糖果賣完，再次購買時會顯示已售完");
		// 當全部糖果被買光後，轉動曲柄會無法購買成功
		service.turnCrank(mechine);
		service.insertQuarter(mechine);
		service.turnCrank(mechine);
		showMechineInfo(mechine);
		
		System.out.println("Case 6: 糖果賣完，投錢時會無法投入金錢");
		// 糖果賣完，投錢時會無法投入金錢
		service.insertQuarter(mechine);
		showMechineInfo(mechine);
	}
	
	private static void showMechineInfo(GumBallMechine mechine) {
		System.out.println("===");
		System.out.println("@當下狀態:" + GumBallStatusEnum.getDescByStatus(mechine.getStatus()));
		System.out.println("@剩餘糖果:" + mechine.getCount());
		System.out.println("===");
	}
}
