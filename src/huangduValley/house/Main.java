package huangduValley.house;

import huangduValley.house.renovation.brick.Floorboard;
import huangduValley.house.renovation.brick.FlyweightBrick;
import huangduValley.house.Furniture.Furniture;
import huangduValley.house.Furniture.FurnitureRoom;
import huangduValley.house.Furniture.MyIterator;
import huangduValley.house.Rent.HouseMediator;
import huangduValley.house.Rent.Landlord;
import huangduValley.house.Rent.Mediator;
import huangduValley.house.Rent.Person;
import huangduValley.house.Rent.Renter;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
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
        // Mediator
        Mediator mediator = new HouseMediator();
        Person renter = new Renter("DP",mediator);
        Person landlordA = new Landlord("Python", mediator);
        Person landlordB = new Landlord("Java", mediator);
        Person landlordC = new Landlord("C++", mediator);
        mediator.registerLandlord(landlordA);
        mediator.registerLandlord(landlordB);
        mediator.registerLandlord(landlordC);
        mediator.registerRenter(renter);
        if(renter.getsendBool()==false) {
            System.out.println("Send message to HouseMediator first to rent a house!");
            renter.sendMessage("Near land, $3115/month");
        }
        FurnitureRoom furnitureroom = new FurnitureRoom(20); //3


        System.out.println("Welcome home!");
        for (; ; ) {
            System.out.println("----------------------------------");
            System.out.println("你想要做什么呢？(请输入以下数字进行选择)");
            System.out.println("[1]查看房屋名称 [2]修改房屋名称 [3]展示家具" +
                    "[4]增添/移除家具 [5]展示地砖 [6]修改地砖材质 [7]离开房屋");

            Scanner scanner = new Scanner(System.in);
            String key = scanner.nextLine();
            Pattern pattern = Pattern.compile("[1-7]"); //正则表达式，Pattern和match
            if (pattern.matcher(key).matches()) {
                switch (key) {
                    case "1":
                        House.showHouseName();
                        break;
                    case "2":
                        House.changeHouseName();
                        break;

                    case "3":
                        System.out.println("查看当前已有家具");
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
                        System.out.println("增加家具：");
                        furnitureroom.appendFurniture(new Furniture("Desk",439,"Yellow","Wood"));
                        furnitureroom.appendFurniture(new Furniture("Bed",456,"Red","Wood"));
                        System.out.println("删除家具");
                        furnitureroom.deleteFurniture("Chair", 123, "Yellow", "Wood");
                        furnitureroom.deleteFurniture("Chair", 123, "Red", "Wood");
                        System.out.println("查看当前已有家具");
                        MyIterator it2 = furnitureroom.furIterator();
                        while (it2.hasNext()) {
                            Furniture furniture = (Furniture)it2.next();
                            System.out.println("This is a "+furniture.getName());
                            System.out.println("It worth "+furniture.getPrice());
                            System.out.println("The color is "+furniture.getColor());
                            System.out.println("It is made of "+furniture.getTexture()+"\n");

                        }
                        break;
                    case "5":
                        System.out.println("展示地砖：");
                        FlyweightBrick.dispalyFlyweightBrick(floorboardList);
                        break;
                    case "6":
                        FlyweightBrick.changeFlyweightBrick(floorboardList);
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
