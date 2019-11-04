package huangduValley.farm.test;

import huangduValley.farm.land.DryLand;
import huangduValley.farm.land.FertileLand;
import huangduValley.farm.land.Land;
import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Potato;

/**
 * @ClassName:AbstractFactoryTest
 * @Description:test "abstract factory"  design pattern 
 * @author CuiYanshen
 */

public class Test_AbstractFactory {
	public static void main(String[] args) throws Exception {
		Land dland = new DryLand();
		
		//DryLand can create plants with prefix "common" 
		Carrot commonCarrot = dland.plantCarrot();
		dland.harvest();
		
		//must harvest before planting another one
		Potato commonPotato = dland.plantPotato();
		dland.harvest();
		
		Land fland = new FertileLand();
		
		//FertileLand can create plants with prefix "strong"
		Carrot strongCarrot = fland.plantCarrot();
		fland.harvest();
		
		//don't forget to harvest
		Potato strongPotato = fland.plantPotato();
		fland.harvest();
		
	}
}
