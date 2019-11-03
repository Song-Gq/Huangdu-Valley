package huangduValley.farm.fence;

import huangduValley.Stdout;

/**
 * @ClassName:FenceBuilder
 * @Description:used for huangduValley.farm.builder
 * @author CuiYanshen
 */

public abstract class FenceBuilder {
	protected Fence fence;
	
	public Fence getFence() {
		return fence;
	}
	
	//build a new fence
	public void buildNewFence() {
		fence = new Fence();
		
		Stdout.print(this, "This fenceBuilder is building fence");
	}
	
	//set different color, height and material
	public abstract void buildFenceColor();
	public abstract void buildFenceHeight();
	public abstract void buildFenceMaterial();
}
