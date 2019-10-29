package abstractFactory;

/**
 * @ClassName:AbstractFactoryTest
 * @Description:test design pattern abstract factory 
 * @author CuiYanshen
 */

public class AbstractFactoryTest {
	public static void main(String[] args) {
		DryLand dryLand = new DryLand();
		
		Carrot commonCarrot = dryLand.plantCarrot();
		Potato commonPotato = dryLand.plantPotato();
		
		FertileLand fertileLand = new FertileLand();
		
		Carrot strongCarrot = fertileLand.plantCarrot();
		Potato strongPotato = fertileLand.plantPotato();
    	
	}
}
