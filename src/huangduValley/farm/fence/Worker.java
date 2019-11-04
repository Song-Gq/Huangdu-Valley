package huangduValley.farm.fence;

import huangduValley.Stdout;

/**
 * @ClassName:Worker
 * @Description:used for "builder" design pattern, to build a fence
 * @author CuiYanshen
 */

public class Worker {
	private FenceBuilder fenceBuilder;
	
	//set a specific fenceBuilder
	public void setFenceBuilder(FenceBuilder fb) {
		fenceBuilder = fb;
		
		Stdout.print(this, fb.getClass().getSimpleName() + " has been set");
	}
	
	//build a fence by fenceBuilder
	public void buildFence() {
		fenceBuilder.buildNewFence();
		fenceBuilder.buildFenceColor();
		fenceBuilder.buildFenceHeight();
		fenceBuilder.buildFenceMaterial();
		
		Stdout.print(this, "New fencee has been built");
	}
	
	//get fence from huangduValley.farm.builder
	public Fence getFence() {
		return fenceBuilder.getFence();
	}
}
