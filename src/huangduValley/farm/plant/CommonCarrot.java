package huangduValley.farm.plant;

import huangduValley.Stdout;

/**
 * @ClassName:CommonCarrot
 * @Description:used for abstract factory, planted by dry land
 * @author CuiYanshen
 */

public class CommonCarrot extends Carrot {
	
	public CommonCarrot(String landType) {
		super(landType);
		Stdout.print(this, "CommonCarrot is created");
	}
	
}
