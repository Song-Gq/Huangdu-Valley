package huangduValley.farm.land;

import huangduValley.farm.plant.*;

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
	public Carrot plantCarrot() throws Exception {
		if(this.plant == null) {
			this.plant = new StrongCarrot();
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
			this.plant = new StrongPotato();
			return (Potato) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}

}
