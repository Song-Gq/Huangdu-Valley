package huangduValley.farm.fence;

/**
 * @ClassName:ShortFenceBuilder
 * @Description:used for huangduValley.farm.builder
 * @author CuiYanshen
 */

public class ShortFenceBuilder extends FenceBuilder {

	@Override
	public void buildFenceColor() {
		fence.setColor("blue");
	}

	@Override
	public void buildFenceHeight() {
		fence.setHeight("short");
	}

	@Override
	public void buildFenceMaterial() {
		fence.setMaterial("wooden");
	}

}
