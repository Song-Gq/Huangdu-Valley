package house.iterator;

import java.util.ArrayList;

import house.interpreter.PrimitiveCommandNode;

public class FurnitureRoom implements Aggregate {
    private ArrayList furnitures;
    public PrimitiveCommandNode primitiveCommandNode;
    public FurnitureRoom(int initialsize) {         
        this.furnitures = new ArrayList(initialsize);   
    }                                           
    public Furniture getBookAt(int index) {
        return (Furniture)furnitures.get(index);          
    }
    public void appendFurniture(Furniture furniture) {
        furnitures.add(furniture);                        
    }
    public int getLength() {
        return furnitures.size();                    
    }
    public Iterator iterator() {
        return new FurnitureRoomIterator(this);
    }
}
