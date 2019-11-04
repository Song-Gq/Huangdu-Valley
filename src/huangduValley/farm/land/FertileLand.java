package huangduValley.farm.land;

import huangduValley.Stdout;
import huangduValley.farm.plant.*;

/**
 * @ClassName:FertileLand
 * @Description:used for abstract factory
 * @author CuiYanshen
 */

public class FertileLand extends Land {
	public FertileLand() {
		Stdout.print(this, "FertileLand is created");
	}
	
	@Override
	public Carrot plantCarrot() throws Exception {
		if(this.plant == null) {
			this.plant = new StrongCarrot("yellow");
			Stdout.print(this, "This Fertile Land is planted with carrots");
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
			this.plant = new StrongPotato("yellow");
			Stdout.print(this, "This Fertile Land is planted with potatoes");
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
			this.plant = new StrongCarrot(landType);
			Stdout.print(this, "This Fertile Land is planted with carrots");
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
			this.plant = new StrongPotato(landType);
			Stdout.print(this, "This Fertile Land is planted with potatoes");
			return (Potato) plant;
		}
		// field not empty!
		// harvest() first and then plant a new one
		else {
			throw new Exception("plant already exists");
		}
	}
}
