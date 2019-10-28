package Command;

import java.util.ArrayList;
import java.util.List;

import abstractFactory.DryLand;
import abstractFactory.Land;

/**
 * @ClassName:CommandTest
 * @Description:to test design pattern command
 * @author CuiYanshen
 */

public class CommandTest {
	
	public static void excuteCommand(List<LandCommand> queue) {
		for (LandCommand lc:queue) {
			lc.excute();
		}
	}
	
	public static void main(String[] args) {
		Land land = new DryLand();
		
		List<LandCommand> queue = new ArrayList<>();
		
		queue.add(new LandCommand(land, "water"));
		queue.add(new LandCommand(land, "fertilize"));
		queue.add(new LandCommand(land, "water"));
		queue.add(new LandCommand(land, "fertilize"));
		
		excuteCommand(queue);
	}
	
}
