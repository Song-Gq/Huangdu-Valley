package Builder;

/**
 * @ClassName:FenceBuilder
 * @Description:used for builder
 * @author CuiYanshen
 */

public abstract class FenceBuilder {
	protected Fence fence;
	
	public Fence getFence() {
		return fence;
	}
	
	public void buildNewFence() {
		fence = new Fence();
	}
	
	//set different color, height and material
	public abstract void buildFenceColor();
	public abstract void buildFenceHeight();
	public abstract void buildFenceMaterial();
}
