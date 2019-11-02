package huangduValley.farm.plant;

/**
 * @ClassName:CommonCarrot
 * @Description:used for abstract factory, planted by dry land
 * @author CuiYanshen
 */

public class CommonCarrot extends Carrot {
	public CommonCarrot(String landType) {
		super(landType);
		System.out.println("CommonCarrot is planted.");
	}
}
