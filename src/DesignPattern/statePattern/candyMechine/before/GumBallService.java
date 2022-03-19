package DesignPattern.statePattern.candyMechine.before;

import DesignPattern.statePattern.candyMechine.GumBallMechine;
import DesignPattern.statePattern.candyMechine.GumBallStatusEnum;

/**
 * 運行 糖果機 服務
 * @author oscar51011
 *
 */
public class GumBallService {

	/**
	 * 處理 投入 二十五分錢
	 */
	public void insertQuarter(GumBallMechine mechine) {
		
		if( mechine.getStatus() == GumBallStatusEnum.HAS_QUARTER.getStatus() ) {
			System.out.println("金額已足夠，無須投入金額");
		} else if ( mechine.getStatus() == GumBallStatusEnum.NO_QUARTER.getStatus() ) {
			mechine.setStatus(GumBallStatusEnum.HAS_QUARTER.getStatus());
			System.out.println("金額已投入");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD_OUT.getStatus() ) {
			System.out.println("糖果已售完，拒絕收錢");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD.getStatus() ) {
			System.out.println("請稍後");
		}
	}
	
	/**
	 * 處理 移除 二十五分錢
	 * @param mechine
	 */
	public void ejectQuarter(GumBallMechine mechine) {
		
		if( mechine.getStatus() == GumBallStatusEnum.HAS_QUARTER.getStatus() ) {
			System.out.println("金額返還");
			mechine.setStatus(GumBallStatusEnum.NO_QUARTER.getStatus());
		} else if ( mechine.getStatus() == GumBallStatusEnum.NO_QUARTER.getStatus() ) {
			System.out.println("你並無投入金錢，無法退款");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD_OUT.getStatus() ) {
			System.out.println("糖果已售完，無法投入金額&退款");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD.getStatus() ) {
			System.out.println("糖果已售出，無法返還金額");
		}
	}
	
	/**
	 * 處理 轉動曲柄
	 * @param mechine
	 */
	public void turnCrank(GumBallMechine mechine) {
		
		if( mechine.getStatus() == GumBallStatusEnum.HAS_QUARTER.getStatus() ) {
			System.out.println("轉動曲柄中...");
			mechine.setStatus(GumBallStatusEnum.SOLD.getStatus());
			this.dispence(mechine);
		} else if ( mechine.getStatus() == GumBallStatusEnum.NO_QUARTER.getStatus() ) {
			System.out.println("無金額，轉動曲柄無效");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD_OUT.getStatus() ) {
			System.out.println("糖果已售完，轉動曲柄無效");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD.getStatus() ) {
			System.out.println("已取過糖果，無法重複取得");
		}
	}	
	
	
	/**
	 * 掉出糖果的動作
	 * @param mechine
	 */
	private void dispence(GumBallMechine mechine) {
		
		if( mechine.getStatus() == GumBallStatusEnum.HAS_QUARTER.getStatus() ) {
			System.out.println("送出糖果中，無法投錢");
		} else if ( mechine.getStatus() == GumBallStatusEnum.NO_QUARTER.getStatus() ) {
			System.out.println("送出糖果中，無法退款");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD_OUT.getStatus() ) {
			System.out.println("機器異常，請稍後在試");
		} else if ( mechine.getStatus() == GumBallStatusEnum.SOLD.getStatus() ) {
			System.out.println("糖果已掉出");
			int count = mechine.getCount() - 1; // 糖果數量扣1
			mechine.setCount(count);
			if( count == 0) {
				System.out.println("糖果已售完，發出公告");
				mechine.setStatus(GumBallStatusEnum.SOLD_OUT.getStatus());
			} else {
				mechine.setStatus(GumBallStatusEnum.NO_QUARTER.getStatus());
			}
			
		}
	}	
}
