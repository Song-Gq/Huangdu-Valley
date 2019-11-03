package huangduValley.house.renovation;

public class Window extends AbstractRenovation {

    public Window() {
        setName("wall");
        setPrice(4999.99D);
        setPattern("wooden");
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public Window clone() {
        Window window = new Window();
        window.setName(this.getName());
        return window;
    }
}
