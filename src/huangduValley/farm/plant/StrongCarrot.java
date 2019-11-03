package huangduValley.farm.plant;

import huangduValley.Stdout;

/**
 * @ClassName:StrongPotato
 * @Description:used for abstract factory, planted by fertile land
 * @author CuiYanshen
 */

public class StrongCarrot extends Carrot {
	
	public StrongCarrot(String landType) {
		super(landType);
		Stdout.print(this, "StrongCarrot is created");
	}
	
}
