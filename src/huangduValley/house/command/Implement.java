package huangduValley.house.command;

import huangduValley.house.furniture.Furniture;
import huangduValley.house.furniture.FurnitureRoom;

public class Implement extends FurnitureRoom{

	public Implement(int initialsize) {
		super(initialsize);
		// TODO 自动生成的构造函数存根
	}
	private FurnitureRoom froom;
    public void setFurnitureRoom(FurnitureRoom froom) {
    	this.froom=froom;
    }
    public void creatFurniture(Furniture furniture) {
    	if (furniture.getName()=="Chair") {
            froom.appendFurniture(new Furniture("Chair",143,"Red","Aluminum"));
        } else if (furniture.getName()=="Desk") {
        	froom.appendFurniture(new Furniture("Desk",382,"Black","Wood"));
        } else if (furniture.getName()=="Bed") {
            froom.appendFurniture(new Furniture("Bed",521,"Pink","Wood"));
        } else if (furniture.getName()=="Sofa") {
            froom.appendFurniture(new Furniture("Sofa",532,"Blue","Leather"));
        }else if (furniture.getName()=="Cabinet") {
            froom.appendFurniture(new Furniture("Cabinet",225,"Yellow","Wood"));
        }
        else {
        	return;
        }
    }
}
