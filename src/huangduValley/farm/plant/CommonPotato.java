package huangduValley.farm.plant;

/**
 * @ClassName:CommonPotato
 * @Description:used for abstract factory, planted by dry land
 * @author CuiYanshen
 */

public class CommonPotato extends Potato {
	
	public CommonPotato(String landType) {
		super(landType);
		System.out.println("CommonPotato is planted.");
	}
	
}
