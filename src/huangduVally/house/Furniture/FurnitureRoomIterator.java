package huangduVally.house.Furniture;

public class FurnitureRoomIterator implements huangduVally.house.Furniture.MyIterator {
    private huangduVally.house.Furniture.FurnitureRoom furnitureRoom;
    private int index;
    public FurnitureRoomIterator(huangduVally.house.Furniture.FurnitureRoom furnitureRoom) {
        this.furnitureRoom = furnitureRoom;
        this.index = 0;
    }
    public boolean hasNext() {
        if (index < furnitureRoom.getLength()) {
            return true;
        } else {
            return false;
        }
    }
    public Object next() {
        huangduVally.house.Furniture.Furniture furniture = furnitureRoom.getFurnitureAt(index);
        index++;
        return furniture;
    }
}
