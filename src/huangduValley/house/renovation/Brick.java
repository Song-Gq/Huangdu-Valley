package huangduValley.house.renovation;

public class Brick extends AbstractRenovation {

    public Brick() {
        setName("wall");
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

