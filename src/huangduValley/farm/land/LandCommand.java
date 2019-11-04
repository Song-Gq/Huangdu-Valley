package huangduValley.farm.land;

import java.lang.reflect.Method;

/**
 * @ClassName:LandCommand
 * @Description:used for "Command" design pattern, water or fertilize
 * @author CuiYanshen
 */

public class LandCommand implements ICommand {
	
	//operation objects
	private Land land;
	//the method name can be "water" or "fertilize"
	//it will throw an exception if use a wrong method name
	private String methodName = "";
	
	public LandCommand(Land l, String m) {
		land = l;
		methodName = m;
	}

	@Override
	public void excute() {
		//use reflection to get method object
		try{
			Method method = Land.class.getMethod(methodName);
			
			method.invoke(land);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
