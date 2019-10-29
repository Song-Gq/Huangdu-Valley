package Builder;

/**
 * @ClassName:BuilderTest
 * @Description:test design pattern builder
 * @author CuiYanshen
 */

public class BuilderTest {
	
	public static void main(String[] args) {
		
		//create a worker
		Worker worker = new Worker();
		FenceBuilder shortfb = new ShortFenceBuilder();
		FenceBuilder tallfb = new TallFenceBuilder();
		
		//set a short fence builder
		worker.setFenceBuilder(shortfb);
		
		//build a fence
		worker.buildFence();
		
		Fence fence = worker.getFence();
		
		System.out.println(fence.getColor());
		System.out.println(fence.getHeight());
		System.out.println(fence.getMaterial());
	}
	
}
