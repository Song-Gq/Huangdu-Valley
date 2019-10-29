package huangduVally.house.renovation.brick;

import java.util.HashMap;
// 创建一个工厂，生成基于给定信息的实体类的对象
public class BrickFactory {
    private static final HashMap<String, Brick> floorboardMap = new HashMap<>();

    public static Brick getFloorboard(String texture) {
        Floorboard floorboard = (Floorboard)floorboardMap.get(texture);

        if(floorboard == null) {
            floorboard = new Floorboard(texture);
            floorboardMap.put(texture,floorboard);
            System.out.println("Creating floorboard of texture : " + texture);
        }
        return floorboard;
    }
}