package huangduValley.house.test;

import huangduValley.house.House;
import huangduValley.house.memento.CareTaker;
import huangduValley.house.memento.Originator;

import java.util.Scanner;

public class MementoTest {
    public static void main(String[] args) {
        System.out.println("****************************  Test Memento Pattren *****************************");
        // Memento
        int index=-1;
        Originator originator=new Originator();
        CareTaker careTaker=new CareTaker();
        int count=0;

        for (; ; ) {
            System.out.println("[1]展示当前房屋名称 [2]修改房屋名称 [3]退出");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {// 判断输入的是否是整数 
                int changeToTexture = scanner.nextInt();
                if (changeToTexture == 1) {
                    House.showHouseName(); // 展示当前房屋名称
                } else if (changeToTexture == 2) {
                    House.changeHouseName(index,originator,careTaker); // 修改房屋名称
                }
                else if (changeToTexture == 3) {
                    break;
                }
                else { // 输入错误正数
                    System.out.println("请按要求正确输入!");
                }
            } else { // 如果输入错误的信息 
                System.out.println("输入的不是整数！请按要求正确输入!");
            }
        }
        System.out.println("****************************************************************************");
    }
}
