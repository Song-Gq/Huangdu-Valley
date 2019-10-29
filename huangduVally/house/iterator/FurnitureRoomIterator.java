package huangduVally.house.iterator;

public class FurnitureRoomIterator implements huangduVally.house.iterator.MyIterator {
    private huangduVally.house.iterator.FurnitureRoom furnitureRoom;
    private int index;
    public FurnitureRoomIterator(huangduVally.house.iterator.FurnitureRoom furnitureRoom) {
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
        huangduVally.house.iterator.Furniture furniture = furnitureRoom.getFurnitureAt(index);
        index++;
        return furniture;
    }
}
