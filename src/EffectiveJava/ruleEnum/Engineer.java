package EffectiveJava.ruleEnum;

public class Engineer {

	private String name;
	private EngineerLevel level;
	
	Engineer(String name, EngineerLevel level) {
		super();
		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EngineerLevel getLevel() {
		return level;
	}

	public void setLevel(EngineerLevel level) {
		this.level = level;
	}
}
