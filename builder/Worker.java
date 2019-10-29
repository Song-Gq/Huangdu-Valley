package Builder;

/**
 * @ClassName:Worker
 * @Description:used for builder, to build a fence
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
	
	//get fence from builder
	public Fence getFence() {
		return fenceBuilder.getFence();
	}
}
