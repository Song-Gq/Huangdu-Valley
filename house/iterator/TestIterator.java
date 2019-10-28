package house.iterator;

import java.util.*;

public class TestIterator {
    public static void main(String[] args) {
        FurnitureRoom furnitureroom = new FurnitureRoom(4);
        furnitureroom.appendFurniture(new Furniture("Bed"));
        furnitureroom.appendFurniture(new Furniture("Desk"));
        furnitureroom.appendFurniture(new Furniture("Chair"));
        furnitureroom.appendFurniture(new Furniture("Bed"));
        furnitureroom.appendFurniture(new Furniture("Desk"));
        furnitureroom.appendFurniture(new Furniture("Chair"));
        furnitureroom.appendFurniture(new Furniture("Sofa"));
        furnitureroom.appendFurniture(new Furniture("Cabinet"));
        Iterator it = furnitureroom.iterator();
        while (it.hasNext()) {
            Furniture furniture = (Furniture)it.next();
            System.out.println(furniture.getName());
        }
    }
}
