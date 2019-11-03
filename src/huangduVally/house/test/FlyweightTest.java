package huangduVally.house.test;

import huangduVally.house.renovation.brick.Floorboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import static huangduVally.house.renovation.brick.FlyweightBrick.*;

public class FlyweightTest {
    public static void main(String[] agrs) {
        System.out.println("****************************  Test Flyweight Pattern *****************************");
        // Flyweight 创建地砖
        ArrayList<Floorboard> floorboardList = new ArrayList<Floorboard>();
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                Floorboard floorboard = new Floorboard(textures[0]); // 初始地砖为木质
                floorboard.setX(i);
                floorboard.setY(j);
                floorboardList.add(floorboard);
            }
        }

        for (; ; ) {
            System.out.println("[1]展示地砖 [2]修改地砖材质 [3]退出");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {// 判断输入的是否是整数 
                int changeToTexture = scanner.nextInt();
                if (changeToTexture == 1) {
                    System.out.println("展示地砖：");
                    dispalyFlyweightBrick(floorboardList); // 展示地砖
                } else if (changeToTexture == 2) {
                    changeFlyweightBrick(floorboardList); // 修改地砖材质
                }
                else if (changeToTexture == 3) {
                    break;
                }
                else { // 输入错误正数
                    System.out.println("请按要求正确输入!");
                    changeFlyweightBrick(floorboardList);
                }
            } else { // 如果输入错误的信息 
                System.out.println("输入的不是整数！请按要求正确输入!");
                changeFlyweightBrick(floorboardList);
            }
        }
        System.out.println("****************************************************************************");
    }
}
