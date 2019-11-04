package huangduValley.farm.fence;

/**
 * @ClassName:Fence
 * @Description:used for "builder" design pattern
 * @author CuiYanshen
 */

public class Fence {
	private String fenceColor = "";
	private String fenceHeight = "";
	private String fenceMaterial = "";
	
	public void setColor(String color) {
		this.fenceColor = color;
	}
	
	public void setHeight(String height) {
		this.fenceHeight = height;
	}
	
	public void setMaterial(String material) {
		this.fenceMaterial = material;
	}
	
	public String getColor() {
		return fenceColor;
	}
	
	public String getHeight() {
		return fenceHeight;
	}
	
	public String getMaterial() {
		return fenceMaterial;
	}
	
}
