package huangduValley.farm.land;

import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Potato;
import huangduValley.farm.plant.StrongCarrot;
import huangduValley.farm.plant.StrongPotato;

/**
 * @ClassName:FertileLand
 * @Description:used for abstract factory
 * @author CuiYanshen
 */

public class FertileLand extends Land {
	public FertileLand() {
		System.out.println("FertileLand is created.");
	}
	
	@Override
	public Carrot plantCarrot() {
		return new StrongCarrot();
	}

	@Override
	public Potato plantPotato() {
		return new StrongPotato();
	}

}
