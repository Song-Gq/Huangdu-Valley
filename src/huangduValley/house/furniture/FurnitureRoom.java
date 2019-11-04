package huangduValley.house.furniture;

import huangduValley.Stdout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FurnitureRoom implements Aggregate {
    private ArrayList furnitures;
    public FurnitureRoom(int initialsize) {
        this.furnitures = new ArrayList(initialsize);
    }
    public Furniture getFurnitureAt(int index) {
        return (Furniture)furnitures.get(index);          
    }
    public void appendFurniture(Furniture furniture) {
        furnitures.add(furniture);
        Stdout.print(this,"乌拉！成功增添了"+furniture.getName()+"！");
    }
    public void deleteFurniture(String name) {
    	boolean exit=false;
    	Iterator<Furniture> iter = furnitures.iterator();
    	while (iter.hasNext()) {
    		Furniture f=(Furniture)(iter.next());
    		if(f.getName().equals(name)) {
    			furnitures.remove(f);
                Stdout.print(this,"乌拉！成功删除了"+name+"！");
    			exit=true;
    			break;
    		}
        }
    	if(exit==false)
            Stdout.print(this,"没有找到"+name+"(T⌓T)，所以并不能进行此次删除操作");
    }
    public int getLength() {
        return furnitures.size();                    
    }
	public MyIterator furIterator() {
		return new FurnitureRoomIterator(this);
	}

    public static void displayFurniture(FurnitureRoom furnitureroom) {
        System.out.println("----------------------------------");
        System.out.println(("展示此时家具："));
        MyIterator it = furnitureroom.furIterator();
        while (it.hasNext()) {
            Furniture furniture = (Furniture)it.next();
            Stdout.print("huangduValley.h" +
                    "ouse.Furniture.FurnitureRoom.displayFurniture@static","这是你的【"+furniture.getName()+"】，价值"+furniture.getPrice()+"元。"+furniture.getColor()+"，材质是"+furniture.getTexture()+"。");
        }
    }

    public static FurnitureRoom addFurniture(FurnitureRoom furnitureroom) {
        System.out.println("乌拉！你想要增添以下哪个家具呢？(输入以下数字进行选择)");
        System.out.println("[1]桌子 [2]椅子 [3]柜子 [4]小床 [5]沙发 [6]退出");
        Scanner scanner1 = new Scanner(System.in);
        if(scanner1.hasNextInt()){// 判断输入的是否是整数 
            int furType = scanner1.nextInt() ;
            if(furType==1) {
                furnitureroom.appendFurniture(new Furniture("桌子",439,"紫檀色","紫檀木"));
            }else if(furType==2){
                furnitureroom.appendFurniture(new Furniture("椅子",123,"红木色","红木"));
            }
            else if(furType==3){
                furnitureroom.appendFurniture(new Furniture("柜子",123,"原木色","松木"));
            }else if(furType==4){
                furnitureroom.appendFurniture(new Furniture("小床",123,"梨花白","布艺床"));
            } else if(furType==5){
                furnitureroom.appendFurniture(new Furniture("沙发",123,"栗黄色","绒布沙发"));
            }else if(furType==6){
            }else{ // 输入错误整数
                System.out.println("乌拉!请按要求正确输入！") ;
                addFurniture(furnitureroom);
            }
        }else{ // 如果输入错误的信息 
            System.out.println("乌拉!输入的不是整数！请按要求正确输入!") ;
            addFurniture(furnitureroom);
        }
        displayFurniture(furnitureroom);
        return furnitureroom;
    }

    public static FurnitureRoom deleteFurniture(FurnitureRoom furnitureroom) {
        System.out.println("乌拉！你想要删除以下哪个家具呢？(输入以下数字进行选择)");
        System.out.println("[1]桌子 [2]椅子 [3]柜子 [4]小床 [5]沙发 [6]退出");
        Scanner scanner1 = new Scanner(System.in);
        if(scanner1.hasNextInt()){// 判断输入的是否是整数 
            int furType = scanner1.nextInt() ;
            if(furType==1) {
                furnitureroom.deleteFurniture("桌子");
            }else if(furType==2){
                furnitureroom.deleteFurniture("椅子");
            } else if(furType==3){
                furnitureroom.deleteFurniture("柜子");
            }else if(furType==4){
                furnitureroom.deleteFurniture("小床");
            } else if(furType==5){
                furnitureroom.deleteFurniture("沙发");
            }else if(furType==6){
                System.out.println("乌拉!已退出！") ;
            }else{ // 输入错误整数
                System.out.println("乌拉!请按要求正确输入！") ;
                deleteFurniture(furnitureroom);
            }
        }else{ // 如果输入错误的信息 
            System.out.println("乌拉!输入的不是整数！请按要求正确输入!") ;
            deleteFurniture(furnitureroom);
        }
        displayFurniture(furnitureroom);
        return furnitureroom;
    }

    public static void changeFurniture(FurnitureRoom furnitureroom) {
        for (; ; ) {
            System.out.println("----------------------------------");
            System.out.println("乌拉！你想要增添还是删除家具呢？(输入以下数字进行选择)");
            System.out.println("[1]增添 [2]删除 [3]退出");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {// 判断输入的是否是整数 
                int act = scanner.nextInt();
                if (act == 1) {
                    furnitureroom = addFurniture(furnitureroom);
                } else if (act == 2) {
                    furnitureroom = deleteFurniture(furnitureroom);
                } else if (act == 3) {
                    System.out.println("乌拉!已退出！");
                    break;
                } else { // 输入错误整数
                    System.out.println("乌拉!请按要求正确输入！");
                    changeFurniture(furnitureroom);
                }
            } else { // 如果输入错误的信息 
                System.out.println("乌拉!输入的不是整数！请按要求正确输入!");
                changeFurniture(furnitureroom);
            }
        }
    }

}
