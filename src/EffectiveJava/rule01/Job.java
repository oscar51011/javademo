package EffectiveJava.rule01;

public class Job {
	public static Job newInstance(String name) {
		
		if(name.equals("doctor")) return new Doctor();
	
		return new Employee();
	}
	
}
