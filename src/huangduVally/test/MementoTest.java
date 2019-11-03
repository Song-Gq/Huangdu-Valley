package huangduVally.test;

import huangduVally.house.House;
import huangduVally.house.memento.CareTaker;
import huangduVally.house.memento.Originator;

import java.util.Scanner;

import static huangduVally.house.House.changeHouseName;
import static huangduVally.house.House.showHouseName;

public class MementoTest {
    public static void main(String[] args) {
        System.out.println("****************************  Test Memento Pattren *****************************");
        // Memento
        int index=0;
        Originator originator=new Originator();
        CareTaker careTaker=new CareTaker();

        for (; ; ) {
            System.out.println("[1]展示当前房屋名称 [2]修改房屋名称 [3]退出");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {// 判断输入的是否是整数 
                int changeToTexture = scanner.nextInt();
                if (changeToTexture == 1) {
                    showHouseName(); // 展示当前房屋名称
                } else if (changeToTexture == 2) {
                    changeHouseName(); // 修改房屋名称
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
