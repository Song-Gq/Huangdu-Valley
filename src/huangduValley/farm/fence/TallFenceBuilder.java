package huangduValley.farm.fence;

/**
 * @ClassName:TallFenceBuilder
 * @Description:used for "builder" design pattern
 * @author CuiYanshen
 */

public class TallFenceBuilder extends FenceBuilder {

	@Override
	public void buildFenceColor() {
		fence.setColor("white");
	}

	@Override
	public void buildFenceHeight() {
		fence.setHeight("tall");
	}

	@Override
	public void buildFenceMaterial() {
		fence.setMaterial("metal");
	}

}
