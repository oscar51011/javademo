package EffectiveJava.ruleEnum;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {		
		rule34();
		rule35();		
		rule37();
	}

	private static void rule37() {
		// 
		List<Engineer> engineers = new ArrayList<>();
		engineers.add(new Engineer("Tom", EngineerLevel.INTERN));
		engineers.add(new Engineer("John", EngineerLevel.JUNIOR));
		engineers.add(new Engineer("Terry", EngineerLevel.JUNIOR));
		engineers.add(new Engineer("Oscar", EngineerLevel.SENIOR));
		
		Map<EngineerLevel, Set<Engineer>> devTeams  =new EnumMap<>(EngineerLevel.class);
		// 初始化
		for(EngineerLevel levelgroup : EngineerLevel.values()) {
			devTeams.put(levelgroup, new HashSet<>());
		}
		// 員工分級
		for(Engineer engineer : engineers) {
			devTeams.get(engineer.getLevel()).add(engineer);
		}
		// 取出數量
		for(EngineerLevel level : devTeams.keySet()) {
			System.out.println( level.toString() + ":" + devTeams.get(level).size());
		}
		
		System.out.println("===");
		
		//// 使用 ordinal 進行分組 ////
		@SuppressWarnings("unchecked")
		Set<Engineer>[] devTeams2 = new HashSet[EngineerLevel.values().length];
		for(int i=0; i< devTeams2.length; i++)
			devTeams2[i] = new HashSet<>();
		
		for(Engineer engineer : engineers) {
			devTeams2[engineer.getLevel().ordinal()].add(engineer);
		}
		
		// 取出數量
		for(int i=0 ; i < devTeams2.length ; i++) {
			System.out.println( EngineerLevel.values()[i] + ":" + devTeams2[i].size() );
		}
	}

	private static void rule35() {
		// compare enum & int constant vale
		System.out.println("Orange Price - constant value:" + Service.addTwoOrangePriceByIntInput(FruitConstant.APPLE_FUJI, FruitConstant.ORANGE_NAVEL));
		System.out.println("Orange Price - Enum:" + Service.addTwoOrangePriceByEnumInput(Orange.NAVEL, Orange.TEMPLE));
		// System.out.println("Orange Price - Enum:" + Service.addTwoOrangePriceByEnumInput(Apple.FUJI, Orange.TEMPLE));
	}

	private static void rule34() {
		// Before add new item
		System.out.println("Before add Enumable new item:" + Enumable.SOLO.ordinal());
		System.out.println("Before add EnumableNew new item:" + EnumableNew.SOLE.getNumber());
		
		// after add new item
		System.out.println("After add Enumable new item:" + Enumable.SOLO.ordinal());
		System.out.println("After add Enumable new item:" + EnumableNew.SOLE.getNumber());
	}
}
