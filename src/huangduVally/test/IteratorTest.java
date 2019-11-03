package huangduVally.test;

import java.util.*;

import huangduVally.house.Furniture.Furniture;
import huangduVally.house.Furniture.FurnitureRoom;
import huangduVally.house.Furniture.MyIterator;
import huangduVally.house.Rent.HouseMediator;
import huangduVally.house.Rent.Mediator;
import huangduVally.house.Rent.Person;
import huangduVally.house.Rent.Renter;

public class IteratorTest {
    public static void main(String[] args) {
    	System.out.println("***************************  Test Iterator  ***************************");
    	Mediator mediator = new HouseMediator();
		Person renter = new Renter("DP",mediator);
		if(renter.getsendBool()==false) {
			System.out.println("Send message to HouseMediator first to rent a house!");
			renter.sendMessage("Near land, $3115/month");
		}

		FurnitureRoom furnitureroom = new FurnitureRoom(4);

//    	String command="build repeat 4 repeat 3 desk chair sofa desk cabinet bed end end end";
//    	System.out.println("text = \"" + command + "\"");
//    	furnitureroom.node.parse(command);
    	
//    	System.out.println("*************************************************************");
    	System.out.println("Add furnitures in room:");
        furnitureroom.appendFurniture(new Furniture("Bed",244,"Red","Wood"));
        furnitureroom.appendFurniture(new Furniture("Desk",382,"Black","Wood"));
        furnitureroom.appendFurniture(new Furniture("Chair",143,"Red","Aluminum"));
        furnitureroom.appendFurniture(new Furniture("Bed",521,"Pink","Wood"));
        furnitureroom.appendFurniture(new Furniture("Desk",324,"White","Wood"));
        furnitureroom.appendFurniture(new Furniture("Chair",143,"Yellow","Wood"));
//        furnitureroom.deleteFurniture("Chair",143,"Red","Wood");
        furnitureroom.appendFurniture(new Furniture("Sofa",532,"Blue","Leather"));
        furnitureroom.appendFurniture(new Furniture("Cabinet",225,"Yellow","Wood"));
        MyIterator it = furnitureroom.furIterator();
        System.out.println("\nDisplay all furnitures in room:");
        while (it.hasNext()) {
            Furniture furniture = (Furniture)it.next();
            System.out.println("There is a "+furniture.getName()+".");
            System.out.println("It is worth "+"￥"+furniture.getPrice()+".");
            System.out.println("The color is "+furniture.getColor()+".");
            System.out.println("It is made of "+furniture.getTexture()+".\n");            
        }
    	System.out.println("***********************************************************************");
    }
}
