package huangduVally.house.renovation;

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
    public huangduVally.house.renovation.Door clone() {
        huangduVally.house.renovation.Door door = new huangduVally.house.renovation.Door();
        door.setName(this.getName());
        return door;
    }
}

