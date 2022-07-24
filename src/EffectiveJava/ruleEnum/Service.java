package EffectiveJava.ruleEnum;

public class Service {
	public static int addTwoOrangePriceByEnumInput(Orange orange1,Orange orange2) {
		return orange1.getPrice() + orange2.getPrice();
	}
	
	public static int addTwoOrangePriceByIntInput(int orange1, int orange2) {
		return orange1 + orange2;
	}
}
