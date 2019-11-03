package huangduValley.house.Furniture;

public class FurnitureRoomIterator implements MyIterator {
    private FurnitureRoom furnitureRoom;
    private int index;
    public FurnitureRoomIterator(FurnitureRoom furnitureRoom) {
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
        Furniture furniture = furnitureRoom.getFurnitureAt(index);
        index++;
        return furniture;
    }
}
