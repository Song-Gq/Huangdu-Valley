package huangduValley.house;

import huangduValley.Stdout;
import huangduValley.house.memento.CareTaker;
import huangduValley.house.memento.Originator;
import huangduValley.house.memento.UndoOrRedo;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @project: HappyFarm
 * @description:
 * @designPattern: CompositeEntity, Visitor, Singleton, DoubleCheckLocking,Proxy
 **/
public class House implements Serializable {

//
//    public int index=-1;
//    public Originator originator=new Originator();
//    public CareTaker careTaker=new CareTaker();

    private static House instance;
    public static House getInstance() {
        if (instance == null) {
            // 双重检查锁定//////////
            // 保证了同一时间只能只能有一个对象访问此同步块
            synchronized (House.class) {
                if(instance==null){
                    instance=new House();
                }
            }
        }
        return instance;
    }

    // house name
    public static String houseName="小屋还没有名字哦，快点给它取个名字吧～";

    public static String getHouseName(){
        return houseName;
    }

    public static void showHouseName(){
        Stdout.print("huangduValley.house.House.showHouseName@static","小屋现在的名字是："+ houseName+"！");
    }

    public static void setHouseName(String newHouseName){
       houseName = newHouseName;
       showHouseName();
    }
    public static void setHouseName(){  // for mementoTest
//        System.out.println("请输入修改后房屋名称:");
        System.out.println("乌拉！请给您的小屋取个名字吧:");
        Scanner input1 = new Scanner(System.in);
        String newHouseName = input1.nextLine();
        houseName = newHouseName;
        showHouseName();
    }

    public static void changeHouseName(int index,Originator originator,CareTaker careTaker){
        System.out.println("乌拉！请给您的小屋取个名字吧:");
        Scanner input1 = new Scanner(System.in);
        String newHouseName = input1.nextLine();
        setHouseName(newHouseName);
        originator.setHouseName(House.getHouseName());
        careTaker.addMemento(originator.saveHouseNameToMemento());
        index++;
        System.out.println("乌拉！成功修改小屋名字！小屋现在的名字是："+getHouseName()+"！");

        UndoOrRedo.undoOrRedo(index, originator, careTaker);
    }

}
