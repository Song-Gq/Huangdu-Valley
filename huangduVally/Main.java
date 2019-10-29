package huangduVally;

import huangduVally.house.House;
import huangduVally.house.Furniture.Furniture;
import huangduVally.house.Furniture.FurnitureRoom;
import huangduVally.house.Furniture.MyIterator;
import huangduVally.house.memento.CareTaker;
import huangduVally.house.memento.Originator;
import huangduVally.house.memento.Redo;
import huangduVally.house.memento.Undo;

import static huangduVally.house.House.setHouseName;
import static huangduVally.house.House.showHouseName;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int index=-1;
        Originator originator=new Originator();
        CareTaker careTaker=new CareTaker();

        FurnitureRoom furnitureroom = new FurnitureRoom(4); //3


        System.out.println("Welcome home!");
        for (; ; ) {
            System.out.println("----------------------------------");
            System.out.println("你想要做什么呢？(请输入以下数字进行选择)");
            System.out.println("[1]查看房屋名称 [2]修改房屋名称 [3]查看当前展示家具" +
                    "[4]增加/移除家具 [5]查看当前装修 [6]修改当前装修 [7]离开房屋");

            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            Pattern pattern = Pattern.compile("[1-7]"); //正则表达式，Pattern和match
            if (pattern.matcher(key).matches()) {
                switch (key) {
                    case "1":
                        showHouseName();
                        break;
                    case "2":
                        System.out.println("请输入修改后房屋名称:");
                        Scanner input1 = new Scanner(System.in);
                        String newHouseName = input1.nextLine();
//                      setHouseName(newHouseName);

                        setHouseName(newHouseName);
//                        System.out.println("The current HouseName are \""+ House.getHouseName()+"\"");
                        System.out.println("MementoPattern:originator:setHouseName:Save HouseName to originator");
                        originator.setHouseName(House.getHouseName());
                        System.out.println("MementoPattern:careTaker:add:add originator'HouseName to careTaker, careTaker[1] is " + originator.getHouseName());
                        careTaker.addMemento(originator.saveHouseNameToMemento());
                        System.out.println("setHouseName");
                        index++;

                        for(;;){
                            System.out.println("是否需要[1]Undo [2]Redo [输入其他]No");
                            Scanner input2 = new Scanner(System.in);
                            String command = input2.nextLine();
                        if (command.matches("1")) {
                            System.out.println("Undo");
                            Undo undo = new Undo();

                            System.out.println(" .we are in careTaker[" + index + "] ");
                            undo.Undo(careTaker, index);
                            if (index > 0)
                                index--;
                            showHouseName();
                        } else if (command.matches("2")) {
                            System.out.println("Redo");
                            Redo redo = new Redo();

                            System.out.println(" .we are in careTaker[" + index + "] ");
                            redo.Redo(careTaker, index);
                            if (index < careTaker.length() - 1)
                                index++;
                            showHouseName();

                        } else {
                            break;
                        }
                }
                        break;

                    case "3":
                        System.out.println("查看当前展示家具");
                        furnitureroom.appendFurniture(new Furniture("Bed",123,"Red","Wood"));
                        furnitureroom.appendFurniture(new Furniture("Desk",123,"Red","Wood"));
                        furnitureroom.appendFurniture(new Furniture("Chair",123,"Red","Wood"));
                        furnitureroom.appendFurniture(new Furniture("Desk",123,"Red","Wood"));
                        furnitureroom.appendFurniture(new Furniture("Sofa",123,"Red","Wood"));
                        furnitureroom.appendFurniture(new Furniture("Cabinet",123,"Red","Wood"));
                        MyIterator it = furnitureroom.furIterator();
                        while (it.hasNext()) {
                            Furniture furniture = (Furniture)it.next();
                            System.out.println("This is a "+furniture.getName());
                            System.out.println("It worth "+furniture.getPrice());
                            System.out.println("The color is "+furniture.getColor());
                            System.out.println("It is made of "+furniture.getTexture()+"\n");

                        }
                        break;
                    case "4":
//                        for(;;) {
//                            System.out.println("请选择以下家具： ");
//                            Scanner input2 = new Scanner(System.in);
//                            String command = input2.nextLine();
//                            if (command.matches("1")) {
//
//                            }
//                        }
//////////////////////////////////// 增加/删除家具
//                        furnitureroom.deleteFurniture("Chair",123,"Red","Wood");
//                        changeFurniture();
                        break;
                    case "5":
                        System.out.println("查看当前装修");
//                        displayRenovation();
                        break;
                    case "6":
                        System.out.println("修改当前装修");
//                        changeRenovation();
                        break;
                    case "7":
                        System.out.println("离开房屋");
//                        exitHouse();
                        break;

                    default:
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("error! 错误输入!");
                        System.out.println("-----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                }
            } else {
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("Error! 请重新输入! ");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.println("\n");
            }
        }
    }



}
