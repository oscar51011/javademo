package EffectiveJava.ruleEnum;

public enum EnumableNew {
	NEW(3),SOLE(0), DUET(1), TRIO(2);
	
	private final int number;
	
	EnumableNew(int number){
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
