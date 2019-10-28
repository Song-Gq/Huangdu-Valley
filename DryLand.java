package abstractFactory;

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
