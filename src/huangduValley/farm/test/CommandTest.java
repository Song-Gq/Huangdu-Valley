package huangduValley.farm.test;

import java.util.ArrayList;
import java.util.List;

import huangduValley.farm.land.DryLand;
import huangduValley.farm.land.Land;
import huangduValley.farm.land.LandCommand;

/**
 * @ClassName:CommandTest
 * @Description:to test "Command" design pattern
 * @author CuiYanshen
 */

public class CommandTest {
	
	//execute a list of commands
	public static void executeCommand(List<LandCommand> queue) {
		for (LandCommand lc:queue) {
			lc.excute();
		}
	}
	
	public static void main(String[] args) {
		//create an operation object
		Land land = new DryLand();
		
		//new a list
		List<LandCommand> queue = new ArrayList<>();
		
		//add some commands
		queue.add(new LandCommand(land, "water"));
		queue.add(new LandCommand(land, "fertilize"));
		queue.add(new LandCommand(land, "water"));
		queue.add(new LandCommand(land, "fertilize"));
		
		//now execute them
		executeCommand(queue);
	}
	
}
