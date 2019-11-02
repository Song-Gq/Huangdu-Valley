package huangduValley.farm.test;

import huangduValley.farm.land.DryLand;
import huangduValley.farm.land.FertileLand;
import huangduValley.farm.land.IHarvest;
import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Potato;

/**
 * @ClassName:AbstractFactoryTest
 * @Description:test design pattern abstract factory 
 * @author CuiYanshen
 */

public class AbstractFactoryTest {
	public static void main(String[] args) throws Exception {
		IHarvest dryLand = new DryLand();
		
		Carrot commonCarrot = dryLand.plantCarrot();
		dryLand.harvest();
		
		Potato commonPotato = dryLand.plantPotato();
		dryLand.harvest();
		
		IHarvest fertileLand = new FertileLand();
		
		Carrot strongCarrot = fertileLand.plantCarrot();
		fertileLand.harvest();
		
		Potato strongPotato = fertileLand.plantPotato();
		fertileLand.harvest();
		
	}
}
