package huangduValley.farm.fence;

/**
 * @ClassName:Worker
 * @Description:used for huangduValley.farm.builder, to build a fence
 * @author CuiYanshen
 */

public class Worker {
	private FenceBuilder fenceBuilder;
	
	public void setFenceBuilder(FenceBuilder fb) {
		fenceBuilder = fb;
	}
	
	public void buildFence() {
		fenceBuilder.buildNewFence();
		fenceBuilder.buildFenceColor();
		fenceBuilder.buildFenceHeight();
		fenceBuilder.buildFenceMaterial();
	}
	
	//get fence from huangduValley.farm.builder
	public Fence getFence() {
		return fenceBuilder.getFence();
	}
}
