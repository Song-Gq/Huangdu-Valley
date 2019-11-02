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
	public Carrot plantCarrot() throws Exception {
		if(this.plant == null) {
			this.plant =  new CommonCarrot();
			return (Carrot) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}

	@Override
	public Potato plantPotato() throws Exception {
		if(this.plant == null) {
			this.plant = new CommonPotato();
			return (Potato) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}
	
}