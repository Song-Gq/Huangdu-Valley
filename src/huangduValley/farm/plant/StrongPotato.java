package huangduValley.farm.plant;

import huangduValley.Stdout;

/**
 * @ClassName:StrongPotato
 * @Description:used for abstract factory, planted by fertile land
 * @author CuiYanshen
 */

public class StrongPotato extends Potato {
	public StrongPotato(String landType) {
		super(landType);
		Stdout.print(this, "StrongPotato is created");
	}
}
