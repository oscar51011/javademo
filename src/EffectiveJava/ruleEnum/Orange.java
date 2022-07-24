package EffectiveJava.ruleEnum;

public enum Orange {
	NAVEL(50), TEMPLE(60);
	
	private final int price;
	
	Orange(int price){
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
