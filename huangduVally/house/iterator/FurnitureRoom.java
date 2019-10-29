package huangduVally.house.iterator;

import java.util.ArrayList;
import java.util.Iterator;
//import house.interpreter.PrimitiveCommandNode;

public class FurnitureRoom implements Aggregate {
    private ArrayList furnitures;
//    public PrimitiveCommandNode primitiveCommandNode;
    public FurnitureRoom(int initialsize) {         
        this.furnitures = new ArrayList(initialsize);   
    }                                           
    public Furniture getFurnitureAt(int index) {
        return (Furniture)furnitures.get(index);          
    }
    public void appendFurniture(Furniture furniture) {
        furnitures.add(furniture);     
    }
    public void deleteFurniture(String name,int price,String color,String texture) {
    	boolean exit=false;
    	Iterator<Furniture> iter = furnitures.iterator();
    	while (iter.hasNext()) {
    		Furniture f=(Furniture)(iter.next());
    		if(f.getName().equals(name)&&f.getPrice()==price&&f.getColor().equals(color)&&f.getTexture().equals(texture)) {
    			furnitures.remove(f);
    			exit=true;
    			break;
    		}
        }
    	if(exit==false)    	System.out.println(name+" cannot be found!");
    }
    public int getLength() {
        return furnitures.size();                    
    }
	public MyIterator furIterator() {
		return new FurnitureRoomIterator(this);
	}

}
