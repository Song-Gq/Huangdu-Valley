package huangduValley.farm.land;

import huangduValley.farm.Stdout;
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
		Stdout.print(this, "DryLand is created");
	}
	
	@Override
	public Carrot plantCarrot() throws Exception {
		if(this.plant == null) {
			this.plant =  new CommonCarrot("yellow");
			Stdout.print(this, "This Dry Land is planted with carrots");
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
			this.plant = new CommonPotato("yellow");
			Stdout.print(this, "This Dry Land is planted with potatoes");
			return (Potato) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}

	protected Carrot plantCarrot(String landType) throws Exception {
		if(this.plant == null) {
			this.plant =  new CommonCarrot(landType);
			Stdout.print(this, "This Dry Land is planted with carrots");
			return (Carrot) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}

	protected Potato plantPotato(String landType) throws Exception {
		if(this.plant == null) {
			this.plant = new CommonPotato(landType);
			Stdout.print(this, "This Dry Land is planted with potatoes");
			return (Potato) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}
	
}
