package huangduValley.farm.plant;

import huangduValley.Stdout;

/**
 * @ClassName:CommonPotato
 * @Description:used for abstract factory, planted by dry land
 * @author CuiYanshen
 */

public class CommonPotato extends Potato {
	
	public CommonPotato(String landType) {
		super(landType);
		Stdout.print(this, "CommonPotato is created");
	}
	
}
