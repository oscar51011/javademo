package DesignPattern.statePattern.candyMechine;

/**
 * 糖果機 物件
 * @author oscar51011
 *
 */
public class GumBallMechine {

	private int status = GumBallStatusEnum.SOLD_OUT.getStatus();

	private int count;
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public GumBallMechine(int count) {
		this.count = count;
		if(count > 0) {
			this.status = GumBallStatusEnum.NO_QUARTER.getStatus();
		}
	}
	
}
