package EffectiveJava.rule01;

public class Service {
	public static Discount getDiscount(String type) {
		switch(type) {
			case "half": return new HalfPriceDiscountImpl();
			case "limit": return new TimeLimitDiscountImpl();
			default :  return new MemberDiscountImpl();
		}
	}
}
