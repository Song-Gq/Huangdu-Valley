package huangduValley.house.test;

import huangduValley.house.renovation.brick.BrickFactory;
import huangduValley.house.renovation.brick.Floorboard;
import huangduValley.house.renovation.brick.FlyweightBrick;

import java.util.ArrayList;

public class FactoryTest {
    public static void main(String[] args) {
        System.out.println("****************************  Test Factory Pattern *****************************");
        // Flyweight 创建地砖
        ArrayList<Floorboard> floorboardList = new ArrayList<Floorboard>();
        for(int i=1;i<3;i++) {
            for (int j = 1; j < 3; j++){
                //获取 Floorboard 的对象，并调用它的方法
                Floorboard floorboard =
                        (Floorboard) BrickFactory.getFloorboard(FlyweightBrick.textures[0]);
                floorboard.setX(i);
                floorboard.setY(j);
                floorboardList.add(floorboard);
                floorboard.isDisplay();
            }
        }
        System.out.println("****************************************************************************");
    }
}
