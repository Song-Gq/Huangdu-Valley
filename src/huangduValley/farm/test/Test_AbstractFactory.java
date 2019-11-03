package huangduValley.farm.test;

import huangduValley.farm.land.DryLand;
import huangduValley.farm.land.FertileLand;
import huangduValley.farm.land.ILand;
import huangduValley.farm.plant.Carrot;
import huangduValley.farm.plant.Potato;

/**
 * @ClassName:AbstractFactoryTest
 * @Description:test design pattern abstract factory 
 * @author CuiYanshen
 */

public class Test_AbstractFactory {
	public static void main(String[] args) throws Exception {
		ILand dryLand = new DryLand();
		
		Carrot commonCarrot = dryLand.plantCarrot();
		dryLand.harvest();
		
		Potato commonPotato = dryLand.plantPotato();
		dryLand.harvest();
		
		ILand fertileLand = new FertileLand();
		
		Carrot strongCarrot = fertileLand.plantCarrot();
		fertileLand.harvest();
		
		Potato strongPotato = fertileLand.plantPotato();
		fertileLand.harvest();
		
	}
}
