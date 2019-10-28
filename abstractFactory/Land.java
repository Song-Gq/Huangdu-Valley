package abstractFactory;

/**
 * @ClassName:Land
 * @Description:used for abstract factory and command
 * @author CuiYanshen
 */

public abstract class Land {
	public abstract Carrot plantCarrot();
	
	public abstract Potato plantPotato();
	
	public void water() {
		System.out.println("Watering...");
	}
	
	public void fertilize() {
		System.out.println("Fertiling...");
	}
}
