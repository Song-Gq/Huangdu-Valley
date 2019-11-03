package huangduVally.house.renovation;

public class Wall extends AbstractRenovation {

    public Wall() {
        setName("wall");
        setPrice(4999.99D);
        setPattern("wooden");
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Wall clone() {
        Wall wall = new Wall();
        wall.setName(this.getName());
        return wall;
    }
}
