package BridgePattern;

public class FlowerPlant extends Plant {
    public FlowerPlant()
    {
        super();
    }
    public FlowerPlant(String landType)
    {
        super(landType);
    }
    public FlowerPlant(String landType,double time)
    {
        super(landType,time);
    }

    public void growUp()
    {
        this.sprout();
        this.growLeaves();
        this.growBud();

        this.blossom();
    }
}
