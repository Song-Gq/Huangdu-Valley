package huangduValley.house;

import huangduValley.Main;
import huangduValley.house.brick.Floorboard;
import huangduValley.house.brick.FlyweightBrick;
import huangduValley.house.furniture.Furniture;
import huangduValley.house.furniture.FurnitureRoom;
import huangduValley.house.memento.CareTaker;
import huangduValley.house.memento.Originator;
import huangduValley.house.memento.UndoOrRedo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import static huangduValley.house.furniture.FurnitureRoom.displayFurniture;
import static huangduValley.house.House.*;

public class HouseMain {

    public static void houseDoAll() throws Exception {
        // Flyweight 创建地砖
        ArrayList<Floorboard> floorboardList = new ArrayList<Floorboard>();
        for(int i=1;i<3;i++) {
            for (int j = 1; j < 3; j++){
                Floorboard floorboard = new Floorboard(FlyweightBrick.textures[0]); // 初始地砖为木质
                floorboard.setX(i);
                floorboard.setY(j);
                floorboardList.add(floorboard);
            }
        }

        // Memento
        int count=0;

        // Memento
        int index=-1;
        Originator originator=new Originator();
        CareTaker careTaker=new CareTaker();

        // 先查看初始名字，然后设置小屋名称3次
        System.out.println("租下房子的你高兴地站在门口，发现现在的小屋还没有名字。\n" +
                "于是你决定给小屋取个霸气侧漏的名字!一开始你给房子取了个名字叫做\"巴啦啦蟹肉煲\"！\n" +
                "但是一想到住在蟹肉煲里带着劳力士的你，日子将像蟹老板一样过得无聊，且枯燥，\n"+
                "所以你决定把小屋的名字改成可爱的\"摸仙堡\"！查了查新华字典的你又悄咪咪地改成了\"魔仙堡\"。");
        House.showHouseName();
        setHouseName("巴啦啦蟹肉煲");
        originator.setHouseName(House.getHouseName());
        careTaker.addMemento(originator.saveHouseNameToMemento());
        index++;
        setHouseName("摸仙堡");
        originator.setHouseName(House.getHouseName());
        careTaker.addMemento(originator.saveHouseNameToMemento());
        index++;
        setHouseName("魔仙堡");
        originator.setHouseName(House.getHouseName());
        careTaker.addMemento(originator.saveHouseNameToMemento());
        index++;
        Main.skip();

        System.out.println("这时一位路人走了过来，对这个名字嗤之以鼻，你一气之下连续撤回两次，\n"+
                "路人当即被\"巴啦啦蟹肉煲\"这个霸气侧漏的名字吓得昏古七惹。");
        UndoOrRedo.Undo undo1 = new UndoOrRedo.Undo();
        undo1.Undo(careTaker, index);
        index--;
        UndoOrRedo.Undo undo2 = new UndoOrRedo.Undo();
        undo2.Undo(careTaker, index);
        index--;
        Main.skip();

        System.out.println("顺手把路人送到非洲去体验生活后,你取消了两次撤回，安心地住在了自己名字为\"魔仙堡\"的小屋里。");
        UndoOrRedo.Redo redo1 = new UndoOrRedo.Redo();
        redo1.Redo(careTaker, index);
        index++;
        UndoOrRedo.Redo redo2 = new UndoOrRedo.Redo();
        redo2.Redo(careTaker, index);
        index++;
        Main.skip();

        System.out.println("你走进自己可爱的\"魔仙堡\"，往家里摆了一些家具：");
        // Mediator
        FurnitureRoom furnitureroom = new FurnitureRoom(20); //3
        furnitureroom.appendFurniture(new Furniture("桌子",439,"紫檀色","紫檀木"));
        furnitureroom.appendFurniture(new Furniture("椅子",123,"红木色","红木"));
        furnitureroom.appendFurniture(new Furniture("柜子",123,"原木色","松木"));
        furnitureroom.appendFurniture(new Furniture("小床",123,"梨花白","布艺床"));
        furnitureroom.appendFurniture(new Furniture("沙发",123,"栗黄色","绒布沙发"));
        displayFurniture(furnitureroom);
        Main.skip();

        for (; ; ) {
            System.out.println("----------------------------------");
            System.out.println("你满意地打量着自己可爱的\"魔仙堡\"。请问现在的你还想在自己的小屋里做什么呢？(输入以下数字进行选择哦)");
            System.out.println("[1]看看小屋的名字 [2]改改小屋的名字 [3]看看小屋的家具" +
                    "[4]增添或移除家具 [5]看看地砖的装修风格 [6]改改地砖装修的装修风格 [7]安心地睡去");

            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            Pattern pattern = Pattern.compile("[1-7]"); //正则表达式，Pattern和match
            if (pattern.matcher(key).matches()) {
                switch (key) {
                    case "1":
                        House.showHouseName();
                        break;
                    case "2":
                        House.changeHouseName(index,originator,careTaker);
                        break;
                    case "3":
                        displayFurniture(furnitureroom);
                        break;
                    case "4":
                        FurnitureRoom.changeFurniture(furnitureroom);
                        break;
                    case "5":
                        System.out.println("----------------------------------");
                        System.out.println("展示地砖：");
                        FlyweightBrick.dispalyFlyweightBrick(floorboardList);
                        break;
                    case "6":
                        System.out.println("----------------------------------");
                        FlyweightBrick.changeFlyweightBrick(floorboardList);
                        break;
                    case "7":
                        System.out.println("好梦，晚安～");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("------------------------------------------------------------");
                        System.out.println("error! 错误输入!");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("\n");
                }
            } else {
                System.out.println("----------------------------------");
                System.out.println("Error! 请重新输入! ");
                System.out.println("----------------------------------");
                System.out.println("\n");
            }
        }

    }
}
