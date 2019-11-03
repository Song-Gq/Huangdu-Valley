package huangduVally.house;

import huangduVally.house.memento.CareTaker;
import huangduVally.house.memento.Originator;
import huangduVally.house.memento.UndoOrRedo;

import java.io.Serializable;
import java.util.Scanner;

/**
 * @project: HappyFarm
 * @description:
 * @designPattern: CompositeEntity, Visitor, Singleton, DoubleCheckLocking,Proxy
 **/
public class House implements Serializable {

    // Memento
    private static int index=-1;
    private static Originator originator=new Originator();
    private static CareTaker careTaker=new CareTaker();
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
    public static String houseName="尚未设置房屋名称";

    public static String getHouseName(){
        return houseName;
    }

    public static void showHouseName(){
        System.out.println("房屋的名称为："+ houseName);
    }

    public static void setHouseName(String newHouseName){
       houseName = newHouseName;
       showHouseName();
    }
    public static void setHouseName(){  // for mementoTest
        System.out.println("请输入修改后房屋名称:");
        Scanner input1 = new Scanner(System.in);
        String newHouseName = input1.nextLine();
        houseName = newHouseName;
        showHouseName();
    }

    public static void changeHouseName(){
        System.out.println("请输入修改后房屋名称:");
        Scanner input1 = new Scanner(System.in);
        String newHouseName = input1.nextLine();
        setHouseName(newHouseName);
        System.out.println("MementoPattern:originator:setHouseName:Save HouseName to originator");
        originator.setHouseName(House.getHouseName());
        System.out.println("MementoPattern:careTaker:add:add originator'HouseName to careTaker, careTaker[1] is " + originator.getHouseName());
        careTaker.addMemento(originator.saveHouseNameToMemento());
        System.out.println("成功修改房屋名称！");
        index++;

        UndoOrRedo.undoOrRedo(index,originator,careTaker);
    }
}
