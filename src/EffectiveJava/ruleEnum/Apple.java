package EffectiveJava.ruleEnum;

public enum Apple {
	FUJI(10), PIPPIN(20);
	
	private final int price;
	
	Apple(int price){
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
