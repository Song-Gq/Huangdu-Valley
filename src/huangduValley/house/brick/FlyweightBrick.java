package huangduValley.house.brick;

import huangduValley.Stdout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// 使用工厂，通过传递砖的材质信息来获取实体类的对象。
public class FlyweightBrick {
    public static final String textures[] =
            { "木质", "大理石", "瓷质"};

    public static void dispalyFlyweightBrick(ArrayList<Floorboard> floorboardList) {
        Iterator<Floorboard> it = floorboardList.iterator();
        while(it.hasNext()){ // 迭代器遍历
            it.next().isDisplay();
        }
        Stdout.print("huangduValley.house.brick.FlyweightBrick.dispalyFlyweightBrick@static","展示地砖");
    }

    public static void changeFlyweightBrick(ArrayList<Floorboard> floorboardList) {
        System.out.println("乌拉！你喜欢装修什么样的地砖呢？(输入以下数字进行选择)");
        System.out.println("[1]木质 [2]大理石 [3]瓷质 [4]退出");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextInt()){// 判断输入的是否是整数 
            int changeToTexture = scanner.nextInt() ;
            if(changeToTexture>=1 && changeToTexture<=3) {
                Iterator<Floorboard> it = floorboardList.iterator(); // 迭代器遍历更改texture
                while(it.hasNext()){
                    it.next().setTexture(textures[changeToTexture - 1]);
                }
                System.out.println("----------------------------------");
                Stdout.print("huangduValley.house.brick.FlyweightBrick.changeFlyweightBrick@static","修改地砖装修");
                System.out.println("装修后地砖：");
                dispalyFlyweightBrick(floorboardList); // 展示地砖

            }else if(changeToTexture==4){
                System.out.println("乌拉!已退出！") ;
            }else{ // 输入错误正数
                System.out.println("乌拉!请按要求正确输入！") ;
                changeFlyweightBrick(floorboardList);
            }
        }else{ // 如果输入错误的信息 
            System.out.println("乌拉!输入的不是整数！请按要求正确输入!") ;
            changeFlyweightBrick(floorboardList);
        }
    }
}