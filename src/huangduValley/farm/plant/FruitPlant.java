package huangduValley.farm.plant;

public class FruitPlant extends Plant {
/*    public FruitPlant()
    {
        super();
    }*/
    public FruitPlant(String landType)
    {
        super(landType);
    }
    public FruitPlant(String landType,double time)
    {
        super(landType, time);
    }

    @Override
    public void growUp()
    {
        // not matured
        if(!this.isMature()) {
            // already has leaves
            if(this.hasLeaves()) {
                this.growBud();
                this.bearFruit();
            }
            // just seeds
            else {
                this.sprout();
                this.growLeaves();
            }
        }

        // matured, do nothing
    }
}
