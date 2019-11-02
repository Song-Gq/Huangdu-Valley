package huangduValley.farm.plant;

public class FlowerPlant extends Plant {
/*    public FlowerPlant()
    {
        super();
    }*/
    public FlowerPlant(String landType)
    {
        super(landType);
    }
    public FlowerPlant(String landType,double time)
    {
        super(landType,time);
    }

    @Override
    public void growUp()
    {
        // not matured
        if(!this.isMature()) {
            // already has leaves
            if(this.hasLeaves()) {
                this.growBud();
                this.blossom();
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
