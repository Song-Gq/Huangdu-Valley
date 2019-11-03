package huangduVally.house.renovation;

public class Door extends AbstractRenovation {

    public Door() {
        setName("door");
        setPrice(4999.99D);
        setPattern("wooden");
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Door clone() {
        Door door = new Door();
        door.setName(this.getName());
        return door;
    }
}


