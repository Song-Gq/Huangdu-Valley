package huangduVally.test;

import huangduVally.house.renovation.Brick;
import huangduVally.house.renovation.brick.BrickFactory;
import huangduVally.house.renovation.brick.Floorboard;

import java.util.ArrayList;

import static huangduVally.house.renovation.brick.FlyweightBrick.dispalyFlyweightBrick;
import static huangduVally.house.renovation.brick.FlyweightBrick.textures;

public class FactoryTest {
    public static void main(String[] args) {
        System.out.println("****************************  Test Factory Pattern *****************************");
        // Flyweight 创建地砖
        ArrayList<Floorboard> floorboardList = new ArrayList<Floorboard>();
        for(int i=1;i<3;i++) {
            for (int j = 1; j < 3; j++){
                //获取 Floorboard 的对象，并调用它的方法
                Floorboard floorboard =
                        (Floorboard)BrickFactory.getFloorboard(textures[0]);
                floorboard.setX(i);
                floorboard.setY(j);
                floorboardList.add(floorboard);
                floorboard.isDisplay();
            }
        }
        System.out.println("****************************************************************************");
    }
}
