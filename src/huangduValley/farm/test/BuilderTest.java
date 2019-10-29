package huangduValley.farm.test;

import huangduValley.farm.fence.*;

/**
 * @ClassName:BuilderTest
 * @Description:test design pattern huangduValley.farm.builder
 * @author CuiYanshen
 */

public class BuilderTest {
	
	public static void main(String[] args) {
		
		//create a worker
		Worker worker = new Worker();
		FenceBuilder shortfb = new ShortFenceBuilder();
		FenceBuilder tallfb = new TallFenceBuilder();
		
		//set a short fence huangduValley.farm.builder
		worker.setFenceBuilder(shortfb);
		
		//build a fence
		worker.buildFence();
		
		Fence fence = worker.getFence();
		
		System.out.println(fence.getColor());
		System.out.println(fence.getHeight());
		System.out.println(fence.getMaterial());
	}
	
}
