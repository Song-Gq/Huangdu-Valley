package huangduValley.farm.plant;

/**
 * @ClassName:StrongPotato
 * @Description:used for abstract factory, planted by fertile land
 * @author CuiYanshen
 */

public class StrongPotato extends Potato {
	public StrongPotato(String landType) {
		super(landType);
		System.out.println("StrongPotato is planted.");
	}
}
