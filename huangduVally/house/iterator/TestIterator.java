package huangduVally.house.iterator;

import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        FurnitureRoom furnitureroom = new FurnitureRoom(4);
    	System.out.println("**********************test interpreter***********************");
    	String command="build repeat 4 repeat 3 desk chair sofa desk cabinet bed end end end";
    	System.out.println("text = \"" + command + "\"");
//    	furnitureroom.node.parse(command);
    	
    	System.out.println("*************************************************************");
        furnitureroom.appendFurniture(new Furniture("Bed",123,"Red","Wood"));
        furnitureroom.appendFurniture(new Furniture("Desk",123,"Red","Wood"));
        furnitureroom.appendFurniture(new Furniture("Chair",123,"Red","Wood"));
        furnitureroom.appendFurniture(new Furniture("Bed",123,"Red","Wood"));
        furnitureroom.appendFurniture(new Furniture("Desk",123,"Red","Wood"));
        furnitureroom.appendFurniture(new Furniture("Chair",123,"Red","Wood"));
        furnitureroom.deleteFurniture("Chair",123,"Red","Wood");
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
    }
}
