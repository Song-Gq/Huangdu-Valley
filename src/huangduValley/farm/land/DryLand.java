package huangduValley.farm.land;

import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.CommonCarrot;
import huangduValley.farm.plant.CommonPotato;
import huangduValley.farm.plant.Potato;

/**
 * @ClassName:DryLand
 * @Description:used for abstract factory
 * @author CuiYanshen
 */

public class DryLand extends Land {
	public DryLand() {
		System.out.println("DryLand is Created.");
	}
	
	@Override
	public Carrot plantCarrot() {
		return new CommonCarrot();
	}

	@Override
	public Potato plantPotato() {
		return new CommonPotato();
	}
	
}
