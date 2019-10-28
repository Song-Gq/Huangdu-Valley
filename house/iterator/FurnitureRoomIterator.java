package house.iterator;

public class FurnitureRoomIterator implements Iterator {
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
        Furniture furniture = furnitureRoom.getBookAt(index);
        index++;
        return furniture;
    }
}
