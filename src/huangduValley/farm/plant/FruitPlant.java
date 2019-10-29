package huangduValley.farm.plant;

public class FruitPlant extends Plant {
    public FruitPlant()
    {
        super();
    }
    public FruitPlant(String landType)
    {
        super(landType);
    }
    public FruitPlant(String landType,double time)
    {
        super(landType, time);
    }

    public void growToFruit()
    {
        this.sprout();
        this.growLeaves();
        this.growBud();

        this.bearFruit();
    }
}
