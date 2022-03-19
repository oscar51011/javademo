package DesignPattern.statePattern.candyMechine;

/**
 * 紀錄糖果機器狀態
 * 
 * @author oscar51011
 * 
 */
public enum GumBallStatusEnum {
	
	SOLD_OUT(0, "糖果無庫存"),
	NO_QUARTER(1, "沒有二十五分錢"),
	HAS_QUARTER(2, "有二十五分錢"),
	SOLD(3, "售出糖果")
	;

	private int status;
	private String desc;
  
	private GumBallStatusEnum(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/**
	 * 取得狀態描述
	 * @param status
	 * @return
	 */
	public static String getDescByStatus(int status) {
		for(GumBallStatusEnum statusEnum : GumBallStatusEnum.values()) {
			if(statusEnum.getStatus() == status)
				return statusEnum.getDesc();
		}
		return "not defined";
	}
}
